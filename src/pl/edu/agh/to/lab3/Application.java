package pl.edu.agh.to.lab3;

import java.util.Collection;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        Collection<Person> persons = new PersonDataProvider().getAllCracovCitizens();
        Map<String, Collection<Prisoner>> prisoners = new PrisonersDatabase().findAll();
        Finder suspects = new Finder(persons, prisoners);
        suspects.displayAllSuspectsWithName("Janusz");
    }
}
