import java.io.*;
import java.util.*;

/**
 * Main class that manages student records.
 * This class demonstrates file I/O and exception handling in Java.
 * 
 * The StudentRecordsManager handles:
 * - Reading student data from CSV files
 * - Processing and validating the data
 * - Calculating statistics
 * - Writing formatted results to output files
 * - Proper exception handling throughout the process
 */
public class StudentRecordsManager {
    
    /**
     * Main method to run the program.
     * Handles user input and delegates processing to other methods.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        StudentRecordsManager manager = new StudentRecordsManager();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter input filename: ");
        String inputFile = scanner.nextLine();
        
        System.out.print("Enter output filename: ");
        String outputFile = scanner.nextLine();
        
        try {
            /**
             * TODO: Call the processStudentRecords method with appropriate parameters
             *
             * This should pass the inputFile and outputFile variables to the method
             */
            manager.processStudentRecords(inputFile, outputFile);

        } catch (Exception e) {
            /**
             * TODO: Handle general exceptions
             * 
             * - Display a user-friendly error message
             * - Include the exception's message for debugging purposes
             * - Consider using System.err instead of System.out for error messages
             */
            System.err.println("An error has occurred: " + e.getMessage());
        } finally {
            /**
             * The scanner is closed in the finally block to ensure resources are
             * properly released regardless of whether an exception occurred.
             * This demonstrates proper resource management.
             */
            scanner.close();
        }
    }
    
    /**
     * Process student records from an input file and write results to an output file.
     * This method orchestrates the entire data processing workflow.
     * 
     * @param inputFile Path to the input file containing student records
     * @param outputFile Path to the output file where results will be written
     */
    public void processStudentRecords(String inputFile, String outputFile) {
        try {
            /**
             * TODO: Call readStudentRecords and writeResultsToFile methods
             * 
             * 1. Call readStudentRecords to get a list of Student objects
             * 2. Call writeResultsToFile to output the processed data
             * 3. Print a success message to the console
             */
            List<Student> students = readStudentRecords(inputFile);
            writeResultsToFile(students, outputFile);
            System.out.println("Student records processed successfully.");
        } catch (FileNotFoundException e) {
            /**
             * TODO: Handle file not found exception
             * 
             * Provide a clear message indicating which file couldn't be found
             * and possibly suggest solutions (check spelling, path, etc.)
             */
            System.err.println("File not found: " + inputFile + ". Check the path and filename.");
        } catch (IOException e) {
            /**
             * TODO: Handle general I/O exceptions
             * 
             * These could be permission issues, disk full, etc.
             * Provide helpful information about the nature of the I/O problem.
             */
            System.err.println("I/O error occurred: " + e.getMessage());
        }
    }
    
    /**
     * Read student records from a file and convert them to Student objects.
     * This method demonstrates file reading operations and exception handling.
     * 
     * @param filename Path to the input file
     * @return List of Student objects created from the file data
     * @throws IOException If an I/O error occurs during file reading
     */
    public List<Student> readStudentRecords(String filename) throws IOException {
        List<Student> students = new ArrayList<>();
        
        /**
         * TODO: Implement using try-with-resources to read the file
         * 
         * 1. Create a BufferedReader wrapped around a FileReader
         * 2. Read each line of the file
         * 3. For each line, parse the student data:
         *    - Split the line by commas
         *    - Extract studentId (parts[0]) and name (parts[1])
         *    - Parse the four grade values (parts[2] through parts[5])
         * 4. Create a Student object with the parsed data
         * 5. Add the Student object to the students list
         * 
         * Remember to handle these specific exceptions:
         * - NumberFormatException: When a grade cannot be parsed as an integer
         * - InvalidGradeException: When a grade is outside the valid range (0-100)
         * - ArrayIndexOutOfBoundsException: When a line has too few fields
         * 
         * For each exception, provide clear error messages that include the line number
         * where the error occurred for easier debugging.
         */
        int lineNumber = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                try {
                    String[] parts = line.split(",");
                    if (parts.length < 6) {
                        throw new ArrayIndexOutOfBoundsException("Insufficient data fields.");
                    }
                    String studentId = parts[0].trim();
                    String name = parts[1].trim();
                    int[] grades = new int[4];
                    for (int i = 0; i < 4; i++) {
                        grades[i] = Integer.parseInt(parts[i + 2].trim());
                        if (grades[i] < 0 || grades[i] > 100) {
                            throw new IllegalArgumentException("Invalid grade: " + grades[i]);
                        }
                    }
                    students.add(new Student(studentId, name, grades));
                } catch (NumberFormatException e) {
                    System.err.println("Line " + lineNumber + ": Invalid number format - " + e.getMessage());
                } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
                    System.err.println("Line " + lineNumber + ": " + e.getMessage());
                }
            }
        }
        return students;
    }
    
    /**
     * Write processed student results to an output file.
     * This method demonstrates file writing operations.
     * 
     * @param students List of Student objects to be written to the file
     * @param filename Path to the output file
     * @throws IOException If an I/O error occurs during file writing
     */
    public void writeResultsToFile(List<Student> students, String filename) throws IOException {
        /**
         * TODO: Implement using try-with-resources to write to the file
         * 
         * 1. Create a PrintWriter wrapped around a FileWriter
         * 2. Write a header section with title and separator
         * 3. Write each student's information
         * 4. Calculate and write class statistics:
         *    - Total number of students
         *    - Class average grade
         *    - Distribution of letter grades (how many A's, B's, etc.)
         * 
         * For calculating statistics:
         * 1. Initialize counters for each letter grade (A, B, C, D, F)
         * 2. Initialize a sum for calculating the average
         * 3. Loop through all students, incrementing counters and adding to sum
         * 4. Calculate the class average and format it to 2 decimal places
         * 5. Write all statistics to the file
         * 
         * Consider using a StringBuilder for building complex strings
         * before writing them to the file.
         */
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("STUDENT REPORT");
            writer.println("====================");

            int total = 0;
            double sum = 0;
            int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

            for (Student student : students) {
                writer.println(student.toString());
                writer.println("--------------------");
                sum += student.getAverageGrade();
                total++;

                switch (student.getLetterGrade()) {
                    case 'A': countA++; break;
                    case 'B': countB++; break;
                    case 'C': countC++; break;
                    case 'D': countD++; break;
                    case 'F': countF++; break;
                }
            }

            writer.println("CLASS STATISTICS");
            writer.println("====================");
            writer.println("Total Students: " + total);
            writer.println("Class Average: " + String.format("%.2f", total > 0 ? sum / total : 0));
            writer.println("Grade Distribution:");
            writer.println("A: " + countA);
            writer.println("B: " + countB);
            writer.println("C: " + countC);
            writer.println("D: " + countD);
            writer.println("F: " + countF);
        }
    }
}