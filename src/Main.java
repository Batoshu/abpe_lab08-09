import person.DataGenerator;
import person.FileHelper;
import person.PersonHelper;

public class Main {
    public static void main(String[] args) {
        var dg = new DataGenerator();
        var ppl = dg.generatePeopleList(100);
        var fh = new FileHelper("test.txt");
        fh.saveListToFile(ppl);

        var pplList = new PersonHelper().convertListOfStringsToListOfPeople(fh.readFromFile());
        for(var person : pplList)
            System.out.println(person);
    }
}