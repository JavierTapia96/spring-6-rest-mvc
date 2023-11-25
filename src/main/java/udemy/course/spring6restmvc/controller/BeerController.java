package udemy.course.spring6restmvc.controller;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import udemy.course.spring6restmvc.model.Beer;
import udemy.course.spring6restmvc.services.BeerService;

/**
 * Created by Javier Tapia on 24/11/2023
 */
@Slf4j
@AllArgsConstructor
@Controller
public class BeerController {

    private final BeerService beerService;

    public Beer getBeerById(UUID id) {

        log.debug("Getting a beer - In controller...");

        return beerService.getBeerById(id);
    }
}
