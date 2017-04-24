/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.admin.backingbean;

import com.estore.model.Publisher;
import com.estore.service.PublisherService;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author A.M.S.Madhuwanthi
 */
@Named(value = "publisherAddBacking")
@ViewScoped
public class PublisherAddBacking {

    @EJB
   PublisherService publisherService;
   
   @Named
    @Produces
    @RequestScoped
   
   Publisher publisher = new Publisher();

    public PublisherService getPublisherService() {
        return publisherService;
    }

    public void setPublisherService(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
    
     public String createPublisher()
    {
        publisherService.addNewPublisher(publisher);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(publisher.getPubName()+" Saved Successfully"));
      clear ();
        return null;
       
        
    }
    public void clear()
    {
      
       publisher.setPubName("");
       publisher.setEmailAdd("");
       publisher.setContactNo("");
    }
   
    
}
