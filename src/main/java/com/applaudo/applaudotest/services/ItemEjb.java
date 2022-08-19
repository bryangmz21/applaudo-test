package com.applaudo.applaudotest.services;

import com.applaudo.applaudotest.data.Item;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ItemEjb {

    List<Item> findAllByStatusAndName(String status, String name);

    void save(Item item);

    Item findById(int id);
}
