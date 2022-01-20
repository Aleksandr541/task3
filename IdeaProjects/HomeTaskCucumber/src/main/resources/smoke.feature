Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check the number of products on the page
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User enters '<keyword>' in search field
    When User clicks on 'Search' button
    Then User checks '<number>' products on the page
    Examples:
      | homePage              | keyword | number |
      | https://www.asos.com/ | dress   | 72     |

  Scenario Outline: Check button load more
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User enters '<keyword>' in search field
    When User clicks on 'Search' button
    And User checks 'Lod More' button visibility
    And User clicks on 'Show more' button
    Then User checks how many products are '<numberProducts>' on the page
    Examples:
      | homePage              | keyword | numberProducts |
      | https://www.asos.com/ | dress   | 144            |

  Scenario Outline: Check add product to cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User enters '<keyword>' in search field
    When User clicks on 'Search' button
    And User clicks for the selected product
    And User choice size product
    And User clicks button 'Add to Bag'
    And User clicks button 'Bag'
    And User clicks 'View Bag' button
    Then User checks the '<number>' of items in the cart
    Examples:
      | homePage              | keyword | number |
      | https://www.asos.com/ | dress   | 1      |

  Scenario Outline: Check validation of registration form with Incorrect data
    Given User opens '<homePage>' page
    And User clicks Register button
    And User click on the Join button
    And User enters Invalid '<email>' into Email field of registration
    And User enters Invalid '<firstName>' into First name field of registration
    And User enters Invalid '<lastName>' into Last name field of registration
    When User enters Invalid '<password>' into Password field of registration
    Then User checks an '<error>'
    Examples:
      | homePage              | email | firstName | lastName | password | error                                                 |
      | https://www.asos.com/ | Alex  | Alex      | Alex     | 12345    | Email fail! Please type in your correct email address |
      | https://www.asos.com/ |       | Alex      | Alex     | 12345    | Oops! You need to type your email here                |

  Scenario Outline: Check url Marketplace page
    Given User opens '<homePage>' page
    And User clicks on Marketplace button
    And User checks  '<text>' on the marketplace page
    Then User checks the '<url>' on the marketplace page
    Examples:
      | homePage              | url                                               | text             |
      | https://www.asos.com/ | https://marketplace.asos.com/?ctaref=Global%20nav | ASOS marketplace |

  Scenario Outline: Check correct work of sort by price on marketplace
    Given User opens '<homePage>' page
    And User clicks on Marketplace button
    And User moves cursor on clothing
    And User chooses category of knitwear
    And User clicks on menu of sort on marketplace
    And User chooses sort by FromHighToLow on marketplace
    And User checks that sort updated on marketplace
    Then User checks that products are sorted by '<type of sort>' on marketplace
    Examples:
      | homePage              | type of sort  |
      | https://www.asos.com/ | FromHighToLow |

  Scenario Outline: Check Man Sale Carousel
    Given User opens '<homePage>' page
    And User clicks on Man button
    And User checks that Men's Sale Carousel is visible
    And User clicks on Carousel scroll forward button
    And User checks that Carousel where scrolled forward
    When User clicks on Carousel scroll back button
    And User checks that Carousel where scrolled back
    Then User checks '<amount>' elements in Carousel
    Examples:
      | homePage              | amount |
      | https://www.asos.com/ | 7      |

  Scenario Outline: Check delete product from cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User enters '<keyword>' in search field
    When User clicks on 'Search' button
    And User clicks for the selected product
    And User choice size product
    And User clicks button 'Add to Bag'
    And User clicks button 'Bag'
    And User clicks 'View Bag' button
    And User checks that Bag visibility
    And User removes product from the cart
    Then User checks that the cart is '<empty>'
    Examples:
      | homePage              | keyword | empty             |
      | https://www.asos.com/ | dress   | Your bag is empty |

  Scenario Outline: Check correct working filter
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User enters '<keyword>' in search field
    When User clicks on 'Search' button
    When User checks field filter's Brand visibility
    And User clicks Brand filter field
    When User checks button Asos visibility
    And User clicks Asos button
    Then The user checks all products '<Brand>' Asos
    Examples:
      | homePage              | keyword | Brand     |
      | https://www.asos.com/ | dress   | ASOS 4505 |

  Scenario Outline: Check the login feature by entering an unregistered email address and password.
    Given User opens '<homePage>' page
    And User clicks Register button
    And User clicks Sign In link
    And User enters '<email>' into email field
    And User enters '<password>' into password field
    And User clicks Sign In submitting button
    Then User checks that the registration page contains the address '<text>' or the wrong password
    Examples:
      | homePage              | email | password | text                                                  |
      | https://www.asos.com/ | Alex  | Alex     | Email fail! Please type in your correct email address |