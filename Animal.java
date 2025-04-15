// Base class
// TODO: Define a class called Animal with:
// - A protected String field called name
// - A constructor that takes a name and assigns it
// - A public void method called speak() that prints a generic sound
// - Override toString() to return "Animal: " + name
// - Override equals(Object o) to compare names if o is an Animal
public class AnimalKingdomTest {

    static class Animal {
        protected String name;

        Animal(String name) {
            this.name = name;
        }
        public void speak(){
            System.out.println("The animal makes a sound");
        }

        @Override
        public String toString() {
            return "Animal: " + name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o){
                return true;
            }
            if (o == null || !(o instanceof Animal)) {
                return false;
            }
            Animal animal = (Animal) o;
            return name.equals(animal.name);
        }
    }

    // Subclass
    // TODO: Define a class called Mammal that extends Animal with:
    // - A protected boolean field called warmBlooded (set to true)
    // - A protected String field called dietType (e.g., "herbivore")
    // - A protected int field called numLegs (e.g., 4)
    // - A protected String field called sound (e.g., "growl")
    // - A constructor that uses super to set name and sets these fields
    // - Override speak() to print the value of sound prefixed by name

        static class Mammal extends Animal {
            protected boolean warmBlooded = true;
            protected String dietType;
            protected int numLegs;
            protected String sound;

            Mammal(String name, boolean warmBlooded, String dietType, int numLegs, String sound) {
                super(name);
                this.warmBlooded = warmBlooded;
                this.dietType = dietType;
                this.numLegs = numLegs;
                this.sound = sound;
            }
            
            @Override
            public void speak() {
                System.out.println(name + " says: " + sound);
            }

            public void performTrick() {
                System.out.println(name + " performs a trick!");
            }
        }

    // Subclasses of Mammal
    // TODO: Define a class Dog that extends Mammal
    // - Constructor takes name and passes name, true, "omnivore", 4, "Woof!" to super
    // - Override speak() to print "<name> says: Woof!"

        static class Dog extends Mammal {
        Dog(String name) {
            super(name, true, "omnivore", 4, "Woof!");
        }

        @Override
        public void speak() {
            System.out.println(name + " says: Woof!");
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Dog)) {
                return false;
            }
            Dog other = (Dog) o;
            return this.name.equals(other.name);
        }
    }

    // TODO: Define a class Cat that extends Mammal
    // - Constructor takes name and passes name, true, "carnivore", 4, "Meow!" to super
    // - Override speak() to print "<name> says: Meow!"

    static class Cat extends Mammal{
        Cat(String name) {
            super(name, true, "carnivore", 4, "Meow!");
        }

        @Override
        public void speak() {
            System.out.println(name + " says: Meow!");
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Cat)) {
                return false;
            }
            Cat other = (Cat) o;
            return this.name.equals(other.name);
        }
    }

    // TODO: Define a final class Human that extends Mammal
    // - Constructor takes name and passes name, true, "omnivore", 2, "Hello!" to super
    final class Human extends Mammal {
        Human(String name) {
            super(name, true, "omnivore", 2, "Hello!");
        }
    }

    // TODO: Define a class Reptile that extends Animal
    // - Add fields: boolean warmBlooded (set to false), int numLegs, String dietType, String sound
    // - Constructor should take all values and use super for name
    // - Override speak() to print the value of sound prefixed by name
    static class Reptile extends Animal {
        protected boolean warmBlooded = false;
        protected int numLegs;
        protected String dietType;
        protected String sound;

        Reptile(String name, int numLegs, String dietType, String sound){
            super(name);
            this.numLegs = numLegs;
            this.dietType = dietType;
            this.sound = sound;
        }


        @Override
        public void speak() {
            System.out.println(name + " says: " + sound);
        }
    }

    static class Bird extends Animal {
        protected String sound;

        Bird(String name, String sound) {
            super(name);
            this.sound = sound;
        }

        @Override
        public void speak() {
            System.out.println(name + " says: " + sound);
        }

    }
    // Main class to test
    // TODO: Define class AnimalKingdomTest with a main method
    // - Create Animal a1 = new Dog("Buddy")
    // - Create Animal a2 = new Cat("Whiskers")
    // - Call speak() on both (demonstrating polymorphism)
    // - Print both using System.out.println
    // - Use equals() to compare a1 to a new Dog("Buddy")
    public static void main(String[] args){
        Animal a1 = new Dog("Buddy");
        Animal a2 = new Cat("Whiskers");

        a1.speak();
        a2.speak();

        System.out.println(a1);
        System.out.println(a2);

        System.out.println("a1 == new Dog(\"Buddy\"): " + a1.equals(new Dog("Buddy")));

        if (a1 instanceof Mammal) {
            ((Mammal) a1).performTrick();
        }

        Animal bird = new Bird("Tweety", "Tweet!");
        bird.speak();
    }
}

// Additional TODOs:
// 1. Create a new subclass of Animal (e.g., Bird) and override speak()
// 2. Try to extend Human – what happens and why?
//      When I tried to extend Human, I get a compile error because Java does not allow inheritance from final classes
// 3. Override equals() in Dog or Cat to also check the type
// 4. Add a method to Mammal called performTrick() and call it via downcasting
