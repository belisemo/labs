public class KidsBike extends Bicycle {
    private boolean dopWheels;
    private int wheelSize;

    public KidsBike(String brand, String type, int weight, boolean dopWheels, int wheelSize) {
        super(brand, type, weight);
        this.dopWheels = dopWheels;
        this.wheelSize = wheelSize;
    }

    @Override
    public void showInfo() {
        System.out.println("бренд: " + brand +
                ", тип: " + type +
                ", доп колеса: " + dopWheels +
                ", вес: " + weight +
                ", размер колес: " + wheelSize);
    }

    public void ride() {
        System.out.println("Детский велосипед едет...");
    }
}


