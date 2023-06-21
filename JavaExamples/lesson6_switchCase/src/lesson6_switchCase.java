public class lesson6_switchCase {
    public static void main(String[] args){
        char grade = 'F';

        switch(grade){
            case 'A' :
                System.out.println("Excellent! You've passed the exam.");
                break;
            case 'B' :
                System.out.println("Very good! You've passed the exam.");
                break;
            case 'C' :
                System.out.println("Good! You've passed the exam.");
                break;
            case 'D' :
                System.out.println("Not bad! You've passed the exam.");
                break;
            case 'F' :
                System.out.println("Unfortunately... You've not passed the exam.");
                break;
            default :
                System.out.println("You entered an invalid grade");
        }
    }
}
