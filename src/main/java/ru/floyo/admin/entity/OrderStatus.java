package ru.floyo.admin.entity;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orderstatus")
public class OrderStatus {

    @Id
    @Column(name = "status")
    private String id;

    public OrderStatus() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "OrderStatusEntity{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderStatus that = (OrderStatus) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
