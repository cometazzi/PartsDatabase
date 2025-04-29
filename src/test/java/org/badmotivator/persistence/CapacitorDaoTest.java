package org.badmotivator.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.badmotivator.entity.Capacitor;
import org.badmotivator.entity.PackageTypes;
import org.badmotivator.entity.Capacitor;
import org.badmotivator.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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

    /**
     * Tests get by id.
     */
    @Test
    void getById() {
        partDao = new GenericDao<>(Capacitor.class);
        Capacitor retrievedCapacitor = partDao.getById(21);
        assertTrue(retrievedCapacitor.getPartNum().equals("56pF"));
    }

    /**
     * Tests an update.
     */
    @Test
    void update() {
        partDao = new GenericDao<>(Capacitor.class);
        Capacitor retrievedCapacitor = partDao.getById(40);
        retrievedCapacitor.setQty(70); // original qty is 72
        retrievedCapacitor.setDescr("Jumpin' JFETS!");  // original descr is "N-Channel JFET"
        partDao.update(retrievedCapacitor);
        assertEquals(70, retrievedCapacitor.getQty());
        assertEquals("Jumpin' JFETS!", retrievedCapacitor.getDescr());
    }

    /**
     * Inserts a new item into the db, checks to see if it worked.
     */
    @Test
    void insert() {
        partDao = new GenericDao<>(Capacitor.class);
        Capacitor newCapacitor = new Capacitor(
                "26",
                "High Voltage Electrolytic",
                "47uF",
                6,
                "7.95"
        );

        Capacitor insertedCapacitor = partDao.insert(newCapacitor);
        int newCapacitorID = insertedCapacitor.getId();

        assertEquals("47uF", partDao.getById(newCapacitorID).getPartNum());
        assertEquals("High Voltage Electrolytic", partDao.getById(newCapacitorID).getDescr());
        assertEquals(6, partDao.getById(newCapacitorID).getQty());

    }


    /**
     * Deletes an item from the db, tests to see if it's actually gone
     */
    @Test
    void delete() {
        partDao = new GenericDao<>(Capacitor.class);
        Capacitor capacitorToDelete = partDao.getById(41);
        partDao.delete(capacitorToDelete);
        assertNull(partDao.getById(41));

    }

    /**
     * Gets all.
     */
    @Test
    void getAll() {
        partDao = new GenericDao<>(Capacitor.class);
        List<Capacitor> retrievedCapacitors = partDao.getAll();
        assertEquals(86, retrievedCapacitors.size());
    }

    /**
     * Gets by property equal.
     */
    @Test
    void getByPropertyEqual() {
        partDao = new GenericDao<>(Capacitor.class);
        List<Capacitor> foundCapacitors = partDao.getByPropertyEqual("descr", "Mylar Capacitor");
        assertEquals(18, foundCapacitors.size());
    }

    /**
     * Gets by property like.
     */
    @Test
    void getByPropertyLike() {
        partDao = new GenericDao<>(Capacitor.class);
        List<Capacitor> foundCapacitors = new ArrayList<>();
        foundCapacitors = partDao.getByPropertyLike("descr", "Disc");
        assertEquals(50, foundCapacitors.size());
    }

    @Test
    void restoreDatabase() {
        // not really a test, just a quick restore sequence I can call whenever I need to.
        init();
    }
}