package org.example;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.WebElement;

public class ProductTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        // Step 1: Open Website

        driver.get("https://www.saucedemo.com/");

        driver.manage().window().maximize();

        // Step 2: Login

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        // Step 3: Verify Product Page Loaded

        String currentURL = driver.getCurrentUrl();

        if(currentURL.contains("inventory")) {

            System.out.println("Login Successful - Product Page Loaded");

        } else {

            System.out.println("Login Failed");

        }

        // Step 4: Get List of Products

        List<WebElement> products = driver.findElements(By.className("inventory_item"));

        System.out.println("Total Products: " + products.size());

        // Step 5: Click First Product

        driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).click();

        Thread.sleep(2000);

        // Step 6: Add to Cart

        driver.findElement(By.id("add-to-cart")).click();

        System.out.println("Product Added to Cart");

        Thread.sleep(2000);

        driver.quit();

    }

}
