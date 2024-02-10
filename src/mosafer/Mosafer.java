package mosafer;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mosafer extends Parameters {

	@BeforeTest
	public void MySetUp() {
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		WebElement popUpScreen = driver.findElement(By.cssSelector(".sc-iBmynh.izXFRL"));
		if (popUpScreen.isDisplayed()) {
			driver.findElement(By.className("cta__saudi")).click();

		}

	}

	@Test(priority = 1 )
	public void TestLanguageIsEnglish() {
		String ExpectedLanaguage = "EN";
		String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang").toUpperCase();
		System.out.println("Actual Language : "+ActualLanguage);
		assertEquals(ActualLanguage, ExpectedLanaguage);
	}

	@Test(priority = 2)
	public void CheekCurrencySAR() {
		String ActualCurrency = driver.findElement(By.className("sc-dRFtgE")).getText().toUpperCase();
		System.out.println("Actual Currency : " + ActualCurrency);
		String ExpectedCurrency = "SAR";
		assertEquals(ActualCurrency, ExpectedCurrency);
	}

	@Test(priority = 3)
	public void CheckContactNumber() {
		String ExpectedNumber = "+966554400000";
		String actualNumber = driver.findElement(By.tagName("strong")).getText();
		System.out.println("The Actual phone number : "+actualNumber);

		assertEquals(ExpectedNumber, actualNumber);
	}

	@Test(priority = 4)
	public void QetafLogo() {
		WebElement theFooter = driver.findElement(By.tagName("footer"));
		WebElement QetafLogo = theFooter.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF"));
		assertEquals(QetafLogo.isDisplayed(), true);
	}
	@Test(priority = 5)
	public void CheckIfTheeHotelTabNotSelected() {
		String HotelTabStatuse =driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")).getAttribute("aria-selected") ;
	System.out.println("Hotel Statuse : " + HotelTabStatuse);
	
	assertEquals(HotelTabStatuse, "false");
	}
	
	
	@Test(priority = 6)
	public void CheckDepatureDateAndReturnDate() {

		LocalDate today = LocalDate.now();

		int expectedDepatureDate = today.plusDays(1).getDayOfMonth();
		int expectedReturnDate = today.plusDays(2).getDayOfMonth();

		int ActualDepatureDate = Integer.parseInt(driver
				.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-kqlzXE blwiEW'] span[class='sc-cPuPxo LiroG']"))
				.getText());

		int ActualReturn = Integer.parseInt(driver
				.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-OxbzP edzUwL'] span[class='sc-cPuPxo LiroG']"))
				.getText());

		assertEquals(ActualReturn, expectedReturnDate);
		assertEquals(ActualDepatureDate, expectedDepatureDate);

	}
	
	@Test(priority = 7)
	public void RandomMethodToChangeTheLanguage() {
		Random rand = new Random();

		int randomIndexForTheWebSite = rand.nextInt(Websites.length);

		driver.get(Websites[randomIndexForTheWebSite]);

		if (driver.getCurrentUrl().contains("ar")) {
			String ExpectedLang = "ar";

			String ActualLang = driver.findElement(By.tagName("html")).getAttribute("lang");

			assertEquals(ActualLang, ExpectedLang);
		} else {
			String ExpectedLang = "en";

			String ActualLang = driver.findElement(By.tagName("html")).getAttribute("lang");

			assertEquals(ActualLang, ExpectedLang);

		}

	}
}
