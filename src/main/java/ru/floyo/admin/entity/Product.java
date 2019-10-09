package ru.floyo.admin.entity;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "category")
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @JoinColumn(name = "collection")
    @ManyToOne(fetch = FetchType.EAGER)
    private Collection collection;

    @Column(name = "characteristic_name")
    private String characteristic_name;

    @Column(name = "characteristic_code")
    private String characteristic_code;

    @JoinColumn(name = "size")
    @ManyToOne(fetch = FetchType.EAGER)
    private Size size;

    @Column(name = "price")
    private Integer price;

    @Column(name = "discount")
    private Integer discount;

    @Column(name = "amount")
    private Integer amount;

    //article (category, collection, characteristic_code, size), ex:BG 1901 001 US
    //фиксированная длина 11 символов
    @Column(name = "article")
    private String article;

    public Product(String name, Category category, Collection collection, String characteristic_name, String characteristic_code, Size size, Integer price, Integer discount, Integer amount, String article) {
        this.name = name;
        this.category = category;
        this.collection = collection;
        this.characteristic_name = characteristic_name;
        this.characteristic_code = characteristic_code;
        this.size = size;
        this.price = price;
        this.discount = discount;
        this.amount = amount;
        this.article = article;
    }
    public Product()
    {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public String getCharacteristic_name() {
        return characteristic_name;
    }

    public void setCharacteristic_name(String characteristic_name) {
        this.characteristic_name = characteristic_name;
    }

    public String getCharacteristic_code() {
        return characteristic_code;
    }

    public void setCharacteristic_code(String characteristic_code) {
        this.characteristic_code = characteristic_code;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Objects.equals(name, product.name) &&
                Objects.equals(category, product.category) &&
                Objects.equals(collection, product.collection) &&
                Objects.equals(characteristic_name, product.characteristic_name) &&
                Objects.equals(characteristic_code, product.characteristic_code) &&
                Objects.equals(size, product.size) &&
                Objects.equals(price, product.price) &&
                Objects.equals(discount, product.discount) &&
                Objects.equals(amount, product.amount) &&
                Objects.equals(article, product.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, collection, characteristic_name, characteristic_code, size, price, discount, amount, article);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", collection=" + collection +
                ", characteristic_name='" + characteristic_name + '\'' +
                ", characteristic_code='" + characteristic_code + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", amount=" + amount +
                ", article='" + article + '\'' +
                '}';
    }
}
