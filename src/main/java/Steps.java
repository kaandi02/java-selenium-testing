import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Steps {

    WebDriver wd;
    private static ExtentReports ext1;
    private static ExtentTest test;

    public void initDriver(WebDriver wd){
        this.wd = wd;
        this.wd.manage().window().maximize();
    }

    public void triggerSteps(String url){
        try{
            wd.get(url);
            String title = wd.getTitle();
            System.out.println(title);
            wd.close();
            reportEntry(Status.PASS, "Testing Passed");
        }
        catch (Exception e){
            reportEntry(Status.ERROR, e+" \n\nTesting Failed");
        }

    }

    public void reportEntry(Status status,String message){
        if(ext1 == null) {
            ext1 = new ExtentReports();
            ExtentHtmlReporter testreport = new ExtentHtmlReporter("src//main//java/report.html"); // path
            ext1=new ExtentReports(); // object
            ext1.attachReporter(testreport);
            test = ext1.createTest("Test Suite Check", "Report on automation testing done for multiple classes in a test suite using TestNG");
        }
        test.log(status,message);
    }

    public void flush(){
        ext1.close();
        ext1.flush();
    }

}
