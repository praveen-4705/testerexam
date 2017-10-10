package io.autotest.pages;

import io.autotest.annotation.PageObject;
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

}
