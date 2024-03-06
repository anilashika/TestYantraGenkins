package com.GenericUtils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {
	
	public void waitForPageLoad(int sec,WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	public void maximizeWindow(WebDriver driver)
	{
	driver.manage().window().maximize();
	}
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
		
	}
	public void waitUntilEleToBeVisible(WebDriver driver ,int sec,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitUntilEleToBeClickable(WebDriver driver ,int sec,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitUntilAlertIsPresent(WebDriver driver ,int sec)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/* For the above WebDriverWait we can also write generic methor for creating object of WebDriverWait*
	 public WebDriverWait webdriverwait(WebDriver driver,int sec)
	 {
	  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
	  return wait;
	 }
	 public void waitUntilEleToBeClickable1(WebDriver driver ,int sec,WebElement element)
		{
			
		 webdriverwait(driver,sec).until(ExpectedConditions.elementToBeClickable(element));
		 }
	 */
	public void handleDropDown(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/*create a method to create object of Select class to make it generic*/
	public Select selectObject(WebElement element)
	{
		Select sel=new Select(element);
		return sel;
		
	}
	public void handleDropDown(WebElement element,String value)
	{
		selectObject(element).selectByValue(value);
	}
	public void handleDropDown(String text,WebElement element)
	{
		selectObject(element).selectByVisibleText(text);
	}
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement dst)
	{
		Actions act= new Actions(driver);
		act.dragAndDrop(src, dst).perform();
	}
	/*create a method to create object of Actions class to make it generic*/
	public Actions actionsObject(WebDriver driver)
	{
		Actions act= new Actions(driver);
		return act;
	}
	public void mouseHoverOnEle(WebDriver driver,WebElement ele)
	{
		actionsObject(driver).moveToElement(ele).perform();
	}
	public void doubleClickAction(WebDriver driver, WebElement element)//double click on element
	{
	
		actionsObject(driver).doubleClick(element).perform();
	}

	public void doubleClickAction(WebDriver driver)//double click on web page
	{
		actionsObject(driver).doubleClick().perform();
	}
	public void rightClick(WebDriver driver)//right click on webpage
	{
		actionsObject(driver).contextClick().perform();
	}
	public void rightClick(WebDriver driver, WebElement element)//right click on element
	{
		actionsObject(driver).contextClick(element).perform();
	}
	public void enterKeyPress(WebDriver driver)
	{
		
		actionsObject(driver).sendKeys(Keys.ENTER).perform();
	}
	

	public void enterKey() throws Throwable
	{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}

	public void enterRelease() throws Throwable
	{
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	public void swithToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	public void switchToFrame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public static String getScreenShot(WebDriver driver, String screenShotName) throws Throwable
	{
		JavaUtils ju=new JavaUtils();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = ".\\screenshot\\"+screenShotName+" "+ju.getSystemDateInFormat()+".png";
		File dst = new File(path);
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)","");
	}
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
		//js.executeScript("argument[0].scrollIntoView()",element);
				
	}
    public void switchToWindow(WebDriver driver,String expwind)
	{
		Set<String> window=driver.getWindowHandles();
		Iterator<String> it=window.iterator();
		while(it.hasNext())//checks whether next element is present or not
		{
			String win=it.next();//will give the data of next ele in set
			String currtitle=driver.switchTo().window(win).getTitle();
			if(currtitle.contains(expwind))
			{
				break;
			}
		}
	}
	
	 
	
	
	

}
