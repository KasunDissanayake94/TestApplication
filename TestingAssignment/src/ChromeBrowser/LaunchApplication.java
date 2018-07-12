

package ChromeBrowser;

//import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.ArrayList;

public class LaunchApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.ikman.lk");
		
		WebDriverWait wait = new WebDriverWait(driver,15);
		
		String cssOfPropertyButton = "body > div.app-content > div.home-top > div > div.home-focus > div > div:nth-child(1) > div:nth-child(2) > a";
		WebElement propertyButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfPropertyButton)));
		propertyButton.click();
		
		String cssOfHousesButton = "body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-3.lg-filter-area > div > div > form > div > div:nth-child(3) > div > ul > li > ul:nth-child(2) > li > ul > li.ui-link-tree-item.cat-411 > a";
		WebElement houseButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfHousesButton)));
		houseButton.click();
		
		String cssOfColomboButton = "body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-3.lg-filter-area > div > div > form > div > div:nth-child(4) > div > ul > li > ul > li.ui-link-tree-item.loc-1506 > a";
		WebElement colomboButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfColomboButton)));
		colomboButton.click();
		
		String cssOfPriceButton = "div.ui-accordion-item:nth-child(6) > a:nth-child(1) > div:nth-child(2)";
		WebElement priceButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfPriceButton)));
		priceButton.click();
		
		String cssOfMin = "#filters\\[0\\]\\[minimum\\]";
		WebElement minField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfMin)));
		minField.sendKeys("5000000");
		
		String cssOfMax = "#filters\\[0\\]\\[maximum\\]";
		WebElement maxField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfMax)));
		maxField.sendKeys("7500000");
		
		String cssOfApply = ".is-price > div:nth-child(6) > div:nth-child(1) > div:nth-child(1)";
		WebElement applyButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfApply)));
		applyButton.click();
		
		String cssOfBeds = "body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-3.lg-filter-area > div > div > form > div > div.ui-accordion-item.filter-enum.filter-bedrooms > a > div";
		WebElement numberOfBeds = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfBeds)));
		numberOfBeds.click();
		
		String cssOfTreeBeds = "#filters2values-3";
		WebElement threeBeds = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfTreeBeds)));
		threeBeds.click();		
		
		String cssOfAdsNumber = ".serp-summary > div:nth-child(2)";
		String adsNumber = driver.findElement(By.cssSelector(cssOfAdsNumber)).getText();
		String[] splited = adsNumber.split(" ");
		System.out.println("No of Ads Found : "+splited[3]);
		
		int count = Integer.parseInt(splited[3]);	
		int countPage = count/25;
		int i = 0;
		int y = 1;
		while (i <= countPage) {			
			
			String cssOfAd = "div[class='ui-item']";
			List<WebElement> elements = driver.findElements(By.cssSelector(cssOfAd));
			System.out.println("page "+(i+1));
			
			for (WebElement e: elements) {
				String adText = e.getText();
				String adPrice = adText.substring(adText.indexOf("Rs ")+3,adText.indexOf("Rs ")+12);
				System.out.println("Ad Number "+y+" Price is : Rs "+adPrice);
				y++;
			}		
			String cssOfNext = "body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div.row.lg-g > div > div > div > div > div > a.col-6.lg-3.pag-next > span";
			WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssOfNext)));
			nextButton.click();
			i++;		
		}		
		System.out.println(y);	
	}

}