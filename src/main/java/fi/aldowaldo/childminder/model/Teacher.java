package fi.aldowaldo.childminder.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Teacher {

    @Id
    @GeneratedValue
    @Column(name = "teacher_id")
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "teacher_childgroup",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "childgroup_id"))
    private List<ChildGroup> childGroups;

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

    public List<ChildGroup> getChildGroups() {
        return childGroups;
    }

    public void setChildGroups(List<ChildGroup> childGroups) {
        this.childGroups = childGroups;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", childGroups=" + childGroups +
                '}';
    }
}
