package com.ibm.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	
		WebDriver driver;
		WebDriverWait wait;
		
		public ProductPage(WebDriver driver,WebDriverWait wait)
		{
			this.driver=driver;
			this.wait=wait;
			PageFactory.initElements(driver,this);
		}
	
	//WebElement for link Catalog
			@FindBy(xpath="//a[contains(text(),'Catalog')]")
			WebElement catalogEle;
		
	//WebElement for link Products
			@FindBy(xpath="//a[contains(text(),'Products')]")
			WebElement prodEle;
		
	//WebElement for icon Add New
			@FindBy(xpath="//a[@title='Add New']")
			WebElement addnewEle;
		
	//WebElement for field Product Name
			@FindBy(xpath="//input[@id='pro_name']")
			WebElement pnameEle;
			
	//WebElement for field Meta Title
			@FindBy(xpath="//input[@id='meta_title']")
			WebElement mtitleEle;
			
	//WebElement for tab Data
			@FindBy(xpath="//a[text()='Data']")
			WebElement datatabEle;
	
	//WebElement for field Model
			@FindBy(xpath="//input[@id='model']")
			WebElement modelEle;
	
	//WebElement for field GST
			@FindBy(xpath="//input[@id='gst']")
			WebElement gstEle;
			
	//WebElement for field Price
			@FindBy(xpath="//input[@id='price']")
			WebElement priceEle;
			
	//WebElement for field Special Discount
			@FindBy(xpath="//input[@id='special_dis']")
			WebElement spdisEle;
	
	//WebElement for field Price After Special Discount
			@FindBy(xpath="//input[@id='price_after_special_dis']")
			WebElement dispriceEle;
			
	//WebElement for tab Link
			@FindBy(xpath="//a[text()='Link']")
			WebElement linktabEle;
			
	//WebElement for drop down Tabs
			@FindBy(xpath="//select[@id='tabs']")
			WebElement tabsddEle;
			
	//WebElement for drop down Categories
			@FindBy(xpath="//select[@id='categories']/option[4]")
			WebElement catEle;
			
	//WebElement for tab Image
			@FindBy(xpath="//a[text()='Image']")
			WebElement imageEle;
			
	//WebElement for icon Product Image
			@FindBy(xpath="//input[@id='pro_image']")
			WebElement pimageEle;
			
	//WebElement for icon Save
			@FindBy(xpath="//button[@title='Save']")
			WebElement saveEle;
			
			public void clickLinkCatalog()
			{
				catalogEle.click();
			}
			
			public void clickOnLinkProducts()
			{
				prodEle.click();
			}
			
			public void clickOnIconAddNew()
			{
				addnewEle.click();
			}
			
			public void enterProductName(String productname)
			{
				pnameEle.sendKeys(productname);
			}
			
			public void enterMetaTitle(String metatitle)
			{
				mtitleEle.sendKeys(metatitle);
			}
			
			public void clickOnTabData()
			{
				datatabEle.click();
			}
			
			public void enterModel(String model)
			{
				modelEle.sendKeys(model);
			}
			
			public void enterGST(String gst)
			{
				gstEle.clear();
				gstEle.sendKeys(gst);
			}
			
			public void enterPrice(String price)
			{
				priceEle.sendKeys(price);
			}
			
			public void enterSplDiscount(String specialdiscount)
			{
				spdisEle.sendKeys(specialdiscount);
			}
			
			public void enterDiscountPrice(String discountprice)
			{
				dispriceEle.sendKeys(discountprice);
			}
			
			public void clickOnTabLink()
			{
				linktabEle.click();
			}
			
			public void selectFromTabs()
			{
				tabsddEle.click();
				Select tabsEle = new Select(tabsddEle);
				tabsEle.selectByVisibleText("Test01");
			}
			
			public void selectCategories()
			{
				catEle.click();
			}
			
			public void clickOnTabImage()
			{
				imageEle.click();
			}
			
			public void enterImage(String imagepath)
			{
				pimageEle.sendKeys(imagepath);
			}
			
			public void clickOnIconSave()
			{
				saveEle.click();
			}
						
			public void validationOnRecord() throws FileNotFoundException, IOException
			{
				Properties p = new Properties();
				p.load(new FileInputStream("./TestData/magentodata.properties"));
			
				String pagesource = driver.getPageSource();
				//System.out.println(pagesource);
				
				if(pagesource.contains(p.getProperty("productname"))) {
					System.out.println("The presence of added product is confirmed!");
				}
				else {
					System.out.println("The product is not added to the Product List");
				}
			}

}
