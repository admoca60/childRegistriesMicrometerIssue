package com.example.democompositemicrometer;
import io.micrometer.core.instrument.*;
import io.micrometer.core.instrument.step.StepMeterRegistry;
import io.micrometer.core.instrument.step.StepRegistryConfig;
import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;
public class ShutdownPublishMeters {
    @Test
    public void testshutdown(){
        MockClock mockClock = new MockClock();
        StepMeterRegistry meterRegistry = new OwnStepMeterRegistry(new StepRegistryConfig(){

            @Override
            public String prefix() {
                return null;
            }

            @Override
            public String get(String key) {
                return null;
            }
        }, mockClock);

        mockClock.addSeconds(1);
        final Counter testCounter1 = meterRegistry.counter("Test1");
        testCounter1.increment();
        mockClock.addSeconds(1);

    }

    static class OwnStepMeterRegistry extends StepMeterRegistry{

        public OwnStepMeterRegistry(StepRegistryConfig config, Clock clock) {
            super(config, clock);
        }

        @Override
        public void publish() {
           for(Meter meter: this.getMeters()){

           }
        }

        @Override
        protected TimeUnit getBaseTimeUnit() {
            return null;
        }
    }

}