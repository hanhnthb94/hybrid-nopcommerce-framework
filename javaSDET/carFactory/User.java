package carFactory;

public class User {
    public static void main(String[] args) {
        Car car = null;
        car = getCar("Honda");
        car.viewCar();
        car.driveCar();
        car.bookCar("Honda");

        car = getCar("Huyndai");
        car.viewCar();
        car.driveCar();

        car = getCar("Toyota");
        car.viewCar();
        car.driveCar();
    }
    public static Car getCar(String carName) {
        Car car;
        if (carName.equals("Honda")) {
            car = new Honda();
        } else if (carName.equals("Huyndai")){
            car = new Huyndai();
        } else if (carName.equals("Toyota")){
            car = new Toyota();
        } else {
            car = new Ford();
        }
        return car;
    }
}
