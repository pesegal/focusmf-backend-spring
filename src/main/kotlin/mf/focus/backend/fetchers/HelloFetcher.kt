package mf.focus.backend.fetchers

import graphql.schema.DataFetcher
import mf.focus.backend.data.HelloWorld
import org.springframework.stereotype.Component

@Component
class HelloFetcher {
    fun getHello(): DataFetcher<HelloWorld> {
        return DataFetcher {
            return@DataFetcher HelloWorld("Hello World!")
        }
    }
}