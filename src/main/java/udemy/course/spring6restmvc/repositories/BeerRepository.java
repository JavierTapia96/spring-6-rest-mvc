package udemy.course.spring6restmvc.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import udemy.course.spring6restmvc.entities.Beer;

/**
 * Created by Javier Tapia on 11/12/2023
 */
public interface BeerRepository extends JpaRepository<Beer, UUID> {

}
