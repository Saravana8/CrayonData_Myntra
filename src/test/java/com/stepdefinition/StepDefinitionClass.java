package com.stepdefinition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.pagefactory.pages.ShoppingPage;
import com.utills.ReusableMethods;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefinitionClass extends ReusableMethods {

	ShoppingPage spage;

	@After
	public void screenshot(Scenario scenario) throws Throwable {
		Screenshot_OnFail(scenario);
		driver.quit();
	}

	@Given("^User enter into myntra shopping site$")
	public void user_enter_into_myntra_shopping_site() throws Throwable {
		lunchBrowser("https://www.myntra.com/");
	}

	@Then("^User searching (.+) in search bar$")
	public void user_searching_in_search_bar(String product) throws Throwable {
		spage = new ShoppingPage();
		spage.searchProduct(product);
		waitFor(3);
		spage.clkSearch();

	}

	@And("^User applying filter to sort by high price$")
	public void user_applying_filter_to_sort_by_high_price() throws Throwable {
		spage = new ShoppingPage();
		spage.sort();
		spage.lowtohigh();
	}

	@Then("^User verifies the product price in ascending order$")
	public void user_verifies_the_product_price_in_ascending_order() throws Throwable {
		spage = new ShoppingPage();
		waitFor(5);

		// after low to high filter
		List<WebElement> afterflt = driver.findElements(By.xpath("//span[@class='product-discountedPrice']"));
		List<Double> afterfltli = new ArrayList<>();

		for (WebElement p : afterflt) {
			afterfltli.add(Double.valueOf(p.getText().replace("Rs.", "")));
		}

		spage.sort();
		waitFor(3);
		spage.hightolow();
		waitFor(5);
       // high to low filter
		List<WebElement> withoutlowtohighflt = driver
				.findElements(By.xpath("//span[@class='product-discountedPrice']"));
		List<Double> withoutlowtohighfltli = new ArrayList<>();

		for (WebElement b : withoutlowtohighflt) {
			withoutlowtohighfltli.add(Double.valueOf(b.getText().replace("Rs.", "")));
		}

       //validation
		SoftAssert softasssert = new SoftAssert();
		Collections.sort(withoutlowtohighfltli);
		softasssert.assertEquals(withoutlowtohighfltli, afterfltli);

	}
}
