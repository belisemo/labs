public class Main {
    public static void main(String[] args) {

        OrderTracker tracker = new OrderTracker();

        
        Order order1 = new Order("Пицца, Кола", 15.5, "12:30");
        Order order2 = new Order("Суп, Чай", 8.0, "13:00");

      
        tracker.addOrder(1, order1);
        tracker.addOrder(2, order2);

     
        tracker.printAllOrders();

        System.out.println("\nПоиск заказа столика #1:");
        System.out.println(tracker.getOrder(1));

        tracker.updateStatus(1, "Готов");

       
        tracker.deleteOrder(2);

        tracker.printAllOrders();
    }
}
