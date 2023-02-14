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
     * @param name the name of the person
     * @param age the age of the person
     * @param gender the gender of the person
     */

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String name(){ return name;}

    public int age(){ return age;}

    public String gender(){
        return gender;
    }

    /**
     * Computes the average age of male and female persons in a list and returns the result in
     * an array of two elements (the first element is the male mean age and the second one is the
     * female mean age)
     * @param persons
     * @return
     */
    public double[] averageAgePerGender(List<Person> persons) {
        int males = 0;
        int females = 0;
        int malesage = 0;
        int femalesage = 0;
        for (Person p : persons) {
            if (p.gender().equals("Male")) {
                malesage += p.age;
                males++;
            } else if (p.gender().equals("Female")) {
                femalesage += p.age;
                females++;
            } else {
                throw new Error("Wrong Gender");
            }
        }
        double[] res = {malesage/males, femalesage/females};
        return res;
    }

}
