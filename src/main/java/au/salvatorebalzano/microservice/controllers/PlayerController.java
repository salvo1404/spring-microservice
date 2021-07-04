package au.salvatorebalzano.microservice.controllers;

import au.salvatorebalzano.microservice.models.Player;
import au.salvatorebalzano.microservice.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Player> index() {

        return playerRepository.findAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Player store(Player player) {

        return playerRepository.save(player);
    }

    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Player> show(@PathVariable Long id) {
        return playerRepository.findById(id);
    }
}
