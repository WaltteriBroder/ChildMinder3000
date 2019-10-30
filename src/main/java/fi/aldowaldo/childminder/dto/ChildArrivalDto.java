package fi.aldowaldo.childminder.dto;

import java.util.Date;

public class ChildArrivalDto {

    private Long id;
    private String firstName;
    private boolean present;
    private Date arrival;
    private Date departure;
    private Long childGroupId;
    private String childGroupName;

    public ChildArrivalDto(Long id, String firstName, boolean present, Date arrival, Date departure) {
        this.id = id;
        this.firstName = firstName;
        this.present = present;
        this.arrival = arrival;
        this.departure = departure;
    }

    public ChildArrivalDto(Long id, String firstName, boolean present, Date arrival, Date departure, Long childGroupId, String childGroupName) {
        this.id = id;
        this.firstName = firstName;
        this.present = present;
        this.arrival = arrival;
        this.departure = departure;
        this.childGroupId = childGroupId;
        this.childGroupName = childGroupName;
    }

    public ChildArrivalDto() {
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

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Long getChildGroupId() {
        return childGroupId;
    }

    public void setChildGroupId(Long childGroupId) {
        this.childGroupId = childGroupId;
    }

    public String getChildGroupName() {
        return childGroupName;
    }

    public void setChildGroupName(String childGroupName) {
        this.childGroupName = childGroupName;
    }

    @Override
    public String toString() {
        return "ChildArrivalDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", present=" + present +
                ", arrival=" + arrival +
                ", departure=" + departure +
                ", childGroupId=" + childGroupId +
                ", childGroupName='" + childGroupName + '\'' +
                '}';
    }
}
