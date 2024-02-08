package mosafer;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mosafer extends Parameters {

	@BeforeTest
	public void MtSetUp() {
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		WebElement popUpScreen = driver.findElement(By.cssSelector(".sc-iBmynh.izXFRL"));
		if (popUpScreen.isDisplayed()) {
			driver.findElement(By.className("cta__saudi")).click();

		}

	}

	@Test
	public void TestLanguageIsEnglish() {
		String ExpectedLanaguage = "EN";
		String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang").toUpperCase();
System.out.println(ActualLanguage);
		assertEquals(ActualLanguage, ExpectedLanaguage);
	}

}
