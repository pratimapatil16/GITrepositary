package com.Vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Vtiger.GenericLib.BaseClass;

public class HomePageElements extends BaseClass {

	@FindBy(linkText="Leads")
	private WebElement leads;
	
	@FindBy(linkText="Organizations")
	private WebElement organization;
	
	@FindBy(linkText="Products")
	private WebElement product;
	
	@FindBy(xpath="//span[text()=' Administrator']/../following-sibling::td[1]/img")
	private WebElement signOutDD;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	public WebElement getLeads()
	{
		return leads;
	}
	
	public WebElement getOrganizations()
	{
		return organization;
	}
	
	public WebElement getProducts()
	{
		return product;
	}
	
	public WebElement getSignOutDD()
	{
		return signOutDD;
	}
	
	public WebElement getSignOutLink()
	{
		return signOutLink;
	}
	
	public void logOutFromApp()
	{
	      wlib.keepMouseOnElement(signOutDD);
	      signOutLink.click();
	}
}
