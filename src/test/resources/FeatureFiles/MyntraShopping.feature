Feature: Validation of Myntra shopping site

@Sanity
Scenario Outline: Search t-shirt sort by price Low to High
Given User enter into myntra shopping site
Then User searching <product> in search bar
And User applying filter to sort by high price
Then User verifies the product price in ascending order


Examples:
|product|
|tshirt|






