package week2.day2.assignments.mandatory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeDriver driver=new ChromeDriver();
driver.navigate().to("http://www.leafground.com/pages/Dropdown.html");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//select by index
WebElement d1=driver.findElement(By.id("dropdown1"));
Select s1=new Select(d1);
s1.selectByIndex(2);
//select by text

WebElement d2=driver.findElement(By.name("dropdown2"));
Select s2=new Select(d2);
s2.selectByVisibleText("Selenium");
//select by value
WebElement d3=driver.findElement(By.id("dropdown3"));
Select s3=new Select(d3);
s3.selectByValue("3");
//get no of options
WebElement d4=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/select"));
Select s4=new Select(d4);
List<WebElement> options = s4.getOptions();
int number=options.size();
System.out.println("Number of elements "+number);
//use sendkeys to select
WebElement d5=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[5]/select"));
d5.sendKeys("Load");
//multiselect
WebElement d6=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[6]/select"));
Select s5=new Select(d6);
s5.selectByIndex(1);
s5.selectByIndex(2);
s5.selectByIndex(3);
	}

}
