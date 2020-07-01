package TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger.GenericLib.BaseClass;
import com.Vtiger.objectRepository.CreatedLeadPageElements;
import com.Vtiger.objectRepository.HomePageElements;
import com.Vtiger.objectRepository.LeadInFoPageElements;
import com.Vtiger.objectRepository.LeadPageElements;

public class CreateLeadTest extends BaseClass {

	@Test
	public void createLead() throws EncryptedDocumentException, IOException
	{
		HomePageElements hp = PageFactory.initElements(driver, HomePageElements.class);
		LeadPageElements lp = PageFactory.initElements(driver, LeadPageElements.class);
		CreatedLeadPageElements clpe = PageFactory.initElements(driver, CreatedLeadPageElements.class);
		LeadInFoPageElements lip = PageFactory.initElements(driver, LeadInFoPageElements.class);
		
		hp.getLeads().click();
		lp.getCreatedLead().click();
		clpe.getLastNameTb().sendKeys(data.getDataFromExcel("LeadData", 2, 1));
		clpe.getCompanyNameTb().sendKeys(data.getDataFromExcel("LeadData", 2, 2));
		clpe.getSaveBtn().click();
		
		
		
		String actLaedMsg = lip.getSuccessMsg().getText();
		Assert.assertTrue(actLaedMsg.contains(data.getDataFromExcel("LeadData", 2, 3)));
	}
}
