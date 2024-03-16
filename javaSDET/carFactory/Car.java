package carFactory;

public abstract class Car {
    // Ham abstract
    public abstract void viewCar();
    public abstract void driveCar();
    // Ham non-abstract
    public void bookCar(String carName) {
        System.out.println("Booking " + carName + " Car");
    }
}
