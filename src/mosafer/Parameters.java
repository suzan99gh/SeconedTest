package mosafer;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameters {

	WebDriver driver = new ChromeDriver();
	String URL = "https://global.almosafer.com/en";

	Random rand = new Random();

	String[] Websites = { "https://global.almosafer.com/en", "https://global.almosafer.com/ar" };

	String[] CitiesInEnglish = { "dubai", "jeddah", "riyadh" };

	int randomEnglishCity = rand.nextInt(CitiesInEnglish.length);

	String[] CitiesInArabic = { "دبي", "جدة" };

	int randomArabicCity = rand.nextInt(CitiesInArabic.length);

	int randomOption = rand.nextInt(2);

}
