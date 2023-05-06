package ru.mirea.bookshop.services.implementations;

import org.springframework.stereotype.Service;
import ru.mirea.bookshop.entities.Order;
import ru.mirea.bookshop.entities.User;
import ru.mirea.bookshop.repos.OrderRepository;
import ru.mirea.bookshop.repos.UserRepository;
import ru.mirea.bookshop.services.interfaces.OrderService;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public OrderServiceImpl(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void add(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> getAll(User user) {
        return orderRepository.findAllByUser(user);
    }

    @Override
    public Order getOrder(Long id) throws IllegalArgumentException {
        Optional<Order> optOrder = orderRepository.findById(id);
        if (optOrder.isPresent()) {
            return optOrder.get();
        } else {
            throw new IllegalArgumentException("Order (id = " + id + ") does not exist!");
        }
    }
}
