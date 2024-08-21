class Vehicle {
    private String model;
    private int year;
    private String color;

    public Vehicle(String model, int year, String color) {
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
    }
}

class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String model, int year, String color, int numberOfDoors) {
        super(model, year, color);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Doors: " + numberOfDoors);
    }
}

class NonPublicMain {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("Toyota Camry", 2022, "Silver");
        System.out.println("Vehicle Information:");
        vehicle.displayInfo();
        System.out.println();

        Car car = new Car("Honda Accord", 2021, "Blue", 4);
        System.out.println("Car Information:");
        car.displayInfo();
    }
}


