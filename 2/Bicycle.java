public abstract class Bicycle {

    protected String brand;
    protected String type;
    protected int weight;

    protected static int count = 0;
    
    public Bicycle(String brand, String type, int weight) {
        this.brand = brand;
        this.type = type;
        this.weight = weight;
        count++;
    }

    public Bicycle() {
        this("Без названия", "Неизвестно", 0);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public static int getCount() {
        return count;
    }


    public abstract void showInfo();
}
