package io.envoyproxy.envoymobile

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.concurrent.Executor;

class ResponseHandlerTest {
  @Test
  fun `parsing status code from headers returns first status code`() {
    val headers = mapOf(":status" to listOf("204", "200"), "other" to listOf("1"))
    val responseHandler = ResponseHandler(Executor {})
    responseHandler.underlyingCallbacks.onHeaders(headers, false)

    responseHandler.onHeaders { _, statusCode, _ -> assertThat(statusCode).isEqualTo(204) }
  }

  @Test
  fun `parsing invalid status code from headers returns 0`() {
    val headers = mapOf(":status" to listOf("invalid"), "other" to listOf("1"))
    val responseHandler = ResponseHandler(Executor {})
    responseHandler.underlyingCallbacks.onHeaders(headers, false)

    responseHandler.onHeaders { _, statusCode, _ -> assertThat(statusCode).isEqualTo(0) }

  }

  @Test
  fun `parsing missing status code from headers returns 0`() {
    val headers = mapOf("other" to listOf("1"))
    val responseHandler = ResponseHandler(Executor {})
    responseHandler.underlyingCallbacks.onHeaders(headers, false)

    responseHandler.onHeaders { _, statusCode, _ -> assertThat(statusCode).isEqualTo(0) }
  }
}
