package person;

import java.util.ArrayList;
import java.util.List;

public class PersonHelper {
    public List<Person> convertListOfStringsToListOfPeople(List<String> list) {
        var people = new ArrayList<Person>();
        for(var line : list)
            people.add(convertStringToPerson(line));

        return people;
    }

    public Person convertStringToPerson(String data) {
        var fields = data.split(";");
        var name = fields[0];
        var surname = fields[1];
        var sex = Sex.valueOf(fields[2]);
        var bornYear = Integer.parseInt(fields[3]);
        var job = fields[4];
        var salary = Double.parseDouble(fields[5]);
        var address = convertStringToAddress(fields[6]);
        var company = convertStringToCompany(fields[7]);

        return new Person(name, surname, sex, bornYear, job, company, salary, address);
    }

    private Address convertStringToAddress(String data) {
        var fields = data.split("_");
        return new Address(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]);
    }

    private Company convertStringToCompany(String data) {
        var fields = data.split("_");
        return new Company(fields[0], Integer.parseInt(fields[1]));
    }
}
