package io.autotest.pages;

import io.autotest.annotation.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageObject
public class GoogleCalcPage {
	@FindBy(id = "cwbt33")
	private WebElement btn1;
	@FindBy(id = "cwbt34")
	private WebElement btn2;
	@FindBy(id = "cwbt35")
	private WebElement btn3;
	@FindBy(xpath = "//span[@id='cwos']")
	private WebElement result;

	public void clickOnGivenButton(WebDriver driver, String value) {
		
		for (int i = 0; i < value.length(); i++) {
			driver.findElement(By.xpath(String.format("//span[text()='%s']", value.charAt(i)))).click();
			synchTime(1000);	
		}
	}
	
	private void synchTime(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getResult() {

		String resultText = result.getText().trim();

		return resultText;
	}

}
