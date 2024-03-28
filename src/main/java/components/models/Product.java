package components.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min=2, max=30, message = "min 2 and max 30")
    @Column(name = "name")
    private String name;

    @Size(min=2, max=100, message = "min 2 and max 100")
    @Column(name = "description")
    private String description;

    @Size(min=2, max=30, message = "min 2 and max 30")
    @Column(name = "category")
    private String category;
    @Min(value = 0, message = "> 0")
    @Column(name = "price")
    private float price;
    @Min(value = 0, message = "> 0")
    @Column(name = "count")
    private int count;

    public Product() {}

    public Product( String name, String description, String category, float price, int count) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}