package TestScripts;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Vtiger.GenericLib.BaseClass;

public class CreateOrganizationTest extends BaseClass {

	@Test
	public void createOrganization() throws EncryptedDocumentException, IOException 
	{
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		String orgName = data.getDataFromExcel("CreateOrganization", 2, 1);
		Random r = new Random();
		int num = r.nextInt(9999);
		orgName = orgName+num;
		
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
		
		String actOrgMsg = driver.findElement(By.xpath("//span[contains(text(),'Organization Information')]")).getText();
		Reporter.log(actOrgMsg, true);
		
		if(actOrgMsg.contains(data.getDataFromExcel("CreateOrganization", 2, 2)))
		{
			Reporter.log("Organization created successfully...", true);
		}else {
			Reporter.log("Organization Creation Fails....", true);
		}
	}
}
