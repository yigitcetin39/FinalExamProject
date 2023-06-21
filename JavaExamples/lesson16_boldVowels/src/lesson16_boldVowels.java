public class lesson16_boldVowels {
    public static void main(String[] args){
        char char1 = 'A';

        switch(char1){
            case 'A':
            case 'I':
            case 'O':
            case 'U':
                System.out.println("This is a bold vovel");
                break;
            default:
                System.out.println("This is not a bold vovel.");
        }
    }
}
