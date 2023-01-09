package hieulc.spring.msscbreweryservice.event;

import hieulc.spring.msscbreweryservice.web.models.BeerDto;

public class BrewBeerEvent extends BeerEvent{

    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
