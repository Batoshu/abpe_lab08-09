package person;

import java.time.Year;
import java.util.*;

public class StatisticHelper {
    private List<Person> list;

    public StatisticHelper(List<Person> list) {
        this.list = list;
    }

    public StatisticHelper(String file) {
        var personHelper = new PersonHelper();
        var fileHelper = new FileHelper(file);
        var data = fileHelper.readFromFile();
        this.list = new ArrayList<Person>();
        for(var personData : data)
            this.list.add(personHelper.convertStringToPerson(personData));
    }

    public List<Person> findOldestPeople() {
        var minYear = list.stream().min(Comparator.comparingInt(Person::getBornYear)).get().getBornYear();
        return list.stream().filter(p -> p.getBornYear() == minYear).toList();
    }

    public long numberOfMen() {
        return list.stream().filter(p -> p.getSex() == Sex.MALE).count();
    }

    public long numberOfWomen() {
        return list.stream().filter(p -> p.getSex() == Sex.FEMALE).count();
    }

    public double averageAge() {
        var sum = 0;
        var year = Year.now().getValue();
        for(var person : list)
            sum += year - person.getBornYear();
        return (double) sum / list.size();
    }

    public double averageSalary() {
        var sum = 0d;
        for(var person : list)
            sum += person.getSalary();
        return (double) sum / list.size();
    }

    public double averageSalaryForMen() {
        var sum = 0d;
        var list = this.list.stream().filter(p -> p.getSex() == Sex.MALE).toList();
        for(var person : list)
            sum += person.getSalary();
        return (double) sum / list.size();
    }

    public double averageSalaryForWomen() {
        var sum = 0d;
        var list = this.list.stream().filter(p -> p.getSex() == Sex.FEMALE).toList();
        for(var person : list)
            sum += person.getSalary();
        return (double) sum / list.size();
    }

    public double findMinSalary() {
        return list.stream().min(Comparator.comparingDouble(Person::getSalary)).get().getSalary();
    }

    public double findMaxSalary() {
        return list.stream().max(Comparator.comparingDouble(Person::getSalary)).get().getSalary();
    }

    public Map<String, Double> averageSalaryByCity() {
        var sums = new HashMap<String, Double>();
        var counts = new HashMap<String, Integer>();
        for(var person : list) {
            var city = person.getAddress().getCity();
            if (sums.containsKey(city))
                sums.put(city, sums.get(city) + person.getSalary());
            else
                sums.put(city, person.getSalary());

            if (counts.containsKey(city))
                counts.put(city, counts.get(city) + 1);
            else
                counts.put(city, 1);
        }

        sums.replaceAll((c, v) -> v / counts.get(c));
        return sums;
    }
}
