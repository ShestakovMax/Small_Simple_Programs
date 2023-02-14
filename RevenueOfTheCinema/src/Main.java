import java.util.Random;
import java.util.Scanner;

public class Main {
    static void input(int[][] x, int weeks, int days) {
        Random r = new Random();
        for (int i = 0; i < weeks; i++) {
            for (int j = 0; j < days; j++) {
                x[i][j] = r.nextInt(200);
            }
        }
    }

    static void output(int[][] x, int weeks, int days){
            for(int i=0;i<weeks;i++){
                System.out.print("Number of spectators during each day of the " + (i+1) + " week: ");
                for(int j=0;j<days;j++){
                    System.out.print(x[i][j] +" ");
            }
                System.out.println();
        }
        System.out.println();
    }

    static void count (int[][] x, int weeks, int days){
        int sum;
        int[] a = new int[weeks];
        for(int i=0;i<weeks;i++){
            sum = 0;
            for(int j=0;j<days;j++){
               sum+= x[i][j];
                a[i]=sum;
            }
            System.out.print("Overall number of spectators during  " + (i+1) + " week is: " + sum);
            System.out.println();
        }
        int imax_a=0;
        int max_a=a[0];
        for(int i=0;i<weeks;i++)
        {
            if(a[i]>max_a)
            {
                max_a=a[i];
                imax_a=i;
            }
        }
        System.out.printf("The most tickets are sold on week %d \n\n",(imax_a+1));
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a ticket price: ");
        int price = sc.nextInt();
        int dsum;
        int isum = 0;
        for(int i =0;i<weeks;i++){
            dsum= a[i]*price;
            System.out.println((i+1) + " week's revenue is $" + dsum);
            isum+=dsum;
        }
        System.out.println("Total revenue of the cinema is: $" + isum );
    }


    public static void main(String[] args) {
        int weeks = 2;
        int days = 7;
        int[][] cinemaRevenue = new int[weeks][days];
        input(cinemaRevenue, weeks, days);
        output(cinemaRevenue, weeks, days);
        count(cinemaRevenue, weeks, days);
    }
}