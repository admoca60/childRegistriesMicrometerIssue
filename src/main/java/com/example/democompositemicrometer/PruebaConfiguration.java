package com.example.democompositemicrometer;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import io.micrometer.core.instrument.config.MeterFilter;
import io.micrometer.influx.InfluxConfig;
import io.micrometer.influx.InfluxMeterRegistry;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PruebaConfiguration {

    public PruebaConfiguration(CompositeMeterRegistry compositeMeterRegistry, InfluxMeterRegistry influxMeterRegistry, PrometheusMeterRegistry prometheusMeterRegistry) {

        influxMeterRegistry.config().meterFilter(MeterFilter.ignoreTags("tagkey2"));


        Counter metricaCounter = compositeMeterRegistry.counter("metricaCounter", "tagkey", "tagvalue", "tagkey2", "tagvalue2");

        compositeMeterRegistry.remove(metricaCounter);

    }
}
