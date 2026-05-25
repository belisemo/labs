public class MountainBike extends Bicycle {

    private String suspension;
    private int  gears;

    public MountainBike(String brand, String type, int weight, String suspension, int  gears) {
        super(brand, type, weight);
        this.suspension = suspension;
        this. gears =  gears;
    }

    public MountainBike() {
        super();
        suspension = "Неизвестно";
        gears = 0;
    }

    @Override
    public void showInfo() {
        System.out.println("бренд: " + brand +
                ", тип: " + type +
                ", вес: " + weight +
                ", подвеска: " + suspension +
                ", кол-во передач: " +  gears);
    }

    public void ride() {
        System.out.println("Горный велосипед едет по трассе...");
    }

}
