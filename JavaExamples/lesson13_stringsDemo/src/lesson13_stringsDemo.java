public class lesson13_stringsDemo {
    public static void main(String[] args){
        String message = "Today is beautiful day.";
        System.out.println(message);

        System.out.println("The number of char is : " + message.length());
        System.out.println("The fifth char is : " + message.charAt(4));
        System.out.println(message.concat(" Yuppiiiiii!!"));
        System.out.println(message.startsWith("T"));
        System.out.println(message.endsWith("."));
        char[] characters = new char[5];
        message.getChars(0,5,characters,0);
        System.out.println(characters);
        System.out.println(message.indexOf("ay"));
        System.out.println(message.lastIndexOf("a"));
    }
}