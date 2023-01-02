package hieulc.spring.msscbreweryservice.services.inventory;

import hieulc.spring.msscbreweryservice.services.inventory.config.InventoryServiceConfig;
import hieulc.spring.msscbreweryservice.services.inventory.model.BeerInventoryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Component
public class BeerInventoryServiceRestTemplateImpl implements BeerInventoryService {

    public static final String INVENTORY_PATH = "/api/v1/beer/{beerId}/inventory";
    private final RestTemplate restTemplate;
    private String beerInventoryServiceHost;

    @Autowired
    public void setBeerInventoryServiceHost(InventoryServiceConfig inventoryServiceConfig) {
        this.beerInventoryServiceHost = inventoryServiceConfig.getBeerInventoryServiceHost();
    }

    public BeerInventoryServiceRestTemplateImpl(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }



    @Override
    public Integer getOnhandInventory(UUID beerId) {
        log.debug("Calling Inventory Service");
        ResponseEntity<List<BeerInventoryDto>> responseEntity = restTemplate
                .exchange(beerInventoryServiceHost + INVENTORY_PATH,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<BeerInventoryDto>>() {
                        },
                        (Object) beerId);
        Integer onHand = Objects.requireNonNull(responseEntity.getBody())
                .stream()
                .mapToInt(BeerInventoryDto::getQuantityOnHand)
                .sum();

        return onHand;
    }
}
