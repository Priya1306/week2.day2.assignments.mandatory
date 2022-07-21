package week2.day2.assignments.mandatory;

import java.util.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Link {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//go to homepage and come back
		WebElement homepage=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div/div/a"));
		homepage.click();
		driver.navigate().back();
		//find where am supposed to go without clicking me
		WebElement element = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/a"));
		String text=element.getAttribute("href");
		System.out.println("the page is going to " +text);
		//go to homepage(interact with same link name)
		WebElement homepage1=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div/div/a"));
		homepage1.click();
	    driver.navigate().back();
	    //verify the link is broken
	    driver.findElement(By.linkText("Verify am I broken?")).click();
	    String title=driver.getTitle();
	    if(title.contains("404")) {
	    	System.out.println("link is broken");
	    }
	    driver.navigate().back();
	    //count no of link
	    List<WebElement> totallinks=driver.findElements(By.tagName("a"));
	    int count=totallinks.size();
	    System.out.println("total no of links "+count);
	   	    
	}
	

}
