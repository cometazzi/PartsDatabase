package org.badmotivator.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.badmotivator.entity.PackageTypes;
import org.badmotivator.entity.Transistor;
import org.badmotivator.util.Database;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PackageTypesDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }

    @Test
    void getById() {
        GenericDao<PackageTypes> packageTypesDao = new GenericDao<>(PackageTypes.class);
        PackageTypes retrievedPackageTypes = packageTypesDao.getById(7);
        assertNotNull(retrievedPackageTypes);
        assertEquals("DIP-28", retrievedPackageTypes.getPackageName());
    }

    @Test
    void update() {
        GenericDao<PackageTypes> packageTypesDao = new GenericDao<>(PackageTypes.class);
        PackageTypes retrievedPackageTypes = packageTypesDao.getById(9);
        retrievedPackageTypes.setPackageDescr("Nobody uses these big ole things anymore!");
        packageTypesDao.update(retrievedPackageTypes);
        PackageTypes updatedPackageTypes = packageTypesDao.getById(9);
        assertNotNull(updatedPackageTypes);
        assertEquals("Nobody uses these big ole things anymore!", updatedPackageTypes.getPackageDescr());
    }

    @Test
    void insert() {
        GenericDao<PackageTypes> packageTypesDao = new GenericDao<>(PackageTypes.class);
        PackageTypes insertedPackageTypes = new PackageTypes();
        insertedPackageTypes.setPackageName("TO-5");
        insertedPackageTypes.setPackageDescr("1960s-era 5mm Metal Can");
        int newPackage = packageTypesDao.insert(insertedPackageTypes).getId();

        PackageTypes retrievedPackageTypes = packageTypesDao.getById(newPackage);
        assertNotNull(retrievedPackageTypes);
        assertEquals("TO-5", retrievedPackageTypes.getPackageName());
        assertEquals("1960s-era 5mm Metal Can", retrievedPackageTypes.getPackageDescr());

    }

    @Test
    void delete() {
        // get a collection of transistor objects
        GenericDao<Transistor> transistorDao = new GenericDao<>(Transistor.class);
        List<Transistor> transistorsToDelete = transistorDao.getByPropertyEqual("packageName", "13");


        // delete package_type 13 (TO-126)
        GenericDao<PackageTypes> packageTypesDao = new GenericDao<>(PackageTypes.class);
        PackageTypes deletedPackageTypes = packageTypesDao.getById(13);
        packageTypesDao.delete(deletedPackageTypes);

        // verify the package_type is deleted:
        PackageTypes retrievedPackageTypes = packageTypesDao.getById(13);
        assertNull(retrievedPackageTypes);

        // now check if the transistors were deleted as well:
        List<Transistor> retrievedTransistors = transistorDao.getByPropertyEqual("packageName", "13");

        assertEquals(0, retrievedTransistors.size());

    }

    @Test
    void getAll() {
        GenericDao<PackageTypes> packageTypesDao = new GenericDao<>(PackageTypes.class);
        List<PackageTypes> retrievedPackageTypes = packageTypesDao.getAll();
        assertNotNull(retrievedPackageTypes);
        assertEquals(27, retrievedPackageTypes.size());
    }

    @Test
    void getByPropertyEqual() {
        GenericDao<PackageTypes> packageTypesDao = new GenericDao<>(PackageTypes.class);
        List<PackageTypes> retrievedPackages = new ArrayList<>();
        retrievedPackages = packageTypesDao.getByPropertyEqual("packageDescr", "Dual-Inline Package, 4 Leads Per Side");
        assertNotNull(retrievedPackages);
        assertEquals(1, retrievedPackages.size());
    }

    @Test
    void getByPropertyLike() {
        GenericDao<PackageTypes> packageTypesDao = new GenericDao<>(PackageTypes.class);
        List<PackageTypes> retrievedPackages = new ArrayList<>();
        retrievedPackages = packageTypesDao.getByPropertyLike("packageDescr", "Dual-Inline Package");
        assertNotNull(retrievedPackages);
        assertEquals(7, retrievedPackages.size());
    }

    @Test
    void restoreDatabase() {
        // not really a test, just a restore sequence.
        setUp();
    }
}