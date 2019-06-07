package fi.aldowaldo.childminder.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ChildGroup {

    @Id
    @GeneratedValue
    @Column(name = "childgroup_id")
    private Long id;
    private String name;

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

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "ChildGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
