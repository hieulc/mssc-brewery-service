package hieulc.spring.msscbreweryservice.services;

import hieulc.spring.msscbreweryservice.config.JmsConfig;
import hieulc.spring.msscbreweryservice.domains.Beer;
import hieulc.spring.msscbreweryservice.event.BrewBeerEvent;
import hieulc.spring.msscbreweryservice.repositories.BeerRepository;
import hieulc.spring.msscbreweryservice.services.inventory.BeerInventoryService;
import hieulc.spring.msscbreweryservice.web.mappers.BeerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrewingService {

    private final BeerRepository beerRepository;
    private final BeerInventoryService beerInventoryService;
    private final JmsTemplate jmsTemplate;
    private final BeerMapper beerMapper;

    @Scheduled(fixedRate = 5000) // Every 5s
    public void checkForLowInventory() {
        List<Beer> beers = beerRepository.findAll();

        beers.forEach(beer -> {
            Integer invOH = beerInventoryService.getOnhandInventory(beer.getId());

            log.debug("Min Onhand is: " + beer.getMinOnHand());
            log.debug("InvOH is: "  + invOH);

            isNeededToBrewingBeer(beer.getMinOnHand(), invOH, beer);
        });
    }


    private void isNeededToBrewingBeer(Integer min, Integer onHand, Beer beer) {
        if (min >= onHand) {
            jmsTemplate.convertAndSend(JmsConfig.BREWING_REQUEST_QUEUE,
                    new BrewBeerEvent(beerMapper.beerToBeerDto(beer)));
        }
    }

}
