package au.salvatorebalzano.microservice.repositories;

import au.salvatorebalzano.microservice.models.Player;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PlayerRepository extends PagingAndSortingRepository<Player, Long> {
}
