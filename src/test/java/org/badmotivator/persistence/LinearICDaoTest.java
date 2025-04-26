package org.badmotivator.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.badmotivator.entity.PackageTypes;
import org.badmotivator.entity.LinearIC;
import org.badmotivator.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type LinearIC dao test.
 */
class LinearICDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The Generic dao.
     */

    // Use GenericDao
    GenericDao<LinearIC> partDao;

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
        partDao = new GenericDao<>(LinearIC.class);
        LinearIC retrievedLinearIC = partDao.getById(6);
        assertTrue(retrievedLinearIC.getPartNum().equals("LM7809"));
    }

    /**
     * Tests an update.
     */
    @Test
    void update() {
        partDao = new GenericDao<>(LinearIC.class);
        LinearIC retrievedLinearIC = partDao.getById(13);
        retrievedLinearIC.setQty(70); // original qty is 72
        retrievedLinearIC.setDescr("OG OpAmp");
        partDao.update(retrievedLinearIC);
        assertEquals(70, retrievedLinearIC.getQty());
        assertEquals("OG OpAmp", retrievedLinearIC.getDescr());
    }

    /**
     * Inserts a new item into the db, checks to see if it worked.
     */
    @Test
    void insert() {
        partDao = new GenericDao<>(LinearIC.class);
        LinearIC newLinearIC = new LinearIC(
                null,
                "3",
                "NE5532",
                "Low-Noise Dual OpAmp",
                10,
                3,
                "0.57",
                "NE5532.pdf");

        LinearIC insertedLinearIC = partDao.insert(newLinearIC);
        int newLinearICID = insertedLinearIC.getId();

        assertEquals("NE5532", partDao.getById(newLinearICID).getPartNum());
        assertEquals(10, partDao.getById(newLinearICID).getQty());

    }

    @Test
    void insertWithPackageType() {
        PackageTypesDao packageTypesDao = new PackageTypesDao();
        PackageTypes packageTypes = packageTypesDao.getById(12);

        partDao = new GenericDao<>(LinearIC.class);
        LinearIC newLinearIC = new LinearIC(
                packageTypes,
                "3",
                "NE5532",
                "Low-Noise Dual OpAmp",
                10,
                packageTypes.getId(),
                "0.57",
                "NE5532.pdf");

        int newLinearICID = partDao.insert(newLinearIC).getId();

        LinearIC retrievedLinearIC = partDao.getById(newLinearICID);
        assertNotNull(retrievedLinearIC);
        assertTrue(retrievedLinearIC.getPartNum().equals("NE5532"));
        assertTrue(retrievedLinearIC.getQty() == 10);

    }

    /**
     * Deletes an item from the db, tests to see if it's actually gone
     */
    @Test
    void delete() {
        partDao = new GenericDao<>(LinearIC.class);
        LinearIC linearICToDelete = partDao.getById(8);  // MPSA13 Darlington LinearIC
        partDao.delete(linearICToDelete);
        assertNull(partDao.getById(8));

    }

    /**
     * Gets all.
     */
    @Test
    void getAll() {
        partDao = new GenericDao<>(LinearIC.class);
        List<LinearIC> retrievedLinearICs = partDao.getAll();
        assertEquals(13, retrievedLinearICs.size());
    }

    /**
     * Gets by property equal.
     */
    @Test
    void getByPropertyEqual() {
        partDao = new GenericDao<>(LinearIC.class);
        List<LinearIC> foundLinearICs = partDao.getByPropertyEqual("descr", "Dual OpAmp");
        assertEquals(2, foundLinearICs.size());
    }

    /**
     * Gets by property like.
     */
    @Test
    void getByPropertyLike() {
        partDao = new GenericDao<>(LinearIC.class);
        List<LinearIC> foundLinearICs = new ArrayList<>();
        foundLinearICs = partDao.getByPropertyLike("descr", "Regulator");
        assertEquals(5, foundLinearICs.size());
    }

    @Test
    void restoreDatabase() {
        // not really a test, just a quick restore sequence I can call whenever I need to.
        init();
    }
}