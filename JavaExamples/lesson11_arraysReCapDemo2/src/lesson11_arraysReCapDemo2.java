public class lesson11_arraysReCapDemo2 {
    public static void main(String[] args){
        double[] myList = {1.2,6.3,4.3,8.6};
        double total = 0;
        double max = myList[0];
        for(double number : myList){
            if(number>max){
                max = number;
            }
            total = total + number;
            System.out.println(number);
        }
        System.out.println("The total of numbers are : " +total);
        System.out.println("The max number is : "+max);
    }
}
