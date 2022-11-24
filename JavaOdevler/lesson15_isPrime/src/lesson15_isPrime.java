public class lesson15_isPrime {
    public static void main(String[] args){
        int num1 = 23;
        boolean isPrime = true;

        if(num1 < 1){
            System.out.println("İnvalid number.");
        }
        if(num1 == 1){
            System.out.println(num1 + " is not a prime number.");
            return;
        }

        for(int i = 2; i < num1; i++){
            if(num1 % i == 0){
                isPrime = false;
            }
        }

        if(isPrime){
            System.out.println(num1 + " is a prime number.");
        }
        else{
            System.out.println(num1 + " is not a prime number");
        }
    }
}
