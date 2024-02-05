package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
public class CreateProductFunctionalTest {
    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setUpTest(){
        baseUrl=String.format("%s:%d",testBaseUrl, serverPort);
    }

    @Test
    void testButtonFromHomeToListProduct (ChromeDriver driver) throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.className("btn")).click();

        String titleProdukList = driver.findElement(By.tagName("h2")).getText();

        assertEquals("Product' List", titleProdukList);
    }

    @Test
    void testCreatePageIsWorking (ChromeDriver driver) throws Exception {
        driver.get(baseUrl+"/product/create");
        String titleCreateProduct = driver.findElement(By.tagName("h3")).getText();

        assertEquals("Create New Product", titleCreateProduct);
    }

    @Test
    void testCreateProductSubmit (ChromeDriver driver) throws Exception {
        String name = "Product 1";
        Integer quantity = 10;

        driver.get(baseUrl+"/product/create");
        driver.findElement(By.id("nameInput")).sendKeys(name);
        driver.findElement(By.id("quantityInput")).sendKeys(String.valueOf(quantity));
        driver.findElement(By.className("btn")).click();

        String titleProductList = driver.findElement(By.tagName("h2")).getText();

        assertEquals("Product' List", titleProductList);

        List<WebElement> tableProduct =  driver.findElements(By.tagName("td"));
        WebElement buttonDelete = tableProduct.get(4);
        buttonDelete.click();
    }

    @Test
    void testProductIsInList (ChromeDriver driver) throws Exception {
        String name = "Product 12";
        Integer quantity = 100;

        driver.get(baseUrl+"/product/create");
        driver.findElement(By.id("nameInput")).sendKeys(name);
        driver.findElement(By.id("quantityInput")).sendKeys(String.valueOf(quantity));
        driver.findElement(By.className("btn")).click();

        List<WebElement> tableProduct =  driver.findElements(By.tagName("td"));

        WebElement productName = tableProduct.getFirst();
        String productNameString = productName.getText();

        WebElement elementProductQuantity = tableProduct.get(1);
        String quantityProduct = elementProductQuantity.getText();

        assertEquals(name,productNameString);
        assertEquals(String.valueOf(quantity),quantityProduct);
    }
}