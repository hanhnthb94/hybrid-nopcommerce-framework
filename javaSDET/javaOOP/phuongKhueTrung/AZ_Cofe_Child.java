package javaOOP.phuongKhueTrung;

import javaOOP.phuongHoaXuan.AZ_Cafe;

// Quan cafe cua nha co B - con ba A
// Dc dung cac thuoc tinh va phuong thuc boi lop cha chia se
public class AZ_Cofe_Child extends AZ_Cafe {
    public static void main(String[] args) {
        AZ_Cofe_Child az = new AZ_Cofe_Child();
        System.out.println(az.espresso);
        az.shipEspresso();
        az.buildRom();

        System.out.println(az.cappuccino);
        az.shipCappuccino();

        /*System.out.println(az.hxCafe);
        az.shipHX();*/

        // System.out.println(az.azCoffee);

    }

    // 3 - Khac package nhung la lop con
    public void buildRom() {
        System.out.println(espresso);
        shipEspresso();

    }
}
