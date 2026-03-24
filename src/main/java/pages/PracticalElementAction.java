package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PracticalElementAction {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailLoginTextbox;

    @FindBy(xpath = "//div[@class='check-border']")
    public WebElement termAndCodititionRadioB;

    @FindBy(xpath = "//button[@id='emailConfirmButton']")
    public WebElement emailConfirmButton;

    @FindBy(xpath = "(//div[@id='loginMethodDiv']//a)[4]")
    public WebElement continueWithEmailButton;

    @FindBy(xpath = "(//div[@id='loginMethodDiv']//a)[2]")
    public WebElement continueWithGEmailButton;

    @FindBy(xpath = "//span[text()='Next']")
    public WebElement nextButton;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordLoginTextbox;
    @FindBy(xpath = "//button[@id='loginBtn']")
    public WebElement loginBtn;
    @FindBy(xpath = "//h6[contains(text(),'Dashboard')]")
    public WebElement dashBoardElem;
    @FindBy(xpath = "//input[@type='password']")
    public WebElement gmailPasswordLogin;
    @FindBy(xpath = "//p[@id='loginErrorMessage']")
    public WebElement loginErrorMessage;
    @FindBy(xpath = "//select[@id='car_park_calendar']")
    public WebElement zoneDropdown;

    @FindBy(xpath = "//span[@id='settings_span']")
    public WebElement settingMenu;
    @FindBy(xpath = "//a[contains(text(),'General Settings')]")
    public WebElement generalSettingMenu ;
    @FindBy(xpath = "//i[@id='add_primary']")
    public WebElement addVehicalplusIcon ;
    @FindBy(xpath = "//i[contains(@class, 'fa-minus')]")
    public WebElement removeVehicalMinIcon ;
    @FindBy(xpath = "//button[@id='update_setting']")
    public WebElement updateSettingButton ;
    @FindBy(xpath = "(//label[text()='Primary Vehicle']//parent::div//input)[2]")
    public WebElement vehicalnofirst ;
    @FindBy(xpath = "(//select[@name='primaryvehicletype[]'])[2]")
    public WebElement vehicaltypefirst ;
    @FindBy(xpath = "(//select[@name='fuelCategory[]'])[2]")
    public WebElement vehicalfuelfirst ;
    @FindBy(xpath = "//span[@class='gritter-title']")
    public WebElement succsessMessage ;
    @FindBy(xpath = "//span[text()='Dashboard']")
    public WebElement dashboardMenu ;
    @FindBy(xpath = "(//i[contains(@class, 'fa-circle')])[1]")
    public WebElement availableFirstDaysForBooking ;
    @FindBy(xpath = "//select[@name='vehicletype']")
    public WebElement selectVehicleDropdown;
    @FindBy(xpath = "//button[contains(text(),'GET RANDOM SPACE')]")
    public WebElement getRandomSpaceButton;
    @FindBy(xpath = "//a[@id='pick_from_map']")
    public WebElement goToMapButton;
    @FindBy(xpath = "(//span[contains(text(),'Edit booking')]/preceding-sibling::a)[1]")
    public WebElement bookedSpot;
    @FindBy(xpath = "//button[@id='release_SpotID']")
    public WebElement cancelbookedSpot;
    @FindBy(xpath = "(//div[contains(@class,'SpotID_blank')])[1]")
    public WebElement availableFirstDaysForBookingonmap ;
    @FindBy(xpath = "//button[contains(@id,'claim_SpotID')]")
    public WebElement bookSpotFromMapButton ;
    @FindBy(xpath = "(//div[contains(@class,'SpotID_assigned')])[1]")
    public WebElement bookedSpotFromMapButton ;

    @FindBy(xpath = "//span[text()='Large Room']")
    public WebElement meetingBookFromMapButton ;

    @FindBy(xpath = "(//td[@data-time='09:30:00'])[2]")
    public WebElement selectTimeform ;

    @FindBy(xpath = "//button[@id='mb_timegrid_next']")
    public WebElement nextButtonfrom ;

    @FindBy(xpath = "//input[@id='mb_name']")
    public WebElement meetingNameTextB ;

    @FindBy(xpath = "//button[@id='mb_Confirm']")
    public WebElement confirmButtonfrom ;
    @FindBy(xpath = "//button[@id='mb_next']")
    public WebElement nextButtonfrom2 ;

    @FindBy(xpath = "//span[text()='Meetings']")
    public WebElement meeting_Tab ;

    @FindBy(xpath = "//a[text()='Cancel']")
    public WebElement cancel_Btn;

    @FindBy(xpath = "//button[@id='mb_cancellationConfirm']")
    public WebElement cancelConfirmButtonfrom ;


    public PracticalElementAction(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Initialize wait with 10 seconds timeout
        PageFactory.initElements(driver, this); // Initialize elements
    }

    // Method to perform click with dynamic wait
    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    // Method to perform sendKeys with dynamic wait
    public void sendKeysToElement(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    // Method to wait until the element is visible and assert its visibility
    public void assertElementVisible(WebElement element, String errorMessage) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element)); // Wait until the element is visible
            Assert.assertTrue(element.isDisplayed(), "Element is not visible: " + errorMessage);
        } catch (Exception e) {
            Assert.fail("Element visibility assertion failed: " + errorMessage, e);
        }
    }

    // Method to click an element using JavaScript
    public void clickElementUsingJS(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element)); // Ensure element is visible
        wait.until(ExpectedConditions.elementToBeClickable(element)); // Ensure element is clickable

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }
    // Method to scroll to an element and click it using JavaScript
    public void scrollclickElementUsingJS(WebElement element) {
        // Scroll to the button using JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Scroll horizontally and click on an element
    public void scrollAndClick(WebElement element) {
        // Locate the element you want to click (replace with the actual element locator)
        WebElement scrollBar = driver.findElement(By.cssSelector("div.ag-body-horizontal-scroll-viewport"));
        // Scroll the element into view using JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth;", scrollBar); // Scrolls vertically by default

        // Optionally, scroll right (horizontal scroll)
        js.executeScript("window.scrollBy(1000,0)");  // Scroll 1000 pixels to the right

        // Click the element after scrolling
        element.click();
    }
}
