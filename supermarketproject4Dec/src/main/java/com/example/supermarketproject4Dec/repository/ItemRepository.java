package com.example.supermarketproject4Dec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.supermarketproject4Dec.domain.Item;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}