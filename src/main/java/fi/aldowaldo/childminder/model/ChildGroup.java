package fi.aldowaldo.childminder.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ChildGroup {

    @Id
    @GeneratedValue
    @Column(name = "group_id")
    private Long id;
    private String name;

    @OneToMany
    @JoinColumn(name = "child_id", referencedColumnName = "group_id")
    private List<Child> children;

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

    @Override
    public String toString() {
        return "ChildGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", children=" + children +
                '}';
    }
}
