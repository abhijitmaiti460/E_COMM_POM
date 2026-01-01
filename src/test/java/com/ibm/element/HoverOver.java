package com.ibm.element;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoverOver {
	
	public void hoverOver(List<WebElement> list, WebDriver driver) {
		
		for(WebElement e :list) {
			new Actions(driver).moveToElement(e).perform();
			System.out.println(e.getText());
		}
	}

}
