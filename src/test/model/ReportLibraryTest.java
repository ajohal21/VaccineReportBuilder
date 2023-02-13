package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReportLibraryTest {

    private Report info1;
    private Report info2;
    private ReportLibrary reportLibrary1;


    @BeforeEach
    public void setup(){
        reportLibrary1 = new ReportLibrary("Set 1");

    }

    @Test
    public void testReportSetConstructor(){
        assertEquals("Set 1", reportLibrary1.getTitle());


    }

    @Test
    public void testAddingToInfoList(){
        assertEquals(0, reportLibrary1.getInfoListSize());
        info1 = new Report("name", 0 , "country");
        reportLibrary1.addInfo(info1);
        assertEquals(1, reportLibrary1.getInfoListSize());
    }

    @Test
    public void testAddingMultipleInfoToInfoList(){
        assertEquals(0, reportLibrary1.getInfoListSize());
        info1 = new Report("name", 0 , "country");
        info2 = new Report("Test2", 1, "Mexico");
        reportLibrary1.addInfo(info1);
        reportLibrary1.addInfo(info2);
        assertEquals(2, reportLibrary1.getInfoListSize());
    }

    @Test
    public void testRemovingInfoFromInfoList() {
        assertEquals(0, reportLibrary1.getInfoListSize());
        info1 = new Report("name", 0 , "country");
        reportLibrary1.addInfo(info1);
        assertEquals(1, reportLibrary1.getInfoListSize());
        reportLibrary1.removeInfo(info1);
        assertEquals(0, reportLibrary1.getInfoListSize());
    }

    @Test
    public void testPrintingMultipleInfo(){
        assertEquals(0, reportLibrary1.getInfoListSize());
        info1 = new Report("name", 0 , "country");
        info2 = new Report("Test2", 1, "Mexico");
        reportLibrary1.addInfo(info1);
        reportLibrary1.addInfo(info2);
        assertEquals(info2.toString() + "\n" + info1.toString() + "\n" , reportLibrary1.printReport());
    }

    @Test
    public void testPrintingSpecificReport() {
        assertEquals(0, reportLibrary1.getInfoListSize());
        info1 = new Report("name", 0 , "country");
        info2 = new Report("Test2", 1, "Mexico");
        reportLibrary1.addInfo(info1);
        reportLibrary1.addInfo(info2);
        assertEquals(info2, reportLibrary1.getSpecificReport("Test2"));
        assertEquals(info1, reportLibrary1.getSpecificReport("name"));
    }


}