public class Job {
    double salary;
    int yearsOfExperience;
    String jobPosition;
    String companyName;

    public Job(double salary, int yearsOfExperience, String jobPosition, String companyName) {
        this.salary = salary;
        this.yearsOfExperience = yearsOfExperience;
        this.jobPosition = jobPosition;
        this.companyName = companyName;
    }

    public void getSalary() {
        System.out.println("Salary: " + salary);
    }

    public void displaySummaryDetails() {
        System.out.println("Job Position: " + jobPosition);
        System.out.println("Company Name: " + companyName);
        System.out.println("Years of Experience: " + yearsOfExperience);
        System.out.println("Salary: " + salary);
    }

   
}
