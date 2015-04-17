package com.example.tests;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;
import static org.apache.commons.lang3.StringUtils.join;

public class meinTestfall3 {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://www.postdirekt.de/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testMeinTestfall3() throws Exception {
		selenium.open("/plzserver/");
		selenium.type("id=search_plz_city", "Stuttgart");
		selenium.click("id=search_btn_find");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Stuttgart".equals(selenium.getText("//tr[@id='0']/td[2]"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		verifyEquals("Stuttgart", selenium.getText("//tr[@id='0']/td[2]"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
