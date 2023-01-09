package hieulc.spring.msscbreweryservice.event;

import hieulc.spring.msscbreweryservice.web.models.BeerDto;

public class NewInventoryEvent extends BeerEvent{

    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
