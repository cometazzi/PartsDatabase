package org.badmotivator.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.badmotivator.entity.PackageTypes;
import org.badmotivator.entity.Diode;
import org.badmotivator.util.Database;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Diode dao test.
 */
class DiodeDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The Generic dao.
     */

    // Use GenericDao
    GenericDao<Diode> partDao;

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
        partDao = new GenericDao<>(Diode.class);
        Diode retrievedDiode = partDao.getById(14);
        assertTrue(retrievedDiode.getPartNum().equals("1N4004"));
    }

    /**
     * Tests an update.
     */
    @Test
    void update() {
        partDao = new GenericDao<>(Diode.class);
        Diode retrievedDiode = partDao.getById(10);
        retrievedDiode.setQty(8); // original qty is 22
        retrievedDiode.setDescr("Power Miser!");  // original descr is "N-Channel JFET"
        partDao.update(retrievedDiode);
        assertEquals(8, retrievedDiode.getQty());
        assertEquals("Power Miser!", retrievedDiode.getDescr());
    }

    /**
     * Inserts a new item into the db, checks to see if it worked.
     */
    @Test
    void insert() {
        partDao = new GenericDao<>(Diode.class);
        Diode newDiode = new Diode(
                null,
                "18",
                "INFRAREDLED",
                "InfraRed LED",
                16,
                18,
                "0.17",
                "None.pdf");

        Diode insertedDiode = partDao.insert(newDiode);
        int newDiodeID = insertedDiode.getId();

        assertEquals("INFRAREDLED", partDao.getById(newDiodeID).getPartNum());
        assertEquals(16, partDao.getById(newDiodeID).getQty());


    }


    /**
     * Deletes an item from the db, tests to see if it's actually gone
     */
    @Test
    void delete() {
        partDao = new GenericDao<>(Diode.class);
        Diode diodeToDelete = partDao.getById(7);
        partDao.delete(diodeToDelete);
        assertNull(partDao.getById(7));

    }

    /**
     * Gets all.
     */
    @Test
    void getAll() {
        partDao = new GenericDao<>(Diode.class);
        List<Diode> retrievedDiodes = partDao.getAll();
        assertEquals(17, retrievedDiodes.size());
    }

    /**
     * Gets by property equal.
     */
    @Test
    void getByPropertyEqual() {
        partDao = new GenericDao<>(Diode.class);
        List<Diode> foundDiodes = partDao.getByPropertyEqual("partNum", "COLORSHIFTFAST");
        assertEquals(1, foundDiodes.size());
    }

    /**
     * Gets by property like.
     */
    @Test
    void getByPropertyLike() {
        partDao = new GenericDao<>(Diode.class);
        List<Diode> foundDiodes = new ArrayList<>();
        foundDiodes = partDao.getByPropertyLike("descr", "LED");
        assertEquals(10, foundDiodes.size());
    }

    @Test
    void restoreDatabase() {
        // not really a test, just a quick restore sequence I can call whenever I need to.
        init();
    }
}