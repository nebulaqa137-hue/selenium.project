package selenium.project.functions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.io.IOException;

public class WebDriverFactory {

    private static Logger log = LogManager.getLogger(WebDriverFactory.class);

    public static WebDriver createNewWebDriver(String browser, String os) throws IOException {
        WebDriver driver;

        if ("FIREFOX".equalsIgnoreCase(browser)) {
            driver = new FirefoxDriver();

        } else if ("CHROME".equalsIgnoreCase(browser)) {
            driver = new ChromeDriver();

        } else if ("INTERNET EXPLORER".equalsIgnoreCase(browser)) {
            driver = new InternetExplorerDriver();

        } else {
            log.error("The Driver is not selected properly, invalid name: " + browser + ", " + os);
            return null;
        }

        driver.manage().window().maximize();
        return driver;
    }
}