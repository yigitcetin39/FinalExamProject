public class lesson20_understandTheMethods {
    public static void main(String[] args){
        String message = "Today is beautiful day.";
        String newMessage = giveCity();
        System.out.println(newMessage);
        int num = sum(5,7);
        System.out.println(num);
    }

    public static void add(){
        System.out.println("Added.");
    }
    public static void delete(){
        System.out.println("Deleted.");
    }
    public static void update(){
        System.out.println("Updated.");
    }
    public static int sum(int num1,int num2){
        return num1+num2;
    }
    public static String giveCity(){
        return "Ankara";
    }
}
