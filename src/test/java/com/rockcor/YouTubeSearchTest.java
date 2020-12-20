package com.rockcor;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YouTubeSearchTest {

	public final String SEARCH = "I think we are alone now";

	//WebDriver from Selenium
	private WebDriver driver;


	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/cromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
	}

	@Test
	public void testYouTubePage() {
		WebElement sBox = driver.findElement(By.name("search_query"));
		sBox.clear();
		sBox.sendKeys(SEARCH);
		sBox.submit();
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);

		assertEquals(SEARCH + " - YouTube", driver.getTitle());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();

	}


}
