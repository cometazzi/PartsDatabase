package org.badmotivator.persistence;

import org.badmotivator.entity.Transistor;
import org.badmotivator.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransistorDaoTest {

    TransistorDao transistorDao;
    @BeforeEach
      public void init() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }

    @Test
    void getById() {
        transistorDao = new TransistorDao();
        Transistor retrievedTransistor = transistorDao.getById(1);
        assertEquals("2N2222", retrievedTransistor.getPartNum());
    }

    @Test
    void update() {
    }

    @Test
    void insert() {
        transistorDao = new TransistorDao();
        Transistor retrievedTransistor = transistorDao.getById(40);
        retrievedTransistor.setQty(72);
        transistorDao.update(retrievedTransistor);
        assertEquals(72, retrievedTransistor.getQty());
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getByPropertyEqual() {
    }

    @Test
    void getByPropertyLike() {
    }
}