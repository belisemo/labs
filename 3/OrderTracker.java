import java.util.HashMap;
import java.util.Map;

public class OrderTracker {

    
    private HashMap<Integer, Order> orders = new HashMap<>();

   
    public void addOrder(int tableNumber, Order order) {
        orders.put(tableNumber, order); 
        System.out.println("Заказ для столика #" + tableNumber + " добавлен.");
    }

    
    public Order getOrder(int tableNumber) {
        return orders.get(tableNumber);
    }

    
    public void deleteOrder(int tableNumber) {
        if (orders.containsKey(tableNumber)) {
            orders.remove(tableNumber);
            System.out.println("Заказ для столика #" + tableNumber + " удален.");
        } else {
            System.out.println("Заказ не найден.");
        }
    }

    
    public void updateStatus(int tableNumber, String newStatus) {
        Order order = orders.get(tableNumber);

        if (order != null) {
            order.setStatus(newStatus);
            System.out.println("Статус обновлен.");
        } else {
            System.out.println("Заказ не найден.");
        }
    }

    public void printAllOrders() {
        System.out.println("\n--- Все заказы ---");


        for (Map.Entry<Integer, Order> entry : orders.entrySet()) {
            System.out.println("Столик #" + entry.getKey() + ": " + entry.getValue());
        }
    }
}
