package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage {
    WebDriver driver;

    By productNames = By.className("inventory_item_name");
    By productPrices = By.className("inventory_item_price");
    By productImages = By.className("inventory_item_img");
    By productDescriptions = By.className("inventory_item_desc");
    By addToCartButtons = By.className("btn_inventory");
    By filterDropdown = By.className("product_sort_container");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getProductNames() {
        return driver.findElements(productNames);
    }

    public List<WebElement> getProductPrices() {
        return driver.findElements(productPrices);
    }

    public List<WebElement> getProductImages() {
        return driver.findElements(productImages);
    }

    public List<WebElement> getProductDescriptions() {
        return driver.findElements(productDescriptions);
    }

    public List<WebElement> getAddToCartButtons() {
        return driver.findElements(addToCartButtons);
    }

    public void selectFilter(String filterOption) {
        Select dropdown = new Select(driver.findElement(filterDropdown));
        dropdown.selectByVisibleText(filterOption);
    }
}
