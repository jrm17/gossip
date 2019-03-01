package es.mango;

import es.models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MangoGossips extends MangoUtil {

    protected List<Person> persons;
    private int minuts;
    private int max_persons;
    private int max_routes;

    public MangoGossips(int minuts, int max_persons, int max_routes) {
        this.minuts = minuts;
        this.max_persons = max_persons;
        this.max_routes = max_routes;
    }

    public String start() throws Exception {

        init();

        int index = 0;
        for (int i = 0; i < minuts; i++) {
            if (index > (max_routes - 1)) index = 0;
            process(index);

            //System.out.println("Hoop: " + (i+1));
            //persons.stream().map(Person::getGossips).forEach(System.out::println);
            if (persons.stream().noneMatch(person1 -> person1.getGossips().size() < max_persons)) {
                return "All people know all gosiips: " + (i+1);
            }
            index++;
        }

        return "All people know all gosiips: Never";
    }

    private void process(int index) throws Exception {
        int store;

        for (Person p : persons) {
            store = p.getRoute().get(index);
            getPersonsOnStore(index, store).forEach(person -> p.getGossips().addAll(person.getGossips()));
        }
    }

    private List<Person> getPersonsOnStore(int index, final int store) throws Exception {
        return persons.stream().filter(it -> it.getRoute().get(index) == store).collect(Collectors.toList());
    }


    private void init() throws Exception {
        persons = new ArrayList<>();

        Person p;
        for (int i = 1; i <= max_persons; i++) {
            persons.add(new Person(i, getRandomRoutes(max_routes)));
        }
    }

    public List<Integer> getRandomRoutes(int max_routes) throws Exception {
        List<Integer> routes = new ArrayList<>();

        for (int i = 1; i <= max_routes; i++) {
            routes.add( randomWithRange(1, max_routes) );
        }

        return routes;
    }

    protected List<Person> getPersons() {
        return persons;
    }
}
