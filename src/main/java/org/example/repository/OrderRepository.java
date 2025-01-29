package org.example.repository;

import org.example.entity.OrderUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderUser, Integer> {

    List<OrderUser> findAllByUser_Id(int id);

    boolean existsOrderByUser_Id(int id);
}
