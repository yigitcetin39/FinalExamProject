public class lesson5_recapDemo1 {
    public static void main(String[] args) {
        int num1 = 24;
        int num2 = 25;
        int num3 = 2;
        int theBiggest = num1;

        if (theBiggest < num2) {
            theBiggest = num2;
        }

        if (theBiggest < num3) {
            theBiggest = num3;
        }

        System.out.println("The biggest is = " + theBiggest);
    }
}
