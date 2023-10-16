package co.com.bancolombia.jpa;

import co.com.bancolombia.model.animales.Animal;
import co.com.bancolombia.model.animales.gateways.AnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class JpaAnimalImpl implements AnimalRepository {

    private JPARepositoryAdapter jpaRepositoryAdapter;

    @Override
    public Animal create(Animal animal) {
        String id = UUID.randomUUID().toString();
        animal.setId(id);
        jpaRepositoryAdapter.save(animal);
        return jpaRepositoryAdapter.findById(id);
    }

    @Override
    public Animal read(String id) {
        return jpaRepositoryAdapter.findById(id);
    }

    @Override
    public Animal update(String id, Animal animal) throws Exception {
        Animal animalUpd = jpaRepositoryAdapter.findById(id);

        if(animalUpd == null) throw new Exception("Animal not find");
        animalUpd.setNumeroPatas(animal.getNumeroPatas());
        animalUpd.setGenero(animal.getGenero());
        animalUpd.setEspecie(animal.getEspecie());
        animalUpd.setHabitad(animal.getHabitad());
        animalUpd.setDomestico(animal.isDomestico());

        jpaRepositoryAdapter.save(animalUpd);

        return animalUpd;
    }

    @Override
    public void delete(String id) {
       jpaRepositoryAdapter.deleteById(id);
    }

    @Override
    public List<Animal> getAll() {
        return jpaRepositoryAdapter.findAll();
    }
}
