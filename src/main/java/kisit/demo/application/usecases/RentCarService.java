package kisit.demo.application.usecases;

import kisit.demo.application.ports.CarRepository;
import kisit.demo.domain.Car;
import org.springframework.stereotype.Service;

@Service
public class RentCarService {

    private final CarRepository carRepository;

    public RentCarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void rentCar(String carId) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Автомобіль з ID '" + carId + "' не знайдено."));

        if (!car.canBeRented()) {
            throw new IllegalStateException(
                    "Автомобіль '" + car.getModel() + "' вже зайнятий і не може бути орендований.");
        }

        car.markAsRented();
        carRepository.save(car);

        System.out.println("✅ Успішна оренда: " + car.getModel() + " (ID: " + car.getId() + ")");
    }
}