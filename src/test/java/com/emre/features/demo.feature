Feature: Demo Feature


  Scenario: 101001 Scenario Success Log in
    * startApplication
    * Wait 5 seconds
    * click "continueWithoutRegister"
    * click "searchTextView"
    * Find element by "searchTextView2" and send keys "Laptop"
    * clicked enter
    * click "filter"
    * click "Bilgisayar"
    * click "applyFilterTextView"
    * click "sortText"
    * click "HighestPrice"
    * Swipe down
    * Swipe down
    * Swipe down
    * click "TenthProduct"
    * click "detailBtnTextView"
    * "GoToSeller" verify if element exists
