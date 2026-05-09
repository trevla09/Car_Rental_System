package kisit.demo;

import kisit.demo.application.usecases.RentCarService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(RentCarService rentCarService) {
        return args -> {
            System.out.println("=== Тест: Оформлення оренди автомобіля ===\n");

            // Тест 1: успішна оренда
            System.out.println("--- Тест 1: Оренда вільного авто (ID: 1) ---");
            rentCarService.rentCar("1");

            // Тест 2: спроба орендувати вже зайняте авто
            System.out.println("\n--- Тест 2: Повторна оренда того ж авто (ID: 1) ---");
            try {
                rentCarService.rentCar("1");
            } catch (IllegalStateException e) {
                System.out.println("❌ Очікувана помилка: " + e.getMessage());
            }

            // Тест 3: спроба орендувати авто, що вже зайняте з початку (ID: 2)
            System.out.println("\n--- Тест 3: Оренда спочатку зайнятого авто (ID: 2) ---");
            try {
                rentCarService.rentCar("2");
            } catch (IllegalStateException e) {
                System.out.println("❌ Очікувана помилка: " + e.getMessage());
            }

            System.out.println("\n=== Тести завершено ===");
        };
    }
}