package tests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.PracticalTaskPage;

public class PracticalTaskTest {

    private PracticalTaskPage practicalTaskPage;

    @BeforeClass
    public void setupBrowser() {
        practicalTaskPage = new PracticalTaskPage();
        practicalTaskPage.openBrowser();

    }
    @Test(priority = 0)
    public void employeeLoginWithInvalidUserLogin() throws InterruptedException {
        System.out.println("-----------------------------Test01----------------------------");
        practicalTaskPage.invaliduserLoginWithEmail();
        System.out.println("--------------------------Verified Login With invalid Login data ");
    }
    @Test(priority = 1)
    public void employeeLoginWithDifferentMethods() throws InterruptedException {
        System.out.println("-----------------------------Test02----------------------------");
        practicalTaskPage.navigateUrl();
        practicalTaskPage.userLoginWithEmail();
        //practicalTaskPage.userLoginWithGEmail();
        System.out.println("--------------------------------Verified Login With Valid Login data ");
    }


    @Test(priority = 2)
    public void addPrimaryVehicle() throws InterruptedException {
        System.out.println("-----------------------------Test03-----------------------------------------");
        practicalTaskPage.AvailablePrimaryVehicle();
        System.out.println("------------------------------Add Primary Vehicle and Verify success message ");

    }

    @Test(priority = 3)
    public void zoneNameWithTotalZoneCounts() throws InterruptedException {
        System.out.println("-----------------------------Test04----------------------------------------");
        practicalTaskPage.zoneDropDown(0);
        System.out.println("-----------------------------zone Name WithTotal ZoneCounts ");
    }
    @Test(priority = 4)
    public void availableAndNotAvailableDays() throws InterruptedException {
        System.out.println("-----------------------------Test05----------------------------------------");
        practicalTaskPage.refreshAndCountDays();
        System.out.println("------------------------------Available And NotAvailable Days ");
    }

    @Test(priority = 5)
    public void bookingSpotFromCalender() throws InterruptedException {
        System.out.println("-----------------------------Test06----------------------------------------");
        practicalTaskPage.bookSpotFromCalender();
        System.out.println("---------------------------------Booking Spot From Calendar");


    }
    @Test(priority = 6)
    public void bookingSpotFroMmap() throws InterruptedException {
        System.out.println("-----------------------------Test07----------------------------------------");
        practicalTaskPage.bookSpotFromMap();
        System.out.println("-------------------------------------------------------Booking Spot From Map");

    }

    @Test(priority = 7)
    public void bookingMeetingFromMap() throws InterruptedException {
        System.out.println("-----------------------------Test08----------------------------------------");
        practicalTaskPage.bookMeeting();
        System.out.println("----------------------------------------------------Booking Meeting From Map");
    }

    @AfterClass
    public void quitDriver() throws InterruptedException {
//        practicalTaskPage.cancelbookMeeting();
//        practicalTaskPage.removePrimaryVehicle();
//        practicalTaskPage.CancelbookSpotFromCalender();

//        System.out.println("Remove the Added Primary Vehicle and Verify success message ");
        practicalTaskPage.closeDriver();
    }
}