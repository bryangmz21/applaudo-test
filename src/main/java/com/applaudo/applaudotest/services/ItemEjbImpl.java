package com.applaudo.applaudotest.services;

import com.applaudo.applaudotest.data.Item;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless
public class ItemEjbImpl implements ItemEjb {

   @PersistenceContext
    EntityManager em;

    @Override
    public List<Item> findAllByStatusAndName(String status, String name) {
        Query q = null;
        try {
            q = em.createQuery("select i from Item i where i.itemStatus = :status and lower(i.itemName) = lower(:name)")
                    .setParameter("status", status).setParameter("name", name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return q.getResultList();
    }

    @Override
    public void save(Item item) {
        em.persist(item);
    }

    @Override
    public Item findById(int id) {
        return em.find(Item.class, id);
    }
}
