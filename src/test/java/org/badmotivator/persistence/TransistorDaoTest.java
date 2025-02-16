package org.badmotivator.persistence;

import org.badmotivator.entity.Transistor;
import org.badmotivator.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

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
        transistorDao = new TransistorDao();
        Transistor retrievedTransistor = transistorDao.getById(40);
        retrievedTransistor.setQty(70); // original qty is 72
        retrievedTransistor.setDescr("Jumpin' JFETS!");  // original descr is "N-Channel JFET"
        transistorDao.update(retrievedTransistor);
        assertEquals(70, retrievedTransistor.getQty());
        assertEquals("Jumpin' JFETS!", retrievedTransistor.getDescr());
    }

    @Test
    void insert() {
        transistorDao = new TransistorDao();
        Transistor newTransistor = new Transistor();
        newTransistor.setImageUrl("TO-92.jpg");
        newTransistor.setPartNum("2N4401");
        newTransistor.setTechnology("BJT");
        newTransistor.setDescr("NPN Transistor, Small Signal");
        newTransistor.setQty(58);
        newTransistor.setPackageName("TO-92");
        newTransistor.setCost("0.12");
        newTransistor.setDatasheetUrl("2N4401.pdf");
        int newTransistorID = transistorDao.insert(newTransistor);

        assertEquals("2N4401", transistorDao.getById(newTransistorID).getPartNum());
        assertEquals("BJT", transistorDao.getById(newTransistorID).getTechnology());
        assertEquals(58, transistorDao.getById(newTransistorID).getQty());

    }

    @Test
    void delete() {
        transistorDao = new TransistorDao();
        Transistor transistorToDelete = transistorDao.getById(41);  // MPSA13 Darlington Transistor
        transistorDao.delete(transistorToDelete);
        assertEquals(null, transistorDao.getById(41));

    }

    @Test
    void getAll() {
        transistorDao = new TransistorDao();
        List <Transistor> retrievedTransistors = transistorDao.getAll();
        assertEquals(49, retrievedTransistors.size());
    }

    @Test
    void getByPropertyEqual() {
        transistorDao = new TransistorDao();
        List <Transistor> foundTransistors = transistorDao.getByPropertyEqual("technology", "JFET");
        assertEquals(4, foundTransistors.size());
    }

    @Test
    void getByPropertyLike() {
        transistorDao = new TransistorDao();
        List <Transistor> foundTransistors = transistorDao.getByPropertyLike("packageName", "220");
        assertEquals(9, foundTransistors.size());
    }
}