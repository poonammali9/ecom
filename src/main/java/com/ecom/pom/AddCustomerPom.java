package com.ecom.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.base.BaseClass;

public class AddCustomerPom extends BaseClass {
	
	public  AddCustomerPom() {
		PageFactory.initElements(driver,this);
		
		}
	 @FindBy(xpath = "//input[@name='name']")
	 WebElement customerName;
	 
	// @FindBy(linkText ="female")
	 //WebElement genderFemale;
	 
	// @FindBy(xpath = )
	 //WebElement genderFemale;
	 
	 @FindBy(xpath = "//textarea[@name='addr']")
	 WebElement address;
	 
	 @FindBy(xpath = "//input[@name='city']")
	 WebElement city;
	 
	 @FindBy(xpath = "//input[@name='state']")
	 WebElement state;
	 
	 @FindBy(xpath = "//input[@name='pinno']")
	 WebElement pinNo;
	 
	 @FindBy(xpath = "//input[@name='telephoneno']")
	 WebElement telephNo;
	 
	 @FindBy(xpath = "//input[@name='emailid']")
	 WebElement email;
	 
	 @FindBy(xpath = "//input[@name='sub']")
	 WebElement submit;
	 
	  @FindBy(xpath = "//input[@name='res']")
	 WebElement reset;
	  
	  public void setLoginCredentials1(Object userName, Object passwordMap) {
		  customerName.sendKeys(userName.toString());
		//  genderFemale.click();
		  address .sendKeys(userName.toString());
		  city.sendKeys(userName.toString());
		  state.sendKeys(userName.toString());
		  pinNo.sendKeys(userName.toString());
		  telephNo.sendKeys(userName.toString());
		  email.sendKeys(userName.toString());
		  submit.click();
		}
	  public ManagerHomePom clickOnsubmit() {
		  submit.click();
			return new ManagerHomePom();
		}


}

	 
	  
		