/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.service;

import com.estore.model.Publisher;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author A.M.S.Madhuwanthi
 */
@Stateless
public class PublisherService {

     @PersistenceContext(unitName = "EstorePU")
    EntityManager em;

    public Publisher addNewPublisher(Publisher publisher) {
         
        em.persist(publisher); //em kiyana reference eken ena data save karana method ekak 
        return publisher;
        
        }   // "Insert Code > Add Business Method")
}
