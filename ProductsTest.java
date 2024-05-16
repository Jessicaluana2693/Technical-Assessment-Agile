package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class ProductsTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test
    @Parameters({"username", "password"})
    public void testProductDisplay(String username, String password) {
        loginPage.login(username, password);
        
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("inventory.html"));

        List<String> productNames = productsPage.getProductNames().stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> productPrices = productsPage.getProductPrices().stream().map(WebElement::getText).collect(Collectors.toList());
        List<WebElement> productImages = productsPage.getProductImages();
        List<String> productDescriptions = productsPage.getProductDescriptions().stream().map(WebElement::getText).collect(Collectors.toList());
        List<WebElement> addToCartButtons = productsPage.getAddToCartButtons();

        assertTrue(productNames.size() > 0, "Products are displayed correctly");
        assertTrue(productPrices.size() > 0, "Product prices are displayed correctly");
        assertTrue(productImages.size() > 0, "Product images are displayed correctly");
        assertTrue(productDescriptions.size() > 0, "Product descriptions are displayed correctly");
        assertTrue(addToCartButtons.size() > 0, "Add to cart buttons are displayed correctly");
    }

    @Test
    @Parameters({"username", "password"})
    public void testFilterFunctionality(String username, String password) {
        loginPage.login(username, password);
        
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("inventory.html"));

        productsPage.selectFilter("Name (A to Z)");
        List<String> productNames = productsPage.getProductNames().stream().map(WebElement::getText).collect(Collectors.toList());

        List<String> sortedNames = productNames.stream().sorted().collect(Collectors.toList());
        assertTrue(productNames.equals(sortedNames), "Products are sorted in alphabetical order");
    }

    @Test
    @Parameters({"username", "password"})
    public void testAddToCart(String username, String password) {
        loginPage.login(username, password);
        
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("inventory.html"));

        List<WebElement> addToCartButtons = productsPage.getAddToCartButtons();
        addToCartButtons.get(0).click();

        String cartBadgeNumber = new CartPage(driver).getCartBadgeNumber();
        assertTrue(cartBadgeNumber.equals("1"), "Product is added to the cart");
    }

    @Test
    @Parameters({"username", "password"})
    public void testSortByPrice(String username, String password) {
        loginPage.login(username, password);
        
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("inventory.html"));

        productsPage.selectFilter("Price (low to high)");
        List<Double> productPrices = productsPage.getProductPrices().stream().map(e -> Double.parseDouble(e.getText().replace("$", ""))).collect(Collectors.toList());

        List<Double> sortedPrices = productPrices.stream().sorted().collect(Collectors.toList());
        assertTrue(productPrices.equals(sortedPrices), "Products are sorted by price (low to high)");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
