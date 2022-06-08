/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class Conge {
     private int id;
  private String type;
  private Date DateDebut;
  private Date DateFin;
  private String status;
  private String description;
  private Date DateValidation;

    public Conge(int id, String type, Date DateDebut, Date DateFin, String status, String description, Date DateValidation) {
        this.id = id;
        this.type = type;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.status = status;
        this.description = description;
        this.DateValidation = DateValidation;
    }

    public Conge(String type, Date DateDebut, Date DateFin, String status, String description, Date DateValidation) {
        this.type = type;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.status = status;
        this.description = description;
        this.DateValidation = DateValidation;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Date getDateDebut() {
        return DateDebut;
    }

    public Date getDateFin() {
        return DateFin;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateValidation() {
        return DateValidation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDateDebut(Date DateDebut) {
        this.DateDebut = DateDebut;
    }

    public void setDateFin(Date DateFin) {
        this.DateFin = DateFin;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateValidation(Date DateValidation) {
        this.DateValidation = DateValidation;
    }

    @Override
    public String toString() {
        return "Cong\u00e9{" + "id=" + id + ", type=" + type + ", DateDebut=" + DateDebut + ", DateFin=" + DateFin + ", status=" + status + ", description=" + description + ", DateValidation=" + DateValidation + '}';
    }
}
