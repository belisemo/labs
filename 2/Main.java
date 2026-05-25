public class Main {
    public static void main(String[] args) {

        MountainBike m = new MountainBike("Cube", "горный", 15, "Полноподвесный",24 );
        KidsBike k = new KidsBike("Stels", "детский", 4,  true, 55);
        BMX b = new BMX("BMX", "трюковой", 8, true, 75);

        m.setBrand("Stels");
        System.out.println("Новое название:" + m.getBrand());

        m.showInfo();
        k.showInfo();
        b.showInfo();

        System.out.println("Всего объектов: " + Bicycle.getCount());
    }
}

