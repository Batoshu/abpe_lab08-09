package person;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {
    public final static String[] NAMES = {
            "John", "Emily", "Michael", "Sarah", "David",
            "Sophia", "Daniel", "Emma", "James", "Olivia",
            "William", "Mia", "Joseph", "Ava", "Alexander"
    };

    public final static String[] SURNAMES = {
            "Smith", "Johnson", "Williams", "Brown", "Jones",
            "Garcia", "Miller", "Davis", "Rodriguez", "Martinez",
            "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson"
    };

    public final static String[] COMPANIES = {
            "TechCorp", "Global Innovations", "GreenPlanet", "BlueWave Technologies", "NextGen Solutions",
            "Sunrise Ventures", "Infinity Systems", "EcoFuture", "AlphaEdge", "Summit Enterprises",
            "Dynamic Horizons", "Visionary Labs", "PrimeSource", "CoreTech", "FutureGate"
    };

    public final static String[] COMPANIES_SUFFIX = {
            "", "Inc.", "Co.", "Corp.", "Ltd.", "LLC"
    };

    public final static String[] STREETS = {
            "Main Street", "Oak Avenue", "Maple Drive", "Pine Lane", "Elm Street",
            "Cedar Boulevard", "Birch Road", "Spruce Way", "Willow Terrace", "Chestnut Path",
            "Aspen Court", "Sycamore Crescent", "Hickory Lane", "Juniper Circle", "Alder Grove"
    };

    public final static String[] CITIES = {
            "New York", "Los Angeles", "Chicago", "Houston", "Phoenix",
            "Philadelphia", "San Antonio", "San Diego", "Dallas", "San Jose",
            "Austin", "Jacksonville", "Fort Worth", "Columbus", "Charlotte"
    };

    public final static String[] JOBS = {
            "Software Engineer", "Data Scientist", "Project Manager", "Graphic Designer", "Marketing Specialist",
            "Sales Executive", "Product Manager", "HR Specialist", "Operations Coordinator", "UX Designer",
            "Business Analyst", "Network Administrator", "Quality Assurance Analyst", "Cybersecurity Specialist",
            "DevOps Engineer"
    };

    public DataGenerator() {}

    public List<Person> generatePeopleList(int n) {
        var list = new ArrayList<Person>();

        for(int i = 0; i < n; ++i)
            list.add(generatePerson());

        return list;
    }

    public Person generatePerson() {
        var nameIndex = randInt(0, NAMES.length - 1);
        var name = NAMES[nameIndex];
        var surname = getRandomElement(SURNAMES);
        var sex = (nameIndex & 1) == 0 ? Sex.MALE : Sex.FEMALE;
        var bornYear = randInt(1960, 2001);
        var job = getRandomElement(JOBS);
        var company = generateCompany();
        var salary = Math.round((Math.random()*15000+10000)*100)/100;
        var address = generateAddress();
        return new Person(name, surname, sex, bornYear, job, company, salary, address);
    }

    private Company generateCompany() {
        var name = String.join(" ", getRandomElement(COMPANIES), getRandomElement(COMPANIES_SUFFIX));
        var year = randInt(1700, 2020);
        return new Company(name, year);
    }

    private Address generateAddress() {
        var street = getRandomElement(STREETS);
        var flatNo = String.valueOf(randInt(1, 100));
        var houseNo = String.valueOf(randInt(1, 300));
        var postalCode = String.format("%05d", randInt(501, 99950));
        var city = getRandomElement(CITIES);
        var country = "United States";
        return new Address(street, flatNo, houseNo, postalCode, city, country);
    }

    private String getRandomElement(String[] arr) {
        if (arr.length == 0) return "";
        var index = (int)(Math.random()*arr.length);
        return arr[index];
    }

    private int randInt(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }
}
