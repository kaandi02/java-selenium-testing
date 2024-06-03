import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaTestingMaven {
    WebDriver wd;
    ExtentReports ext1; // class
    ExtentTest test;//interface

    @BeforeTest
    public void setup() {
        ExtentHtmlReporter testreport = new ExtentHtmlReporter("src//main//java/report.html"); // path
        ext1=new ExtentReports(); // object
        ext1.attachReporter(testreport);
        test = ext1.createTest("user.dir", "test");
    }

    Steps steps = new Steps();

    @Test
    public void testWithChrome(){
        wd = new ChromeDriver();
        steps.initDriver(wd);
        try{
            steps.triggerSteps();
            test.log(Status.PASS, "Chrome Testing Passed");
        }
        catch (Exception e) {
            test.log(Status.ERROR, e+" Chrome Testing Failed");
        }
    }

    @Test
    public void testWithFirefox(){
        wd = new FirefoxDriver();
        steps.initDriver(wd);
        try{
            steps.triggerSteps();
            test.log(Status.PASS, "Firefox Testing Passed");
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
