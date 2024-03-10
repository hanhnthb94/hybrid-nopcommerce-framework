package javaBasic;

public class Dog extends Annimal {

    String animalName;
    public Dog(String annimalName) {
        super(annimalName); // Constructor của lớp con dùng super de goi toi Constructor cua lớp cha Annimal
        this.animalName = animalName;

    }

    @Override
    public void sleep() {
        System.out.println("Sleep....");
    }
    // The hien tinh chat kế thừa trong OOP (Abstraction)


}
