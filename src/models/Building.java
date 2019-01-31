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
    private String agent;
    private int commonPartsArea;
    private Integer agentIdAgent;

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
    @Column(name = "agent")
    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return idBuilding == building.idBuilding &&
                numberOfFloors == building.numberOfFloors &&
                commonPartsArea == building.commonPartsArea &&
                Objects.equals(address, building.address) &&
                Objects.equals(agent, building.agent) &&
                Objects.equals(agentIdAgent, building.agentIdAgent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBuilding, address, numberOfFloors, agent, commonPartsArea, agentIdAgent);
    }
}
