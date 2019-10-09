package ru.floyo.admin.entity;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "\"order\"")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private Time time;

    @JoinColumn(name = "delivery")
    @ManyToOne(fetch = FetchType.EAGER)
    private Delivery delivery;

    @JoinColumn(name = "client")
    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;

    @JoinColumn(name = "status")
    @ManyToOne(fetch = FetchType.EAGER)
    private OrderStatus status;

    @Column(name = "address")
    private String address;

    @Column(name = "comment")
    private String comment;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<OrderLine> orderLineEntities = new HashSet<OrderLine>();

    public Order(Date date, Time time, Delivery delivery, Client client, OrderStatus status, Set<OrderLine> orderLineEntities) {
        this.date = date;
        this.time = time;
        this.delivery = delivery;
        this.client = client;
        this.status = status;
        this.orderLineEntities = orderLineEntities;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Set<OrderLine> getOrderLineEntities() {
        return orderLineEntities;
    }

    public void setOrderLineEntities(Set<OrderLine> orderLineEntities) {
        this.orderLineEntities = orderLineEntities;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", date=" + date +
                ", time=" + time +
                ", delivery=" + delivery +
                ", client=" + client +
                ", status='" + status + '\'' +
                ", address='" + address + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order that = (Order) o;
        return id == that.id &&
                Objects.equals(date, that.date) &&
                Objects.equals(time, that.time) &&
                Objects.equals(delivery, that.delivery) &&
                Objects.equals(client, that.client) &&
                Objects.equals(status, that.status) &&
                Objects.equals(address, that.address) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, time, delivery, client, status, address, comment);
    }
}
