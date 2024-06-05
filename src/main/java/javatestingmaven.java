import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class javatestingmaven {
    WebDriver wd;

    Steps steps = new Steps();

    @Test
    public void testWithChrome(){
        wd = new ChromeDriver();
        steps.initDriver(wd);
        steps.triggerSteps("https://www.flipkart.com");
//      File src = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
//      Files.copy(src, new File("src//test//screenshot1.png"));
    }

    @Test
    public void testWithFirefox(){
        wd = new FirefoxDriver();
        steps.initDriver(wd);
        steps.triggerSteps("https://www.amazon.in");
    }
}
