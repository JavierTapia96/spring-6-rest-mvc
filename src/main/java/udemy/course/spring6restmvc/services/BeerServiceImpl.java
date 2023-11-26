package udemy.course.spring6restmvc.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    private final Map<UUID, Beer> beerMap;

    public BeerServiceImpl() {
        this.beerMap = new HashMap<>();

        Beer beer1 = Beer.builder()
            .id(UUID.randomUUID())
            .version(1)
            .beerName("Galaxy Cat")
            .beerStyle(BeerStyle.PALE_ALE)
            .upc("123456")
            .price(new BigDecimal("12.95"))
            .quantityOnHand(200)
            .createdDate(LocalDateTime.now())
            .lastModifiedDate(LocalDateTime.now())
            .build();

        Beer beer2 = Beer.builder()
            .id(UUID.randomUUID())
            .version(1)
            .beerName("Crank")
            .beerStyle(BeerStyle.PALE_ALE)
            .upc("12356222")
            .price(new BigDecimal("11.95"))
            .quantityOnHand(392)
            .createdDate(LocalDateTime.now())
            .lastModifiedDate(LocalDateTime.now())
            .build();

        Beer beer3 = Beer.builder()
            .id(UUID.randomUUID())
            .version(1)
            .beerName("No Hammers On The Bar")
            .beerStyle(BeerStyle.IPA)
            .upc("123572")
            .price(new BigDecimal("13.95"))
            .quantityOnHand(125)
            .createdDate(LocalDateTime.now())
            .lastModifiedDate(LocalDateTime.now())
            .build();

        beerMap.put(beer1.getId(), beer1);
        beerMap.put(beer2.getId(), beer2);
        beerMap.put(beer3.getId(), beer3);
    }

    @Override
    public List<Beer> listBeers() {
        log.debug("Listing beers - In service...");
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public Beer getBeerById(UUID id) {
        log.debug("Getting a beer by id - In service...");
        return beerMap.get(id);
    }

    @Override
    public Beer saveNewBeer(Beer beer) {
        log.debug("Saving a new beer - In service...");
        Beer savedBeer = Beer.builder()
            .id(UUID.randomUUID())
            .version(1)
            .beerName(beer.getBeerName())
            .beerStyle(beer.getBeerStyle())
            .upc(beer.getUpc())
            .price(beer.getPrice())
            .quantityOnHand(beer.getQuantityOnHand())
            .createdDate(LocalDateTime.now())
            .lastModifiedDate(LocalDateTime.now())
            .build();
        beerMap.put(savedBeer.getId(), savedBeer);
        return savedBeer;
    }
}
