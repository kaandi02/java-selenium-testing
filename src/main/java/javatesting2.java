import com.aventstack.extentreports.Status;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class javatesting2 {

    @Test
    public Status nthtest(){
        try{
            ChromeDriver wd;
            wd = new ChromeDriver();
            wd.get("www.google.com");
            wd.close();
            return Status.PASS;
        }
        catch (Exception e){
            return Status.FAIL;
        }
    }
}
