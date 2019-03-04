import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class RedVenturesTestSuite {
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();


@Before public void setUp() throws Exception {
//Chrome Driver
System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");

// Initialize browser
driver=new ChromeDriver();
}	

//Test 1
@Test public void Test1() throws Exception {
	System.out.println("TEST 1 RESULTS: ");

	// Open creditcards.com
	driver.get("http://www.creditcards.com/");
	// Maximize browser
	driver.manage().window().maximize();
	Thread.sleep(3000);
	WebElement check = driver.findElement(By.xpath("/html/body/div[1]/main/section[1]/div[1]/h1"));

    if(check.isDisplayed() ) { //check if the "Get recommendations button" is present and if so run this test
    	 
    	Thread.sleep(3000);;
   		System.out.println( "The Get recommendations button did NOT appear");	
   		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='OK'])[1]/following::h1[1]")).click();
   		try {
   			assertEquals("Excellent\n 740 – 850", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='What’s your credit score?'])[1]/following::label[1]")).getText());
   			System.out.println("The Excellent 740 – 850 element is present step PASSES");
   		} catch (Error e) {
   			verificationErrors.append(e.toString());
   			System.out.println("The Excellent 740 - 850 element is present step FAILS");
   		}
   		Thread.sleep(2000);

   		try {
   			assertEquals("Good\n 670 – 739", driver.findElement(By.xpath("//label[2]")).getText());
   			System.out.println("The Good 670 - 739 element is present step PASSES");

   		} catch (Error e) {
   			verificationErrors.append(e.toString());
   			System.out.println("The Good 670 - 739 element is present step FAILS");
   		}
   		Thread.sleep(2000);

   		try {
   			assertEquals("Fair", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Fair Credit'])[2]/preceding::strong[1]")).getText());
   			System.out.println("The Fair element is present step PASSS");
   		} catch (Error e) {
   			verificationErrors.append(e.toString());
   			System.out.println("The Fair element is not present step FAILS");
   		}
   		Thread.sleep(2000);

   		try {
   			assertEquals("Needs Work\n 300 – 579", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='™'])[1]/following::label[2]")).getText());
   			System.out.println("The needs work 300 - 579 element is present step PASSES");
   		} catch (Error e) {
   			verificationErrors.append(e.toString());
   			System.out.println("The Needs work 300 - 579 element is not present step FAILS");
   		}
   		Thread.sleep(2000);

   		try {
   			assertEquals("Limited / No Credit", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='™'])[2]/following::strong[1]")).getText());
   			System.out.println("No Credit element is present step PASSES");
   		} catch (Error e) {
   			verificationErrors.append(e.toString());
   			System.out.println("No Credit element is not present step FAILES");
   		}
   		Thread.sleep(2000);
    		
    } else {	//if the "get recommendation" box is not present
    	
    		Thread.sleep(3000);
   			System.out.println( "The Get recommendations button appeared");	   
     		try {
     	        assertEquals("", driver.findElement(By.id("flow_button")).getAttribute("value"));
     	      } catch (Error e) {
     	        verificationErrors.append(e.toString());
     	      }
     		driver.findElement(By.id("flow_button")).click();
     		try {
     			assertEquals("740 - 850", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Excellent'])[1]/following::div[1]")).getText());
       			System.out.println("The Excellent 740 – 850 element is present step PASSES");  
     		} catch (Error e) {
     			verificationErrors.append(e.toString());
       			System.out.println("The Excellent 740 - 850 element is present step FAILS");

     		}
     		try {
     			assertEquals("Good", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Excellent'])[1]/following::div[6]")).getText());
       			System.out.println("The Good element is present step PASSES");

     		} catch (Error e) {
     			verificationErrors.append(e.toString());
       			System.out.println("The Good element is present step PASSES");

     		}
     		try {
     			assertEquals("300 - 579", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Needs Work'])[1]/following::div[1]")).getText());
       			System.out.println("The 300 - 579 element is present step PASSES");
     		} catch (Error e) {
     			verificationErrors.append(e.toString());
       			System.out.println("The 300 - 579 element is not present step FAILS");

     		}
     		try {
     			assertEquals("Limited / No Credit", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Needs Work'])[1]/following::div[6]")).getText());
       			System.out.println("No Credit element is present step PASSES");

     		} catch (Error e) {
     			verificationErrors.append(e.toString());
       			System.out.println("No Credit element is not present step FAILS");
     		}
     		try {
     			assertEquals("", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Advertiser Disclosure'])[2]/following::button[1]")).getAttribute("value"));
       			System.out.println("X button element is present step PASSES");
     		} catch (Error e) {
     			verificationErrors.append(e.toString());
       			System.out.println("X button element is not present step FAILS");

     		}
     		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Advertiser Disclosure'])[2]/following::button[1]")).click();
    	}

}

//Test2
@Test public void Test2() throws Exception {
	System.out.println("TEST 2 RESULTS: ");
	
	// Open creditcards.com
	driver.get("http://www.creditcards.com/");
	 
	// Maximize browser
	driver.manage().window().maximize();
	Thread.sleep(3000);
	//create hover action to hover over menu
	WebElement hover = driver.findElement(By.linkText("Resources"));
	Actions action = new Actions(driver);
	
	action.moveToElement(hover).build().perform();
	Thread.sleep(2000);
	
//The following If statements are to check if the values are present and if so notify the command line
	if (driver.findElement(By.linkText("Resources")) != null ){
	      System.out.println( "Resources is present and STEP PASSES");
	    } else {
	    	System.out.println( "Resources is NOT present and STEP FAILS");
	    }
	
	if (driver.findElement(By.linkText("News & Advice")) != null ){
	      System.out.println( "News & Advice is present and STEP PASSES");
	    } else {
	    	System.out.println( "News & Advice is NOT present and STEP FAILS");
	    }
	if (driver.findElement(By.linkText("Reviews")) != null ){
	      System.out.println( "Reviews is present and STEP PASSES");
	    } else {
	    	System.out.println( "Reviews is NOT present and STEP FAILS");
	    }
	if (driver.findElement(By.linkText("Glossary")) != null ){
	      System.out.println( "Glossary is present and STEP PASSES");
	    } else {
	    	System.out.println( "Glossary is NOT present and STEP FAILS");
	    }
	if (driver.findElement(By.linkText("Calculators")) != null ){
	      System.out.println( "Calculators is present and STEP PASSES");
	    } else {
	    	System.out.println( "Calculators is NOT present and STEP FAILS");
	    }
	if (driver.findElement(By.linkText("CardMatch™")) != null ){
	      System.out.println( "CardMatch™ is present and STEP PASSES");
	    } else {
	    	System.out.println( "CardMatch™ is NOT present and STEP FAILS");
	    }	
	
}

//Test 3
@Test public void Test3() throws Exception {
	
	System.out.println("TEST 3 RESULTS: ");
	
	// Open creditcards.com
	driver.get("http://www.creditcards.com/");
	 
	// Maximize browser
	driver.manage().window().maximize();
	Thread.sleep(3000);
	
	//Create a string of the social media buttons titles for output
	String twitter = driver.findElement(By.xpath("/html/body/div[1]/footer/div[2]/div[2]/div[1]/div/a[1]")).getAttribute("title");
	String facebook = driver.findElement(By.xpath("/html/body/div[1]/footer/div[2]/div[2]/div[1]/div/a[2]")).getAttribute("title");
	String Instagram = driver.findElement(By.xpath("/html/body/div[1]/footer/div[2]/div[2]/div[1]/div/a[3]")).getAttribute("title");
	String Youtube = driver.findElement(By.xpath("/html/body/div[1]/footer/div[2]/div[2]/div[1]/div/a[4]")).getAttribute("title");
	//create a string of the social media buttons link to show upon output
	String twitterLink = driver.findElement(By.xpath("/html/body/div[1]/footer/div[2]/div[2]/div[1]/div/a[1]")).getAttribute("href");
	String facebookLink = driver.findElement(By.xpath("/html/body/div[1]/footer/div[2]/div[2]/div[1]/div/a[2]")).getAttribute("href");
	String instagramLink = driver.findElement(By.xpath("/html/body/div[1]/footer/div[2]/div[2]/div[1]/div/a[3]")).getAttribute("href");
	String youtubeLink = driver.findElement(By.xpath("/html/body/div[1]/footer/div[2]/div[2]/div[1]/div/a[4]")).getAttribute("href");
	
	//Test to confirm that the element is preset. If present output will show the title and URL in output
	try {
		assertTrue(isElementPresent(By.xpath("/html/body/div[1]/footer/div[2]/div[2]/div[1]/div/a[1]")));
		System.out.println(twitter+ " is present and link desintation is " + twitterLink + "STEP PASSES");
	} catch (Error e) {
		verificationErrors.append(e.toString());
		System.out.println("Twitter is NOT present and STEP FAILED");
	}
	try {
		assertTrue(isElementPresent(By.xpath("/html/body/div[1]/footer/div[2]/div[2]/div[1]/div/a[1]")));
		System.out.println(facebook+ " is present and link desintation is " + facebookLink + "STEP PASSES");
	} catch (Error e) {
		verificationErrors.append(e.toString());
		System.out.println("Facebook is NOT present and STEP FAILED");
	}
	try {
		assertTrue(isElementPresent(By.xpath("/html/body/div[1]/footer/div[2]/div[2]/div[1]/div/a[1]")));
		System.out.println(Instagram+ " is present and link desintation is " + instagramLink + "STEP PASSES");
	} catch (Error e) {
		verificationErrors.append(e.toString());
		System.out.println("Instagram is NOT present and STEP FAILED");
	}
	try {
		assertTrue(isElementPresent(By.xpath("/html/body/div[1]/footer/div[2]/div[2]/div[1]/div/a[1]")));
		System.out.println(Youtube+" is present and link desintation is " + youtubeLink + "STEP PASSES");
	} catch (Error e) {
		verificationErrors.append(e.toString());
		System.out.println("Youtube is NOT present and STEP FAILED");
	}
	

}

//Test 4
@Test public void Test4() throws Exception {
	
	System.out.println("TEST 4 RESULTS: ");
	
	// Open creditcards.com
	driver.get("http://www.creditcards.com/");
 
	// Maximize browser
	driver.manage().window().maximize();
	Thread.sleep(3000);

	//Find the elements

	try {
		assertEquals("", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Learn More'])[1]/following::button[1]")).getAttribute("value"));
		System.out.println("Choose what you earn element is present and STEP PASSED");
	} catch (Error e) {
		verificationErrors.append(e.toString());
		System.out.println("Choose what you earn element is NOT present and STEP FAILED");

	}
	

	try {
		assertTrue(isElementPresent(By.xpath("//*[@id=\"homepage-tab-panel-earn\"]/div[1]/button[1]")));
		System.out.println("Cash Back is present and STEP PASSES");
	} catch (Error e) {
		verificationErrors.append(e.toString());
		System.out.println("Cash Back is NOT present and STEP FAILED");
	}


	driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Points'])[1]/preceding::button[1]")).click();
  

	try {
		assertTrue(isElementPresent(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cash Back'])[3]/following::button[1]")));
		System.out.println("Points element is present and STEP PASSED");
	} catch (Error e) {
		verificationErrors.append(e.toString());
		System.out.println("Points is NOT present and STEP FAILED");
	}
  
	driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cash Back'])[3]/following::button[1]")).click();
  
	try {
		assertTrue(isElementPresent(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Points'])[1]/following::button[1]")));
		System.out.println("Miles is present and STEP PASSED");
	} catch (Error e) {
		verificationErrors.append(e.toString());
		System.out.println("Miles is NOT present and STEP FAILED");
	}
  
	driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Points'])[1]/following::button[1]")).click();
  
	Thread.sleep(3000);
  
	//second tab is selected 
	driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Learn More'])[1]/following::button[2]")).click();
  

	try {
		assertTrue(isElementPresent(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Learn more'])[9]/following::button[1]")));
		System.out.println("Choose what you save on is present and STEP PASSED");
	} catch (Error e) {
		verificationErrors.append(e.toString());
		System.out.println("Choose what you save on is NOT present and STEP FAILED");

	}
	driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Learn more'])[9]/following::button[1]")).click();
  

	try {
		assertTrue(isElementPresent(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Dining'])[1]/following::button[1]")));
		System.out.println("Dining is present and STEP PASSED");
	} catch (Error e) {
		verificationErrors.append(e.toString());
		System.out.println("Dining is NOT present and STEP FAILED");

	}
	driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Dining'])[1]/following::button[1]")).click();


	try {
		assertTrue(isElementPresent(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Travel'])[2]/following::button[1]")));
		System.out.println("Travel is present and STEP PASSED");
	} catch (Error e) {
		verificationErrors.append(e.toString());
		System.out.println("Travel is NOT present and STEP FAILED");

	}
	driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Travel'])[2]/following::button[1]")).click();
  

	try {
		assertTrue(isElementPresent(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Gas'])[2]/following::button[1]")));
		System.out.println("Gas is present and STEP PASSED");
	} catch (Error e) {
		verificationErrors.append(e.toString());
		System.out.println("Gas is NOT present and STEP FAILED");

	}
	driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Gas'])[2]/following::button[1]")).click();
	
  driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Business'])[2]/following::button[1]")).click();
  
	try {
		assertTrue(isElementPresent(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Business'])[2]/following::button[1]")));
		System.out.println(" Business is present and STEP PASSED");
	} catch (Error e) {
		verificationErrors.append(e.toString());
		System.out.println("Business is NOT present and STEP FAILED");

	}
	
	try {
		assertTrue(isElementPresent(By.xpath("//*[@id=\"homepage-tab-panel-save\"]/div[1]/button[5]")));
		System.out.println("Everyday Spending is present and STEP PASSED");
	} catch (Error e) {
		verificationErrors.append(e.toString());
		System.out.println("Everyday Spending is NOT present and  STEP FAILED");

	}

}


@After public void tearDown() throws Exception {
  driver.quit();
  String verificationErrorString = verificationErrors.toString();
  if (!"".equals(verificationErrorString)) {
    fail(verificationErrorString);
  }
  System.out.println(" ");
}

//action to check if element is present
private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

}

