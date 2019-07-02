package fi.aldowaldo.childminder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Childgroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "childgroup_id")
    private Long id;
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "childgroups")
    List<Teacher> teachers;

    public Childgroup(String name) {
        this.name = name;
    }

    public Childgroup() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Childgroup)) return false;
        Childgroup that = (Childgroup) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getTeachers(), that.getTeachers());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName(), getTeachers());
    }

    @Override
    public String toString() {
        return "Childgroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
