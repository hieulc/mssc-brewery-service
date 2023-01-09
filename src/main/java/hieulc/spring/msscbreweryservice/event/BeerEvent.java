package hieulc.spring.msscbreweryservice.event;

import hieulc.spring.msscbreweryservice.web.models.BeerDto;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
@Builder
public class BeerEvent implements Serializable {

    static final long serialVersionUID = -8403957379536859467L;

    private final BeerDto beerDto;

}
