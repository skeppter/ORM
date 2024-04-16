package com.example.accessingdatamysql;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DataLoader implements CommandLineRunner {

    private final WarehouseRepository warehouseRepository;
    private final ProductRepository productRepository;

    public DataLoader(WarehouseRepository warehouseRepository, ProductRepository productRepository) {
        this.warehouseRepository = warehouseRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create Warehouses
        Warehouse w1 = new Warehouse(null, "Warehouse 1", "1234 Street", new ArrayList<>());
        Warehouse w2 = new Warehouse(null, "Warehouse 2", "5678 Avenue", new ArrayList<>());

        warehouseRepository.save(w1);
        warehouseRepository.save(w2);

        // Create Products and assign to warehouses
        for (int i = 1; i <= 10; i++) {
            Product p = new Product();
            p.setName("Product " + i);
            p.setPrice(i * 10);
            p.setWarehouse(i <= 5 ? w1 : w2);  // First 5 products in Warehouse 1, rest in Warehouse 2
            productRepository.save(p);
        }
    }
}
