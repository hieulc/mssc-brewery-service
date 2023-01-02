package hieulc.spring.msscbreweryservice;

import hieulc.spring.msscbreweryservice.services.inventory.config.InventoryServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {InventoryServiceConfig.class})
public class MsscBreweryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsscBreweryServiceApplication.class, args);
	}

}
