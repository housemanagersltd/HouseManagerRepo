package models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Agent {
    private int idAgent;
    private String name;

    public Agent(){

    }

    public Agent(String name){
        this.name =name;
    }



    @Id
    @Column(name = "idAgent")
    public int getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(int idAgent) {
        this.idAgent = idAgent;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agent agent = (Agent) o;
        return idAgent == agent.idAgent &&
                Objects.equals(name, agent.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAgent, name);
    }
}
