package ru.alishev.springcourse.dao;

import ru.alishev.springcourse.models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDAO {
    private  static int PRODUCT_COUNT;
    private List<Product> product;

    {
        product = new ArrayList<>();

        product.add(new Product(++PRODUCT_COUNT, "Картошка"));
        product.add(new Product(++PRODUCT_COUNT, "Гиря"));
    }

    public List<Product> index() {
        return product;
    }

    public Product show(int id) {
        return product.stream().filter(product -> product.getId() == id).findAny().orElse(null);
    }

}
