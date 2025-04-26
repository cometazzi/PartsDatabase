package org.badmotivator.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.badmotivator.entity.PackageTypes;
import org.badmotivator.entity.Resistor;
import org.badmotivator.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Resistor dao test.
 */
class ResistorDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The Generic dao.
     */

    // Use GenericDao
    GenericDao<Resistor> partDao;

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
        partDao = new GenericDao<>(Resistor.class);
        Resistor retrievedResistor = partDao.getById(12);
        assertTrue(retrievedResistor.getPartNum().equals("120K"));
    }

    /**
     * Tests an update.
     */
    @Test
    void update() {
        partDao = new GenericDao<>(Resistor.class);
        Resistor retrievedResistor = partDao.getById(21);
        retrievedResistor.setQty("All Gone!");
        partDao.update(retrievedResistor);
        assertEquals("All Gone!", retrievedResistor.getQty());
    }

    /**
     * Inserts a new item into the db, checks to see if it worked.
     */
    @Test
    void insert() {
        partDao = new GenericDao<>(Resistor.class);
        Resistor newResistor = new Resistor(
                null,
                "23",
                "470K",
                "Not Enough?",
                "0.01");

        Resistor insertedResistor = partDao.insert(newResistor);
        int newResistorID = insertedResistor.getId();

        assertEquals("470K", partDao.getById(newResistorID).getPartNum());
        assertEquals("Not Enough?", partDao.getById(newResistorID).getQty());

    }


    /**
     * Deletes an item from the db, tests to see if it's actually gone
     */
    @Test
    void delete() {
        partDao = new GenericDao<>(Resistor.class);
        Resistor resistorToDelete = partDao.getById(41);
        partDao.delete(resistorToDelete);
        assertNull(partDao.getById(41));

    }

    /**
     * Gets all.
     */
    @Test
    void getAll() {
        partDao = new GenericDao<>(Resistor.class);
        List<Resistor> retrievedResistors = partDao.getAll();
        assertEquals(137, retrievedResistors.size());
    }

    /**
     * Gets by property equal.
     */
    @Test
    void getByPropertyEqual() {
        partDao = new GenericDao<>(Resistor.class);
        List<Resistor> foundResistors = partDao.getByPropertyEqual("partNum", "56");
        assertEquals(1, foundResistors.size());
    }

    /**
     * Gets by property like.
     */
    @Test
    void getByPropertyLike() {
        partDao = new GenericDao<>(Resistor.class);
        List<Resistor> foundResistors = new ArrayList<>();
        foundResistors = partDao.getByPropertyLike("partNum", "K");
        assertEquals(62, foundResistors.size());
    }

    @Test
    void restoreDatabase() {
        // not really a test, just a quick restore sequence I can call whenever I need to.
        init();
    }
}