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

// Test Case 5: Add New User
def addNewUser() {
	validLogin()
	WebUI.click(findTestObject('AdminPage/AddUser'))
	WebUI.click(findTestObject('AdminPage/UserRoleDropdown'))
	WebUI.click(findTestObject('AdminPage/UserRoleAdmin'))
	WebUI.click(findTestObject('AdminPage/StatusDropdown'))
	WebUI.click(findTestObject('AdminPage/StatusEnabled'))
	WebUI.setText(findTestObject('AdminPage/EmployeeName'), 'John Doe')
	WebUI.setText(findTestObject('AdminPage/Username'), 'john_doe')
	WebUI.setEncryptedText(findTestObject('AdminPage/Password'), 'hUKwJTbofgPU9eVlw/CnDQ==')
	WebUI.setEncryptedText(findTestObject('AdminPage/ConfirmPassword'), 'hUKwJTbofgPU9eVlw/CnDQ==')
	WebUI.click(findTestObject('AdminPage/SaveButton'))
	WebUI.verifyElementPresent(findTestObject('AdminPage/SuccessMessage'), 10)
	WebUI.closeBrowser()
}