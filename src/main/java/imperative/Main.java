package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static imperative.Main.Gender.*;

public class Main {
    public static void main(String[] args){
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );

        System.out.println("----- IMPERATIVE APPROACH -----");

        // Imperative approach
        List<Person> females = new ArrayList<>();
        for(Person person : people){
            if(FEMALE.equals(person.gender)){
                females.add(person);
            }
        }

        List<Person> males = new ArrayList<>();
        for(Person person : people){
            if(MALE.equals(person.gender)){
                males.add(person);
            }
        }

        System.out.println("Females:");
        for(Person female: females){
            if(FEMALE.equals(female.gender)) {
                System.out.println(female);
            }
        }

        System.out.println("Males:");
        for(Person male: males){
            if(MALE.equals(male.gender)) {
                System.out.println(male);
            }
        }

        System.out.println("----- DECLARATIVE APPROACH -----");

        // Declarative approach
        people.stream()
                .filter(person -> FEMALE.equals(person.gender)) // filter by the Predicate
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    static class Person{
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender){
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender{
        MALE,
        FEMALE
    }
}
