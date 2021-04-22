
package com.qa.opencart.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;


public class LoginPageTestNegative {

	
	

	@Epic("Epic 500: Design login page for demo cart application")
	@Story("Us 100: Develop a feature with all login page scenarios")
	public class LoginPageTest extends BaseTest {
		
		
		@DataProvider
		public Object[][]  loginNegativeData(){
			return new Object[][] {
									{"test@gmail.com", "test@123"},
									{" ", " "},
									{" "," "}
																};
		}
		

		@Test(priority = 0, dataProvider = "loginNegativeData")
		public void loginNegativeTest(String un, String pwd) {
			loginPage.doLoginWrongData(un,pwd);
		}
	}

}
