package io.envoyproxy.envoymobile.engine;

import android.content.Context;

public class AndroidEngineImpl extends EnvoyEngineImpl {

  public AndroidEngineImpl(Context context, String configurationYAML, String logLevel) {
    super(configurationYAML, logLevel);
    AndroidJniLibrary.load(context);
  }

  public AndroidEngineImpl(Context context, EnvoyConfiguration envoyConfiguration, String logLevel) {
    super(envoyConfiguration, logLevel);
    AndroidJniLibrary.load(context);
  }
}
