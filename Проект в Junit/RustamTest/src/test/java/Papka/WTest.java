package Papka;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WTest extends WebDriverSettings {

    @Test
    public void wTest() throws InterruptedException {

        webDriver.findElement(By.cssSelector(("[placeholder=\"E-mail\"]"))).sendKeys("test_acc_ip@testemail.org");
        webDriver.findElement(By.cssSelector(("[placeholder=\"Пароль\"]"))).sendKeys("890890");
        webDriver.findElement(By.cssSelector(("[type=\"button\"]"))).click();
        Thread.sleep(5000);
        Assert.assertTrue(webDriver.getCurrentUrl().contains("Main?_companyId=9137852"));
        System.out.println("Check url");
    }

    @Test
    public void noText() throws InterruptedException {

        webDriver.findElement(By.cssSelector(("[type=\"button\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("style-m__errorMessage___2NB-z")));
        String error = webDriver.findElement(By.className("style-m__errorMessage___2NB-z")).getText();
        Assert.assertTrue(error.equals("Заполните все поля"));
    }

    @Test
    public void noPassword() throws InterruptedException {

        webDriver.findElement(By.cssSelector(("[placeholder=\"E-mail\"]"))).sendKeys("test_acc_ip@testemail.org");
        webDriver.findElement(By.cssSelector(("[type=\"button\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("style-m__errorMessage___2NB-z")));
        String error = webDriver.findElement(By.className("style-m__errorMessage___2NB-z")).getText();
        Assert.assertEquals(error, "Заполните все поля");
    }

    @Test
    public void noMail() throws InterruptedException {

        webDriver.findElement(By.cssSelector(("[placeholder=\"Пароль\"]"))).sendKeys("890890");
        webDriver.findElement(By.cssSelector(("[type=\"button\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("style-m__errorMessage___2NB-z")));
        String error = webDriver.findElement(By.className("style-m__errorMessage___2NB-z")).getText();
        Assert.assertEquals(error, "Заполните все поля");
    }

    @Test
    public void wrongPassword() throws InterruptedException {

        webDriver.findElement(By.cssSelector(("[placeholder=\"E-mail\"]"))).sendKeys("test_acc_ip@testemail.org");
        webDriver.findElement(By.cssSelector(("[placeholder=\"Пароль\"]"))).sendKeys("8908901");
        webDriver.findElement(By.cssSelector(("[type=\"button\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("style-m__errorMessage___2NB-z")));
        String error = webDriver.findElement(By.cssSelector("[class=\"style-m__errorMessage___2NB-z\"]")).getText();
        Assert.assertTrue(error.equals("Вы ввели неправильный пароль."));
    }

    @Test
    public void wrongMail() throws InterruptedException {

        webDriver.findElement(By.cssSelector(("[placeholder=\"E-mail\"]"))).sendKeys("1234567890@testemail.org");
        webDriver.findElement(By.cssSelector(("[placeholder=\"Пароль\"]"))).sendKeys("890890");
        webDriver.findElement(By.cssSelector(("[type=\"button\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("style-m__errorMessage___2NB-z")));
        String error = webDriver.findElement(By.className("style-m__errorMessage___2NB-z")).getText();
        Assert.assertTrue(error.equals("Пользователь не найден."));
    }
}