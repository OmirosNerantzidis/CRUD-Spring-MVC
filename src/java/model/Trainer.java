/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author omiro
 */
@Entity
@Table(name = "trainer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trainer.findAll", query = "SELECT t FROM Trainer t")
    , @NamedQuery(name = "Trainer.findByTrainerId", query = "SELECT t FROM Trainer t WHERE t.trainerId = :trainerId")
    , @NamedQuery(name = "Trainer.findByTrainerFirstName", query = "SELECT t FROM Trainer t WHERE t.trainerFirstName = :trainerFirstName")
    , @NamedQuery(name = "Trainer.findByTrainerLastName", query = "SELECT t FROM Trainer t WHERE t.trainerLastName = :trainerLastName")
    , @NamedQuery(name = "Trainer.findByTrainerSubject", query = "SELECT t FROM Trainer t WHERE t.trainerSubject = :trainerSubject")})
public class Trainer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TRAINER_ID")
    private Integer trainerId;
    @Basic(optional = false)
    @Column(name = "TRAINER_FIRST_NAME")
    private String trainerFirstName;
    @Basic(optional = false)
    @Column(name = "TRAINER_LAST_NAME")
    private String trainerLastName;
    @Basic(optional = false)
    @Column(name = "TRAINER_SUBJECT")
    private String trainerSubject;

    public Trainer() {
    }

    public Trainer(Integer trainerId) {
        this.trainerId = trainerId;
    }

    public Trainer(Integer trainerId, String trainerFirstName, String trainerLastName, String trainerSubject) {
        this.trainerId = trainerId;
        this.trainerFirstName = trainerFirstName;
        this.trainerLastName = trainerLastName;
        this.trainerSubject = trainerSubject;
    }

    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }

    public String getTrainerFirstName() {
        return trainerFirstName;
    }

    public void setTrainerFirstName(String trainerFirstName) {
        this.trainerFirstName = trainerFirstName;
    }

    public String getTrainerLastName() {
        return trainerLastName;
    }

    public void setTrainerLastName(String trainerLastName) {
        this.trainerLastName = trainerLastName;
    }

    public String getTrainerSubject() {
        return trainerSubject;
    }

    public void setTrainerSubject(String trainerSubject) {
        this.trainerSubject = trainerSubject;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trainerId != null ? trainerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trainer)) {
            return false;
        }
        Trainer other = (Trainer) object;
        if ((this.trainerId == null && other.trainerId != null) || (this.trainerId != null && !this.trainerId.equals(other.trainerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Trainer[ trainerId=" + trainerId + " ]";
    }

}
