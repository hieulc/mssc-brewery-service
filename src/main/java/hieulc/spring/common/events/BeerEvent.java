package hieulc.spring.common.events;

import hieulc.spring.msscbreweryservice.web.models.BeerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerEvent implements Serializable {

    static final long serialVersionUID = -8403957379536859467L;

    private BeerDto beerDto;

}
