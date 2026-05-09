package kisit.demo.infrastructure;

import kisit.demo.application.ports.CarRepository;
import kisit.demo.domain.Car;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryCarRepository implements CarRepository {

    private final Map<String, Car> storage = new HashMap<>();

    public InMemoryCarRepository() {
        // Початкові дані
        storage.put("1", new Car("1", "Toyota Camry", true));
        storage.put("2", new Car("2", "BMW X5", false)); // вже зайнятий
    }

    @Override
    public Optional<Car> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public void save(Car car) {
        storage.put(car.getId(), car);
    }
}