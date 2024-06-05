import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class javatesting2 {

    WebDriver wd;
    Steps step = new Steps();

    @Test
    public void nthTest(){
        wd = new FirefoxDriver();
        step.initDriver(wd);
        step.triggerSteps("HTTPS://www.google.com");
        step.flush();
    }
}
