package src.main.java;

public class Task3{

    public static int convertToNum(char digit){
        return (digit - '0');
    }

    public static int task3(String digits){
        int sum = 0;
        for(char digit: digits.toCharArray()){
            sum = sum + convertToNum(digit);
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!\n");
        System.out.println(task3("9463"));
        
    }
}
