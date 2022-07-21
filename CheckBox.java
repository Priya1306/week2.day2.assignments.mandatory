package week2.day2.assignments.mandatory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//select languages that you know
		WebElement element1=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/input[1]"));
		element1.click();
		
		//Confirm selenium is checked
		WebElement element2=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/input"));
		System.out.println(element2.isSelected());
		
		//deselect only checked
		WebElement firstelement=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/input[1]"));
		if(firstelement.isSelected()) {
			firstelement.click();
		}
		WebElement secondelement=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/input[2]"));
		if(secondelement.isSelected()) {
			secondelement.click();
		}
		//Select all checkboxes
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/input[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/input[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/input[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/input[5]")).click();
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/input[6]")).click();
	}

}
