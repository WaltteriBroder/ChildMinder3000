package fi.aldowaldo.childminder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class ChildGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_group_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy="childGroup")
    private List<Child> children;

    @JsonIgnore
    @ManyToMany(mappedBy = "childGroups")
    List<Teacher> teachers;

    public ChildGroup(String name) {
        this.name = name;
    }

    public ChildGroup() {
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

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
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
        if (!(o instanceof ChildGroup)) return false;
        ChildGroup that = (ChildGroup) o;
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
        return "ChildGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
