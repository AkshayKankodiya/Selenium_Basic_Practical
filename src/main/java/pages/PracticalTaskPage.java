package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PracticalTaskPage {

    private WebDriver driver;
    private PracticalElementAction practicalElementAction;

    public PracticalTaskPage() {
        // Initialize the driver here
    }
    // Method to open the browser and navigate to the login page

//    public WebDriver openBrowser() {
//
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.navigate().to("https://staging.ronspot.ie/member/login/employee");
//        this.practicalElementAction = new PracticalElementAction(driver);
//        return driver;
//    }

    // Method to navigate to the login page URL
    public void navigateUrl(){
        driver.navigate().to("https://staging.ronspot.ie/member/login/employee");
    }

    // Method to open the browser and navigate to the login page in incognito mode
    public WebDriver openBrowser() {
        // Initialize ChromeOptions and add the incognito argument
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito"); // Set incognito mode
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://staging.ronspot.ie/member/login/employee");
        this.practicalElementAction = new PracticalElementAction(driver);
        return driver;
    }


    // Method for logging in with a valid email and password
    public void userLoginWithEmail() throws InterruptedException {

        practicalElementAction.sendKeysToElement(practicalElementAction.emailLoginTextbox,"test.automation.krayons@gmail.com");
        practicalElementAction.clickElement(practicalElementAction.termAndCodititionRadioB);
        practicalElementAction.clickElement(practicalElementAction.emailConfirmButton);
        practicalElementAction.clickElementUsingJS(practicalElementAction.continueWithEmailButton);
        practicalElementAction.sendKeysToElement(practicalElementAction.passwordLoginTextbox,"Test@12345");
        practicalElementAction.clickElement(practicalElementAction.loginBtn);
        practicalElementAction.assertElementVisible(practicalElementAction.dashBoardElem, "Dashboard is not Display");
        System.out.println("User On Dashboard page");
        Thread.sleep(5000);
    }
    // Method for logging in with an invalid email/password
    public void invaliduserLoginWithEmail() throws InterruptedException {
        practicalElementAction.sendKeysToElement(practicalElementAction.emailLoginTextbox,"test.automation.krayons@gmail.com");
        practicalElementAction.clickElement(practicalElementAction.termAndCodititionRadioB);
        practicalElementAction.clickElement(practicalElementAction.emailConfirmButton);
        practicalElementAction.clickElementUsingJS(practicalElementAction.continueWithEmailButton);
        practicalElementAction.sendKeysToElement(practicalElementAction.passwordLoginTextbox,"Test@88888");
        practicalElementAction.clickElement(practicalElementAction.loginBtn);
        practicalElementAction.assertElementVisible(practicalElementAction.loginErrorMessage, "login Error Message is not Display");
        Thread.sleep(5000);
    }
    // Method for logging in using Gmail
    public void userLoginWithGEmail() throws InterruptedException {
        practicalElementAction.sendKeysToElement(practicalElementAction.emailLoginTextbox,"test.automation.krayons@gmail.com");
        practicalElementAction.clickElement(practicalElementAction.termAndCodititionRadioB);
        practicalElementAction.clickElement(practicalElementAction.emailConfirmButton);
        practicalElementAction.clickElementUsingJS(practicalElementAction.continueWithGEmailButton);
        Thread.sleep(5000);
        practicalElementAction.clickElement(practicalElementAction.nextButton);
        practicalElementAction.sendKeysToElement(practicalElementAction.gmailPasswordLogin,"Test@123");
        practicalElementAction.clickElement(practicalElementAction.nextButton);
        practicalElementAction.clickElement(practicalElementAction.loginBtn);
        practicalElementAction.assertElementVisible(practicalElementAction.dashBoardElem, "Dashboard is not Dispaly");
        Thread.sleep(5000);
    }

    // Method to check and add a primary vehicle
    public void AvailablePrimaryVehicle() throws InterruptedException {
        practicalElementAction.clickElement(practicalElementAction.settingMenu);
        practicalElementAction.clickElement(practicalElementAction.generalSettingMenu);
        Thread.sleep(3000);
        List<WebElement> elements = driver.findElements(By.xpath("//div[@id='primary_div']//div//div[@class='row']"));
        System.out.println("Total Available Vehicles are :" +elements.size() );

        practicalElementAction.clickElement(practicalElementAction.addVehicalplusIcon);
        practicalElementAction.sendKeysToElement(practicalElementAction.vehicalnofirst,"171717");
        fuelDropDown(1);
        vehicaltypeDropDown(1);
        Thread.sleep(4000);
        practicalElementAction.scrollclickElementUsingJS(practicalElementAction.updateSettingButton);
        practicalElementAction.clickElementUsingJS(practicalElementAction.updateSettingButton);
        practicalElementAction.assertElementVisible(practicalElementAction.succsessMessage,"success message is not display");
        Thread.sleep(5000);

    }

    // Method for selecting a zone from dropdown
    public void zoneDropDown(int index) throws InterruptedException {
        practicalElementAction.clickElement(practicalElementAction.dashboardMenu);
        practicalElementAction.assertElementVisible(practicalElementAction.dashBoardElem, "Dashboard is not Dispaly");
        Thread.sleep(5000);

        Select dropdown = new Select(practicalElementAction.zoneDropdown);
        List<WebElement> options = dropdown.getOptions();

        System.out.println("Available Total zone are "+ options.size());
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        dropdown.selectByIndex(index);
        System.out.println("Selected option: " + dropdown.getFirstSelectedOption().getText());
        Thread.sleep(5000);
    }
    // Method for selecting a fueltype from dropdown
    public void fuelDropDown(int index) throws InterruptedException {
        Select dropdown = new Select(practicalElementAction.vehicalfuelfirst);
        List<WebElement> options = dropdown.getOptions();

        System.out.println("Available Total Dropdown option "+ options.size());
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        dropdown.selectByIndex(index);
        System.out.println("Selected option: " + dropdown.getFirstSelectedOption().getText());
        Thread.sleep(5000);
    }
    // Method for selecting vehicle type from dropdown
    public void vehicaltypeDropDown(int index) throws InterruptedException {
        Select dropdown = new Select(practicalElementAction.vehicaltypefirst);
        List<WebElement> options = dropdown.getOptions();

        System.out.println("Available Total Dropdown option "+ options.size());
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        dropdown.selectByIndex(index);
        System.out.println("Selected option: " + dropdown.getFirstSelectedOption().getText());
        Thread.sleep(5000);
    }

    // Method to refresh and count available and not available days for booking
    public void refreshAndCountDays() throws InterruptedException {

        List<WebElement> elements = driver.findElements(By.xpath("//i[@class='fa fa-refresh']"));
        System.out.println("Total Available Vehicles are :" +elements.size() );

        for (WebElement element : elements) {
            // Wait for 5 seconds
            Thread.sleep(3000);
            practicalElementAction.scrollclickElementUsingJS(element);
            Thread.sleep(3000);
            // Click the element
            element.click();

            // Optionally, you can log the action
            System.out.println("Clicked on element: " + element);
        }
        Thread.sleep(3000);
        List<WebElement> availableDays = driver.findElements(By.xpath("//i[contains(@class,'fa-circle')]"));
        System.out.println("Total Available Days for Booking:" +availableDays.size() );

        List<WebElement> notavailableDays = driver.findElements(By.xpath("//i[contains(@class, 'fa-ban')]"));
        System.out.println("Total Not Available Days for Booking:" +notavailableDays.size() );


    }

    // Method for selecting vehicle from dropdown
    public void selectVehicalDropDown(int index) throws InterruptedException {
        Select dropdown = new Select(practicalElementAction.selectVehicleDropdown);
        List<WebElement> options = dropdown.getOptions();

        System.out.println("Available Total Dropdown option "+ options.size());
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        dropdown.selectByIndex(index);
        System.out.println("Selected option: " + dropdown.getFirstSelectedOption().getText());
        Thread.sleep(5000);
    }

    // Method to book a parking spot from the calendar
    public void bookSpotFromCalender() throws InterruptedException {
        zoneDropDown(0);
        refreshAndCountDays();
        practicalElementAction.clickElement(practicalElementAction.availableFirstDaysForBooking);
        selectVehicalDropDown(1);
        practicalElementAction.clickElement(practicalElementAction.getRandomSpaceButton);
        practicalElementAction.assertElementVisible(practicalElementAction.succsessMessage,"success message is not display");
        Thread.sleep(5000);
        String bookedSpot = practicalElementAction.bookedSpot.getText();
        System.out.println("Booked Spot is :" +bookedSpot);

    }
    // Method to book a parking spot from the map
    public void bookSpotFromMap() throws InterruptedException {
        zoneDropDown(0);
        refreshAndCountDays();
        practicalElementAction.clickElement(practicalElementAction.availableFirstDaysForBooking);
        selectVehicalDropDown(0);
        practicalElementAction.clickElement(practicalElementAction.goToMapButton);
        Thread.sleep(5000);
        List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class,'SpotID_blank')]"));
        System.out.println("Total Available Spot On MAP :" +elements.size() );
        Thread.sleep(2000);
        practicalElementAction.clickElement(practicalElementAction.availableFirstDaysForBookingonmap);
        Thread.sleep(3000);
        practicalElementAction.clickElement(practicalElementAction.bookSpotFromMapButton);
        practicalElementAction.assertElementVisible(practicalElementAction.succsessMessage,"success message is not display");
        Thread.sleep(3000);
        String bookedSpot = practicalElementAction.bookedSpotFromMapButton.getAttribute("title");
        System.out.println("Booked Spot is :" +bookedSpot);

    }

    // Method to book a meeting room
    public void bookMeeting() throws InterruptedException {
        zoneDropDown(1);
        refreshAndCountDays();
        practicalElementAction.clickElement(practicalElementAction.availableFirstDaysForBooking);
        practicalElementAction.clickElement(practicalElementAction.goToMapButton);
        Thread.sleep(7000);
        practicalElementAction.clickElement(practicalElementAction.meetingBookFromMapButton);
        Thread.sleep(7000);
        datepicker2();
        Thread.sleep(5000);
        practicalElementAction.clickElement(practicalElementAction.selectTimeform);
        Thread.sleep(3000);
        practicalElementAction.scrollclickElementUsingJS(practicalElementAction.nextButtonfrom);
        practicalElementAction.clickElement(practicalElementAction.nextButtonfrom);
        Thread.sleep(3000);
        practicalElementAction.sendKeysToElement(practicalElementAction.meetingNameTextB,"TestMeeting");
        practicalElementAction.clickElement(practicalElementAction.nextButtonfrom2);
        Thread.sleep(3000);
        practicalElementAction.clickElement(practicalElementAction.confirmButtonfrom);
        practicalElementAction.assertElementVisible(practicalElementAction.succsessMessage,"success message is not display");
        Thread.sleep(3000);
        System.out.println("Created Meeting is : TestMeeting");
        }

    // Method to handle date picker selection for meeting booking

    public void datepicker2() throws InterruptedException {
        WebElement dateInput = driver.findElement(By.id("select_bookingdate")); // Adjust the XPath as needed
        dateInput.click();
        Thread.sleep(2000);
        WebElement calendarPopup = driver.findElement(By.xpath("//table[contains(@class, 'table-condensed')]")); // Adjust XPath as needed
        List<WebElement> days = calendarPopup.findElements(By.xpath(".//td"));
        int enabledDayCount = 0;
        for (WebElement day : days) {
            // Skip if the day is empty or disabled
            if (day.getText().isEmpty() || day.getAttribute("class").contains("disabled")) {
                continue;
            }
            enabledDayCount++;
            if (enabledDayCount == 2) {
                day.click();
                break; // Exit after selecting the second enabled day
            }
        }
        Thread.sleep(5000);

    }
    // Method to cancel a meeting booking
    public void cancelbookMeeting() throws InterruptedException {
        practicalElementAction.clickElement(practicalElementAction.meeting_Tab);
        Thread.sleep(7000);
        practicalElementAction.scrollAndClick(practicalElementAction.cancel_Btn);
        //practicalElementAction.clickElement(practicalElementAction.cancel_Btn);
        Thread.sleep(2000);
        practicalElementAction.clickElement(practicalElementAction.cancelConfirmButtonfrom);
        Thread.sleep(5000);
        System.out.println("Cancel Created Meeting -TestMeeting ");
    }

    // Method to remove the primary vehicle
    public void removePrimaryVehicle() throws InterruptedException {

        practicalElementAction.clickElement(practicalElementAction.settingMenu);
        practicalElementAction.clickElement(practicalElementAction.generalSettingMenu);
        // Click the first element in the list
        practicalElementAction.removeVehicalMinIcon.click();
        // Log the action
        Thread.sleep(4000);
        practicalElementAction.scrollclickElementUsingJS(practicalElementAction.updateSettingButton);
        practicalElementAction.clickElementUsingJS(practicalElementAction.updateSettingButton);
        practicalElementAction.assertElementVisible(practicalElementAction.succsessMessage,"success message is not display");
        Thread.sleep(5000);

    }
    // Method to cancel a booked spot from the calendar
    public void CancelbookSpotFromCalender() throws InterruptedException {
        zoneDropDown(0);
        Thread.sleep(3000);

        List<WebElement> elements = driver.findElements(By.xpath("(//span[contains(text(),'Edit booking')]/preceding-sibling::a)"));
        System.out.println("Total Booked Spot :" +elements.size() );

        for (WebElement element : elements) {
            // Wait for 5 seconds
            Thread.sleep(3000);
            practicalElementAction.scrollclickElementUsingJS(element);
            practicalElementAction.clickElement(practicalElementAction.bookedSpot);
            Thread.sleep(3000);
            practicalElementAction.clickElement(practicalElementAction.cancelbookedSpot);
        }

    }

    // Method to close the browser driver
    public void closeDriver(){
        driver.quit();
    }
}
