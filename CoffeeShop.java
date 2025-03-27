// TODO 1: Change the class name to CoffeeShop
public class CoffeeShop {
    public static void main(String[] args) {
        // TODO 2: Create three CoffeeOrder objects
        // Use a different constructor each time
        CoffeeOrder order1 = new CoffeeOrder();
        CoffeeOrder order2 = new CoffeeOrder("large");
        CoffeeOrder order3 = new CoffeeOrder("small", "latte");

        // TODO 3: Call describeOrder() on each and print the result
        System.out.println(order1.describeOrder());
        System.out.println(order2.describeOrder());
        System.out.println(order3.describeOrder());

        // TODO 4: Print the total number of orders using
        // CoffeeOrder.getTotalOrders()
        System.out.println("Total number of orders: " + CoffeeOrder.getTotalOrders());

    }
}
