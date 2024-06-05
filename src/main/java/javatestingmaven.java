import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;

public class javatestingmaven {
    WebDriver wd;
    ExtentReports ext1; // class
    ExtentTest test;//interface

    @BeforeTest
    public void setup() {
        ExtentHtmlReporter testreport = new ExtentHtmlReporter("src//main//java/report.html"); // path
        ext1=new ExtentReports(); // object
        ext1.attachReporter(testreport);
        test = ext1.createTest("2 Browser Check", "Report on automation testing done on 2 browsers(Chrome and Firefox) in a test suite using TestNG");
    }

    Steps steps = new Steps();

//    javatesting2 jt2 = new javatesting2();
//
//    @Test(priority = 2)
//    public void callanother(){
//        if(jt2.nthtest()==Status.PASS)
//            test.log(Status.PASS,"Java Testing 2 Passed");
//        else
//            test.log(Status.FAIL,"Java Testing 2 Failed");
//    }

    @Test(priority = 1)
    public void testWithChrome(){
        wd = new ChromeDriver();
        steps.initDriver(wd);
        try{
            steps.triggerSteps();
            File src = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
            Files.copy(src, new File("src//test//screenshot1.png"));
            test.log(Status.PASS, "Chrome Testing Passed");
            wd.close();
        }
        catch (Exception e) {
            test.log(Status.ERROR, e+" Chrome Testing Failed");
        }
    }

    @Test(priority = 3)
    public void testWithFirefox(){
        wd = new FirefoxDriver();
        steps.initDriver(wd);
        try{
            steps.triggerSteps();
            File src = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
            Files.copy(src, new File("src//test//screenshot2.png"));
            test.log(Status.PASS, "Firefox Testing Passed");
            wd.close();
        }
        catch (Exception e) {
            test.log(Status.ERROR, e+" Firefox Testing Failed");
        }
    }

    @AfterTest
    public void teardown() {
        ext1.close();
        ext1.flush();
    }
}
