package org.example.service;

import org.example.entity.OrderUser;
import org.example.repository.ApartmentRepository;
import org.example.repository.OrderRepository;
import org.example.repository.StatusOrderRepository;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    protected OrderRepository orderRepository;

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected ApartmentRepository apartmentRepository;

    @Autowired
    protected StatusOrderRepository statusOrderRepository;

    public final static Integer OPEN = 1;

    //check
    public OrderUser saveOrder(int userId, int apartmentId, OrderUser order) {
        LocalDateTime localDateTime = LocalDateTime.now();
        order.setOpenTime(localDateTime);
        order.setUser(userRepository.findById(userId).get());
        order.setApartment(apartmentRepository.findById(apartmentId).get());
        order.setStatus(statusOrderRepository.findById(OPEN).get());
        return orderRepository.save(order);
    }

    public boolean existsOrderByUser(int id) {
        return orderRepository.existsOrderByUser_Id(id);
    }

    public List<OrderUser> findAllByUser(int id) {
        return orderRepository.findAllByUser_Id(id);
    }
}
