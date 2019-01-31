package models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Resident {
    private int idResident;
    private String name;
    private byte isRetired;
    private byte isChild;
    private byte isDisabled;
    private Byte hasPaid;
    private int apartmentIdapartment;

    @Id
    @Column(name = "idResident")
    public int getIdResident() {
        return idResident;
    }

    public void setIdResident(int idResident) {
        this.idResident = idResident;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "isRetired")
    public byte getIsRetired() {
        return isRetired;
    }

    public void setIsRetired(byte isRetired) {
        this.isRetired = isRetired;
    }

    @Basic
    @Column(name = "isChild")
    public byte getIsChild() {
        return isChild;
    }

    public void setIsChild(byte isChild) {
        this.isChild = isChild;
    }

    @Basic
    @Column(name = "isDisabled")
    public byte getIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(byte isDisabled) {
        this.isDisabled = isDisabled;
    }

    @Basic
    @Column(name = "hasPaid")
    public Byte getHasPaid() {
        return hasPaid;
    }

    public void setHasPaid(Byte hasPaid) {
        this.hasPaid = hasPaid;
    }

    @Basic
    @Column(name = "apartment_idapartment")
    public int getApartmentIdapartment() {
        return apartmentIdapartment;
    }

    public void setApartmentIdapartment(int apartmentIdapartment) {
        this.apartmentIdapartment = apartmentIdapartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resident resident = (Resident) o;
        return idResident == resident.idResident &&
                isRetired == resident.isRetired &&
                isChild == resident.isChild &&
                isDisabled == resident.isDisabled &&
                apartmentIdapartment == resident.apartmentIdapartment &&
                Objects.equals(name, resident.name) &&
                Objects.equals(hasPaid, resident.hasPaid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idResident, name, isRetired, isChild, isDisabled, hasPaid, apartmentIdapartment);
    }
}
