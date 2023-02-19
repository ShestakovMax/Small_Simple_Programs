public class Item { //class for the item in the queue
    private Order order;
    private Item next;

    public void setObject(Order order) {
        this.order = order;
    }

    public Item getNext() {
        return next;
    }

    public void setNext(Item next) {
        this.next = next;
    }

    public Order getOrder() {
        return order;
    }
}
