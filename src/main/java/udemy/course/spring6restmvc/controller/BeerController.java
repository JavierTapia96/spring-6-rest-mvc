package udemy.course.spring6restmvc.controller;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import udemy.course.spring6restmvc.exception.NotFoundException;
import udemy.course.spring6restmvc.model.Beer;
import udemy.course.spring6restmvc.services.BeerService;

/**
 * Created by Javier Tapia on 24/11/2023
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class BeerController {

    public static final String BEER_PATH = "/api/v1/beer";
    public static final String BEER_PATH_ID = BEER_PATH + "/{id}";

    private final BeerService beerService;

    @PatchMapping(BEER_PATH_ID)
    public ResponseEntity<?> updateBeerPatchById(@PathVariable("id") UUID id,
                                                 @RequestBody Beer beer) {
        beerService.patchBeerById(id, beer);
        log.debug("Patch beer with id: " + id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(BEER_PATH_ID)
    public ResponseEntity<?> deleteById(@PathVariable("id") UUID id) {
        beerService.deleteById(id);
        log.debug("Deleted beer with id: " + id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(BEER_PATH_ID)
    public ResponseEntity<?> updateById(@PathVariable("id") UUID id, @RequestBody Beer beer) {
        beerService.updateBeerById(id, beer);
        log.debug("Updated beer with id: " + id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(BEER_PATH)
    public ResponseEntity<?> handlePost(@RequestBody Beer beer) {
        Beer savedBeer = beerService.saveNewBeer(beer);

        log.debug("Saved beer with id: " + savedBeer.getId());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedBeer.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping(BEER_PATH)
    public List<Beer> listBeers() {
        log.debug("Listing beers - In controller...");
        return beerService.listBeers();
    }

    @GetMapping(BEER_PATH_ID)
    public Beer getBeerById(@PathVariable("id") UUID id) {
        log.debug("Getting a beer by id - In controller...");
        return beerService.getBeerById(id).orElseThrow(NotFoundException::new);
    }
}
