package exercise03.entities;

import exercise03.entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private static SimpleDateFormat fmt1 = new SimpleDateFormat("dd/MM/yyyy");
    private static SimpleDateFormat fmt2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date moment;
    private OrderStatus status;

    private Client client;
    private List<OrderItem> items = new ArrayList<>();

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }

    public void removeItem(OrderItem item){
       items.remove(item);
    }
    
    public double total(){
        double sum = 0.0;
        for (OrderItem j : items){
            sum += j.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: " +  fmt2.format(moment) + "\n");
        sb.append("Order Status: " + status + "\n");
        sb.append(client + "\n");
        for (OrderItem j : items){
            sb.append(j + "\n");
        }
        sb.append("Total price: $" + String.format("%.2f", total()));
        return sb.toString();
    }

}
