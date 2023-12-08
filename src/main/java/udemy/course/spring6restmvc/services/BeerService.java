package udemy.course.spring6restmvc.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import udemy.course.spring6restmvc.model.Beer;

/**
 * Created by Javier Tapia on 24/11/2023
 */
public interface BeerService {

    List<Beer> listBeers();

    Optional<Beer> getBeerById(UUID id);

    Beer saveNewBeer(Beer beer);

    void updateBeerById(UUID id, Beer beer);

    void deleteById(UUID id);

    void patchBeerById(UUID id, Beer beer);
}
