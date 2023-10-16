package co.com.bancolombia.usecase.animalescasos;

import co.com.bancolombia.model.animales.Animal;
import co.com.bancolombia.model.animales.gateways.AnimalRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class AnimalUseCase {
    private AnimalRepository animalRepository;

    public Animal create(Animal animal){
        System.out.println(animal);
        animalRepository.create(animal);
        return animal;
    }

    public Animal read(String idAnimal){return animalRepository.read(idAnimal);}
    public Animal update(String id, Animal animal) throws Exception{
        Animal update = animalRepository.update(id, animal);
        return update;
    }
    public void delete(String id){ animalRepository.delete(id);}

    public List<Animal> getAll(){return animalRepository.getAll();}
}
