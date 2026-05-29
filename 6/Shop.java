import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Shop {

    public static void main(String[] args) {

        CopyOnWriteArrayList<String> sales = new CopyOnWriteArrayList<>();

        addSale(sales, "Apple");
        addSale(sales, "Banana");
        addSale(sales, "Apple");
        addSale(sales, "Orange");
        addSale(sales, "Banana");
        addSale(sales, "Pineapple");


        Map<String,Integer> prices = new  HashMap<>();
        prices.put("Apple",1000);
        prices.put("Banana",50);
        prices.put("Orange",10);
        prices.put("Pineapple",500);

        System.out.println("Список продаж:");
        for (String product : sales) {
            System.out.println(product);
        }


        Map<String, Integer> countMap = new HashMap<>();
        for (String product : sales) {
            countMap.put(product, countMap.getOrDefault(product, 0) + 1);
        }


        String popular = "";
        int max = 0;

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                popular = entry.getKey();
            }

        }

        int total = 0;
        for (String product : sales){
            total += prices.get(product);
        }

        System.out.println("Самый популярный товар: " + popular);


        System.out.println("Общее количество продаж: " + sales.size());

        System.out.println("Общее сумма продаж: " + total);
    }

    public static void addSale(CopyOnWriteArrayList<String> sales, String product) {
        sales.add(product);
    }
}
