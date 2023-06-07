package baseClases;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final Duration TIMEOUT = Duration.ofSeconds(10);

    public BasePage(WebDriver driver) {
        wait = new WebDriverWait(driver, TIMEOUT);
        this.driver = driver;
    }

    protected void openUrl(String url) {
        driver.get(url);
        waitForCurrentUrl(url);
    }

    /**
     * This method returns WebElement. This method accepts parameter String "xpath"
     */
    protected WebElement findClickableElementBy(String xpath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        return driver.findElement(By.xpath(xpath));
    }

    protected WebElement findVisibleElementBy(String xpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return driver.findElement(By.xpath(xpath));
    }

    /**
     * This method waits for a clickable WebElement and returns it. This method accepts parameter String "xpath"
     */
    protected void waitElementToBeClickable(String xpath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    /**
     * This method waits for a clickable WebElement and returns it. This method accepts parameter WebElement "element"
     */
    protected void waitElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * This method waits for a visible WebElement and returns it. This method accepts parameter String "xpath"
     */
    protected void waitElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf((element)));
    }

    /**
     * This method waits for a visibility all elements of WebElement and returns List<WebElement>. This method accepts
     * parameter String "xpath"
     */
    protected void waitElementsAreVisibility(String xpath) {
        Allure.step("Waiting for visibility of all elements By %s" + xpath,
                () -> wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))));
    }

    /**
     * This method waits for a visibility all elements of WebElement and returns List<WebElement>. This method accepts
     * parameter WebElement "element"
     */
    protected void waitElementsAreVisibility(WebElement element) {
        Allure.step("Waiting for visibility of all elements By %s" + element,
                () -> wait.until(ExpectedConditions.visibilityOfAllElements(element)));
    }

    /**
     * This method waits for a selected WebElement and returns it. This method accepts parameter String "xpath"
     */
    protected void waitElementToBeSelected(String xpath) {
        wait.until(ExpectedConditions.elementToBeSelected(By.xpath(xpath)));
    }

    /**
     * This method waits for a selected WebElement and returns it. This method accepts parameter WebElement "element"
     */
    protected void waitElementToBeSelected(WebElement element) {
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    /**
     * This method waits for invisibility WebElement and returns it. This method accepts parameter String "xpath"
     */
    protected boolean waitElementToBeInvisibility(String xpath) {
      return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }

    /**
     * This method waits for invisibility WebElement and returns it. This method accepts the WebElement parameter "element"
     */
    protected void waitElementToBeInvisibility(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * This method waits for invisibility all elements of WebElement and returns List<WebElement>. This method accepts
     * parameter WebElement "element"
     */
    protected List<WebElement> waitElementsAreInvisibility(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOfAllElements(element));
        return driver.findElements((By) element);
    }

    /**
     * This method returns "true" if the current page will be expected url. This method accepts parameter String "url"
     */
    protected boolean waitForCurrentUrl(String url) {
        return wait.until(ExpectedConditions.urlToBe(url));
    }

    /**
     * This method switches on a new tab
     */
    protected BasePage switchNewTab() {
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(windowHandles.size() - 1));
        return this;
    }

    /**
     * This method switches on the tab
     */
    protected BasePage switchOnTab(int index) {
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(index));
        return this;
    }
}
