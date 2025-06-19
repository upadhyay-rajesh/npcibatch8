package com.myconsumer.config;



import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
//import org.springframework.cloud.client.loadbalancer.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.List;

//@Configuration
public class LoadBalancerConfig {

   //// @Bean
    public ServiceInstanceListSupplier serviceInstanceListSupplier() {
        return new ServiceInstanceListSupplier() {
            @Override
            public String getServiceId() {
                return "employee-service";
            }

            @Override
            public Flux<List<ServiceInstance>> get() {
                return Flux.just(List.of(
                    new DefaultServiceInstance("employee1", "employee-service", "localhost", 8081, false),
                    new DefaultServiceInstance("employee2", "employee-service", "localhost", 8082, false)
                ));
            }
        };
    }
}
