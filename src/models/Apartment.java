package models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Apartment {
    private int idapartment;
    private int number;
    private String ownerFamily;
    private int buildingIdBuilding;

    @Id
    @Column(name = "idapartment")
    public int getIdapartment() {
        return idapartment;
    }

    public void setIdapartment(int idapartment) {
        this.idapartment = idapartment;
    }

    @Basic
    @Column(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "ownerFamily")
    public String getOwnerFamily() {
        return ownerFamily;
    }

    public void setOwnerFamily(String ownerFamily) {
        this.ownerFamily = ownerFamily;
    }

    @Basic
    @Column(name = "building_idBuilding")
    public int getBuildingIdBuilding() {
        return buildingIdBuilding;
    }

    public void setBuildingIdBuilding(int buildingIdBuilding) {
        this.buildingIdBuilding = buildingIdBuilding;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment apartment = (Apartment) o;
        return idapartment == apartment.idapartment &&
                number == apartment.number &&
                buildingIdBuilding == apartment.buildingIdBuilding &&
                Objects.equals(ownerFamily, apartment.ownerFamily);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idapartment, number, ownerFamily, buildingIdBuilding);
    }
}
