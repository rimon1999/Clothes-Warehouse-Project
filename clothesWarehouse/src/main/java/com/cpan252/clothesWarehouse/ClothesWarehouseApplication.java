package com.cpan252.clothesWarehouse;

import com.cpan252.clothesWarehouse.Data.ItemRepository;
import com.cpan252.clothesWarehouse.model.Brand;
import com.cpan252.clothesWarehouse.model.ItemModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClothesWarehouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClothesWarehouseApplication.class, args);
    }

// Main class that include CommandLineRunner that added data to the database and the list.
    @Bean
    public CommandLineRunner dataLoader(ItemRepository repository) {
        return args -> {
            repository.save(new ItemModel("Sac Plat BB", Brand.LOUIS_VUITTON, 3000.00, 2023));
            repository.save(new ItemModel("On The Go PM", Brand.LOUIS_VUITTON, 3950.00, 2023));
            repository.save(new ItemModel("Jumbo GG medium messenger bag", Brand.GUCCI, 1490, 2022));
            repository.save(new ItemModel("Never-full Bag", Brand.STONE, 1400, 2023));
            repository.save(new ItemModel("Alma Bag", Brand.LOUIS_VUITTON, 2500, 2023));
            repository.save(new ItemModel("Capucines Bag", Brand.GUCCI, 4000, 2022));
            repository.save(new ItemModel("Twist Bag", Brand.ISLAND, 3800.00, 2023));
            repository.save(new ItemModel("Pochette Métis Bag", Brand.LOUIS_VUITTON, 2300, 2023));
            repository.save(new ItemModel("Jumbo GG small messenger bag", Brand.GUCCI, 1000, 2022));
            repository.save(new ItemModel("Petite Malle Bag", Brand.LOUIS_VUITTON, 1200, 2023));
            repository.save(new ItemModel("Go PM", Brand.LOUIS_VUITTON, 2099, 2023));
            repository.save(new ItemModel("Jumbo GG large messenger bag", Brand.GUCCI, 1599, 2022));
            repository.save(new ItemModel("Keep all Bag ", Brand.LOUIS_VUITTON, 1000, 2023));
            repository.save(new ItemModel("Artsy Bag PM", Brand.DIOR, 2500, 2023));
            repository.save(new ItemModel("Monogram Belt", Brand.GUCCI, 1300, 2022));

        };
    }
}
