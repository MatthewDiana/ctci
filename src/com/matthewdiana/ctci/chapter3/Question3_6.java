package com.matthewdiana.ctci.chapter3;

import java.util.LinkedList;
import java.util.List;

public class Question3_6 {

    public static void main(String[] args) {

        AnimalShelter as = new AnimalShelter();
        as.enqueue(new ShelterAnimal("Billy", ShelterAnimal.DOG));
        as.enqueue(new ShelterAnimal("Bob", ShelterAnimal.CAT));
        System.out.println(as.dequeueAny().name);

    }

}

class AnimalShelter {

    private LinkedList<ShelterAnimal> dogs;
    private LinkedList<ShelterAnimal> cats;

    public AnimalShelter() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
    }

    public void enqueue(ShelterAnimal sa) {
        if (sa.type.equals(ShelterAnimal.CAT)) {
            cats.add(sa);
        } else {
            dogs.add(sa);
        }
    }

    public ShelterAnimal dequeueAny() {
        if (dogs.isEmpty()) {
            return dequeueCat();
        } else if (cats.isEmpty()) {
            return dequeueDog();
        } else {
            if (dogs.peek().id < cats.peek().id) {
                return dequeueDog();
            } else {
                return dequeueCat();
            }
        }
    }

    public ShelterAnimal dequeueCat() {
        if (cats.isEmpty()) {
            throw new Error();
        }
        return cats.poll();
    }

    public ShelterAnimal dequeueDog() {
        if (dogs.isEmpty()) {
            throw new Error();
        }
        return dogs.poll();
    }

}

class ShelterAnimal {

    public static final String CAT = "cat";
    public static final String DOG = "dog";

    private static int animalCount = 0;

    public int id;
    public String name;
    public String type;

    public ShelterAnimal(String name, String type) {
        this.id = ++animalCount;
        this.name = name;
        this.type = type;
    }
}