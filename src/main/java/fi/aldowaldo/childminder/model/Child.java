package fi.aldowaldo.childminder.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Child {

    @Id
    @GeneratedValue
    @Column(name = "child_id")
    private Long id;
    private String firstName;
    private LocalDate birthday;
    private boolean present;

    @Column(name = "group_id")
    private Long groupId;

    public Child(String firstName, LocalDate birthday, boolean present) {
        this.firstName = firstName;
        this.birthday = birthday;
        this.present = present;
    }

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

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
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
