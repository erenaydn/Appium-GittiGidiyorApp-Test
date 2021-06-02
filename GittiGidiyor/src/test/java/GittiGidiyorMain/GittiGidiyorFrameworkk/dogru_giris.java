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
import GittiGidiyorMain.GittiGidiyorFrameworkk.Util;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class dogru_giris extends Base{
	
	
	// Bot kontrol Re-Capctha'den dolayı sorun cıkartıyor 
	
	
	@Parameters({"gecerli_mail","gecerli_sifre"})
	@Test
	public void dogru_giris(String gecerli_mail,String gecerli_sifre) throws InterruptedException 
	{
		Page_Package anasayfa = new Page_Package(driver);
		Util util = new Util(driver);
		
		anasayfa.kisayol_hesabim.click();
		
		anasayfa.entry_buton.click();
		
		anasayfa.kullanıcı_id.click();
		anasayfa.kullanıcı_id.sendKeys(gecerli_mail);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		anasayfa.password_entry.click();
		anasayfa.password_entry.sendKeys(gecerli_sifre);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		anasayfa.loginbuton.click();

		Thread.sleep(50000);;
		
		anasayfa.kisayol_hesabim.click();
			
		util.scrollIntoText("Çıkış Yap");
		
		assertEquals(anasayfa.cikis.isDisplayed(), true);
		
		anasayfa.cikis.click();
		
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
	
	
}
