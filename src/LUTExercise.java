package ExerciseCode2;

import java.util.Random;

/**
 * Unassessed coursework on look-up tables starting point.
 *
 * This program generates 676 Employee objects containing different
 * combinations of names.
 */
class LUTExercise {

    public static void main(String[] args) {

        // An array of 26 surnames.
        String[] surnames = {"O'Connell",
                             "Collins",
                             "Kennedy",
                             "Timbale",
                             "Hamilton",
                             "Roberts",
                             "French",
                             "Donald",
                             "Janus",
                             "Xando",
                             "Anand",
                             "Venison",
                             "Le Bihan",
                             "Gerard",
                             "Neave",
                             "Yu",
                             "Peterson",
                             "Ibou",
                             "Sasse",
                             "Barrett",
                             "Zhang",
                             "Quincey",
                             "Wilkins",
                             "Edwards",
                             "McGlinchey",
                             "Underwood"};

        // An array of 26 first names.
        String[] firstNames = {"Ulf",
                               "Ingo",
                               "Quentin",
                               "Belinda",
                               "Leonardo",
                               "Ximon",
                               "David",
                               "Trifon",
                               "Penny",
                               "Graham",
                               "Julia",
                               "Zebedee",
                               "Cameron",
                               "Fred",
                               "Majid",
                               "Winnie",
                               "Ellen",
                               "Sally",
                               "Nigel",
                               "Keith",
                               "Helen",
                               "Oliver",
                               "Rohan",
                               "Amanda",
                               "Vincent",
                               "Yumn"};

        // Array of characters indicating the sex of the person with
        // the first name in the corresponding position of the array
        // above. Thus firstNames[6] is David, so sexes[6] is 'M';
        // firstNames[10] is Julia, so sexes[10] is 'F'.
        char[] sexes = {
            'M', 'M', 'M', 'F', 'M', 'F', 'M', 'M', 'F', 'M', 'F', 'M', 'F',
            'M', 'M', 'F', 'F', 'F', 'M', 'M', 'F', 'M', 'M', 'F',
            'M', 'F'
        };

        // A selection of job titles
        String[] jobs =
        {"Director", "Manager", "Secretary", "Worker", "Cleaner"};

        // The salary associated with each job title.
        float[] salaries =
        {500000.00f, 100000.00f, 21710.55f, 18444.21f, 15397.72f};

        // Create an instance of the class Random, which produces
        // random numbers - see Java documentation for details.
        Random r = new Random();

        // Payroll numbers are assigned in sequence starting from the
        // number below.
        long payrollNum = 11000000;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {

                // First create all the data items to put into an
                // Employee object.

                // The name is constructed from the unique combination
                // of first and surnames indexed by i and j,
                // respectively.
                String name = firstNames[i] + " " + surnames[j];

                // The sex is also indexed by i to correspond to
                // the first name.
                char gender = sexes[i];

                // The date of birth is chosen randomly. Notice that
                // the construct: Math.abs(r.nextInt() % n) provides a
                // random integer between 0 and n-1.  In the Date
                // class, years are defined since 1900 so the year of
                // birth is in the range 1930-1980.
                int year = Math.abs(r.nextInt() % 50) + 30;
                int month = Math.abs(r.nextInt() % 12) + 1;
                int day = Math.abs(r.nextInt() % 28) + 1;
                String dob = day + "/" + month + "/" + year;

                // Choose an index to the jobs array at random.
                int jobIndex = Math.abs(r.nextInt() % jobs.length);

                // Then set that random job and corresponding salary.
                String jobTitle = jobs[jobIndex];
                float salary = salaries[jobIndex];

                // Set the payroll number and increment the value.
                long pN = payrollNum;
                payrollNum += 1;

                // Create new instance of employee record object
                Employee newEmployee = new Employee(name, dob, gender, salary,
                                                    jobTitle, pN);

                // Print out the new Employee record.
                System.out.println(newEmployee);
            }
        }
    }
}

