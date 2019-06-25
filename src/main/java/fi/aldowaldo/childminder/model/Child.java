package fi.aldowaldo.childminder.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Child {

    @Id
    @GeneratedValue()
    @Column(name = "child_id")
    private Long id;
    private LocalDate birthday;
    private String first_name;
    private boolean present;

    @ManyToOne
    @JoinColumn(name = "childgroup_id")
    private ChildGroup childGroup;

    public Child() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public ChildGroup getChildGroup() {
        return childGroup;
    }

    public void setChildGroup(ChildGroup childGroup) {
        this.childGroup = childGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Child)) return false;
        Child child = (Child) o;
        return isPresent() == child.isPresent() &&
                Objects.equals(getId(), child.getId()) &&
                Objects.equals(getBirthday(), child.getBirthday()) &&
                Objects.equals(first_name, child.first_name) &&
                Objects.equals(getChildGroup(), child.getChildGroup());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getBirthday(), first_name, isPresent(), getChildGroup());
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", birthday=" + birthday +
                ", present=" + present +
                '}';
    }
}
