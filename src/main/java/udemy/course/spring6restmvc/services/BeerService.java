package udemy.course.spring6restmvc.services;

import java.util.UUID;
import udemy.course.spring6restmvc.model.Beer;

/**
 * Created by Javier Tapia on 24/11/2023
 */
public interface BeerService {

    Beer getBeerById(UUID id);
}
