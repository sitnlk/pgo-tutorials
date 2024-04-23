import java.util.ArrayList;
import java.util.List;

class Employee {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String pesel;
    private int yearOfEmployment;

    public Employee(String firstName, String lastName, String address, String email, String pesel, int yearOfEmployment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.pesel = pesel;
        this.yearOfEmployment = yearOfEmployment;
    }

    public int calculateBaseSalary() {
        int currentYear = 2024; // Assuming the current year is 2024
        int yearsWorked = currentYear - yearOfEmployment;
        int baseSalary = 3000 + yearsWorked * 1000;
        return baseSalary;
    }

    public int calculateSalary() {
        return calculateBaseSalary();
    }
}

class Developer extends Employee {
    private List<Technology> technologies;

    public Developer(String firstName, String lastName, String address, String email, String pesel, int yearOfEmployment) {
        super(firstName, lastName, address, email, pesel, yearOfEmployment);
        this.technologies = new ArrayList<>();
    }

    public void addTechnology(Technology technology) {
        technologies.add(technology);
    }

    @Override
    public int calculateSalary() {
        int baseSalary = calculateBaseSalary();
        int bonus = 0;
        for (Technology tech : technologies) {
            bonus += tech.getBonus();
        }
        return baseSalary + bonus;
    }
}

class Tester extends Employee {
    private List<String> testTypes;

    public Tester(String firstName, String lastName, String address, String email, String pesel, int yearOfEmployment) {
        super(firstName, lastName, address, email, pesel, yearOfEmployment);
        this.testTypes = new ArrayList<>();
    }

    public void addTestType(String testType) {
        testTypes.add(testType);
    }

    @Override
    public int calculateSalary() {
        int baseSalary = calculateBaseSalary();
        int bonus = testTypes.size() * 300; // Assuming each test type gives a bonus of 300 PLN
        return baseSalary + bonus;
    }
}

class Manager extends Employee {
    private List<Goal> goals;

    public Manager(String firstName, String lastName, String address, String email, String pesel, int yearOfEmployment) {
        super(firstName, lastName, address, email, pesel, yearOfEmployment);
        this.goals = new ArrayList<>();
    }

    public void addGoal(Goal goal) {
        goals.add(goal);
    }

    @Override
    public int calculateSalary() {
        int baseSalary = calculateBaseSalary();
        int bonus = 0;
        for (Goal goal : goals) {
            if (goal.isAchieved()) {
                bonus += goal.getBonusAmount();
            }
        }
        return baseSalary + bonus;
    }
}

class Technology {
    private String name;
    private int bonus;

    public Technology(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }
}

class Goal {
    private String name;
    private boolean achieved;
    private int bonusAmount;

    public Goal(String name, boolean achieved, int bonusAmount) {
        this.name = name;
        this.achieved = achieved;
        this.bonusAmount = bonusAmount;
    }

    public boolean isAchieved() {
        return achieved;
    }

    public int getBonusAmount() {
        return bonusAmount;
    }
}
