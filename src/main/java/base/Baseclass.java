package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public WebDriver driver;
	ExtentReports extent;

	@BeforeTest
	public void prerequisites() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

		ExtentKlovReporter klov = new ExtentKlovReporter("Smoke Test");
		extent = new ExtentReports();
		klov.initMongoDbConnection("localhost", 27017);
		klov.initKlovServerConnection("http://localhost:1100");
		klov.setProjectName("Login Test");
		
		extent.attachReporter(klov);

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		driver.manage().window().maximize();

		driver.get("https://www.google.com");

	}

	@AfterTest
	public void closing() {
		extent.flush();
		driver.close();
	}
}
