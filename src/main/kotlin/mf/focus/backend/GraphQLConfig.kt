package mf.focus.backend

import org.springframework.util.ResourceUtils

import graphql.GraphQL
import graphql.schema.Coercing
import graphql.schema.CoercingParseLiteralException
import graphql.schema.CoercingParseValueException
import graphql.schema.CoercingSerializeException
import graphql.schema.GraphQLScalarType
import graphql.schema.GraphQLSchema
import graphql.schema.idl.RuntimeWiring
import graphql.schema.idl.SchemaGenerator
import graphql.schema.idl.SchemaParser
import graphql.schema.idl.TypeDefinitionRegistry
import graphql.schema.idl.TypeRuntimeWiring
import mf.focus.backend.fetchers.HelloFetcher
import mf.focus.backend.fetchers.ProjectDataFetchers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeParseException

@Configuration
class GraphQLConfig {

    @Autowired
    lateinit var projectDataFetchers: ProjectDataFetchers

    @Autowired
    lateinit var helloFetcher: HelloFetcher

    @Bean
    fun graphQL(): GraphQL {
        val schema = ResourceUtils.getFile("classpath:schema.graphqls")
        val graphQlSchema : GraphQLSchema = buildSchema(schema)
        return GraphQL.newGraphQL(graphQlSchema).build();
    }

    fun buildSchema(schema: File): GraphQLSchema {
        val typeRegistry: TypeDefinitionRegistry = SchemaParser().parse(schema)
        val runtimeWiring: RuntimeWiring = buildWiring()
        return SchemaGenerator().makeExecutableSchema(typeRegistry, runtimeWiring)
    }

    fun buildWiring(): RuntimeWiring {
        return RuntimeWiring.newRuntimeWiring()
            .scalar(dateTimeScalar())
            .type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("hello", helloFetcher.getHello()))
            //.type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("getProjects", projectDataFetchers.getProjects()))
            .build()
    }

    fun dateTimeScalar(): GraphQLScalarType {
        return GraphQLScalarType.newScalar()
            .name("DateTime")
            .description("Java LocalDateTime as scalar")
            .coercing(object: Coercing<LocalDateTime, String> {
                override fun serialize(dataFetcherResult: Any): String {
                    if (dataFetcherResult is LocalDateTime) {
                        return dataFetcherResult.toString()
                    } else {
                        throw CoercingSerializeException("Expected a LocalDateTime object")
                    }
                }

                override fun parseValue(input: Any): LocalDateTime {
                    try {
                        if (input is String) {
                            return LocalDateTime.parse(input)
                        } else {
                            throw CoercingParseValueException("Expected a string")
                        }
                    } catch (e: DateTimeParseException) {
                        throw CoercingParseValueException("Not a valid date: $input")
                    }
                }

                override fun parseLiteral(input: Any): LocalDateTime {
                    if (input is graphql.language.StringValue) {
                        try {
                            return LocalDateTime.parse(input.value)
                        } catch (e: DateTimeParseException) {
                            throw CoercingParseLiteralException(e)
                        }
                    } else {
                        throw CoercingParseLiteralException("Expected a StringValue")
                    }
                }
            }).build()
    }

}

