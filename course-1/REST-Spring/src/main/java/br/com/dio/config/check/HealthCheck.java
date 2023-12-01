package br.com.dio.config.check;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

import java.net.InetAddress;

public class HealthCheck implements HealthIndicator
{
    @Override
    public Health health() {
        try {
            InetAddress adress = InetAddress.getByName("localhost");
            if(adress.isReachable(10000)) {
                return Health.up().build();
            }
        } catch(Exception exception) {
            return Health.down().withDetail("Motivo", exception.getMessage()).build();
        }
        return null;
    }
}
