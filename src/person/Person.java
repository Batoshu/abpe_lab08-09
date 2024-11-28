package person;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {
    @Setter
    @Getter
    private String name;
    private String surname;
    private Sex sex;
    private int bornYear;
    private String job;
    private Company company;
    private double salary;
    private Address address;

    public Person(String name, String surname, Sex sex, int bornYear, String job, Company company, double salary, Address address) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.bornYear = bornYear;
        this.job = job;
        this.company = company;
        this.salary = salary;
        this.address = address;
    }
}
