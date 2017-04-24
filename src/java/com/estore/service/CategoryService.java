/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.service;

import com.estore.model.Category;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author A.M.S.Madhuwanthi
 */
@Stateless   // history ekak mathaka thiyaganne na
public class CategoryService {

    // inject persistence unit
    @PersistenceContext(unitName = "EstorePU")
    EntityManager em;
    // emkiyanne entitimanagergen hadapu reference ekak entiti manager kiyanne db wala sql language ha java language athara thiyana bridge ekak wage deyak

    public Category addNewCategory(Category category) {
        em.persist(category); //em kiyana reference eken ena data save karana method ekak 
        return category;
    }
}
