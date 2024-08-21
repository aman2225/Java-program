// Base class Animal
class Animal {
    // Method to make a sound
    public void makeSound() {
        System.out.println("Animal makes a generic sound");
    }
}

// Derived class Dog
class Dog extends Animal {
    // Override makeSound method for Dog
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

// Derived class Cat
class Cat extends Animal {
    // Override makeSound method for Cat
    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }
}

// Renamed class for the main program
class AnimalSoundDemo {
    public static void main(String[] args) {
        // Creating objects of Dog and Cat
        Dog myDog = new Dog();
        Cat myCat = new Cat();

        // Calling makeSound method for Dog
        System.out.print("Dog: ");
        myDog.makeSound();

        // Calling makeSound method for Cat
        System.out.print("Cat: ");
        myCat.makeSound();
    }
}


