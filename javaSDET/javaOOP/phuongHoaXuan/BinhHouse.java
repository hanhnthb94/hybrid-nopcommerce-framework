package javaOOP.phuongHoaXuan;

// Cung nam trong phuong Hoa Xuan (package)
public class BinhHouse {
    // 2 - Cung package
    public static void main(String[] args) {
        AZ_Cafe az = new AZ_Cafe();
        System.out.println(az.espresso);
        az.shipEspresso();

        az.shipCappuccino();

        // System.out.println(az.azCoffee);

    }
}
