package TestSuite;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.LoginPage;
import Utilities.ReadConfig;

public class HomeTestSuite extends Base {
	LoginPage loginPage;
	HomePage homePage;

	@BeforeTest(alwaysRun = true)
	public void setup() {
		initializeDriver();
		readConfig = new ReadConfig();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		log.info("Execution started...");
	}

	@Test(enabled = true, priority = 1)
	public void userAddItemtoCartAndRemove() {
		loginPage.userLogin(readConfig.getUsername(), readConfig.getPassword());
		homePage.addItemToCart();
		homePage.goToCart();
		homePage.removeItemFromCart();
		homePage.continueShopping();
		Assert.assertTrue(homePage.verifyTitle(), "User logged in successfully");

	}

	@AfterTest
	public void teardown() {
		log.info("Execution ended...");
		driver.close();
		driver.quit();
	}
}
