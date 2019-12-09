/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Trainer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author omiro
 */
@Repository
public class TrainerDao {

    // INJECTED database connection:
    @PersistenceContext
    private EntityManager em;

    // Insert a new Trainer from Spring:
    @Transactional // epeidi vazoume auto sto Spring, de xreiazetai na valoume
    // em.getTranscation().begin() - em.flush() - em.getTransaction().commit(), klp
    // prosoxi to import tou, apo Spring framework
    public void insert(Trainer trainer) {
        em.persist(trainer);

    }

    public List findAll() {
        // me ta named queries pou dinei to Netbeans
        List<Trainer> result = em.createNamedQuery("Trainer.findAll").getResultList();

        // (2os tropos) me JPQL gia to idio pragma:
        List<Trainer> result2 = em.createQuery("SELECT t FROM Trainer t").getResultList();
        //prosoxi edw to Trainer den einai to table, alla to Entity

        // (3os tropos) me mySQL:
        List<Trainer> result3 = em.createNativeQuery("SELECT * FROM TRAINER").getResultList();

        return result;
    }

    @Transactional
    public void delete(int id) {
        Trainer trainer = em.find(Trainer.class, id);
        em.remove(trainer);
    }

    @Transactional
    public Trainer getTrainerToBeUpdated(int id) {
        Trainer trainer = em.find(Trainer.class, id);
        return trainer;
    }

    @Transactional
    public void update(Trainer trainer) {
        em.merge(trainer);

    }

}
