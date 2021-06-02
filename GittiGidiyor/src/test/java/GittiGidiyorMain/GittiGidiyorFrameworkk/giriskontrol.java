package GittiGidiyorMain.GittiGidiyorFrameworkk;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Objects.Page_Package;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class giriskontrol extends Base{
	
	@Parameters({"gecerli_mail","yanlis_sifre"})
	@Test
	public void eksik_sifre(String gecerli_mail,String yanlis_sifre) 
	{
		Page_Package anasayfa = new Page_Package(driver);
		
		
		anasayfa.kisayol_hesabim.click();
		
		anasayfa.entry_buton.click();
		
		anasayfa.kullanıcı_id.click();
		anasayfa.kullanıcı_id.sendKeys(gecerli_mail);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		anasayfa.password_entry.click();
		anasayfa.password_entry.sendKeys(yanlis_sifre);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		anasayfa.loginbuton.click();
		
		assertEquals(anasayfa.digerhatalar.get(0).isDisplayed(), true);
	}
	
	@BeforeMethod
	public void BeforeMethod() throws IOException, InterruptedException 
	{
		service = startServer();
		AndroidDriver<AndroidElement> driver = Capabilities("GittiGidiyorApp");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);	
	}
	
	@AfterMethod
	public void AfterMethod() 
	{
		service.stop();
	}
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException 
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		
	}

}
