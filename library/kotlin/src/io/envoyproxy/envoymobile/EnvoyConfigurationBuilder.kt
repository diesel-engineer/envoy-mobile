package io.envoyproxy.envoymobile

import io.envoyproxy.envoymobile.engine.EnvoyConfiguration
import io.envoyproxy.envoymobile.engine.EnvoyEngine
import io.envoyproxy.envoymobile.engine.EnvoyEngineImpl


open class EnvoyConfigurationBuilder internal constructor(
) {
  private var connectTimeoutSeconds = 30
  private var dnsRefreshSeconds = 60
  private var statsFlushSeconds = 60

  /**
   * Add a timeout for new network connections to hosts in the cluster.
   *
   * @param connectTimeoutSeconds timeout for new network connections to hosts in the cluster.
   */
  fun addConnectTimeoutSeconds(connectTimeoutSeconds: Int): EnvoyConfigurationBuilder {
    this.connectTimeoutSeconds = connectTimeoutSeconds
    return this
  }

  /**
   * Add a rate at which to refresh DNS.
   *
   * @param dnsRefreshSeconds rate in seconds to refresh DNS.
   */
  fun addDNSRefreshSeconds(dnsRefreshSeconds: Int): EnvoyConfigurationBuilder {
    this.dnsRefreshSeconds = dnsRefreshSeconds
    return this
  }

  /**
   * Add an interval at which to flush Envoy stats.
   *
   * @param statsFlushSeconds interval at which to flush Envoy stats.
   */
  fun addStatsFlushSeconds(statsFlushSeconds: Int): EnvoyConfigurationBuilder {
    this.statsFlushSeconds = statsFlushSeconds
    return this
  }

  /**
   * Builds a new instance of Envoy using the provided configurations.
   *
   * @return A new instance of Envoy.
   */
  fun build(): EnvoyConfiguration {
    return EnvoyConfiguration(connectTimeoutSeconds, dnsRefreshSeconds, statsFlushSeconds)
  }

}
