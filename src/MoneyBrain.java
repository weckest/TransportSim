import java.util.List;

public class MoneyBrain implements Brain {
    static Order cheapestOrder(List<Order> orders) {
        Order cheapest = orders.get(0);
        for(Order order : orders){
            if(order.price < cheapest.price){
                cheapest = order;
            }
        }
        return cheapest;
    }

    static Order mostExpensiveOrder(List<Order> orders) {
        Order highestPrice = orders.get(0);
        for(Order order : orders) {
            if(order.price > highestPrice.price) {
                highestPrice = order;
            }
        }
        return highestPrice;
    }

}
