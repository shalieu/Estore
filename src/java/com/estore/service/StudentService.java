/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.service;

import com.estore.model.Student;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author A.M.S.Madhuwanthi
 */
@Stateless
public class StudentService {
    
     @PersistenceContext(unitName = "EstorePU")
    EntityManager em;

    public Student addNewStudent(Student student) {
         
        em.persist(student); //em kiyana reference eken ena data save karana method ekak 
        return student;
        
        }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
