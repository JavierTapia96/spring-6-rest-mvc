package udemy.course.spring6restmvc.controller;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import udemy.course.spring6restmvc.model.Beer;
import udemy.course.spring6restmvc.services.BeerService;

/**
 * Created by Javier Tapia on 24/11/2023
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    @PostMapping
    public ResponseEntity<?> handlePost(@RequestBody Beer beer) {
        Beer savedBeer = beerService.saveNewBeer(beer);
        log.debug("Saved beer with id: " + savedBeer.getId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<Beer> listBeers() {
        log.debug("Listing beers - In controller...");
        return beerService.listBeers();
    }

    @GetMapping("/{id}")
    public Beer getBeerById(@PathVariable("id") UUID id) {
        log.debug("Getting a beer by id - In controller...");
        return beerService.getBeerById(id);
    }
}
