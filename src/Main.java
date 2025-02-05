package src;
import java.util.ArrayList;

public class Main {

public static void main(String[] args) {
    ArrayList<Worker> folks = new ArrayList<>();

    //Create 3 worker instances
    Worker w1 = new Worker("W001", "Sally", "Smith", 2005, 15.0); // ID, Name, YOB, Hourly Rate
    Worker w2 = new Worker("W002", "Fred", "Williams", 1970, 20.0);
    Worker w3 = new Worker("W003", "Homer", "Simpson", 1972, 18.0);

    // Create 3 SalaryWorker instances
    SalaryWorker sw1 = new SalaryWorker("S001", "Kobe", "Crawford", 1960, 60000.0); // ID, Name, YOB, Annual Salary
    SalaryWorker sw2 = new SalaryWorker("S002", "Herbert", "Wright", 1962, 75000.0);
    SalaryWorker sw3 = new SalaryWorker("S003", "Dayvon", "Bennet", 1990, 90000.0);

    folks.add(w1);
    folks.add(w2);
    folks.add(w3);
    folks.add(sw1);
    folks.add(sw2);
    folks.add(sw3);

    //Pay periods
    int[] hoursWorked = {40, 50, 40}; // Week 1, Week 2, Week 3

    // Table header
    System.out.printf("%-15s %-15s %-10s %-10s %-10s%n", "Employee ID", "Name", "Week 1", "Week 2", "Week 3");
    System.out.printf("%-15s %-15s %-10s %-10s %-10s%n", "-----------", "----", "------", "------", "------");


    for (Worker employee : folks) {
        System.out.printf("%-15s %-15s", employee.getID(), employee.getFirstName() + " " + employee.getLastName()); // ID and Name

        for (int i = 0; i < hoursWorked.length; i++) {
            double pay = employee.calculateWeeklyPay(hoursWorked[i]);
            System.out.printf(" $%8.2f", pay); // Formatted pay
        }
        System.out.println();
    }

    System.out.println("\nFile Storage formats:");

    System.out.println("JSON: " + w1.toJSONRecord());
    System.out.println("XML:  " + w1.toXMLRecord());
    System.out.println("CSV:  "+ w1.toCSVRecord());

}

}