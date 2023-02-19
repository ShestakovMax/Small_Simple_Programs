class Pizza {//class for order data
    String pizza;
    float cost;
    int quantity;

    public Pizza(String pizza, float cost, int quantity) {
        this.pizza = pizza;
        this.cost = cost;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return pizza + " " + cost + " " + quantity;
    }
}