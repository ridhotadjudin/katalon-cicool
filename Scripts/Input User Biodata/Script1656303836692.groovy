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
import com.kms.katalon.core.testdata.ExcelData as ExcelData
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.entity.checkpoint.ExcelCheckpointSourceInfo as ExcelCheckpointSourceInfo
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.click(findTestObject('Object Repository/Page_Admin_Cicool/Page_Admin  APIGenerator  User Profile/a_CRUD Builder'))

WebUI.callTestCase(findTestCase('Login Cicool'), [('urlCicool') : 'http://localhost/cicool/administrator/login', ('uname') : 'ridhotadjudin@gmail.com'
        , ('passw') : '123456'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Admin_Cicool/Page_Admin  APIGenerator  Crud List/a_see'))

ExcelData data = findTestData('Data User/Biodata')

for (def index : (0..data.getRowNumbers() - 1)) {
    WebUI.click(findTestObject('Object Repository/Page_Admin_Cicool/Page_Admin  APIGenerator  Userbiodata List/a_Add Userbiodata New'))

    WebUI.setText(findTestObject('Object Repository/Page_Admin_Cicool/Page_Admin  APIGenerator  Userbiodata New/input__first_name'), 
        data.internallyGetValue('first_name', index))

    WebUI.setText(findTestObject('Object Repository/Page_Admin_Cicool/Page_Admin  APIGenerator  Userbiodata New/input__last_name'), 
        data.internallyGetValue('last_name', index))

    WebUI.setText(findTestObject('Object Repository/Page_Admin_Cicool/Page_Admin  APIGenerator  Userbiodata New/input__email'), 
        data.internallyGetValue('email', index))

    WebUI.setText(findTestObject('Object Repository/Page_Admin_Cicool/Page_Admin  APIGenerator  Userbiodata New/input__gender'), 
        data.internallyGetValue('gender', index))

    WebUI.scrollToElement(findTestObject('Page_Admin_Cicool/Page_Admin  APIGenerator  Userbiodata New/a_Save and go to list'), 
        0)

    WebUI.uploadFile(findTestObject('Page_Admin_Cicool/Page_Admin  APIGenerator  Userbiodata New/select_photo'), 'D:\\nx.jpg')

    WebUI.click(findTestObject('Object Repository/Page_Admin_Cicool/Page_Admin  APIGenerator  Userbiodata New/a_Save and go to list'))
}

//WebUI.click(findTestObject('Object Repository/Page_Admin_Cicool/Page_Admin  APIGenerator  Userbiodata List/a_Add Userbiodata New'))
//
//WebUI.setText(findTestObject('Object Repository/Page_Admin_Cicool/Page_Admin  APIGenerator  Userbiodata New/input__first_name'),
//	firstname)
//
//WebUI.setText(findTestObject('Object Repository/Page_Admin_Cicool/Page_Admin  APIGenerator  Userbiodata New/input__last_name'),
//	lastname)
//
//WebUI.setText(findTestObject('Object Repository/Page_Admin_Cicool/Page_Admin  APIGenerator  Userbiodata New/input__email'),
//	email)
//
//WebUI.setText(findTestObject('Object Repository/Page_Admin_Cicool/Page_Admin  APIGenerator  Userbiodata New/input__gender'),
//	gender)
//
//WebUI.scrollToElement(findTestObject('Page_Admin_Cicool/Page_Admin  APIGenerator  Userbiodata New/a_Save and go to list'),
//	0)
//
//WebUI.uploadFile(findTestObject('Page_Admin_Cicool/Page_Admin  APIGenerator  Userbiodata New/select_photo'), 'D:\\nx.jpg')
//
//WebUI.click(findTestObject('Object Repository/Page_Admin_Cicool/Page_Admin  APIGenerator  Userbiodata New/a_Save and go to list'))
WebUI.delay(5)

WebUI.closeBrowser()

