package carWithoutFactory;

public class User {
    public static void main(String[] args) {
        // Sang T7
        Honda honda = new Honda();
        honda.viewCar();
        honda.driveCar();
        // Chieu T7
        Toyota toyota = new Toyota();
        toyota.viewCar();
        toyota.driveCar();
        // Sang Cn
        Huyndai huyndai = new Huyndai();
        huyndai.viewCar();
        huyndai.driveCar();
        // Chieu CN
        Ford ford = new Ford();
        ford.viewCar();
        ford.driveCar();
    }
}
