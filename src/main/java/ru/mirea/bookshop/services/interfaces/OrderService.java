package ru.mirea.bookshop.services.interfaces;

import ru.mirea.bookshop.entities.Order;
import ru.mirea.bookshop.entities.User;

import java.util.List;

public interface OrderService {

    void add(Order order);
    List<Order> getAll(User user);

    Order getOrder(Long id);
}
