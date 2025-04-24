package org.badmotivator.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.badmotivator.entity.PackageTypes;
import org.badmotivator.entity.Transistor;
import org.badmotivator.util.Database;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Transistor dao test.
 */
class TransistorDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The Generic dao.
     */

    // Use GenericDao
    GenericDao<Transistor> partDao;

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
        partDao = new GenericDao<>(Transistor.class);
        Transistor retrievedTransistor = partDao.getById(1);
        assertTrue(retrievedTransistor.getPartNum().equals("2N2222"));
    }

    /**
     * Tests an update.
     */
    @Test
    void update() {
        partDao = new GenericDao<>(Transistor.class);
        Transistor retrievedTransistor = partDao.getById(40);
        retrievedTransistor.setQty(70); // original qty is 72
        retrievedTransistor.setDescr("Jumpin' JFETS!");  // original descr is "N-Channel JFET"
        partDao.update(retrievedTransistor);
        assertEquals(70, retrievedTransistor.getQty());
        assertEquals("Jumpin' JFETS!", retrievedTransistor.getDescr());
    }

    /**
     * Inserts a new item into the db, checks to see if it worked.
     */
    @Test
    void insert() {
        partDao = new GenericDao<>(Transistor.class);
        Transistor newTransistor = new Transistor(
                null,
                "TO-92.jpg",
                "2N4401",
                "BJT",
                "NPN Transistor, Small Signal",
                58,
                12,
                "0.12",
                "2N4401.pdf");

        Transistor insertedTransistor = partDao.insert(newTransistor);
        int newTransistorID = insertedTransistor.getId();

        assertEquals("2N4401", partDao.getById(newTransistorID).getPartNum());
        assertEquals("BJT", partDao.getById(newTransistorID).getTechnology());
        assertEquals(58, partDao.getById(newTransistorID).getQty());

    }

    @Test
    void insertWithPackageType() {
        PackageTypesDao packageTypesDao = new PackageTypesDao();
        PackageTypes packageTypes = packageTypesDao.getById(12);

        partDao = new GenericDao<>(Transistor.class);
        Transistor newTransistor = new Transistor(
                packageTypes,
                "TO-29.jpg",
                "2N4403",
                "BJT",
                "PNP Transistor, Small Signal",
                72,
                packageTypes.getId(),
                "0.12",
                "2n4403.pdf");

        int newTransistorID = partDao.insert(newTransistor).getId();

        Transistor retrievedTransistor = partDao.getById(newTransistorID);
        assertNotNull(retrievedTransistor);
        assertTrue(retrievedTransistor.getPartNum().equals("2N4403"));
        assertTrue(retrievedTransistor.getTechnology().equals("BJT"));
        assertTrue(retrievedTransistor.getQty() == 72);
        assertTrue(retrievedTransistor.getPackageType().getPackageName().equals("TO-92"));
    }

    /**
     * Deletes an item from the db, tests to see if it's actually gone
     */
    @Test
    void delete() {
        partDao = new GenericDao<>(Transistor.class);
        Transistor transistorToDelete = partDao.getById(41);  // MPSA13 Darlington Transistor
        partDao.delete(transistorToDelete);
        assertNull(partDao.getById(41));

    }

    /**
     * Gets all.
     */
    @Test
    void getAll() {
        partDao = new GenericDao<>(Transistor.class);
        List<Transistor> retrievedTransistors = partDao.getAll();
        assertEquals(49, retrievedTransistors.size());
    }

    /**
     * Gets by property equal.
     */
    @Test
    void getByPropertyEqual() {
        partDao = new GenericDao<>(Transistor.class);
        List<Transistor> foundTransistors = partDao.getByPropertyEqual("technology", "JFET");
        assertEquals(4, foundTransistors.size());
    }

    /**
     * Gets by property like.
     */
    @Test
    void getByPropertyLike() {
        partDao = new GenericDao<>(Transistor.class);
        List<Transistor> foundTransistors = new ArrayList<>();
        foundTransistors = partDao.getByPropertyLike("descr", "PNP");
        assertEquals(14, foundTransistors.size());
    }

    @Test
    void restoreDatabase() {
        // not really a test, just a quick restore sequence I can call whenever I need to.
        init();
    }
}