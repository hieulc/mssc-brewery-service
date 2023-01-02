package hieulc.spring.msscbreweryservice.services.inventory;

import hieulc.spring.msscbreweryservice.boostrap.BeerLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Disabled
@SpringBootTest
public class BeerServiceRestTemplateImplTest {

    @Autowired
    BeerInventoryService beerInventoryService;

    @BeforeEach
    void setUp() {}

    @Test
    void getOnhandInventory() {
        Integer qoh = beerInventoryService.getOnhandInventory(BeerLoader.BEER_2_UUID);
        System.out.println(qoh);
    }
}
