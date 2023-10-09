Feature: DeFacto UI Test
  Scenario: Add and Remove Product to Basket

    Given Start Driver and Browser
    When Navigate to DeFacto
    Then Verify to Home Page

    When Click on the Woman Category
    And Mouseover the Clothes Menu
    Then Verify to Subcategories Appear

    When Click on the Jacket Category
    And Select the Small Size
    And Select the Product
    Then Verify to Product Page

    When Select the Size
    And Click on the Add to Basket Button
    Then Verify to Number of Product on Basket

    When Click on the Basket Summary
    And Click on the Go to Cart Page Button
    Then Verify to Cart Page

    When Delete to Product from Cart
    Then Verify to Empty Cart Page