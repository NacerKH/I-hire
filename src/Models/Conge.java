/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

//import Enums.CongeType;
import Enums.CongeType;
import Enums.StatusCongeType;
import java.util.Date;
 
public class Conge extends BaseEntity
{
   public  CongeType  Type;
   public Date StartDate;
   public Date EndDate;
   public String Description;
   public  StatusCongeType Status;
   public Date ValidationDate;

    public Conge() {
    }

    public Conge(CongeType Type, Date StartDate, Date EndDate, String Description, StatusCongeType Status, Date ValidationDate) {
        this.Type = Type;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.Description = Description;
        this.Status = Status;
        this.ValidationDate = ValidationDate;
    }

    public Conge(CongeType Type, Date StartDate, Date EndDate, String Description, StatusCongeType Status, Date ValidationDate, int Id, Date CreatedDate, Date UpdatedDate) {
        super(Id, CreatedDate, UpdatedDate);
        this.Type = Type;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.Description = Description;
        this.Status = Status;
        this.ValidationDate = ValidationDate;
    }

    public CongeType getType() {
        return Type;
    }

    public void setType(CongeType Type) {
        this.Type = Type;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public StatusCongeType getStatus() {
        return Status;
    }

    public void setStatus(StatusCongeType Status) {
        this.Status = Status;
    }

    public Date getValidationDate() {
        return ValidationDate;
    }

    public void setValidationDate(Date ValidationDate) {
        this.ValidationDate = ValidationDate;
    }
@Override    public int getId() {
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
        return "Conge{" + "Type=" + Type + ", StartDate=" + StartDate + ", EndDate=" + EndDate + ", Description=" + Description + ", Status=" + Status + ", ValidationDate=" + ValidationDate + '}';
    }
   
}


