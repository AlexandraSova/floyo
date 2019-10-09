package ru.floyo.admin.entity;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orderline")
public class OrderLine {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "product")
    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    @Column(name = "amount")
    private Integer amount;

    @JoinColumn(name = "\"order\"")
    @ManyToOne(fetch = FetchType.EAGER)
    private Order order;

    public OrderLine(Product product, Integer amount, Order order) {
        this.product = product;
        this.amount = amount;
        this.order = order;
    }

    public OrderLine() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", amount='" + amount + '\'' +
                ", order='" + order + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLine orderLine = (OrderLine) o;
        return id == orderLine.id &&
                Objects.equals(product, orderLine.product) &&
                Objects.equals(amount, orderLine.amount) &&
                Objects.equals(order, orderLine.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, amount, order);
    }
}
