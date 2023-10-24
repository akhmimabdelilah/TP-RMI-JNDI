/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

/**
 *
 * @author akhmim
 */
@Entity
@NamedQuery(name = "findAll", query = "from Machine")
@NamedNativeQuery(name = "findAllNative", query = "SELECT * FROM machine", resultClass = Machine.class)
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ref;
    private String marque;
    private double prix;

    public Machine() {
    }

    public Machine(String ref, String marque, double prix) {
        this.ref = ref;
        this.marque = marque;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getRef() {
        return ref;
    }

    public String getMarque() {
        return marque;
    }

    public double getPrix() {
        return prix;
    }

    @Override
    public String toString() {
        return "Machine{" + "id=" + id + ", ref=" + ref + ", marque=" + marque + ", prix=" + prix + '}';
    }

}
