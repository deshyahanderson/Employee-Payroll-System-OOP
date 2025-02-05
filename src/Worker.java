package src;

public class Worker extends Person {

    private String ID;
    private double hourlyPayRate;

    public Worker(String ID, String firstName, String lastName, int YOB, double hourlyPayRate) {
        super(firstName, lastName, YOB);
        this.ID = ID;
        this.hourlyPayRate = hourlyPayRate;
    }
    public String getID() {
        return ID;
    }

    public Worker(Person person, double hourlyPayRate) {
        super(person.getweeklyPay());
        this.hourlyPayRate = hourlyPayRate;
    }

    double calculateWeeklyPay(double hoursWorked) {
        double regularPay = 0;
        double overtimePay = 0;

        if (hoursWorked <= 40) {
            regularPay = hoursWorked * hourlyPayRate;
        } else {
            regularPay = 40 * hourlyPayRate;
            overtimePay = (hoursWorked - 40) * hourlyPayRate * 1.5;
        }

        return regularPay + overtimePay;
    }

    void displayWeeklyPay(double hoursWorked) {
        double regularPay = 0;
        double overtimePay = 0;
        double totalPay = 0;

        if (hoursWorked <= 40) {
            regularPay = hoursWorked * hourlyPayRate;
            totalPay = regularPay;
            System.out.println("Regular Pay ( " + hoursWorked + " hours): $" + String.format("%.2f", regularPay));
            System.out.println("Overtime Pay (0 hours): $0.00");

        } else {
            regularPay = 40 * hourlyPayRate;
            overtimePay = (hoursWorked - 40) * hourlyPayRate * 1.5;
            totalPay = regularPay + overtimePay;
            System.out.println("Regular Pay (40 hours): $" + String.format("%.2f", regularPay));
            System.out.println("Overtime Pay (" + (hoursWorked - 40) + " hours): $" + String.format("%.2f", overtimePay));
        }

        System.out.println("Total Pay: $" + String.format("%.2f", totalPay));
    }

    public String toJSONRecord() {
        return String.format("{\"hourlyPayRate\": %.2f}", this.hourlyPayRate);
    }

    public String toXMLRecord() {
        return String.format("<hourlyPayRate>%.2f</hourlyPayRate>", this.hourlyPayRate);
    }

    public String toCSVRecord() {
        return String.format("%.2f", this.hourlyPayRate); // Consistent formatting
    }
}