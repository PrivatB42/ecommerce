package com.ecommerce.Repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.Entity.Order;

public interface OrderReposistory extends CrudRepository<Order, Long>  {


}
