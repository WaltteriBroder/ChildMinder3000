package fi.aldowaldo.childminder.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;

@Entity
public class ChildSchedule {

    @Id
    @GeneratedValue
    @Column(name = "schedule_id")
    private Long id;
    private LocalDate date;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "child_id")
    private Child child;
    private Time arrive;
    private Time departure;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public Time getArrive() {
        return arrive;
    }

    public void setArrive(Time arrive) {
        this.arrive = arrive;
    }

    public Time getDeparture() {
        return departure;
    }

    public void setDeparture(Time departure) {
        this.departure = departure;
    }
}