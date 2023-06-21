public class lesson21_variableArguments {
    public static void main(String[] args){
        int sum2 = sum(24,5,6);
        System.out.println(sum2);
        helloWorld("Hakan");
        System.out.println(sum(26,7));
        int sayi1 = 5;
        System.out.println(sum(5,6,2,6,2));

    }

    // int function
    public static int sum(int... numbers){
        int sum1 = 0;
        for(int num : numbers){
            sum1 = sum1 + num;
        }
        return sum1;
    }

    //String fuction
    public static String helloWorld(String name){
        System.out.println("Hello world! " + name);
        return name;
    }
}
