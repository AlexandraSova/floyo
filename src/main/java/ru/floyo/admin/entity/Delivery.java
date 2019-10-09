package ru.floyo.admin.entity;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "delivery")
public class Delivery {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    public Delivery(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public Delivery() {
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return id == delivery.id &&
                Objects.equals(name, delivery.name) &&
                Objects.equals(price, delivery.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}
