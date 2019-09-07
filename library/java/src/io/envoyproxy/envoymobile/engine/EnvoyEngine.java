package io.envoyproxy.envoymobile.engine;

import io.envoyproxy.envoymobile.engine.types.EnvoyHTTPCallbacks;

public interface EnvoyEngine {
  /**
   * Creates a new stream with the provided callbacks.
   *
   * @param callbacks The callbacks for receiving callbacks from the stream.
   * @return A stream that may be used for sending data.
   */
  EnvoyHTTPStream startStream(EnvoyHTTPCallbacks callbacks);

  /**
   * Run the Envoy engine with the provided yaml string and log level.
   *
   * @return A status indicating if the action was successful.
   */
  int runWithConfig();
}
