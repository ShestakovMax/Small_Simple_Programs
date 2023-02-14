import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n =1;
        float distance, speed, hours = 0.5F;

        System.out.println("Enter the number of miles");
        Scanner sc = new Scanner(System.in);
        distance = sc.nextFloat();

        while (n==1){
            if(distance<=0){
                System.out.println("Please enter a correct value.");
                System.out.println("Enter the number of miles");
                distance = sc.nextFloat();
            }
            else n=0;
        }
        speed = distance/hours;

        if (speed > 45) System.out.println("The driver has violated the traffic rules!");
        else System.out.println("The driver has not violated the traffic rules.");
    }
}