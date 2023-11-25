package com.defacto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubCategoryPage extends BasePage{
    public SubCategoryPage(WebDriver driver) {
        super(driver);
    }

    private final By moreSizeButtonLocator = By.xpath("/html/body/main/div/div[6]/div/div[1]/div/div/div/ul/li[2]/ul/li[2]/button[1]");
    private final By smallSizeSelectLocator = By.xpath("//li[@data-textfilter='S']");
    private final By productLocator = By.xpath("//div[@id='product-fill']/*//div[@data-index='0']");

    public void selectSmallSize() {
        scrollDown();
        clickElement(moreSizeButtonLocator);
        clickElement(smallSizeSelectLocator);
    }
    public void selectProduct() throws InterruptedException {

        try {
            Thread.sleep(2000);
            clickElement(productLocator);
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            Thread.sleep(2000);
            clickElement(productLocator);
        }
    }
}
