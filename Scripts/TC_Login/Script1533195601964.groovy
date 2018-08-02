import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('http://localhost:8681/login')

WebUI.setText(findTestObject('Page_DMS ONE/input_username'), user)

WebUI.setText(findTestObject('Page_DMS ONE/input_password'), password)

WebUI.click(findTestObject('Page_DMS ONE/input_submit'))

if (user.equals('') && password.equals('')) {
    WebUI.verifyElementPresent(findTestObject('Page_DMS ONE/div_Please enter your login in'), 5 )
} else if (user.equals('')) {
    WebUI.verifyElementPresent(findTestObject('Page_DMS ONE/div_You have not entered your'), 5)
} else if (password.equals('')) {
    WebUI.verifyElementPresent(findTestObject('Page_DMS ONE/div_You have not filled out th'), 5)
} else {
    if (WebUI.getUrl().equals('http://localhost:8681/login')) {
        WebUI.verifyElementPresent(findTestObject('Object Repository/Page_DMS ONE/div_Username or password incor'), 10)
    } else {
        WebUI.verifyElementClickable(findTestObject('Page_SALES.ONE/span_GADMIN1 - GROUP ADMIN'), FailureHandling.CONTINUE_ON_FAILURE)
    }
}

WebUI.closeBrowser()

