package hieulc.spring.msscbreweryservice.services;

import hieulc.spring.msscbreweryservice.web.models.BeerDto;
import hieulc.spring.msscbreweryservice.web.models.BeerPagedList;
import hieulc.spring.msscbreweryservice.web.models.v2.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);

    BeerDto getById(UUID beerId, Boolean showInventoryOnHand);

    BeerDto getBeerByUpc(String upc, Boolean showInventoryOnHand);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

}
