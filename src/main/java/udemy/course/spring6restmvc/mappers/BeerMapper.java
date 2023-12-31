package udemy.course.spring6restmvc.mappers;

import org.mapstruct.Mapper;
import udemy.course.spring6restmvc.entities.Beer;
import udemy.course.spring6restmvc.model.BeerDTO;

/**
 * Created by Javier Tapia on 30/12/2023
 */
@Mapper
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDTO beerDTO);

    BeerDTO beerToBeerDto(Beer beer);
}
