package com.vishu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vishu.model.Item;

public interface ItemRepository extends JpaRepository<Item,Integer>{

}
