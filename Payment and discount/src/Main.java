import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = 1;
        double cost, discountedCost;

        System.out.println("How much does a purchase cost?");
        Scanner sc = new Scanner(System.in);
        cost = sc.nextDouble();

        while (n == 1){
            if (cost<0){
                System.out.println("Please enter a correct value.");
                System.out.println("How much does a purchase cost?");
                cost = sc.nextDouble();
            }
            else n = 0;
        }

        if (cost>0 && cost<100){
            discountedCost = cost*0.95;
            System.out.println("Discount will be 5%. The purchase will cost only" + discountedCost);
        }
        if (cost>100 && cost<200){
            discountedCost = cost*0.90;
            System.out.println("Discount will be 10%. The purchase will cost only" + discountedCost);
        }
        if (cost>=200){
            discountedCost = cost*0.85;
            System.out.println("Discount will be 15%. The purchase will cost only" + discountedCost);
        }
        else System.out.println("The cost of the purchase must be positive number");
    }
}