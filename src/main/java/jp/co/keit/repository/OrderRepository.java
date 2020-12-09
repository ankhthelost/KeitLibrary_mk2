package jp.co.keit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.keit.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
