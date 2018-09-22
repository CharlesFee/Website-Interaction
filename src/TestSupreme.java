/**
 * @author Charles Fee
 */

import java.awt.AWTException;
import java.awt.Robot;
import java.lang.reflect.Array;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.sourceforge.htmlunit.corejs.javascript.ast.Name;


public class TestSupreme {
static String name ="Charles Fee";
static char[] charArray;
static int x=0;
static WebDriver driver = new ChromeDriver();
static Scanner console = new Scanner(System.in);
public static void main(String[] args) throws InterruptedException, AWTException {
	WebElement link;
	//go to website
	driver.get("https://www.supremenewyork.com/shop/all");
	waitForPageLoaded();
	System.out.println("Enter Something ");
	String guess = console.next();
	//navigate to jackets
	link = driver.findElement(By.linkText("jackets"));
	System.out.println(link);
	link.click();
	waitForPageLoaded();
	//name of product
	link = driver.findElement(By.partialLinkText("Logo Tape N-3B Parka"));
	System.out.println(link);
	link.click();
	waitForPageLoaded();
	//choosing color
	link = driver.findElement(By.xpath("//img[@alt=\"6v3 ppoemz8\"]"));
	System.out.println(link);
	link.click();
	waitForPageLoaded();
	//buy button
	link = driver.findElement(By.name("commit"));
	System.out.println(link);
	link.click();
	Thread.sleep(500);
	//checkout
	link = driver.findElement(By.partialLinkText("checkout now"));
	System.out.println(link);
	link.click();
	waitForPageLoaded();
	//name
	link = driver.findElement(By.cssSelector("label[for=\"order_billing_name\"]"));
	link.click();
	driver.switchTo().activeElement().sendKeys("Charles Fee");
	Thread.sleep(50);
	//email
	link = driver.findElement(By.cssSelector("label[for=\"order_email\"]"));
	link.click();
	driver.switchTo().activeElement().sendKeys("email");
	Thread.sleep(50);
	//phone number
	link = driver.findElement(By.cssSelector("label[for=\"order_tel\"]"));
	link.click();
	driver.switchTo().activeElement().sendKeys("12341234");
	Thread.sleep(50);
	//Address
	link = driver.findElement(By.cssSelector("label[for=\"bo\"]"));
	link.click();
	driver.switchTo().activeElement().sendKeys("address");
	Thread.sleep(50);
	//zip
	link = driver.findElement(By.cssSelector("label[for=\"order_billing_zip\"]"));
	link.click();
	driver.switchTo().activeElement().sendKeys("12345");
	Thread.sleep(50);
	//Credit card
	link = driver.findElement(By.cssSelector("label[for=\"nnaerb\"]"));
	link.click();
	driver.switchTo().activeElement().sendKeys("111111111111"+Keys.TAB+"05"+Keys.TAB+"2027");
	Thread.sleep(50);
	/**CC month
	link = driver.findElement(By.name("credit_card[month]"));
	link.click();
	driver.switchTo().activeElement().sendKeys("11");
	Thread.sleep(200);
	//CC Year
	link = driver.findElement(By.name("credit_card[year]"));
	link.click();
	driver.switchTo().activeElement().sendKeys("1111");
	Thread.sleep(200);**/
	//CVV
	link = driver.findElement(By.cssSelector("label[for=\"orcer\"]"));
	link.click();
	driver.switchTo().activeElement().sendKeys("111");
	Thread.sleep(50);	
}

public static void waitForPageLoaded() {
    ExpectedCondition<Boolean> expectation = new
            ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                }
            };
    try {
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(expectation);
    } catch (Throwable error) {

    }
}
}