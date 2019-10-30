package fi.aldowaldo.childminder.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_id")
    private Long id;

    private LocalDate birthday;

    @Column(name = "first_name")
    private String firstName;

    private boolean present;

    @OneToMany(mappedBy="child")
    private List<ChildSchedule> schedules;

    @ManyToOne
    @JoinColumn(name = "child_group_id")
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
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public List<ChildSchedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<ChildSchedule> schedules) {
        this.schedules = schedules;
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
                Objects.equals(firstName, child.firstName) &&
                Objects.equals(getChildGroup(), child.getChildGroup());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getBirthday(), firstName, isPresent(), getChildGroup());
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", birthday=" + birthday +
                ", present=" + present +
                '}';
    }
}
