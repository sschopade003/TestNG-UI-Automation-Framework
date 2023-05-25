package TestSuite;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.LoginPage;
import Utilities.ReadConfig;

public class LoginTestSuite extends Base {
	LoginPage loginPage;

	@BeforeTest(alwaysRun = true)
	public void setup() {
		initializeDriver();
		readConfig = new ReadConfig();
		loginPage = new LoginPage(driver);
		log.info("Execution started...");
	}

	@Test(enabled = true, priority = 1)
	public void userLogin() {
		loginPage.enterUsername(readConfig.getUsername());
		loginPage.enterPassword(readConfig.getPassword());
		loginPage.clickLoginButton();
		Assert.assertTrue(loginPage.getPageTitle(), "User logged in successfully");

	}

	@AfterTest
	public void teardown() {
		log.info("Execution ended...");
		driver.close();
		driver.quit();
	}
}
