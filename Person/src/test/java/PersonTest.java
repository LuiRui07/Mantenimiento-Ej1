
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mps.person.Person;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


public class PersonTest {

    Person p ;

    @BeforeEach
    /*
    Inicializamos la variable p (Persona) antes de cada test.
    */
    void setUp(){
        p = new Person("Pepe",20,"Male");
    }

    /*
    Tras cada test establecemos como nula la variable p (Persona) con la que probamos, para evitar problemas.
    */
    @AfterEach
    void shutDown(){
        Person p = null;
    }

    /*
    Comprobamos que el metodo name() devuelve el nombre correctamente.
    */
    @Test
    void NameGetter(){
        assertEquals("Pepe",p.name());
    }

    /*
    Comprobamos que el metodo age() devuelve la edad correctamente.
    */
    @Test
    void AgeGetter(){
        assertEquals(20,p.age());
    }

    /*
    Comprobamos que el metodo gender() devuelve el genero correctamente.
    */
    @Test
    void GenderGetter(){
        assertEquals("Male",p.gender());
    }

    /*
    Comprobamos que lance una excepcion ante una edad erronea.
    */
    @Test
    void WrongAge(){
        Exception thrown = assertThrows(
                RuntimeException.class,
                () -> p = new Person("Pepe",-1,"Male"));
        assertTrue(thrown.getMessage().contentEquals("Wrong Age"));
    }

    /*
    Comprobamos que lance una excepcion ante un genero erroneo.
    */
    @Test
    void WrongGender(){
        Exception thrown = assertThrows(
                RuntimeException.class,
                () -> p = new Person("Pepe",10,"Lala"));
        assertTrue(thrown.getMessage().contentEquals("Wrong Gender"));
    }

    /*
    Comprobamos que lance una excepcion ante una nombre nulo.
    */
    @Test
    void EmptyName(){
        Exception thrown = assertThrows(
                RuntimeException.class,
                () -> p = new Person("",10,"Lala"));
        assertTrue(thrown.getMessage().contentEquals("Empty Name"));
    }

    /*
    Comprobamos que funcione el metodo averageAgePerGender.
    */
    @Test
    void CorrectAverage(){
        Person p1 = new Person("Marta", 25, "Female");
        Person p2 = new Person("Alba", 28, "Female");
        Person p3 = new Person("Sonia", 19, "Female");

        Person p4 = new Person("Jaime", 21, "Male");
        Person p5 = new Person("Joel", 45, "Male");
        Person p6 = new Person("Carles", 14, "Male");

        List<Person> persons = Arrays.asList(p1, p2, p3, p4, p5, p6);

        double [] averages = p.averageAgePerGender(persons);
        assertEquals(24.0, averages[1], 0.1);
        assertEquals(26.66, averages[0], 0.1);
    }

    /*
    Comprobamos que funcione el metodo averageAgePerGender ante un numero nulo de varones.
    */
    @Test
    void EmptyMales(){
        Person p1 = new Person("Marta", 25, "Female");
        Person p2 = new Person("Alba", 28, "Female");
        Person p3 = new Person("Sonia", 19, "Female");

        List<Person> persons = Arrays.asList(p1, p2, p3);

        double [] averages = p.averageAgePerGender(persons);
        assertEquals(24.0, averages[1], 0.1);
        assertEquals(0.00, averages[0], 0.1);
    }

    /*
    Comprobamos que funcione el metodo averageAgePerGender ante un numero nulo de mujeres.
    */
    @Test
    void EmptyFemales(){
        Person p4 = new Person("Jaime", 21, "Male");
        Person p5 = new Person("Joel", 45, "Male");
        Person p6 = new Person("Carles", 14, "Male");

        List<Person> persons = Arrays.asList(p4,p5,p6);

        double [] averages = p.averageAgePerGender(persons);
        assertEquals(00.0, averages[1], 0.1);
        assertEquals(26.66, averages[0], 0.1);
    }

    /*
    Comprobamos que lance una excepcion si se le pasa por parametro una lista vacia.
    */
    @Test
    void EmptyList() {
        List<Person> persons = null;
        Exception thrown = assertThrows(
                RuntimeException.class,
                () -> p.averageAgePerGender(persons));
        assertTrue(thrown.getMessage().contentEquals("Empty List"));
    }
}
