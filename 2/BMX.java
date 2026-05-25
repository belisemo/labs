public class BMX extends Bicycle {

    private boolean pegs ;
    private int wheelSize;

    public BMX(String brand, String type, int weight, boolean pegs, int wheelSize) {
        super(brand, type, weight);// вызов конструктора род класса
        this.pegs = pegs;
        this.wheelSize = wheelSize;
    }

    @Override
    public void showInfo() {
        System.out.println("бренд: " + brand +
                ", тип: " + type +
                ", наличие пегов: " + pegs +
                ", вес: " + weight +
                ", размер колес: " + wheelSize);
    }

    public void doTrick() {
        System.out.println("BMX выполняет трюк...");
    }//доп метод класса
}
