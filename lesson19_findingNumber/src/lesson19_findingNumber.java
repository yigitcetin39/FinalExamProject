public class lesson19_findingNumber {
    public static void main(String[] args){
        int[] numbers = new int[]{1,2,4,5,7,9};
        int num = 5;
        boolean isThere = false;

        for(int number : numbers){
            if(number == num){
                isThere = true;
                break;
            }
        }
        if(isThere){
            System.out.println("Number is in this list");
        }
        else{
            System.out.println("Number is not in this list");
        }

    }
}