package org.badmotivator.persistence;

import org.badmotivator.entity.PackageTypes;
import org.badmotivator.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PackageTypesDaoTest {

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }

    @Test
    void getById() {
        PackageTypesDao packageTypesDao = new PackageTypesDao();
        PackageTypes retrievedPackageTypes = packageTypesDao.getById(7);
        assertNotNull(retrievedPackageTypes);
        assertEquals("DIP-28", retrievedPackageTypes.getPackageName());
    }

    @Test
    void update() {
        PackageTypesDao packageTypesDao = new PackageTypesDao();
        PackageTypes retrievedPackageTypes = packageTypesDao.getById(9);
        retrievedPackageTypes.setPackageDescr("Nobody uses these big ole things anymore!");
        packageTypesDao.update(retrievedPackageTypes);
        PackageTypes updatedPackageTypes = packageTypesDao.getById(9);
        assertNotNull(updatedPackageTypes);
        assertEquals("Nobody uses these big ole things anymore!", updatedPackageTypes.getPackageDescr());
    }

    @Test
    void insert() {
        PackageTypesDao packageTypesDao = new PackageTypesDao();
        PackageTypes insertedPackageTypes = new PackageTypes();
        insertedPackageTypes.setPackageName("TO-5");
        insertedPackageTypes.setPackageDescr("1960s-era 5mm Metal Can");
        int newPackage = packageTypesDao.insert(insertedPackageTypes);

        PackageTypes retrievedPackageTypes = packageTypesDao.getById(newPackage);
        assertNotNull(retrievedPackageTypes);
        assertEquals("TO-5", retrievedPackageTypes.getPackageName());
        assertEquals("1960s-era 5mm Metal Can", retrievedPackageTypes.getPackageDescr());

    }

    @Test
    void delete() {
        PackageTypesDao packageTypesDao = new PackageTypesDao();
        PackageTypes deletedPackageTypes = packageTypesDao.getById(7);
        packageTypesDao.delete(deletedPackageTypes);
        PackageTypes retrievedPackageTypes = packageTypesDao.getById(7);
        assertNull(retrievedPackageTypes);
    }

    @Test
    void getAll() {
        PackageTypesDao packageTypesDao = new PackageTypesDao();
        List<PackageTypes> retrievedPackageTypes = packageTypesDao.getAll();
        assertNotNull(retrievedPackageTypes);
        assertEquals(14, retrievedPackageTypes.size());
    }

    @Test
    void getByPropertyEqual() {
        PackageTypesDao packageTypesDao = new PackageTypesDao();
        List<PackageTypes> retrievedPackages = new ArrayList<>();
        retrievedPackages = packageTypesDao.getByPropertyEqual("packageDescr", "Dual-Inline Package, 4 Leads Per Side");
        assertNotNull(retrievedPackages);
        assertEquals(1, retrievedPackages.size());
    }

    @Test
    void getByPropertyLike() {
        PackageTypesDao packageTypesDao = new PackageTypesDao();
        List<PackageTypes> retrievedPackages = new ArrayList<>();
        retrievedPackages = packageTypesDao.getByPropertyLike("packageDescr", "Dual-Inline Package");
        assertNotNull(retrievedPackages);
        assertEquals(7, retrievedPackages.size());
    }
}