package emsi.university;

import emsi.university.entities.Product;
import emsi.university.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        productRepository.save(new Product(null, "Laptop", 1000, 10));
//        productRepository.save(new Product(null, "Tablet", 500, 10));
//        productRepository.save(new Product(null, "Smartphone", 200, 10));
        List<Product> products = productRepository.findAll();
        products.forEach(p->{
            System.out.println(p.toString());
        });
        Product product = productRepository.findById(Long.valueOf(1)).get();
        System.out.println(product.toString());
        System.out.println("----------------------------------------");
        List<Product> productList = productRepository.findByNameContains("o");
        productList.forEach(p->{
            System.out.println(p);
        });

        System.out.println("----------------------------------------");
        List<Product> productList2 = productRepository.search("%o%");
        productList2.forEach(p->{
            System.out.println(p);
        });

        System.out.println("----------------------------------------");
        List<Product> productList3 = productRepository.findByPriceGreaterThan(500);
        productList3.forEach(p->{
            System.out.println(p);
        });

        System.out.println("----------------------------------------");
        List<Product> productList4 = productRepository.searchByPrice(500);
        productList4.forEach(p->{
            System.out.println(p);
        });

    }
}
