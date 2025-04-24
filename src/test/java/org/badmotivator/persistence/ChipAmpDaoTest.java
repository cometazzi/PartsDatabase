package org.badmotivator.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.badmotivator.entity.PackageTypes;
import org.badmotivator.entity.ChipAmp;
import org.badmotivator.util.Database;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type ChipAmp dao test.
 */
class ChipAmpDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The Generic dao.
     */

    // Use GenericDao
    GenericDao<ChipAmp> partDao;

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
        partDao = new GenericDao<>(ChipAmp.class);
        ChipAmp retrievedChipAmp = partDao.getById(4);
        assertTrue(retrievedChipAmp.getPartNum().equals("LM386"));
    }

    /**
     * Tests an update.
     */
    @Test
    void update() {
        partDao = new GenericDao<>(ChipAmp.class);
        ChipAmp retrievedChipAmp = partDao.getById(10);
        retrievedChipAmp.setQty(7); // original qty is 2
        retrievedChipAmp.setDescr("Greg Anderson Favourite!");  // original descr is "N-Channel JFET"
        partDao.update(retrievedChipAmp);
        assertEquals(7, retrievedChipAmp.getQty());
        assertEquals("Greg Anderson Favourite!", retrievedChipAmp.getDescr());
    }

    /**
     * Inserts a new item into the db, checks to see if it worked.
     */
    @Test
    void insert() {
        partDao = new GenericDao<>(ChipAmp.class);
        ChipAmp newChipAmp = new ChipAmp(
                null,
                "1",
                "L1319",
                "Optical",
                "Single-Channel OptoIsolator",
                13,
                4,
                "0.50",
                "L1319.pdf");

        ChipAmp insertedChipAmp = partDao.insert(newChipAmp);
        int newChipAmpID = insertedChipAmp.getId();

        assertEquals("L1319", partDao.getById(newChipAmpID).getPartNum());
        assertEquals("Optical", partDao.getById(newChipAmpID).getTechnology());
        assertEquals(13, partDao.getById(newChipAmpID).getQty());

    }

    @Test
    void insertWithPackageType() {
        PackageTypesDao packageTypesDao = new PackageTypesDao();
        PackageTypes packageTypes = packageTypesDao.getById(12);

        partDao = new GenericDao<>(ChipAmp.class);
        ChipAmp newChipAmp = new ChipAmp(
                packageTypes,
                "12",
                "2N4403",
                "BJT",
                "PNP ChipAmp, Small Signal",
                72,
                packageTypes.getId(),
                "0.12",
                "2n4403.pdf");

        int newChipAmpID = partDao.insert(newChipAmp).getId();

        ChipAmp retrievedChipAmp = partDao.getById(newChipAmpID);
        assertNotNull(retrievedChipAmp);
        assertTrue(retrievedChipAmp.getPartNum().equals("2N4403"));
        assertTrue(retrievedChipAmp.getTechnology().equals("BJT"));
        assertTrue(retrievedChipAmp.getQty() == 72);
        assertTrue(retrievedChipAmp.getPackageType().getPackageName().equals("TO-92"));
    }

    /**
     * Deletes an item from the db, tests to see if it's actually gone
     */
    @Test
    void delete() {
        partDao = new GenericDao<>(ChipAmp.class);
        ChipAmp chipAmpToDelete = partDao.getById(3);
        partDao.delete(chipAmpToDelete);
        assertNull(partDao.getById(3));

    }

    /**
     * Gets all.
     */
    @Test
    void getAll() {
        partDao = new GenericDao<>(ChipAmp.class);
        List<ChipAmp> retrievedChipAmps = partDao.getAll();
        assertEquals(15, retrievedChipAmps.size());
    }

    /**
     * Gets by property equal.
     */
    @Test
    void getByPropertyEqual() {
        partDao = new GenericDao<>(ChipAmp.class);
        List<ChipAmp> foundChipAmps = partDao.getByPropertyEqual("technology", "Class-D");
        assertEquals(1, foundChipAmps.size());
    }

    /**
     * Gets by property like.
     */
    @Test
    void getByPropertyLike() {
        partDao = new GenericDao<>(ChipAmp.class);
        List<ChipAmp> foundChipAmps = new ArrayList<>();
        foundChipAmps = partDao.getByPropertyLike("descr", "1W");
        assertEquals(2, foundChipAmps.size());
    }

    @Test
    void restoreDatabase() {
        // not really a test, just a quick restore sequence I can call whenever I need to.
        init();
    }
}