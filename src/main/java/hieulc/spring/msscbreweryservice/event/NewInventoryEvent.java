package hieulc.spring.msscbreweryservice.event;

import hieulc.spring.msscbreweryservice.web.models.BeerDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent{

    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
