package week2.day2.assignments.mandatory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//no of columns
		List<WebElement> columns=driver.findElements(By.tagName("th")); 
		int columncount=columns.size();
		System.out.println("number of columns "+columncount);
		
		//no of rows
		List<WebElement> rows=driver.findElements(By.tagName("tr"));
		int rowcount=rows.size();
		System.out.println("number of rows "+rowcount);
		
		//get the progress of Learn to interact with elements
		WebElement element=driver.findElement(By.xpath("(//td[normalize-space()='Learn to interact with Elements'])[1]//following::td[1]"));
		String text=element.getText();
		System.out.println("The percenntage is "+text);
		
		//check the vital of least completed progress
		List<WebElement> progress=driver.findElements(By.xpath("//td[2]"));	
		List<Integer> numberList=new ArrayList<Integer>();
		for (WebElement webElement : progress) {
			String individualprogress=webElement.getText().replace("%", "");
			numberList.add(Integer.parseInt(individualprogress));
		}
		System.out.println("Final list "+numberList);
		int smallvalue= Collections.min(numberList);
		String str=Integer.toString(smallvalue)+"%";
		//the xpath is //td[normalize-space()='20%']//following::td
		driver.findElement(By.xpath("//td[normalize-space()="+"\""+str+"\""+"]"+"//following::td")).click();
		//to check whether xpath is correct
		//System.out.println("//td[normalize-space()="+"\""+str+"\""+"]"+"//following::td");
	

	}

}
