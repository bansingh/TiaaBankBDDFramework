package stepDefs;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class SubmitApplicationStepDefs {

	WebDriver driver;

	@Given("^user is already on Home Page$")
	public void user_is_already_on_Home_Page() {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\vanda\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\vanda\\Downloads\\chromedriver_win32\\chromedriver.exe"); driver
		 * = new ChromeDriver();
		 */
		driver.get("https://www.tiaabank.com");

	}

	@When("^title of Home page is TIAA Bank :: Bank on Better: High Yields, Home Loans, 24/7 Support$")
	public void title_of_Home_page_is_TIAA_Bank() {

		String title = driver.getTitle();
		Assert.assertEquals("TIAA Bank :: Bank on Better: High Yields, Home Loans, 24/7 Support", title);
		System.out.println("Title matched with actual");

	}

	@Then("^user clicks on Open an account button$")
	public void user_clicks_on_Open_an_account_button() {

		driver.findElement(By.xpath("//a[@class='action-bar__cta-btn']")).click();
		String title = driver.getTitle();

		System.out.println("Title of this page is= " + title);
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^user selects product$")
	public void user_selects_product() {

		driver.findElement(By.xpath("//product-set[1]/div/div/div[2]/div/div[2]/div[2]/button")).click();
		;
		/*
		 * WebElement selProdBtn = driver.findElement(By.xpath(
		 * "/html/body/oa-app/div/div/div/oa-product-selection-route/form/div[3]/div/oa-switcher/oa-switcher-content[1]/div/product-set[1]/div/div/div[2]/div/div[2]/div[2]/button"
		 * )); JavascriptExecutor js = (JavascriptExecutor)driver;
		 * js.executeScript("arguments[0].click();", selProdBtn);
		 */
		// driver.findElement(By.xpath("//a[contains(text(), 'Select']")).click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("^user click on Start Application button$")
	public void user_click_on_Start_Application_button() {
		driver.findElement(
				By.xpath("/html/body/oa-app/div/div/div/oa-product-selection-route/form/div[2]/div/div[2]/button"))
				.click();
	}

	@Then("^user is redirected to Online Application page$")
	public void user_is_redirected_to_Online_Application_page() {

		String title = driver.getTitle();
		System.out.println("Actual Page Title is= " + title);
		Assert.assertEquals("Online Application", title);
		System.out.println("Page title matched with Actual");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^user clicks on Continue button$")
	public void user_clicks_on_Continue_button() {
		driver.findElement(By.xpath(
				"/html/body/oa-app/div/div/div/oa-client-check-route/form/div/div[2]/div/div/div/div/div[2]/div/button"))
				.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^user enters opening deposit amount$")
	public void user_enters_opening_deposit_amount(DataTable openingDep) {
		for(Map<String, String> data:openingDep.asMaps(String.class, String.class)) {     
		driver.findElement(By.xpath("//*[@id=\"deposit_product1\"]")).sendKeys(data.get("OpeningDeposit"));
	}
	}
	@Then("^user clicks on continue button$")
	public void user_clicks_on_continue_button() throws Throwable {
		driver.findElement(By.xpath(
				"/html/body/oa-app/div/div/div/oa-account-setup-route/form/div[1]/div[2]/div/div[2]/div/div[1]/oa-progress/div/ul/li[5]/button"))
				.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^user enters Applicant details$")
	public void user_enters_Applicant_details() {

		WebElement acctTypeRadioBtn = driver.findElement(By.xpath("//*[@id=\"applicationClassCode_0\"]"));
		acctTypeRadioBtn.click();

		Select titleDrpDwn = new Select(driver.findElement(By.name("title0")));
		titleDrpDwn.selectByVisibleText("Mr.");

		driver.findElement(By.name("firstName0")).sendKeys("AutomationFirst");
		driver.findElement(By.name("middleInitial0")).sendKeys("T");
		driver.findElement(By.name("lastName0")).sendKeys("Test1");

		Select suffixDrpDwn = new Select(driver.findElement(By.name("suffix0")));
		suffixDrpDwn.selectByVisibleText("Sr.");

		driver.findElement(By.xpath(
				"/html/body/oa-app/div/div/div/oa-applicant-details-route/form/div[1]/div[2]/div/div[1]/div[2]/div[2]/personal-form/div[2]/div[1]/date-input/div[1]/div/input[1]"))
				.sendKeys("09");
		driver.findElement(By.xpath(
				"/html/body/oa-app/div/div/div/oa-applicant-details-route/form/div[1]/div[2]/div/div[1]/div[2]/div[2]/personal-form/div[2]/div[1]/date-input/div[1]/div/input[2]"))
				.sendKeys("12");
		driver.findElement(By.xpath(
				"/html/body/oa-app/div/div/div/oa-applicant-details-route/form/div[1]/div[2]/div/div[1]/div[2]/div[2]/personal-form/div[2]/div[1]/date-input/div[1]/div/input[3]"))
				.sendKeys("1999");

		Select countryDrpDwn = new Select(driver.findElement(By.xpath("//*[@id=\"citizenshipCountry0\"]")));
		countryDrpDwn.selectByVisibleText("United States of America");

		Select taxIdTypeDrpDwn = new Select(driver.findElement(By.xpath("//*[@id=\"taxType0\"]")));
		taxIdTypeDrpDwn.selectByVisibleText("SSN");
		driver.findElement(By.name("taxNumber0")).sendKeys("987123765");

		driver.findElement(By.name("email0")).sendKeys("test123@auto.com");
		driver.findElement(By.name("emailConfirm0")).sendKeys("test123@auto.com");
		driver.findElement(By.name("mobilePhone0")).sendKeys("7045377942");
		driver.findElement(By.name("homePhone0")).sendKeys("7045388942");

		WebElement mobIntChkBox = driver.findElement(By.name("mobileInternational0"));
		mobIntChkBox.click();

		WebElement homeIntChkBox = driver.findElement(By.name("homeInternational0"));
		homeIntChkBox.click();

		WebElement resiIntChkBox = driver.findElement(By.name("residentialInternational0"));
		resiIntChkBox.click();

		driver.findElement(By.name("residentialStreet0")).sendKeys("Autumn Park");
		driver.findElement(By.name("residentialCity0")).sendKeys("Charlotte");
		driver.findElement(By.name("residentialPostalCode0")).sendKeys("28262");

		Select cntryDrpDwn = new Select(driver.findElement(By.name("residentialCountry0")));
		cntryDrpDwn.selectByVisibleText("United States of America");

		WebElement resiAsMlRadioBtn = driver.findElement(By.id("residentialAsMailing0_0"));
		resiAsMlRadioBtn.click();

		driver.findElement(By.name("securityCode0")).sendKeys("111111");
		driver.findElement(By.name("securityCodeHint0")).sendKeys("222222");

		Select employmentDrpDwn = new Select(driver.findElement(By.name("employmentType_0")));
		employmentDrpDwn.selectByVisibleText("Not Employed");

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * Select hdyhauDrpDwn = new
		 * Select(driver.findElement(By.name("referralType")));
		 * hdyhauDrpDwn.deselectByValue("Social Media");
		 */
		driver.findElement(By.xpath("//referral-form/div/div[1]/select-input/div/select/option[10]")).click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * driver.findElement(By.name("referralSource")).sendKeys("LinkedIn");
		 * 
		 * try { Thread.sleep(4000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

	}

	@Then("^user clicks on ApplicantDetailsContinue button$")
	public void user_clicks_on_ApplicantDetailsContinue_button() {
		driver.findElement(By.xpath(
				"/html/body/oa-app/div/div/div/oa-applicant-details-route/form/div[1]/div[2]/div/div[2]/div/div[1]/oa-progress/div/ul/li[5]/button"))
				.click();

		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^user clicks on ReviewInfoContinue button$")
	public void user_clicks_on_ReviewInfoContinue_button() {
		driver.findElement(By.cssSelector(".mu-btn")).click();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("^user Esigns and accepts the disclosures$")
	public void Esigns_and_accepts_the_disclosures() {

		WebElement eSignChkBox = driver.findElement(By.name("esignConsentAgree0"));
		eSignChkBox.click();

		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement accTermsChkBox = driver.findElement(By.name("accountTermsAgree0"));
		accTermsChkBox.click();

		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement prvcyChkBox = driver.findElement(By.name("privacyNoticeAgree0"));
		prvcyChkBox.click();

		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * Select bkpWithDrpDwn= new
		 * Select(driver.findElement(By.name("taxWithholdingAgree0"))); bkpWithDrpDwn.
		 * selectByVisibleText("No, I am not subject to backup withholding");
		 */

		driver.findElement(By.xpath("//*[@value='false']")).click();

		WebElement taxWithChkBox = driver.findElement(By.name("taxWithholdingAgree0"));
		taxWithChkBox.click();

	}

	@Then("^user clicks on Submit Application button$")
	public void user_clicks_on_Submit_Application_button() {

		driver.findElement(By.xpath("//*[@type='submit']")).click();

		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * @Then("^user enters funding details$") public void
	 * user_enters_funding_details() {
	 * 
	 * //driver.findElement(By.name("fundingAmount0")).sendKeys("8000");
	 * System.out.println("In funding details");
	 * 
	 * driver.findElement(By.xpath("//*[@id='fundingMethod0']/option[3]")).click();
	 * 
	 * 
	 * }
	 * 
	 * @Then("^user clicks on Choose Funding continue button$") public void
	 * user_clicks_on_Choose_Funding_continue_button() {
	 * 
	 * driver.findElement(By.xpath("//*[@type='submit']")).click(); }
	 */
}
