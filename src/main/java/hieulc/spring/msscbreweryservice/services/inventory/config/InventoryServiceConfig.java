package hieulc.spring.msscbreweryservice.services.inventory.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

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
