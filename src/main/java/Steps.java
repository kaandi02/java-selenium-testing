import org.openqa.selenium.WebDriver;

public class Steps {

    WebDriver wd;

    public void initDriver(WebDriver wd){
        this.wd = wd;
    }

    public void triggerSteps(){
        wd.get("https://www.flipkart.com");
        String title = wd.getTitle();
        System.out.println(title);
    }

}
