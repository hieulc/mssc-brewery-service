package hieulc.spring.msscbreweryservice.web.mappers;

import hieulc.spring.msscbreweryservice.domains.Beer;
import hieulc.spring.msscbreweryservice.domains.BeerV2;
import hieulc.spring.msscbreweryservice.web.models.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}
