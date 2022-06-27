import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as Keys

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.ExcelData as ExcelData
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

WebUI.callTestCase(findTestCase('Login Cicool'), [('urlCicool') : 'http://localhost/cicool/administrator/login', ('uname') : 'ridhotadjudin@gmail.com'
        , ('passw') : '123456'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page Absensi/Page_Admin  APIGenerator  User Profile/a_CRUD Builder'))

WebUI.click(findTestObject('Object Repository/Page Absensi/Page_Admin  APIGenerator  Crud List/a_see'))

ExcelData inputData = findTestData('Data User/Absensi')

int iter = 0

for (def index : (0..inputData.getRowNumbers() - 1)) {
    WebUI.click(findTestObject('Object Repository/Page Absensi/Page_Admin  APIGenerator  Absensi List/a_Add Absensi New'))

    WebUI.setText(findTestObject('Object Repository/Page Absensi/Page_Admin  APIGenerator  Absensi New/input__username'), 
        inputData.internallyGetValue('username', index))

    WebUI.setText(findTestObject('Object Repository/Page Absensi/Page_Admin  APIGenerator  Absensi New/input__email'), 
		inputData.internallyGetValue('email', index))

    WebUI.setText(findTestObject('Object Repository/Page Absensi/Page_Admin  APIGenerator  Absensi New/input__location'), 
        inputData.internallyGetValue('location', index))

    WebUI.click(findTestObject('Object Repository/Page Absensi/Page_Admin  APIGenerator  Absensi New/a_Save and go to list'))
	
	WebDriver driver = DriverFactory.getWebDriver() //webdriver using katalon (not selenium)
	
	if(iter<5) {
	
		// list properties using java.util
		List<WebElement> lstUser = driver.findElements(By.xpath("//*[(text()='"+inputData.internallyGetValue('username', index)+"')]"))  //*[(text()='adada')]
		
		String nama = lstUser.get(0).text
		
		println(nama)
		
		WebUI.verifyEqual(nama, inputData.internallyGetValue('username', index))
			
	}
	iter += 1  // only make 5 iterate validation as a sample
	
	WebUI.delay(1)
	
	}

WebUI.delay(5)

WebUI.closeBrowser()

