package org.mps.person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Class representing a person with a name, age and gender.
 *
 * @author Luis Ruiz
 */
public class Person {

    private final String name;

    private final int age;

    private final String gender; //Male, Female

    /**
     * Constructs a person with a name, age and gender.
     *
     * @param name   the name of the person
     * @param age    the age of the person
     * @param gender the gender of the person
     */

    public Person(String name, int age, String gender) {
        if (name == "") {
            throw new RuntimeException("Empty Name");
        } else {
            this.name = name;
        }
        if (age < 0) {
            throw new RuntimeException("Wrong Age");
        } else {
            this.age = age;
        }
        if (gender != "Male" && gender != "Female") {
            throw new RuntimeException("Wrong Gender");
        } else {
            this.gender = gender;
        }
    }

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    public String gender() {
        return gender;
    }

    /**
     * Computes the average age of male and female persons in a list and returns the result in
     * an array of two elements (the first element is the male mean age and the second one is the
     * female mean age)
     *
     * @param persons
     * @return
     */

    /**
     *
     * Sumamos el total de las edades de cada general, a la par que sumamos la cantidad de personas de cada genero.
     * Finalmente dividimos esta suma de edades entre el total de personas de cada genero.
     */
    public double[] averageAgePerGender(List<Person> persons) {
        int males = 0;
        int females = 0;
        int malesAge = 0;
        int femalesAge = 0;
        for (Person p : persons) {
            if (p.gender().equals("Male")) {
                malesAge += p.age;
                males++;
            } else {
                femalesAge += p.age;
                females++;
            }
        }

            double averageMales = males == 0 ? 0 : (double) malesAge / males;
            double averageFemales = females == 0 ? 0 : (double) femalesAge / females;
            double[] res = {averageMales, averageFemales};
            return res;

    }
}
