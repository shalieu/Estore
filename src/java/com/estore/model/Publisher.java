/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author A.M.S.Madhuwanthi
 */
@Entity
@Table(name = "publisher")
@NamedQueries({
    @NamedQuery(name = "Publisher.findAll", query = "SELECT p FROM Publisher p"),
    @NamedQuery(name = "Publisher.findByPubId", query = "SELECT p FROM Publisher p WHERE p.pubId = :pubId"),
    @NamedQuery(name = "Publisher.findByPubName", query = "SELECT p FROM Publisher p WHERE p.pubName = :pubName"),
    @NamedQuery(name = "Publisher.findByEmailAdd", query = "SELECT p FROM Publisher p WHERE p.emailAdd = :emailAdd"),
    @NamedQuery(name = "Publisher.findByContactNo", query = "SELECT p FROM Publisher p WHERE p.contactNo = :contactNo")})
public class Publisher implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pubId")
    private Integer pubId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pubName")
    private String pubName;
    @Size(max = 50)
    @Column(name = "emailAdd")
    private String emailAdd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "contactNo")
    private String contactNo;

    public Publisher() {
    }

    public Publisher(Integer pubId) {
        this.pubId = pubId;
    }

    public Publisher(Integer pubId, String pubName, String contactNo) {
        this.pubId = pubId;
        this.pubName = pubName;
        this.contactNo = contactNo;
    }

    public Integer getPubId() {
        return pubId;
    }

    public void setPubId(Integer pubId) {
        this.pubId = pubId;
    }

    public String getPubName() {
        return pubName;
    }

    public void setPubName(String pubName) {
        this.pubName = pubName;
    }

    public String getEmailAdd() {
        return emailAdd;
    }

    public void setEmailAdd(String emailAdd) {
        this.emailAdd = emailAdd;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pubId != null ? pubId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publisher)) {
            return false;
        }
        Publisher other = (Publisher) object;
        if ((this.pubId == null && other.pubId != null) || (this.pubId != null && !this.pubId.equals(other.pubId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.estore.model.Publisher[ pubId=" + pubId + " ]";
    }

    public void getPubId(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getPubName(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getEmailAdd(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getContactNo(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
