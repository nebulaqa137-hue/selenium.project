package selenium.project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestingSelenium {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        
         //New driver        
        // MANAGE
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // ABRIR PAGINA DE PRUEBA
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        // VALIDAR URL
        String currentUrl = driver.getCurrentUrl();
        if (!currentUrl.contains("web-form")) {
            System.out.println("URL incorrecta");
            driver.quit();
            return;
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // TEXT INPUT
        WebElement textInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("my-text")));
        textInput.sendKeys("Jonathan QA Automation");

        // PASSWORD
        driver.findElement(By.name("my-password")).sendKeys("123456");

        // TEXTAREA
        driver.findElement(By.name("my-textarea")).sendKeys("Prueba Selenium CDMX");

        // DROPDOWN
        Select select = new Select(driver.findElement(By.name("my-select")));
        select.selectByVisibleText("Two");

        // CHECKBOX
        WebElement checkbox = driver.findElement(By.id("my-check-1"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        // RADIO BUTTON
        driver.findElement(By.id("my-radio-1")).click();

        // TIMER CONTROLADO
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // SUBMIT
        driver.findElement(By.cssSelector("button")).click();

        // WAIT RESULTADO
        wait.until(ExpectedConditions.urlContains("submitted-form"));

        // VALIDAR URL FINAL
        String finalUrl = driver.getCurrentUrl();
        System.out.println("URL final: " + finalUrl);

        if (finalUrl.contains("submitted-form")) {
            System.out.println("TEST PASÓ ✅");
        } else {
            System.out.println("TEST FALLÓ ❌");
        }
        
        try {
            Thread.sleep(60000); // espera 60 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}