package org.badmotivator.persistence;

import org.badmotivator.entity.Transistor;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

public class TransistorDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get transistor by id
     */
    public Transistor getById(int id) {
        Session session = sessionFactory.openSession();
        Transistor transistor = session.get(Transistor.class, id);
        session.close();
        return transistor;
    }

    /**
     * update transistor
     * @param transistor  Transistor to be updated
     */
    public void update(Transistor transistor) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(transistor);
        transaction.commit();
        session.close();
    }

    /**
     * insert a new transistor
     * @param transistor  Transistor to be inserted
     */
    public int insert(Transistor transistor) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(transistor);
        transaction.commit();
        id = transistor.getId();
        session.close();
        return id;
    }

    /**
     * Delete a transistor
     * @param transistor Transistor to be deleted
     */
    public void delete(Transistor transistor) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(transistor);
        transaction.commit();
        session.close();
    }


    /** Return a list of all transistors
     *
     * @return All transistors
     */
    public List<Transistor> getAll() {

        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Transistor> query = builder.createQuery(Transistor.class);
        Root<Transistor> root = query.from(Transistor.class);
        List<Transistor> transistors = session.createSelectionQuery( query ).getResultList();

        logger.debug("The list of transistors " + transistors);
        session.close();

        return transistors;
    }

    /**
     * Get transistor by property (exact match)
     * sample usage: getByPropertyEqual("partNum", "2N3904")
     */
    public List<Transistor> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for transistor with " + propertyName + " = " + value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Transistor> query = builder.createQuery(Transistor.class);
        Root<Transistor> root = query.from(Transistor.class);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Transistor> transistors = session.createSelectionQuery( query ).getResultList();

        session.close();
        return transistors;
    }

    /**
     * Get transistor by property (like)
     * sample usage: getByPropertyLike("partNum", "2N")
     */
    public List<Transistor> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for transistor with {} = {}",  propertyName, value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Transistor> query = builder.createQuery(Transistor.class);
        Root<Transistor> root = query.from(Transistor.class);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Transistor> transistors = session.createQuery( query ).getResultList();
        session.close();
        return transistors;
    }

}
