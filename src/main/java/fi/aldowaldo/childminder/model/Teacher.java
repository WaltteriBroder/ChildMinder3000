package fi.aldowaldo.childminder.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "teacher_childgroup",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "childgroup_id"))
    private List<Childgroup> childgroups;

    public Teacher(String name) {
        this.name = name;
    }

    public Teacher() {
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

    public List<Childgroup> getChildgroups() {
        return childgroups;
    }

    public void setChildgroups(List<Childgroup> childgroups) {
        this.childgroups = childgroups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(getId(), teacher.getId()) &&
                Objects.equals(getName(), teacher.getName()) &&
                Objects.equals(getChildgroups(), teacher.getChildgroups());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName(), getChildgroups());
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", childgroups=" + childgroups +
                '}';
    }
}
