package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReportSetTest {

    private Information info1;
    private Information info2;
    private ReportSet reportSet1;


    @BeforeEach
    public void setup(){
        reportSet1 = new ReportSet("Set 1");

    }

    @Test
    public void testReportSetConstructor(){
        assertEquals("Set 1", reportSet1.getTitle());


    }

    @Test
    public void testAddingToInfoList(){
        assertEquals(0, reportSet1.getInfoListSize());
        info1 = new Information("name", 0 , "country", "vaccine");
        reportSet1.addInfo(info1);
        assertEquals(1, reportSet1.getInfoListSize());
    }

    @Test
    public void testAddingMultipleInfoToInfoList(){
        assertEquals(0, reportSet1.getInfoListSize());
        info1 = new Information("name", 0 , "country", "vaccine");
        info2 = new Information("Test2", 1, "Mexico", "Vaccines");
        reportSet1.addInfo(info1);
        reportSet1.addInfo(info2);
        assertEquals(2, reportSet1.getInfoListSize());
    }

    @Test
    public void testRemovingInfoFromInfoList() {
        assertEquals(0, reportSet1.getInfoListSize());
        info1 = new Information("name", 0 , "country", "vaccine");
        reportSet1.addInfo(info1);
        assertEquals(1, reportSet1.getInfoListSize());
        reportSet1.removeInfo(info1);
        assertEquals(0, reportSet1.getInfoListSize());
    }

    @Test
    public void testPrintingMultipleInfo(){
        assertEquals(0, reportSet1.getInfoListSize());
        info1 = new Information("name", 0 , "country", "vaccine");
        info2 = new Information("Test2", 1, "Mexico", "Vaccines");
        reportSet1.addInfo(info1);
        reportSet1.addInfo(info2);
        assertEquals("Test21MexicoVaccines" + "name0countryvaccine", reportSet1.printReport());
    }


}