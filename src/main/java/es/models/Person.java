package es.models;

import java.io.Serializable;
import java.util.*;

public class Person implements Serializable {
    private static final long serialVersionUID = -3775716408262605583L;
    private int id;
    private String name;
    private List<Integer> route;
    private Set<Integer> gossips = new HashSet<>();

    public Person(int id, List<Integer> route) {
        this.id = id;
        this.name = "person_" + 1;
        this.route = route;
        this.getGossips().add( id );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getRoute() {
        return route;
    }

    public void setRoute(List<Integer> route) {
        this.route = route;
    }

    public Set<Integer> getGossips() {
        return gossips;
    }

    public void setGossips(Set<Integer> gossips) {
        this.gossips = gossips;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name) &&
                Objects.equals(route, person.route) &&
                Objects.equals(gossips, person.gossips);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, route, gossips);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", route=" + route +
                ", gossips=" + gossips +
                '}';
    }
}
