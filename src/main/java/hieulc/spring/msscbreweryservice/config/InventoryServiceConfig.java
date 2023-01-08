package hieulc.spring.msscbreweryservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "hieulc.brewery")
public class InventoryServiceConfig {
    private String beerInventoryServiceHost;

    public void setBeerInventoryServiceHost(String beerInventoryServiceHost) {
        this.beerInventoryServiceHost = beerInventoryServiceHost;
    }

    public String getBeerInventoryServiceHost() {
        return beerInventoryServiceHost;
    }
}
