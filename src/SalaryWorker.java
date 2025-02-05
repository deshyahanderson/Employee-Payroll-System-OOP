package src;

public class SalaryWorker extends Worker {

    private double annualSalary;

    public SalaryWorker(String ID, String firstName, String lastName, int YOB, double annualSalary) {
        super(ID, firstName, lastName, YOB, 0);
        this.annualSalary = annualSalary;
    }

    @Override
    double calculateWeeklyPay(double hoursWorked) {
        return annualSalary / 52.0; // Calculate weekly pay from annual salary
    }

    @Override
    void displayWeeklyPay(double hoursWorked) {
        double weeklyPay = calculateWeeklyPay(hoursWorked); // Use the overridden method

        System.out.println("Weekly Pay (calculated from annual salary): $" + String.format("%.2f", weeklyPay));
    }

    @Override
    public String toJSONRecord() {
        return String.format("{\"annualSalary\": %.2f, %s}", this.annualSalary, super.toJSONRecord().substring(1)); // Remove the opening brace from super's JSON
    }

    @Override
    public String toXMLRecord() {
        return String.format("<annualSalary>%.2f</annualSalary>%s", this.annualSalary, super.toXMLRecord());
    }

    @Override
    public String toCSVRecord() {
        return String.format("%.2f,%s", this.annualSalary, super.toCSVRecord());
    }


}
