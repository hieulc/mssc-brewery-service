package hieulc.spring.msscbreweryservice.repositories;

import hieulc.spring.msscbreweryservice.domains.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {

}
