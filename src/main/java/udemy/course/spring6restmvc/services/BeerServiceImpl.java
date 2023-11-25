package udemy.course.spring6restmvc.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import udemy.course.spring6restmvc.model.Beer;
import udemy.course.spring6restmvc.model.BeerStyle;

/**
 * Created by Javier Tapia on 24/11/2023
 */
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    @Override
    public Beer getBeerById(UUID id) {

        log.debug("Getting a beer - In service...");

        return Beer.builder()
            .id(id)
            .version(1)
            .beerName("Galaxy Cat")
            .beerStyle(BeerStyle.PALE_ALE)
            .upc("123456")
            .price(new BigDecimal("12.95"))
            .quantityOnHand(200)
            .createdDate(LocalDateTime.now())
            .lastModifiedDate(LocalDateTime.now())
            .build();
    }
}
