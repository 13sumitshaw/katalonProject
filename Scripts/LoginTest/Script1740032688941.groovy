import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Import necessary Katalon libraries
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.ObjectRepository as OR
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil

// Start browser and navigate to login page
WebUI.openBrowser('https://the-internet.herokuapp.com/login')  // Update with actual URL
WebUI.waitForPageLoad(10)

// Find test objects
TestObject usernameField = OR.findTestObject('Object Repository/LoginPage/Username1')
TestObject passwordField = OR.findTestObject('Object Repository/LoginPage/Password1')
TestObject loginButton  = OR.findTestObject('Object Repository/LoginPage/LoginButton1')

// Check if any test object is NULL before proceeding
if (usernameField == null || passwordField == null || loginButton == null) {
	KeywordUtil.markFailedAndStop("❌ One or more test objects are NULL. Please verify Object Repository paths.")
}

// Perform login actions
WebUI.setText(usernameField, "tomsmith")
WebUI.setText(passwordField, "SuperSecretPassword!")
WebUI.click(loginButton)

// Verify login success
WebUI.waitForElementPresent(OR.findTestObject('Object Repository/Dashboard/HomePage'), 10)

// Close browser
WebUI.closeBrowser()


