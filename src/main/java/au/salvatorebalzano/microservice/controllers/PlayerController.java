package au.salvatorebalzano.microservice.controllers;

import au.salvatorebalzano.microservice.exceptions.PlayerNotFoundException;
import au.salvatorebalzano.microservice.models.Player;
import au.salvatorebalzano.microservice.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

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
    public Player store(@RequestBody @Valid Player player) throws ConstraintViolationException {

        return playerRepository.save(player);
    }

    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Player show(@PathVariable Long id) throws Exception {
        return playerRepository.findById(id)
                .orElseThrow(PlayerNotFoundException::new);
    }

    @PutMapping(value = "/{id}")
    public String update(@RequestParam String param) {
        return "updated";
    }
}
