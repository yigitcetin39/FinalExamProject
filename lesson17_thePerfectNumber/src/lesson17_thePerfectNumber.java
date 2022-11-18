public class lesson17_thePerfectNumber {
    public static void main(String[] args){
        int num1  = 28;
        int total = 0;

        for(int i = 1; i < num1; i++){
            if(num1 % i == 0){
                total = total + i;
            }
        }

        if(total == num1){
            System.out.println("This is a perfect number");
        }
        else{
            System.out.println("This is not a perfect number");
        }
    }
}