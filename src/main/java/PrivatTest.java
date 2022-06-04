import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PrivatTest {

    @Test
    public void checkMinPaymentSum (){

        // 1. Мы добавили системную переменную для драйвера - для создания образа браузера
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        // 2. Создаем объект driver и добавляем свойства от ChromeDriver
        WebDriver driver = new ChromeDriver();
        // Создание ожидание элемента перед тем, как над ним воздействовать
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        // Непосредственно логика теста
        // 1. Перейти на страницу
        driver.get("https://next.privat24.ua/money-transfer/card");
        driver.manage().window().maximize();

        // 2. Описать элемент интерфейса

        By cardNumber1 = By.xpath("//input[@data-qa-node='numberdebitSource']");
        By expData = By.xpath("//input[@data-qa-node='expiredebitSource']");
        By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
        By firstName = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
        By lastName = By.xpath("//input[@data-qa-node='lastNamedebitSource']");
        By cardNumber2 = By.xpath("//input[@data-qa-node='numberreceiver']");
        By firstName2 = By.xpath("//input[@data-qa-node='firstNamereceiver']");
        By lastName2 = By.xpath("//input[@data-qa-node='lastNamereceiver']");
        By amount = By.xpath("//input[@data-qa-node='amount']");
        By currencyUAH = By.xpath("//button[@data-qa-value='UAH']");
        By currencyUSD = By.xpath("//button[@data-qa-value='USD']");
        By submitBtn1 = By.xpath("//span[@data-qa-node='toggle-comment']");
        By comment = By.xpath("//textarea[@data-qa-node='comment']");
        By submitBtn = By.xpath("//*[@id='app']/div[2]/section/div/div[1]/div[2]/div[1]/form/div[6]/div/button");

        // 3. Действия над элементами интерфейса


        driver.findElement(cardNumber1).sendKeys("4567739561253907");
        driver.findElement(expData).sendKeys("0924");
        driver.findElement(cvv).sendKeys("528");
        driver.findElement(firstName).sendKeys("Gloria");
        driver.findElement(lastName).sendKeys("Hayakawa");
        driver.findElement(cardNumber2).sendKeys("4552331448138217");
        driver.findElement(firstName2).sendKeys("Federico");
        driver.findElement(lastName2).sendKeys("Stojan");
        driver.findElement(amount).sendKeys("10");
        driver.findElement(currencyUAH).click();
        driver.findElement(currencyUSD).click();
        driver.findElement(submitBtn1).click();
        driver.findElement(comment).sendKeys("Test Privat");
        driver.findElement(submitBtn).click();

       // By linkTerms = By.xpath("//a[@href='https://privatbank.ua/terms']");

        // driver.findElement(linkTerms).click();
        //driver.switchTo().window(String.valueOf(driver.getWindowHandles().toArray()[1]))
        wait.until(ExpectedConditions.textToBePresentInElementLocated
                (By.xpath("//*[@id='app']/div[2]/section/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div"),
                        "Переказ між своїми рахунками, з/на картку VISA/MasterCard інших українських та закордонних банків."));

        // Assert.assertEquals("Переказ між своїми рахунками, з/на картку VISA/MasterCard інших українських та закордонних банків.",
                // driver.findElement(By.xpath("//*[@id='app']/div[2]/section/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/div")).getText());

        Assert.assertEquals("4567 7395 6125 3907", driver.findElement(By.xpath("//span[@data-qa-node='payer-card']")).getText());
        Assert.assertEquals("4552 3314 4813 8217", driver.findElement(By.xpath("//span[@data-qa-node='receiver-card']")).getText());
        Assert.assertEquals("10 USD", driver.findElement(By.xpath("//div[@data-qa-node='payer-amount']")).getText());
        Assert.assertEquals("FEDERICO STOJAN", driver.findElement(By.xpath("//div[@data-qa-node='receiver-name']")).getText());

        //driver.close();

        /**
         * Команды Selenium:
         * 1. get() - переход на URL
         * 2. to () - переход на URL
         * 3. sendKeys() - ввод текста
         * 4. click() - нажатие на элемент
         * 5. submit() - подтверждение формы
         * 6. findElement() - поиск элемента по определенной стратегии
         * 7. close() - закрыть окно браузера и если оно последнее, то и сам браузер
         * 8. quick() - закрыть драйвер и браузер
         * 9. implicitlyWait() - явновое ожидание элемента определенное время
         * 10. manage.fullscreen - полноэкранный режим
         * 11. manage.maximize - полный размер экрана
         */

    }

}
