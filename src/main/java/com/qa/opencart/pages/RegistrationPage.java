package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class RegistrationPage {
	private ElementUtil elementUtil;

	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");

	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input");
	
	private By agreeCheckBox = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");
	private By sucessMessg = By.cssSelector("div#content h1");

	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");

	public RegistrationPage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
	}
	
	public boolean accountRegistration(String firstName, String lastName, 
							String email, String telephone,
							String password, String subsribe) {
		elementUtil.doSendKeys(this.firstName, firstName);
		elementUtil.doSendKeys(this.lastName, lastName);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.telephone, telephone);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doSendKeys(this.confirmpassword, password);
		if(subsribe.equals("yes")) {
			elementUtil.doClick(subscribeYes);
		}else {
			elementUtil.doClick(subscribeNo);
		}
		elementUtil.doClick(agreeCheckBox);
		elementUtil.doClick(continueButton);
//		WebElement ele = elementUtil.waitForElementVisible(sucessMessg, 5);
//		ele.getText();
		String mesg = elementUtil.waitForElementVisible(sucessMessg, 5).getText();
		System.out.println("account creation : " + mesg);
		if(mesg.contains(Constants.REGISTER_SUCCESS_MESSG)) {
			elementUtil.doClick(logoutLink);
			elementUtil.doClick(registerLink);
			return true;
		}
		return false;		
	}
	
	
	
	
}
	
//	private WebDriver driver;
//	private ElementUtil elementUtil;
//	
//	// 1. private By locators:
//		private By firstName = By.id("input-firstname");
//		private By lastName = By.id("input-lastname");
//		private By email = By.id("input-email");
//		private By telePhone = By.id("input-telephone");
//		private By password = By.id("input-password");
//		private By passwordConfirm = By.id("input-confirm");
//		private By subscribeNo = By.xpath("//label[normalize-space()='No']");
//		private By privacypolicy = By.xpath("//input[@type='checkbox']");
//		private By continueButton = By.xpath("//input[@type='submit']");
//
//		// 2. constructors
//		public RegistrationPage(WebDriver driver) {
//			this.driver = driver;
//			elementUtil = new ElementUtil(driver);
//		}
//		public String getRegistrationPageTitle() {
//			return elementUtil.waitForTitle(5, Constants.REGISTRATION_PAGE_TITLE);
//		}
//
//		public void doRegister(locator) {
//			elementUtil.doSendKeys(firstName);
//			elementUtil.doSendKeys(lastName);
//			elementUtil.doSendKeys(email);
//			elementUtil.doSendKeys(telePhone);
//			elementUtil.doSendKeys(password);
//			elementUtil.doSendKeys(passwordConfirm);
//			elementUtil.doClick(subscribeNo);
//			elementUtil.doClick(privacypolicy);
//			elementUtil.doClick(continueButton);
//			return new AccountsPage(driver);
//		}
//
//}
