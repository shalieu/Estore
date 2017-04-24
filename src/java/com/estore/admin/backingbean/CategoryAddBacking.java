/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.admin.backingbean;

import com.estore.model.Category;
import com.estore.service.CategoryService;
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
@Named(value = "categoryAddBacking")
@ViewScoped
public class CategoryAddBacking {

    // inject CategoryService object
    @EJB
    CategoryService categoryService; // CategoryService eken reference ekak hadala thiyene

    @Named
    @Produces
    @RequestScoped
            // userta category eka access karanna(visible wenne) puluwan wenne me thun dena dammoth pamanai
    Category category = new Category();
    
    private String infoMessage;

    public String getInfoMessage() {
        return infoMessage;
    }

    public void setInfoMessage(String infoMessage) {
        this.infoMessage = infoMessage;
    }
    
    public String createCategory ()
    {
       // categoryService.addNewCategory(category);
        category=categoryService.addNewCategory(category);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(category.getCategoryName()+" Saved Successfully"));
       // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Saved Successfully"));
        clear();
       
        return null;
        
    }
    public void clear()
    {
        category.setCategoryName(" ");
    }

}
