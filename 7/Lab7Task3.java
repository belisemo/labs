import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Lab7Task3 {


    static class Product {
        String name;
        int weight;

        public Product(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }


    static class WarehouseManager {
        private final List<Product> sourceWarehouse = new ArrayList<>();
        private final ReentrantLock lock = new ReentrantLock();


        private final Condition clearToLoad = lock.newCondition();
        private final Condition clearToUnload = lock.newCondition();

        private int currentTruckWeight = 0;
        private boolean truckIsUnloading = false;

        public WarehouseManager() {

            for (int i = 1; i <= 12; i++) {
                sourceWarehouse.add(new Product("Товар №" + i, 40));
            }
        }


        public void loadProduct(String loaderName) throws InterruptedException {
            lock.lock();
            try {

                while (truckIsUnloading) {
                    clearToLoad.await();
                }


                if (sourceWarehouse.isEmpty()) {

                    if (currentTruckWeight > 0 && !truckIsUnloading) {
                        System.out.println(">>> Склад пуст! Отправляем последнюю партию на разгрузку.");
                        truckIsUnloading = true;
                        clearToUnload.signalAll();
                    }
                    return;
                }

                Product nextProduct = sourceWarehouse.get(0);


                if (currentTruckWeight + nextProduct.weight <= 150) {
                    sourceWarehouse.remove(0);
                    currentTruckWeight += nextProduct.weight;
                    System.out.println(loaderName + " взял " + nextProduct.name + " (" + nextProduct.weight + " кг). Всего в кузове: " + currentTruckWeight + " кг.");
                } else {

                    System.out.println(">>> Набрано " + currentTruckWeight + " кг. Лимит! Машина едет на разгрузку.");
                    truckIsUnloading = true;
                    clearToUnload.signalAll();
                }

            } finally {
                lock.unlock();
            }
        }


        public void unloadTruck() throws InterruptedException {
            lock.lock();
            try {

                while (!truckIsUnloading) {
                    clearToUnload.await();
                }

                System.out.println("...Машина в пути и разгружается на втором складе...");
                Thread.sleep(1000);

                currentTruckWeight = 0;
                truckIsUnloading = false;
                System.out.println("<<< Машина разгружена и вернулась обратно. Грузим дальше!");

                clearToLoad.signalAll();

            } finally {
                lock.unlock();
            }
        }


        public boolean isFinished() {
            lock.lock();
            try {
                return sourceWarehouse.isEmpty() && currentTruckWeight == 0 && !truckIsUnloading;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        WarehouseManager manager = new WarehouseManager();


        Thread transportTruck = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!manager.isFinished()) {
                        manager.unloadTruck();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        transportTruck.start();


        for (int i = 1; i <= 3; i++) {
            final String loaderName = "Грузчик-" + i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (!manager.isFinished()) {
                            manager.loadProduct(loaderName);
                            Thread.sleep(150);
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }).start();
        }
    }
}
