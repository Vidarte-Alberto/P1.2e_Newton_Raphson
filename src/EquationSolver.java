
class EquationSolver {
    private final String expression;

    public EquationSolver(String expression) {
        this.expression = expression;
    }

    public double evaluateFunction(double x) {
        double result = 0.0;
        String[] terms = expression.split("(?=[-+])");
        for (String term : terms) {
            if (term.contains("x")) {
                String[] parts = term.split("x");
                double coefficient = 1.0;
                if (parts[0].equals("-")) {
                    coefficient = -1.0;
                } else if (!parts[0].equals("+") && !parts[0].equals("")) {
                    coefficient = Double.parseDouble(parts[0]);
                }
                int exponent = 1;
                if (parts.length > 1) {
                    exponent = Integer.parseInt(parts[1].substring(1));
                }
                result += coefficient * Math.pow(x, exponent);
            } else {
                result += Double.parseDouble(term);
            }
        }
        return result;
    }

    public double evaluateDerivative(double x) {
        double stepSize = 0.0001;
        double f1 = evaluateFunction(x);
        double f2 = evaluateFunction(x + stepSize);
        return (f2 - f1) / stepSize;
    }

    public double findRoot(double tolerance, double initialGuess) {
        double x1 = initialGuess;
        while (Math.abs(evaluateFunction(x1)) > tolerance) {
            x1 = x1 - evaluateFunction(x1) / evaluateDerivative(x1);
        }
        return x1;
    }
}