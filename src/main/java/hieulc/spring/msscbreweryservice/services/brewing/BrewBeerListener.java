package hieulc.spring.msscbreweryservice.services.brewing;

import hieulc.spring.msscbreweryservice.config.JmsConfig;
import hieulc.spring.msscbreweryservice.domains.Beer;
import hieulc.spring.msscbreweryservice.event.BrewBeerEvent;
import hieulc.spring.msscbreweryservice.event.NewInventoryEvent;
import hieulc.spring.msscbreweryservice.repositories.BeerRepository;
import hieulc.spring.msscbreweryservice.web.models.BeerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BrewBeerListener {

    private final BeerRepository beerRepository;
    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.BREWING_REQUEST_QUEUE)
    public void listen(BrewBeerEvent event) {
        BeerDto beerDto = event.getBeerDto();

        Beer beer = beerRepository.getReferenceById(beerDto.getId());

        beerDto.setQuantityOnHand(beer.getQuantityToBrew());

        NewInventoryEvent newInventoryEvent = new NewInventoryEvent(beerDto);

        log.debug("Brewed beer " + beer.getMinOnHand() + " : QOH: " + beerDto.getQuantityOnHand());

        jmsTemplate.convertAndSend(JmsConfig.NEW_INVENTORY_QUEUE, newInventoryEvent);
    }

}
