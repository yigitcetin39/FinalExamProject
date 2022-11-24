public class lesson24_miniCalculator {
    public static void main(String[] args){
        lesson24_miniCalculatorReference calculator = new lesson24_miniCalculatorReference();

        //sum function

        int resultSum = calculator.sum(1,6);
        System.out.println(resultSum);

        // substrac function

        int resultSubstrac = calculator.subtrac(12,6);
        System.out.println(resultSubstrac);

        // multiply function

        int resultMultiply = calculator.multiply(1,6);
        System.out.println(resultMultiply);

        // divide function

        double resultDivide = calculator.divide(24,6);
        System.out.println(resultDivide);

    }
}
