package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C09_KeybordActions extends TestBaseEach {

    @Test
    public void test01(){

        //1- https://www.testotomasyonu.com sayfasina gidelim
        driver.get("https://www.testotomasyonu.com ");

        //2- Arama kutusuna actions method’larini kullanarak “DELL Core I3” yazdirin
        //   ve Enter’a basarak arama yaptirin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        actions.click(aramaKutusu)
                .keyDown(Keys.SHIFT)
                .sendKeys("dell c")
                .keyUp(Keys.SHIFT)
                .sendKeys("ore ")
                .keyDown(Keys.SHIFT)
                .sendKeys("i")
                .keyUp(Keys.SHIFT)
                .sendKeys("3")
                .sendKeys(Keys.ENTER).perform();
        ReusableMethods.bekle(10);


        //3- Bulunan urun isminde “DELL Core I3” bulundugunu test edin
        actions.sendKeys(Keys.PAGE_DOWN).perform();

       String expectedisim ="DELL Core I3";

        WebElement UrunIsim =driver.findElement(By.xpath("//*[@class='prod-title mb-3 ']"));

        String actualIsim = UrunIsim.getText();

        Assertions.assertTrue(actualIsim.contains(expectedisim));

    }
}
