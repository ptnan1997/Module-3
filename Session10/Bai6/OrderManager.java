package Session10.Bai6;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderManager implements Manage <Order> {
    public ArrayList<Order> orders;
    public OrderManager()
    {
       orders = new ArrayList<Order>();
    }

    public void add(Order item) {
        orders.add(item);
    }
    public void update (int index,Order item){
        if(index >= 0 && index < orders.size()) {
            orders.set(index, item);
        }
    }
    public void delete (int index){
        if(index >= 0 && index < orders.size()) {
            orders.remove(index);
        }
    }
    public void display() {
        if (orders.isEmpty()) {
            System.out.println("There are no orders in the system");
        } else  {
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }
}
