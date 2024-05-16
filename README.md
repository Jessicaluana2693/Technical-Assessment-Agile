# SauceDemo Automation Project

This project automates the testing of the SauceDemo website using Selenium and TestNG with the Page Object Model (POM) pattern. 
It includes tests for product display, filter functionality, adding products to the cart, and sorting products by price.
This repository is a technical assessment for QA job.


## Project Structure
src/test/java
|-- pages

| |-- LoginPage.java

| |-- ProductsPage.java

| -- CartPage.java |-- tests | |-- LoginTest.java | -- ProductsTest.java

|-- resources

| `-- testng.xml


## Prerequisites

- Java JDK 8 or higher
- Maven
- ChromeDriver
- An IDE with TestNG support (e.g., IntelliJ IDEA, Eclipse)

## Setup

1. Clone the repository:

   ```sh
   git clone https://github.com/your-username/saucedemo-automation.git
   cd saucedemo-automation
   
2. Install dependencies using Maven:
mvn clean install

3. Download the ChromeDriver and place it in a directory of your choice. Update the path to ChromeDriver in the setUp method of your test classes.

## Project Modules

### Page Objects
- LoginPage.java: Handles interactions with the login page.
- ProductsPage.java: Handles interactions with the products page.
- CartPage.java: Handles interactions with the cart page.
- Test Classes
- LoginTest.java: Tests the login functionality.
- ProductsTest.java: Tests the product display, filter functionality, adding products to the cart, and sorting by price.

- Test Suite
- testng.xml: Defines the TestNG suite and parameters for different user types.

Running the Tests
Open the project in your IDE.
Right-click on testng.xml and select "Run As > TestNG Suite".

## Test Scenarios

 ### Product Display Test
  Verifies that products are displayed correctly with name, image, price, description, and an "Add to Cart" button.
### Filter Functionality Test
  Verifies that product filters work correctly in alphabetical order of names.
### Add to Cart Test
  Verifies that the user can add a product to the cart.
### Sorting by Price Test
  Verifies sorting by price (from lowest to highest and highest to lowest) and checks the order of displayed products.

## Users Tested

'standard_user'

'problem_user'

'performance_glitch_user'

## Notes

Ensure you have the correct path for the ChromeDriver in your setUp method.
Adjust the locators in your page classes if necessary.

## Dependencies
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.0.0</version>
    </dependency>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.4.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>

## License

This project is licensed under the MIT License.


This `README.md` file provides a comprehensive overview of the project, setup instructions, and details on how to run the tests. Feel free to modify it to fit your specific needs and preferences
