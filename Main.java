public class Main {
    public static void main(String[] args) {
        SoftwareDeveloper dev1 = new SoftwareDeveloper(50000, 2, "Junior Developer", "Accenture");
        SoftwareDeveloper dev2 = new SoftwareDeveloper(70000, 4, "Senior Developer", "University of Makati");
        SoftwareDeveloper dev3 = new SoftwareDeveloper(60000, 3, "Mid-Level Developer", "Alorica");

        dev1.getSalary();
        dev2.getSalary();
        dev3.getSalary();
        dev1.displaySummaryDetails();
        dev2.displaySummaryDetails();
        dev3.displaySummaryDetails();
    }
}