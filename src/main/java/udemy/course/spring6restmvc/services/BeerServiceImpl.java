package udemy.course.spring6restmvc.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import udemy.course.spring6restmvc.model.BeerDTO;
import udemy.course.spring6restmvc.model.BeerStyle;

/**
 * Created by Javier Tapia on 24/11/2023
 */
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    private final Map<UUID, BeerDTO> beerMap;

    public BeerServiceImpl() {
        this.beerMap = new HashMap<>();

        BeerDTO beer1 = BeerDTO.builder()
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

        BeerDTO beer2 = BeerDTO.builder()
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

        BeerDTO beer3 = BeerDTO.builder()
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
    public List<BeerDTO> listBeers() {
        log.debug("Listing beers - In service...");
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public Optional<BeerDTO> getBeerById(UUID id) {
        log.debug("Getting a beer by id - In service...");
        return Optional.of(beerMap.get(id));
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beer) {
        log.debug("Saving a new beer - In service...");
        BeerDTO savedBeer = BeerDTO.builder()
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

    @Override
    public void updateBeerById(UUID id, BeerDTO beer) {
        log.debug("Updating a beer by id - In service...");
        BeerDTO existingBeer = beerMap.get(id);
        existingBeer.setBeerName(beer.getBeerName());
        existingBeer.setBeerStyle(beer.getBeerStyle());
        existingBeer.setPrice(beer.getPrice());
        existingBeer.setQuantityOnHand(beer.getQuantityOnHand());
        existingBeer.setUpc(beer.getUpc());
        existingBeer.setLastModifiedDate(LocalDateTime.now());

        beerMap.put(id, existingBeer);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("Deleting a beer by id - In service...");
        beerMap.remove(id);
    }

    @Override
    public void patchBeerById(UUID id, BeerDTO beer) {
        log.debug("Patching a beer by id - In service...");
        BeerDTO existingBeer = beerMap.get(id);

        if (StringUtils.hasText(beer.getBeerName())) {
            existingBeer.setBeerName(beer.getBeerName());
        }

        if (beer.getBeerStyle() != null) {
            existingBeer.setBeerStyle(beer.getBeerStyle());
        }

        if (beer.getPrice() != null) {
            existingBeer.setPrice(beer.getPrice());
        }

        if (beer.getQuantityOnHand() != null) {
            existingBeer.setQuantityOnHand(beer.getQuantityOnHand());
        }

        if (StringUtils.hasText(beer.getUpc())) {
            existingBeer.setUpc(beer.getUpc());
        }
    }
}
