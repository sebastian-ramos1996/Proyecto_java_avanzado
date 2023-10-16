package co.com.bancolombia.api;
import co.com.bancolombia.model.animales.Animal;
import co.com.bancolombia.usecase.animalescasos.AnimalUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final AnimalUseCase animalUseCase;


    @GetMapping(path = "/path")
    public String commandName() {
//      return useCase.doAction();
        return "Hello, is conected!";
    }
    @GetMapping(path = "/animal_read/{id}")
    public Animal read(@PathVariable String id) {
        return animalUseCase.read(id);
    }

    @PostMapping(path = "/animal_create")
    public Animal create(@RequestBody Animal animal) {



        try {
            animalUseCase.create(animal);
            return animal;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PutMapping(path = "/animal_update/{id}")

    public Animal update(@PathVariable String id, @RequestBody Animal animal) {
        try {
            animalUseCase.update(id, animal);
            return animal;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }

    @DeleteMapping(path = "/animal_delete/{id}")
    public String delete(@PathVariable String id) {
        try {
            animalUseCase.delete(id);
            return "Successfully Deleted Record!";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(path = "/animal_all")
    public List<Animal> getAll() {
        return animalUseCase.getAll();
    }


}
