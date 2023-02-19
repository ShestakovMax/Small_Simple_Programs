import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void instructions() {
        System.out.printf("\n1) Add order to the queue\n" +
                "2) Deleting an order from the queue \n" +
                "3) Count orders\n" +
                "4) Output on display\n" +
                "0) Exit the program\n");
    }
    static Order insert(){
        Scanner in = new Scanner(System.in);
        System.out. println("Enter the name: ");
        String name =in.nextLine();
        System.out. println("Enter the address: ");
        String address =in.nextLine();
        System.out. println("Enter the order: ");
        int finish=1;
        int sum=0;
        String pizzaName;
        float cost;
        int quantity;
        List<Pizza> pizzaList = new ArrayList<>();
        while(finish!=0)
        {
            System.out.println("Enter the name of the pizza: ");
            pizzaName = in.nextLine();
            System.out.println("Enter cost of the pizza: ");
            cost = in.nextFloat();
            System.out.println("Enter the quantity: ");
            quantity = in.nextInt();
            pizzaList.add(new Pizza(pizzaName,cost,quantity));
            sum += quantity*cost;
            System.out.println("Finish order 0-yes 1-no");
            finish = in.nextInt();
            if(finish==1) in.nextLine();
        }

        System.out.print("Total amount $\n"+sum);
        return new Order(name,address,pizzaList,sum);  //creating an order object

    }
    public static void main(String[] args) {
            MyQueue queue = new MyQueue();            //creating an order queue object
            instructions();
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            while (choice != 0){
                switch (choice) {
                    case 1 -> queue.push(insert());
                    case 2 -> {
                        String filePath = "my_order.txt";
                        try {
                            queue.saveFile(filePath, queue.pop());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    case 3 -> queue.quantity();
                    case 4 -> queue.show();
                    default -> System.out.println("Invalid entry. Please try again\n");
                }
                instructions();
                choice = in.nextInt();
            }
        }
    }
