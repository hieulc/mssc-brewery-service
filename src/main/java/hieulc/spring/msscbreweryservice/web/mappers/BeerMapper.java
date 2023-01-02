package hieulc.spring.msscbreweryservice.web.mappers;

import hieulc.spring.msscbreweryservice.domains.Beer;
import hieulc.spring.msscbreweryservice.web.models.BeerDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    BeerDto beerToBeerDtoWithInventory(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}
