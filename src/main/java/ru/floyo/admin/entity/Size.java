package ru.floyo.admin.entity;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "size")
public class Size {

    @Id
    @Column(name = "id")
    private String id;

    public Size(String id) {
        this.id = id;
    }

    public Size() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Size{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Size size = (Size) o;
        return id == size.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
