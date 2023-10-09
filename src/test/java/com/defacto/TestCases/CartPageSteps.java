package com.defacto.TestCases;

import com.defacto.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class CartPageSteps extends BaseTest {
    private HomePage homePage;
    private ProductPage productPage;
    private BasketCard basketCard;
    private CartPage cartPage;
    private MainCategoryPage mainCategoryPage;
    private SubCategoryPage subCategoryPage;

    @Given("Start Driver and Browser")
    public void start_driver_and_browser(){
        setUp();
    }

    @When("Navigate to DeFacto")
    public void navigate_to_webpage(){
        navigateToHome();
    }

    @Then("Verify to Home Page")
    public void verify_homepage(){
        homePage = new HomePage(driver);
        assertTrue(homePage.isOnHomePage());
    }

    @When("Click on the Woman Category")
    public void go_to_woman_category(){
        homePage.clickWomanCategory();
    }

    @And("Mouseover the Clothes Menu")
    public void mouseover_clothes_menu(){
        mainCategoryPage = new MainCategoryPage(driver);
        mainCategoryPage.mouseoverClothesMenu();
    }

    @Then("Verify to Subcategories Appear")
    public void verify_subcategories_appear(){
        assertTrue(mainCategoryPage.isAppearSubcategories());
    }

    @When("Click on the Jacket Category")
    public void click_jacket_category(){
        mainCategoryPage.clickSubCategory();
    }

    @And("Select the Small Size")
    public void select_small_size(){
        subCategoryPage = new SubCategoryPage(driver);
        subCategoryPage.selectSmallSize();
    }

    @And("Select the Product")
    public void select_product() throws InterruptedException {
        subCategoryPage.selectProduct();
    }

    @Then("Verify to Product Page")
    public void verify_product_page(){
        productPage = new ProductPage(driver);
        assertTrue(productPage.isOnProductPage());
    }

    @When("Select the Size")
    public void select_random_size(){
        productPage.selectRandomSize();
    }

    @And("Click on the Add to Basket Button")
    public void add_product_to_basket(){
        productPage.addProductToBasket();
    }

    @Then("Verify to Number of Product on Basket")
    public void verify_number_of_product_on_basket() throws InterruptedException {
        basketCard = new BasketCard(driver);
        assertTrue(basketCard.isProductOnBasket());
    }

    @When("Click on the Basket Summary")
    public void click_cart_summary(){
        basketCard.clickBasketSummary();
    }

    @And("Click on the Go to Cart Page Button")
    public void go_to_cartpage(){
        basketCard.goToCartpage();
    }

    @Then("Verify to Cart Page")
    public void verify_to_cartpage(){
        cartPage = new CartPage(driver);
        assertTrue(cartPage.isOnCartPage());
    }

    @When("Delete to Product from Cart")
    public void delete_product_from_cart(){
        cartPage.deleteProduct();
    }

    @Then("Verify to Empty Cart Page")
    public void verify_empty_cartpage(){
        assertTrue(cartPage.isCartEmpty());
        tearDown();
    }
}
