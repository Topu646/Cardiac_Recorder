package com.example.cardiacrecorder;
import static org.junit.Assert.*;

import org.junit.Test;

public class UnitTest {


    @Test
    public void testAdd() {
        Insert_Record datalist = new Insert_Record("01/01/2023","10.25","80","120","72","no comment");
        assertEquals("01/01/2023" ,datalist.getDate_of_measurement());
        assertEquals("10.25" ,datalist.getTime_of_measurement());
        assertEquals("80" ,datalist.getSystolic_ressure());
        assertEquals("120" ,datalist.getDiastolic_pressure());
        assertEquals("72" ,datalist.getHeartrate());
        assertEquals("no comment" ,datalist.getComment());


    }

    @Test
    public void testaddUserData()
    {
        Insert_Record datalist = new Insert_Record("01/01/2023","10.25","80","120","72","no comment");
        datalist.addUserData(datalist);
        assertEquals(1,datalist.count());

        Insert_Record datalist2 = new Insert_Record("01/01/2023","10.25","80","120","72","no comment");
        datalist.addUserData(datalist2);
        assertEquals(2,datalist.count());

        assertTrue(datalist.getData().contains(datalist));
        assertTrue(datalist.getData().contains(datalist));
    }


    @Test
    public void testdeleteUserData()
    {
        Insert_Record datalist = new Insert_Record("01/01/2023","10.25","80","120","72","no comment");
        datalist.addUserData(datalist);
        assertEquals(1,datalist.getData().size());

        Insert_Record datalist2 = new Insert_Record("01/01/2023","10.25","80","120","72","no comment");
        datalist.addUserData(datalist2);
        assertEquals(2,datalist.count());

        datalist.deleteUserData(datalist);
        assertEquals(1,datalist.getData().size());
        assertFalse(datalist.getData().contains(datalist));

        datalist.deleteUserData(datalist2);
        assertEquals(0,datalist.getData().size());
        assertFalse(datalist.getData().contains(datalist2));

    }

    @Test
    public void testdeleteUserDataException()
    {
        Insert_Record datalist = new Insert_Record("01/01/2023","10.25","80","120","72","no comment");
        datalist.addUserData(datalist);

        datalist.deleteUserData(datalist);
        assertThrows(IllegalArgumentException.class,() -> datalist.deleteUserData(datalist));
    }

    @Test
    public void testaddUserDataException()
    {
        Insert_Record datalist = new Insert_Record("01/01/2023","10.25","80","120","72","no comment");
        datalist.addUserData(datalist);

        assertThrows(IllegalArgumentException.class,() -> datalist.addUserData(datalist));
    }


    @Test
    public void testCount()
    {
        Insert_Record datalist = new Insert_Record("01/01/2023","10.25","80","120","72","no comment");
        datalist.addUserData(datalist);
        assertEquals(1,datalist.count());
    }
}
