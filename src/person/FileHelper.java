package person;

import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FileHelper {
    private String file;

    public FileHelper(String file) {
        this.file = file;
    }

    public boolean saveListToFile(List<Person> list) {
        try {
            var personHelper = new PersonHelper();
            var file = new File(this.file);
            if (!file.exists())
                file.createNewFile();

            var fileWriter = new FileWriter(file, true);
            for(var person : list)
                fileWriter.write(convertPersonToString(person) + "\n");

            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public List<String> readFromFile() {
        var lines = new ArrayList<String>();
        var file = new File(this.file);
        try {
            var fileReader = new FileReader(file);
            var buffer = new BufferedReader(fileReader);
            String row;
            while((row = buffer.readLine()) != null)
                lines.add(row);

        } catch (Exception e) {
            System.out.println(e);
        }
        return lines;
    }

    private String convertPersonToString(Person person) {
        var address = person.getAddress();
        var addressStr = String.join("_", address.getStreet(), address.getFlatNo(), address.getHouseNo(),
                address.getPostalCode(), address.getCity(), address.getCountry());
        var company = person.getCompany();
        var companyStr = String.join("_", company.getName(), String.valueOf(company.getYear()));

        return String.join(";", person.getName(), person.getSurname(), person.getSex().toString(),
                String.valueOf(person.getBornYear()), person.getJob(), String.valueOf(person.getSalary()), addressStr, companyStr);
    }
}
