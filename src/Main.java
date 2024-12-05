import person.DataGenerator;
import person.FileHelper;
import person.PersonHelper;
import person.StatisticHelper;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        var dg = new DataGenerator();
        var ppl = dg.generatePeopleList(300);
        var fh = new FileHelper("test.txt");
        fh.saveListToFile(ppl);

        var stats = new StatisticHelper("test.txt");
        printStats(stats);
    }

    public static void printStats(StatisticHelper stats) {
        System.out.println("Oldest People: " + stats.findOldestPeople());
        System.out.println("Number of Men: " + stats.numberOfMen());
        System.out.println("Number of Women: " + stats.numberOfWomen());
        System.out.println("Average Age: " + stats.averageAge());
        System.out.println("Average Salary: " + stats.averageSalary());
        System.out.println("Average Salary for Men: " + stats.averageSalaryForMen());
        System.out.println("Average Salary for Women: " + stats.averageSalaryForWomen());
        System.out.println("Minimum Salary: " + stats.findMinSalary());
        System.out.println("Maximum Salary: " + stats.findMaxSalary());

        System.out.println("Average Salary by City:");
        Map<String, Double> salaryByCity = stats.averageSalaryByCity();
        for (Map.Entry<String, Double> entry : salaryByCity.entrySet()) {
            System.out.println(entry.getKey() + ": " + Math.round(entry.getValue()));
        }
    }
}