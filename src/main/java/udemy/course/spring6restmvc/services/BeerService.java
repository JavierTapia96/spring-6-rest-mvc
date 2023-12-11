package udemy.course.spring6restmvc.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import udemy.course.spring6restmvc.model.BeerDTO;

/**
 * Created by Javier Tapia on 24/11/2023
 */
public interface BeerService {

    List<BeerDTO> listBeers();

    Optional<BeerDTO> getBeerById(UUID id);

    BeerDTO saveNewBeer(BeerDTO beer);

    void updateBeerById(UUID id, BeerDTO beer);

    void deleteById(UUID id);

    void patchBeerById(UUID id, BeerDTO beer);
}
