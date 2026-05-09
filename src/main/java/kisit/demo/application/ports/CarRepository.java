package kisit.demo.application.ports;

import kisit.demo.domain.Car;
import java.util.Optional;

public interface CarRepository {
    Optional<Car> findById(String id);
    void save(Car car);
}

