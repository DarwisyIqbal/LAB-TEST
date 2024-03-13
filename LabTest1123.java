
/**
 * Programme:Employee Salary Processing
 * Programmer:Ahmad Darwisy Iqbal Bin Mohd Fadzil
 * Date:13/3/2024
 */

//importing the packages

import java.io.*;
import java.util.StringTokenizer;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class LabTest1123 {
    public static void main(String[] args) {
        DecimalFormat dF = new DecimalFormat("0.00");

        try {
            BufferedReader inputFile = new BufferedReader(new FileReader("Employee Salaries.txt"));
            PrintWriter topEmp = new PrintWriter(new FileWriter("Top Performing Employee.txt"));
            PrintWriter Junior = new PrintWriter(new FileWriter("Employee with the least years of service.txt"));

            String inputData;
            topEmp.println("The Top Performing Employee");
            topEmp.println("\nEmpName\t\t TotalAnnualSalary");
            topEmp.println("----------------------------------");
            Junior.println("The Junior Employee");
            Junior.println("EmpName\t\t EmploymentPeriod");

            while ((inputData = inputFile.readLine()) != null) {
                StringTokenizer sT = new StringTokenizer(inputData, ";");
                String EmpName = sT.nextToken();
                int BaseSalary = Integer.parseInt(sT.nextToken());
                int EmploymentPeriod = Integer.parseInt(sT.nextToken());

                // Calculate GrossIncome based on BaseSalary and EmploymentPeriod
                int GrossIncome = calculateGrossIncome(BaseSalary, EmploymentPeriod);

                // Calculating the annual salary
                int TotalAnnualSalary = GrossIncome + (GrossIncome * 5 / 100);

                // Writing to files
                topEmp.println(EmpName + "\t\t" + dF.format(TotalAnnualSalary));
                Junior.println(EmpName + "\t\t" + EmploymentPeriod);
            }

            inputFile.close();
            topEmp.close();
            Junior.close();
        } catch (FileNotFoundException ex) {
            String output = "File not found";
            JOptionPane.showMessageDialog(null, output);
        } catch (IOException ex) {
            String output = "Error reading file";
            JOptionPane.showMessageDialog(null, output);
        }
    }

    // Method to calculate GrossIncome
    private static int calculateGrossIncome(int baseSalary, int employmentPeriod) {
        // Implement your calculation here
        // For example:
        // int grossIncome = baseSalary * employmentPeriod;
        // return grossIncome;
        return baseSalary * employmentPeriod;
    }
}