/**
 * 
 */
package com.rockcor;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author ricardodelgadocarreno
 *
 */
public class GoogleSearchTest {
	
	public final String SEARCH = "I think we are alone now";
	
	//WebDriver from Selenium
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/cromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void testGooglePage() {
		WebElement sBox = driver.findElement(By.name("q"));
		sBox.clear();
		sBox.sendKeys(SEARCH);
		sBox.submit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		assertEquals(SEARCH, driver.getTitle());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	

}
