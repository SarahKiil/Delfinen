package data;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DatabaseTest {
    private Database database;

    @org.junit.jupiter.api.Test
    void testBeregnSamletKontingent() {
        Database database = new Database();
        Date date1 = new Date(1990, 10, 10);
        Date date2 = new Date(2020, 05, 07);
        Date date3 = new Date(1995, 07, 03);
        Date date4 = new Date(2015, 01, 02);

        database.tilføjSvømmer("John Johnson", 15248, "Senior", true, true, date1, "Vejen 2", "mailadresse@mail.com", 12345678, "crawl og butterfly", 1000);
        database.tilføjSvømmer("Carina Crawl", 18768, "Junior", true, false, date2, "Vejen 2", "mailadresse@mail.com", 12345678, "crawl", 1000);
        database.tilføjSvømmer("Benny Butterfly", 15288, "Senior", true, true, date3, "Vejen 2", "mailadresse@mail.com", 12345678, "butterfly", 1600);
        database.tilføjSvømmer("Ronnie Rygsvømmer", 11248, "Junior", true, true, date3, "Vejen 2", "mailadresse@mail.com", 12345678, "rygsvømning", 0);



        double expectedResult = 5200;
        double actualResult = database.beregnSamletKontingent();

        assertEquals(expectedResult, actualResult);
    }

    @org.junit.jupiter.api.Test
    void testBetaltKontingentIAlt() {
        Database database = new Database();
        Date date1 = new Date(1990, 10, 10);
        Date date2 = new Date(2020, 05, 07);
        Date date3 = new Date(1995, 07, 03);
        Date date4 = new Date(2015, 01, 02);

        database.tilføjSvømmer("John Johnson", 15248, "Senior", true, true, date1, "Vejen 1", "mailadresse@mail.com", 12345678, "crawl og butterfly", 1000);
        database.tilføjSvømmer("Carina Crawl", 18768, "Junior", true, false, date2, "Vejen 2", "mailadresse@mail.com", 12345678, "crawl", 1000);
        database.tilføjSvømmer("Benny Butterfly", 15288, "Senior", true, true, date3, "Vejen 3", "mailadresse@mail.com", 12345678, "butterfly", 1600);
        database.tilføjSvømmer("Ronnie Rygsvømmer", 11248, "Junior", true, true, date3, "Vejen 4", "mailadresse@mail.com", 12345678, "rygsvømning", 0);

        double expectedResult = 3600;
        double actualResult = database.betaltKontingentIAlt();

        assertEquals(expectedResult, actualResult);
    }

    @org.junit.jupiter.api.Test
    void testBeregnMedlemsRestance() {
        Database database = new Database();
        Date date1 = new Date(1990, 10, 10);

        database.tilføjSvømmer("John Johnson", 15248, "Senior", true, true, date1, "Vejen 1", "mailadresse@mail.com", 12345678, "crawl og butterfly", 1000);
        double expectedResult = 600;
        double actualResult = database.beregnMedlemsRestance("John Johnson");

        assertEquals(expectedResult, actualResult);
    }

}
