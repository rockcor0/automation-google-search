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
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
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
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		assertEquals(SEARCH + " - Buscar con Google", driver.getTitle());
	}
	
	
	
	public void localizators() {
		By locator_Id = By.name("name_element");
		By locator_className = By.className("Nombre de la etiqueta class");
		By locator_tagName = By.tagName("Nombre tag");
		By locator_linkText = By.linkText("Texto exacto");
		By locator_partialLinkText = By.partialLinkText("Elementos que contienen este texto");
		By locator_cssSelector = By.cssSelector("input[name='q']");
		By locator_XPath = By.xpath("//input[@name='q']");
		//JavaScript
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement searchBox = (WebElement)js.executeScript("return document.getElementsByName('')");
		
	}
	
	@After
	public void tearDown() {
		//Close the web driver
		driver.quit();
	}
	

}
