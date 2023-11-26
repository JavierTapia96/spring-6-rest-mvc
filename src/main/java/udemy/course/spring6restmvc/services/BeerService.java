package udemy.course.spring6restmvc.services;

import java.util.List;
import java.util.UUID;
import udemy.course.spring6restmvc.model.Beer;

/**
 * Created by Javier Tapia on 24/11/2023
 */
public interface BeerService {

    List<Beer> listBeers();

    Beer getBeerById(UUID id);

    Beer saveNewBeer(Beer beer);
}
