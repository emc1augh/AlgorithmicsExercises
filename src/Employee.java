package ExerciseCode2;

/**
 * <dl>
 * <dt>Purpose: Company Employees.
 * <dd>
 * <p>
 * <dt>Description:
 * <dd>Class representing company employees described by their name, date of
 * birth, gender, salary and job title.
 * </dl>
 *
 * @author Danny Alexander
 * @version $Date: 2000/01/08
 */

public class Employee {
    private String name;
    private String dob;
    private char sex;
    private float salary;
    private String jobTitle;
    private long payrollNumber;

    /**
     * Default constructor.
     */
    public Employee() {
        name = "Unknown";
        dob = "";
        sex = 'u';
        salary = 0;
        jobTitle = "Unknown";
    }

    /**
     * Constructs and Employee object from initial set of values.
     */
    public Employee(String newName, String newDOB, char gender,
                    float newSalary, String job, long pN) {
        name = newName;
        dob = newDOB;
        sex = gender;
        salary = newSalary;
        jobTitle = job;
        payrollNumber = pN;
    }

    /**
     * Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name field.
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * Returns the date of birth.
     */
    public String getDob() {
        return dob;
    }

    /**
     * Returns the gender.
     */
    public char getSex() {
        return sex;
    }

    /**
     * Returns the salary.
     */
    public float getSalary() {
        return salary;
    }

    /**
     * Sets the salary.
     */
    public void setSalary(float newSalary) {
        salary = newSalary;
    }

    /**
     * Returns the job title.
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * Sets the job title.
     */
    public void setJobTitle(String newJob) {
        jobTitle = newJob;
    }

    /**
     * Returns the payroll number.
     */
    public long getPayrollNumber() {
        return payrollNumber;
    }

    /**
     * Sets the payroll number.
     */
    public void setPayrollNumber(long newPN) {
        payrollNumber = newPN;
    }

    /**
     * Returns a String containing all the information about the
     * employee.
     */
    public String toString() {
        String output = "Name: " + name + "\n";
        output += "Date of Birth: " + dob + "\n";
        output += "Sex: " + String.valueOf(sex) + "\n";
        output += "Salary: " + String.valueOf(salary) + "\n";
        output += "Job Title: " + jobTitle + "\n";
        output += "Payroll Number: " + String.valueOf(payrollNumber) + "\n";

        return output;
    }
}
