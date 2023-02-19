import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyQueue { //class for the order queue
    Item head = null;
    Item tail = null;
    private int size = 0;

    public void push(Order obj) {  //adding an item to the queue
        Item ob = new Item();
        ob.setObject(obj);
        if (head == null) {
            head = ob;
        } else {
            tail.setNext(ob);
        }
        tail = ob;
        size++;
    }

    public Order pop() {          //removing an item from the queue
        if (size == 0) {
            System.out.println("No orders");
            return null;
        }
        Order obj = head.getOrder();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
        System.out.println("The order deleted");
        return obj;
    }

    public Order get(int index) {
        if(size == 0 || index >= size || index < 0) {
            return null;
        }
        Item current = head;
        int pos = 0;
        while(pos < index) {
            current = current.getNext();
            pos++;
        }
        return current.getOrder();
    }

    void quantity() {    //counting orders in the queue
        Item current = head;
        int count = 0;
        if (head == null)
            System.out.println("No orders");
        else
        {
            while ( current!= null)
            {
                count++;
                current = current.getNext();
            }
            System.out.println("Number of clients  " + count);
        }
    }

    void saveFile(String filePath,Order order) throws IOException { //saving a completed (deleted) order from the queue
        File file = new File(filePath);
        FileWriter fileWrite;
        fileWrite = new FileWriter(file,true);
        try {
            fileWrite.write("______________________________________________\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileWrite.write(order.toString()+"\n");
        fileWrite.write("______________________________________________\n");
        fileWrite.close();
    }

    public int size() {   //determining the size of the queue
        return size;
    }

    public void show() {  //display of all orders
        int i=1;
        Item current = head;
        if (head != null)
        {
            System.out.println("______________________________________________");
            System.out.println("|  Order");
            System.out.println("______________________________________________");
            while (current != null)
            {
                System.out.printf("%d| Name %15s| Address %15s| Total amount %.2f", i, current.getOrder().name, current.getOrder().address,current.getOrder().sum);
                System.out.println("\n______________________________________________");
                current = current.getNext();
                i++;
            }
        }
        else System.out.println("No orders");
    }
}