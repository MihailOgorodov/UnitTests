package seminars.five;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;



public class SeleniumTest {
    WebDriver webDriver;

    @BeforeEach
    void setUp(){
        webDriver = new ChromeDriver();
    }

    @Test
    public void checkSeleniumPath() {
        webDriver.get("http://www.google.com/");
        WebElement searchBox = webDriver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();

        WebElement seleniumPath = webDriver
                .findElement(By
                        .xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/div/div/div/cite"));

        assertThat(seleniumPath).isNotNull();

        webDriver.quit();
    }

    @Test
    public void testSaucedemoDotCom() throws InterruptedException {
        webDriver.get("https://www.saucedemo.com/");
        WebElement searchUser = webDriver.findElement(By.name("user-name"));
        searchUser.sendKeys("standard_user");
        WebElement searchPswd = webDriver.findElement(By.name("password"));
        searchPswd.sendKeys("secret_sauce");
        WebElement searchLoginBtn = webDriver.findElement(By.name("login-button"));
        searchLoginBtn.click();
        WebElement productPath = webDriver.findElement(By.className("title"));

        assertThat(productPath).isNotNull();
        assertThat(productPath.getText()).isEqualTo("Products");
        Thread.sleep(5000); // пауза 5 сек
        webDriver.quit();
    }



}
