package javaOOP.phuongHoaXuan;

// QUan cafe cua nha ba A
public class AZ_Cafe {
    // Property/ Field/ Variable
    public String espresso = "Espresso Coffee";

    // Function/ Method
    public void shipEspresso() {
        System.out.println("Ship: " + espresso);
    }

    protected String cappuccino = "Cappuccino ";

    protected void shipCappuccino() {
        System.out.println("Ship: " + cappuccino);
    }

    String hxCafe = "Hoa Xuan Coffee";
    void shipHX() {
        System.out.println("Ship: " + hxCafe);
    }

    private String azCoffee = "AZ Coffee";



    // 1 - Su dung trong chinh class nay
    public static void main(String[] args) {
        AZ_Cafe az = new AZ_Cafe();
        System.out.println(az.espresso);
        az.shipEspresso();

        System.out.println(az.cappuccino);
        az.shipCappuccino();

        System.out.println(az.hxCafe);
        az.shipHX();

        System.out.println(az.azCoffee);
    }

}
