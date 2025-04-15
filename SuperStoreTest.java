// SuperStore Exercise: Access Modifiers & Object Modeling Focus

// TODO: Define a class called Product with:
// - A protected String field called name
// - A protected double field called price
// - A private final int productId
// - A public static int nextId to help generate unique IDs
// - A constructor that sets name, price, and assigns a unique ID
// - Public getters for all fields
// - Override toString() to return formatted product details
// - Override equals(Object o) to compare name and productId

public class SuperStoreTest {
    static class Product {
        protected  String name;
        protected double price;
        private int productId;
        public static int nextId = 1;

        Product(String name, double price, int productId) {
            this.name = name;
            this.price = price;
            this.productId = nextId++;
        }

        public String getName() {
            return this.name;
        }

        public double getPrice() {
            return this.price;
        }

        public int getProductId() {
            return this.productId;
        }
        @Override
        public String toString() {
            return "Product details\nName: " + name + "\nPrice: $" + price + "\nProductId: " + productId + "\n";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o){
                return true;
            }
            if (o == null || !(o instanceof Product)) {
                return false;
            }
            Product other = (Product) o;
            return name.equals(other.name) && this.productId == other.productId;
        }
    }

    // TODO: Define a subclass Electronics that extends Product
    // - Add a private String field called brand
    // - Add a private boolean field called hasBattery
    // - Constructor takes all fields and uses super for shared ones
    // - Override toString() to include brand and battery status

    static class Electronics extends Product {
        private String brand;
        private boolean hasBattery;

        Electronics(String name, double price, int productId, String brand, boolean hasBattery) {
            super(name, price, productId);
            this.brand = brand;
            this.hasBattery = hasBattery;
        }

        @Override
        public String toString() {
            return "Product details\nName: " + name + "\nPrice: " + price + "\nProductId: " + super.productId + "\nBattery: " + hasBattery + "\n";
        }

        public final String warrantyInfo() {
            return "The Electronic product has a 1-year warranty.";
        }
    }

    // TODO: Define a subclass Grocery that extends Product
    // - Add a private double field called weight (in kg)
    // - Add a private boolean field called isPerishable
    // - Constructor takes all fields and uses super for shared ones
    // - Override toString() to include weight and perishability

    static class Grocery extends Product {
        private double weight;
        private boolean isPerishable;

        Grocery(String name, double price, int productId, double weight, boolean isPerishable){
            super(name, price, productId);
            this.weight = weight;
            this.isPerishable = isPerishable;
        }

        @Override
        public String toString() {
            return "Product details\nName: " + name + " Price: $" + price + "\nProductId: " + super.productId + "\nWeight: " + weight + "kg\nPerishable: " + isPerishable + "\n";
        }
    }
    // TODO: Define a final class Toy that extends Product
    // - Add a private int field called minAge
    // - Constructor takes all fields and uses super for shared ones
    // - Override toString() to include minAge
    final static class Toy extends Product {
        private int minAge;

        public Toy(String name, double price, int productId, int minAge) {
            super(name, price, productId);
            this.minAge = minAge;
        }

        @Override
        public String toString() {
            return "Product details\nName: " + name + " Price: $" + price + "\nProductId: " + super.productId + "\nMin age: " + minAge + "\n";
        }
        
    }

    static class Coupon {
        private final double discountRate;
            
        Coupon(double discountRate) {
            this.discountRate = discountRate;
        }

        double apply(Product p) {
            return p.getPrice() * (1 - discountRate);
        }
    }

    // TODO: Define class SuperStoreTest with a main method
    // - Create at least one instance of each subclass
    // - Store them in a Product[] array
    // - Loop through and print each item
    // - Call equals() to compare two products with the same ID and name

    public static void main(String[] args) {        
        Electronics laptop = new Electronics("Laptop", 999.99, 1, "Lenovo", true);
        Grocery apple = new Grocery("Apple", 1.49, 1,  0.5, true);
        Toy lego = new Toy("Lego Set", 68.99, 1,  5);

        Product[] products = {laptop, apple, lego};
        
        for (Product p : products) {
            System.out.println(p.toString());
        }
    
        System.out.println(laptop.warrantyInfo());
        Coupon tenPercentOff = new Coupon(0.10);
        System.out.println("Laptop price after discount: $" + tenPercentOff.apply(laptop));
        System.out.println("lego.equals(anotherLego): " + lego.equals(lego));
    }
}

// Additional TODOs:
// 1. Try to extend Toy — what happens and why? 
// I get a comple error when I attempt to extend Toy, this is because Java does not allow inheritance from final classes
// 2. Make a class Coupon with a final discountRate and apply it to a Product
// 3. Add a method to Electronics called warrantyInfo() and mark it final
// 4. Use access modifiers appropriately and explain your choices in comments
