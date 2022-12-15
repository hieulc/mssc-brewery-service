package hieulc.spring.msscbreweryservice.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerV2 {
    private UUID id;
    private String beerName;
    private String beerStyle;
    private Long upc;
}
