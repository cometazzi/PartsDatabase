package org.badmotivator.persistence;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.badmotivator.entity.PackageTypes;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;


public class PackageTypesDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get packageTypes by id
     */
    public PackageTypes getById(int id) {
        Session session = sessionFactory.openSession();
        PackageTypes packageTypes = session.get(PackageTypes.class, id);
        session.close();
        return packageTypes;
    }

    /**
     * update packageTypes
     *
     * @param packageTypes PackageTypes to be updated
     */
    public void update(PackageTypes packageTypes) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(packageTypes);
        transaction.commit();
        session.close();
    }

    /**
     * insert a new packageTypes
     *
     * @param packageTypes PackageTypes to be inserted
     */
    public int insert(PackageTypes packageTypes) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(packageTypes);
        transaction.commit();
        id = packageTypes.getId();
        session.close();
        return id;
    }

    /**
     * Delete a packageTypes
     *
     * @param packageTypes PackageTypes to be deleted
     */
    public void delete(PackageTypes packageTypes) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(packageTypes);
        transaction.commit();
        session.close();
    }


    /**
     * Return a list of all packageTypes
     *
     * @return All packageTypes
     */
    public List<PackageTypes> getAll() {

        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PackageTypes> query = builder.createQuery(PackageTypes.class);
        Root<PackageTypes> root = query.from(PackageTypes.class);
        List<PackageTypes> packageTypes = session.createSelectionQuery(query).getResultList();

        logger.debug("The list of packageTypes " + packageTypes);
        session.close();

        return packageTypes;
    }

    /**
     * Get packageTypes by property (exact match)
     * sample usage: getByPropertyEqual("package_name", "TO-92")
     */
    public List<PackageTypes> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for packageTypes with " + propertyName + " = " + value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PackageTypes> query = builder.createQuery(PackageTypes.class);
        Root<PackageTypes> root = query.from(PackageTypes.class);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<PackageTypes> packageTypes = session.createSelectionQuery(query).getResultList();

        session.close();
        return packageTypes;
    }

    /**
     * Get packageTypes by property (like)
     * sample usage: getByPropertyLike("package_name", "220")
     */
    public List<PackageTypes> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for packageTypes with {} = {}", propertyName, value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PackageTypes> query = builder.createQuery(PackageTypes.class);
        Root<PackageTypes> root = query.from(PackageTypes.class);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<PackageTypes> packageTypes = session.createQuery(query).getResultList();
        session.close();
        return packageTypes;
    }


}
