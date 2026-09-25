class SoftwareDeveloper extends Job {
    public SoftwareDeveloper(double salary, int yearsOfExperience, String jobPosition, String companyName) {
        super(salary, yearsOfExperience, jobPosition, companyName);
    }

    @Override
    public void getSalary() {
        if (yearsOfExperience > 3) {
            salary += salary * 0.30;
        } else {
            salary += salary * 0.05;
        }
        System.out.println("The salary is: P" +salary);
    }
} 