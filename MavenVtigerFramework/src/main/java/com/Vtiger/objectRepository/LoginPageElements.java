package com.Vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageElements {

	@FindBy(name="user_name")
	private WebElement username;
	
	@FindBy(name="user_password")
	private WebElement password;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	@FindBy(xpath="//div[contains(text(),'You must specify a valid')]")
	private WebElement errMsg;
	
	public WebElement getUsename() 
	{
	  return username;	
	}
	
	public WebElement getPassword() 
	{
	  return password;	
	}
	
	public WebElement getLoginBtn() 
	{
	  return loginBtn;	
	}
	
	public WebElement getErrorMsg() 
	{
	  return errMsg;	
	}
	public void loginToApp(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click(); 
		
	}
}
