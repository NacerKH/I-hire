/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author e.bentijani
 */
public class TableJobOffreDto {
    private int idOffre;
private Date  CreatedDate;
private Date UpdatedDate;
private int totalPlaces;
private int idTest;
    public TableJobOffreDto(int idOffre, Date CreatedDate, Date UpdatedDate, int totalPlaces, int idTest) {
        this.idOffre = idOffre;
        this.CreatedDate = CreatedDate;
        this.UpdatedDate = UpdatedDate;
        this.totalPlaces = totalPlaces;
        this.idTest = idTest;
    }
    public TableJobOffreDto(int idOffre, Date CreatedDate, Date UpdatedDate, int totalPlaces) {
        this.idOffre = idOffre;
        this.CreatedDate = CreatedDate;
        this.UpdatedDate = UpdatedDate;
        this.totalPlaces = totalPlaces;
    }



    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Date CreatedDate) {
        this.CreatedDate = CreatedDate;
    }

    public Date getUpdatedDate() {
        return UpdatedDate;
    }

    public void setUpdatedDate(Date UpdatedDate) {
        this.UpdatedDate = UpdatedDate;
    }

    public int getTotalPlaces() {
        return totalPlaces;
    }

    public void setTotalPlaces(int totalPlaces) {
        this.totalPlaces = totalPlaces;
    }

}
