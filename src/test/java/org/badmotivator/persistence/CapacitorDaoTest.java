package org.badmotivator.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.badmotivator.entity.Capacitor;
import org.badmotivator.entity.Transistor;
import org.badmotivator.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CapacitorDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The Generic dao.
     */

    // Use GenericDao
    GenericDao<Capacitor> partDao;

    /**
     * Init- runs before each test to reset the database.
     */
    @BeforeEach
    public void init() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }

    @Test
    void getId() {
        partDao = new GenericDao<>(Capacitor.class);
        Capacitor retrievedCapacitor = partDao.getById(21);
        assertTrue(retrievedCapacitor.getPartNum().equals("56pf"));
    }


    @Test
    void getImageUrl() {
        partDao = new GenericDao<>(Capacitor.class);
        Capacitor retrievedCapacitor = partDao.getById(21);
        assertTrue(retrievedCapacitor.getImageUrl().equals("ceramicCap.jpg"));
    }

    @Test
    void setImageUrl() {
        partDao = new GenericDao<>(Capacitor.class);
        Capacitor retrievedCapacitor = partDao.getById(21);
        retrievedCapacitor.setImageUrl("19");
        partDao.update(retrievedCapacitor);
        Capacitor updatedCapacitor = partDao.getById(21);
        assertTrue(updatedCapacitor.getImageUrl().equals("yellowLED.jpg"));
    }

    @Test
    void getPartNum() {
    }

    @Test
    void setPartNum() {
    }

    @Test
    void getDescr() {
    }

    @Test
    void setDescr() {
    }

    @Test
    void getQty() {
    }

    @Test
    void setQty() {
    }

    @Test
    void getCost() {
    }

    @Test
    void setCost() {
    }

    @Test
    void restoreDatabase() {
        // not really a test, just a quick restore sequence I can call whenever I need to.
        init();
    }
}