package JavaAdvanced.three.collection.Person;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Person<gender> implements Comparable<Person>{
    private int id;
    private String name;
    private String surname;
    private LocalDate birthday;
    private gender gender;

    public Person(){

    }

    public Person(String name, String surname, LocalDate birthday) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public int getId(){
        return id;
    }
    public Person setId(int id){
        this.id=id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Person setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    public LocalDate getBirthday(){return birthday; }

    public Person setBirthday(LocalDate birthday){
        this.birthday=birthday;
        return this;
    }

    public gender getGender() {
        return gender;
    }

    public Person setGender(gender gender) {
        this.gender = gender;
        return this;
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        Period period=birthday.until(now);
        int years = period.getYears();
        return years;
    }

    @Override
    public String toString() {
        return name + " " + surname + " "+ birthday + " "+ "age: "+ getAge()+" "+
                name + " " + surname + " "+ birthday + birthday.toString() + "age: "+ getAge() ;
    }

    @Override
    public int hashCode(){
        int hashCode = Objects.hash(name,surname,birthday);
        return hashCode;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person comparedObj = (Person) obj;
            return name.equals(comparedObj.getName()) &&
                    surname.equals(comparedObj.getSurname()) &&
                    birthday.equals(comparedObj.getBirthday());
        }
        return false;
    }

    @Override
    public int compareTo(Person o) {
        int result = 0;
        result = birthday.compareTo(o.getBirthday());//0
        if (result == 0) {
            result = name.compareTo(o.getName());//0
        }
        if (result == 0) {
            result = surname.compareTo(o.getSurname());
        }


        return result;
    }
}
