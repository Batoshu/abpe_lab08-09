package person;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Company {
    private String name;
    private int year;

    public Company(String name, int year) {
        this.name = name;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.year + ")";
    }
}
