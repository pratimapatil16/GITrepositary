package TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Vtiger.GenericLib.BaseClass;

public class CreateCampaignTest extends BaseClass {

	@Test
	public void CreateCampaign() throws EncryptedDocumentException, IOException 
	{
		WebElement ListMore = driver.findElement(By.linkText("More"));
		Actions act = new Actions(driver);
		act.moveToElement(ListMore).perform();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(data.getDataFromExcel("Campaign", 2, 1));
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		String successMsg = driver.findElement(By.className("dvHeaderText")).getText();
		Reporter.log(successMsg, true);
		
		String result = successMsg.contains(data.getDataFromExcel("Campaign", 2, 2))?
				"Campaign Create SuccessFully.." : "Campaign not Created..";
		Reporter.log(result, true);

	}
}
