package hieulc.spring.msscbreweryservice.repositories;

import hieulc.spring.msscbreweryservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {

}
