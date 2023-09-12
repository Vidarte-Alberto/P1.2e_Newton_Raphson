import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        System.out.print("Enter the equation: ");
        String equation = sc.nextLine();
        System.out.print("Enter the tolerance: ");
        double tolerance = Double.parseDouble(sc.nextLine());
        System.out.print("Enter the starting point: ");
        double initialGuess = Double.parseDouble(sc.nextLine());
        sc.close();*/
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the equation, tolerance, and starting point (separated by coma's): ");
        String input = sc.nextLine();
        sc.close();

        String[] parts = input.split(",");

        if (parts.length != 3) {
            System.out.println("Please enter all three values.");
            return;
        }

        String equation = parts[0];
        double tolerance = Double.parseDouble(parts[1]);
        double initialGuess = Double.parseDouble(parts[2]);

        EquationSolver solver = new EquationSolver(equation);
        double root = solver.findRoot(tolerance, initialGuess);
        System.out.println("The solution is: " + root);
    }
}