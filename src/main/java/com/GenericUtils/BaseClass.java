package com.GenericUtils;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.pomObjectrepo.HomePage;
import com.pomObjectrepo.LoginPage;

public class BaseClass {
	public DataBaseUtils db = new DataBaseUtils();
	public ExcelUtils eu = new ExcelUtils();
	
	public FileUtils fu = new FileUtils();
	public WebDriverUtils wdu = new WebDriverUtils();
	public JavaUtils ju = new JavaUtils();
	public static WebDriver driver;

	@BeforeSuite(alwaysRun = true)
	public void connectToDB() throws SQLException {
		db.connectToDB();
		System.out.println("Connect To DB");

	}

	//@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser() throws Exception {
		String browser = fu.readDataFromPropertyFile("browser");
		String url = fu.readDataFromPropertyFile("userurl");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		} else {
			throw new Exception("invalid browser name ..");
		}


		wdu.maximizeWindow(driver);
		driver.get(url);
		wdu.waitForPageLoad(10, driver);
		System.out.println("browser launced");

	}

	@BeforeMethod(alwaysRun = true)
	public void loginToApp1() throws IOException {
		String uemail = fu.readDataFromPropertyFile("useremail");
		String pwd = fu.readDataFromPropertyFile("userpwd");
		LoginPage lp = new LoginPage(driver);
		lp.logInToApp(uemail, pwd);
		System.out.println("Logged in to app");

	}

	@AfterMethod(alwaysRun = true)
	public void logOutFromApp1() {
		HomePage hp = new HomePage(driver);
		hp.logoutConfirmation();
		System.out.println("Logged out from aplication");
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
		System.out.println("Browser closed");
	}

	@AfterSuite(alwaysRun = true)
	public void closeDB() throws SQLException {
		db.disconnectedDB();
		System.out.println("Disconnected from db");

	}

}
