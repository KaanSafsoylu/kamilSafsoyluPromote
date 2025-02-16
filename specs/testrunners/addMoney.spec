CatchyLabs Money Add Operations
=====================

TC008 - Adding Money With Correct Card Details
--------------------------------------------
Tags:TC008-addingMoneyWithCorrectCardDetails
* Go To CatchyLabs URL Address
* Verify That The Homepage Elements Opens Correctly
* Login To Account With "KamilSafsoylu" Username And "k33lwb7979" Password
* Check That The User Has Successfully Logged In
* Go To My Account Screen
* Go to the Add Money Screen
* Check That The Add Money Screen Opens Correctly
* Enter "1234123412341234" as Card Number
* Enter "testacc" as Card Holder Name
* Enter "1026" as Expiry Date
* Enter "110" as Cvv Number
* Enter "10" In The Amount Of Money To Send
* Click To The Add Button
* Check That The Last Transaction Is Containing Added Amount


TC009 - Fill Add Money Inputs With Short Card Number
--------------------------------------------
Tags:TC009-fillAdMoneyInputsWithShortCardNumber
* Go To CatchyLabs URL Address
* Verify That The Homepage Elements Opens Correctly
* Login To Account With "KamilSafsoylu" Username And "k33lwb7979" Password
* Check That The User Has Successfully Logged In
* Go To My Account Screen
* Go to the Add Money Screen
* Check That The Add Money Screen Opens Correctly
* Enter "1234" as Card Number
* Click The "cardHolderInput" Element
* Check If Element "tooShortError" Exist

TC010 - Fill Add Money Inputs With Long Card Number
--------------------------------------------
Tags:TC010-fillAdMoneyInputsWithLongCardNumber
* Go To CatchyLabs URL Address
* Verify That The Homepage Elements Opens Correctly
* Login To Account With "KamilSafsoylu" Username And "k33lwb7979" Password
* Check That The User Has Successfully Logged In
* Go To My Account Screen
* Go to the Add Money Screen
* Check That The Add Money Screen Opens Correctly
* Enter "1234123412341234123412341234" as Card Number
* Click The "cardHolderInput" Element
* Check If Element "tooLongError" Exist

TC011 - Fill Add Money Inputs With Empty Card Number
--------------------------------------------
Tags:TC011-fillAdMoneyInputsWithEmptyCardNumber
* Go To CatchyLabs URL Address
* Verify That The Homepage Elements Opens Correctly
* Login To Account With "KamilSafsoylu" Username And "k33lwb7979" Password
* Check That The User Has Successfully Logged In
* Go To My Account Screen
* Go to the Add Money Screen
* Check That The Add Money Screen Opens Correctly
* Enter "" as Card Number
* Click The "cardHolderInput" Element
* Check If Element "requiredError" Exist

TC012 - Fill Add Money Inputs With Wrong Expiry Date
--------------------------------------------
Tags:TC012-fillAdMoneyInputsWithWrongExpiryDate
* Go To CatchyLabs URL Address
* Verify That The Homepage Elements Opens Correctly
* Login To Account With "KamilSafsoylu" Username And "k33lwb7979" Password
* Check That The User Has Successfully Logged In
* Go To My Account Screen
* Go to the Add Money Screen
* Check That The Add Money Screen Opens Correctly
* Enter "1234123412341234" as Card Number
* Enter "testacc" as Card Holder Name
* Enter "1626" as Expiry Date
* Check If Element "wrongDateError" Exist

TC013 - Fill Add Money Inputs With Short CVV
--------------------------------------------
Tags:TC013-fillAdMoneyInputsWithShortCVV
* Go To CatchyLabs URL Address
* Verify That The Homepage Elements Opens Correctly
* Login To Account With "KamilSafsoylu" Username And "k33lwb7979" Password
* Check That The User Has Successfully Logged In
* Go To My Account Screen
* Go to the Add Money Screen
* Check That The Add Money Screen Opens Correctly
* Enter "1234123412341234" as Card Number
* Enter "testacc" as Card Holder Name
* Enter "1026" as Expiry Date
* Enter "1" as Cvv Number
* Click The "AmountInput" Element
* Check If Element "tooShortError" Exist

TC014 - Fill Add Money Inputs With Alphabetic Amount
--------------------------------------------
Tags:TC014-fillAdMoneyInputsWithAlphabeticAmount
* Go To CatchyLabs URL Address
* Verify That The Homepage Elements Opens Correctly
* Login To Account With "KamilSafsoylu" Username And "k33lwb7979" Password
* Check That The User Has Successfully Logged In
* Go To My Account Screen
* Go to the Add Money Screen
* Check That The Add Money Screen Opens Correctly
* Enter "1234123412341234" as Card Number
* Enter "testacc" as Card Holder Name
* Enter "1026" as Expiry Date
* Enter "110" as Cvv Number
* Enter "sss" In The Amount Of Money To Send
* Check If Element "amountMustBeNumberError" Exist
