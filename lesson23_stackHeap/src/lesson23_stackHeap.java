public class lesson23_stackHeap {
    public static void main(String[] args){
        int num1  = 10;
        int num2 = 20;
        num2 = num1;
        num1 = 30;
        System.out.println(num2);

        int[] number1 = new int[]{1,2,3};
        int[] number2 = new int[]{4,5,6};
        number2 = number1;
        number1[0] = 10;
        System.out.println(number2[0]);
    }
}
