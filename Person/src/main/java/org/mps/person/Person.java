package org.mps.person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Person {

    private final String name;

    private final int age;

    private final String gender; //Male, Female




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








    public double[] averageAgePerGender(List<Person> persons){
        List<Integer> males = new ArrayList<>();
        List<Integer> females = new ArrayList<>();
        for (int i = 0; i < persons.size(); i++){
            if (persons.get(i).gender().equals("Male")){
                males.add(persons.get(i).age);
            } else {
                females.add(persons.get(i).age);
            }
        }
        double[] res = {media(males),media(females)};
        return res;
    }

    private double media(List<Integer> persons){
        int sz = persons.size();
        double res;
        int suma = 0;
        for (int i = 0; i< persons.size(); i++){
            suma += persons.get(i);
        }
        return suma/sz;
    }

}
