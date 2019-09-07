package io.envoyproxy.envoymobile.engine;

import io.envoyproxy.envoymobile.engine.types.EnvoyHTTPCallbacks;

public class EnvoyEngineImpl implements EnvoyEngine {

  private long engineHandle;

  public EnvoyEngineImpl(String configurationYAML, String logLevel) {
    JniLibrary.load();
    this.engineHandle = 0;
    try {
      this.engineHandle = JniLibrary.initEngine(configurationYAML, logLevel);
    } catch (Throwable throwable) {
      // TODO: Need to have a way to log the exception somewhere
    }
  }

  public EnvoyEngineImpl(EnvoyConfiguration envoyConfiguration, String logLevel) {
    JniLibrary.load();
    this.engineHandle = 0;
    try {
      this.engineHandle = JniLibrary.initEngine(envoyConfiguration.resolveTemplate(JniLibrary.templateString()), logLevel);
    } catch (Throwable throwable) {
      // TODO: Need to have a way to log the exception somewhere
    }
  }

  /**
   * Creates a new stream with the provided callbacks.
   *
   * @param callbacks The callbacks for the stream.
   * @return A stream that may be used for sending data.
   */
  @Override
  public EnvoyHTTPStream startStream(EnvoyHTTPCallbacks callbacks) {
    long streamHandle = JniLibrary.initStream(engineHandle);
    return new EnvoyHTTPStream(streamHandle, callbacks);
  }

  /**
   * Run the Envoy engine with the provided yaml string and log level.
   *
   * @param configurationYAML The configuration yaml with which to start Envoy.
   * @return A status indicating if the action was successful.
   */
  @Override
  public int runWithConfig() {
    return JniLibrary.runEngine();
  }
}
