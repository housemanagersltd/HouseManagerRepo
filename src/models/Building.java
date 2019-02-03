package models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Building {
    private int idBuilding;
    private String address;
    private int numberOfFloors;
    private int commonPartsArea;
    private Integer agentIdAgent;
    private int numberOfApartments;

    public Building(){

    }

    public Building(String address, int numberOfFloors,int commonPartsArea, Integer agentID, int numberOfApartments, Integer agId){
        this.address = address;
        this.agentIdAgent = agentID;
        this.commonPartsArea = commonPartsArea;
        this.numberOfFloors = numberOfFloors;
        this.numberOfApartments = numberOfApartments;
        this.agentIdAgent = agentID;
    }




    @Id
    @Column(name = "idBuilding")
    public int getIdBuilding() {
        return idBuilding;
    }

    public void setIdBuilding(int idBuilding) {
        this.idBuilding = idBuilding;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "numberOfFloors")
    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Basic
    @Column(name = "commonPartsArea")
    public int getCommonPartsArea() {
        return commonPartsArea;
    }

    public void setCommonPartsArea(int commonPartsArea) {
        this.commonPartsArea = commonPartsArea;
    }

    @Basic
    @Column(name = "agent_idAgent")
    public Integer getAgentIdAgent() {
        return agentIdAgent;
    }

    public void setAgentIdAgent(Integer agentIdAgent) {
        this.agentIdAgent = agentIdAgent;
    }

    @Basic
    @Column(name = "numberOfApartments")
    public int getNumberOfApartments() {
        return numberOfApartments;
    }

    public void setNumberOfApartments(int numberOfApartments) {
        this.numberOfApartments = numberOfApartments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return idBuilding == building.idBuilding &&
                numberOfFloors == building.numberOfFloors &&
                commonPartsArea == building.commonPartsArea &&
                numberOfApartments == building.numberOfApartments &&
                Objects.equals(address, building.address) &&
                Objects.equals(agentIdAgent, building.agentIdAgent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBuilding, address, numberOfFloors, commonPartsArea, agentIdAgent, numberOfApartments);
    }
}
