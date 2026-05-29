public class Order {

    private String items;        
    private double totalAmount;  
    private String orderTime;    
    private String status;       

    public Order(String items, double totalAmount, String orderTime) {
        this.items = items;
        this.totalAmount = totalAmount;
        this.orderTime = orderTime;
        this.status = "Новый";
    }

    // метод для изменения статуса
    public void setStatus(String status) {
        this.status = status;
    }


    public String getStatus() {
        return status;
    }


    @Override
    public String toString() {
        return "Заказ {" +
                "блюда: '" + items + '\'' +
                ", сумма: " + totalAmount +
                ", время: '" + orderTime + '\'' +
                ", статус: '" + status + '\'' +
                '}';
    }
}
