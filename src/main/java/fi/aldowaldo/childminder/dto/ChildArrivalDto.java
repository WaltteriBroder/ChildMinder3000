package fi.aldowaldo.childminder.dto;

import java.util.Date;

public class ChildArrivalDto {

    private Long id;
    private String first_name;
    private boolean present;
    private Date arrival;
    private Date departure;

    public ChildArrivalDto(Long id, String first_name, boolean present, Date arrival, Date departure) {
        this.id = id;
        this.first_name = first_name;
        this.present = present;
        this.arrival = arrival;
        this.departure = departure;
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
        return first_name;
    }

    public void setFirstName(String name) {
        this.first_name = name;
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

    @Override
    public String toString() {
        return "ChildArrivalDto{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", present=" + present +
                ", arrival=" + arrival +
                ", departure=" + departure +
                '}';
    }
}
