package co.com.bancolombia.model.animales.gateways;

import co.com.bancolombia.model.animales.Animal;

import java.util.List;

public interface AnimalRepository {
    Animal create(Animal animal);

    Animal read(String id);
    default Animal update(String id, Animal animal) throws Exception{
        return animal;
    }

    void delete(String animal);

    List<Animal> getAll();

}
