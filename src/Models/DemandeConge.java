/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author fsgha
 */
public class DemandeConge extends BaseEntity{
  public  int UserId;
  public int CongeId ;
  public Date  RequesteDate;

    public DemandeConge() {
    }

    public DemandeConge(int UserId, int CongeId, Date RequesteDate) {
        this.UserId = UserId;
        this.CongeId = CongeId;
        this.RequesteDate = RequesteDate;
    }

    public DemandeConge(int UserId, int CongeId, Date RequesteDate, int Id, Date CreatedDate, Date UpdatedDate) {
        super(Id, CreatedDate, UpdatedDate);
        this.UserId = UserId;
        this.CongeId = CongeId;
        this.RequesteDate = RequesteDate;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public int getCongeId() {
        return CongeId;
    }

    public void setCongeId(int CongeId) {
        this.CongeId = CongeId;
    }

    public Date getRequesteDate() {
        return RequesteDate;
    }

    public void setRequesteDate(Date RequesteDate) {
        this.RequesteDate = RequesteDate;
    }
@Override
    public int getId() {
        return Id;
    }
@Override
    public void setId(int Id) {
        this.Id = Id;
    }
@Override
    public Date getCreatedDate() {
        return CreatedDate;
    }
@Override
    public void setCreatedDate(Date CreatedDate) {
        this.CreatedDate = CreatedDate;
    }
@Override
    public Date getUpdatedDate() {
        return UpdatedDate;
    }
@Override
    public void setUpdatedDate(Date UpdatedDate) {
        this.UpdatedDate = UpdatedDate;
    }

    @Override
    public String toString() {
        return "DemandeConge{" + "UserId=" + UserId + ", CongeId=" + CongeId + ", RequesteDate=" + RequesteDate + '}';
    }
  

}
    



 

