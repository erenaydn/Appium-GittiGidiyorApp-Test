package GittiGidiyorMain.GittiGidiyorFrameworkk;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import GittiGidiyorMain.GittiGidiyorFrameworkk.Base;
import GittiGidiyorMain.GittiGidiyorFrameworkk.Util;
import Objects.Page_Package;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;



		public class urun_test extends Base{
	
		@Test
		public void uruntest() throws InterruptedException 
		{
		Page_Package sayfalar = new Page_Package(driver);
		Util util  = new Util(driver);
		
		sayfalar.arama_cubugu.click();
		sayfalar.arama_cubugu.sendKeys("klavye");
		sayfalar.arama_secim.click();
		
		
		int min=0;
		int max=1;
		Random rnd = new Random();
		
		int num=rnd.nextInt(max-min+1)+min;	
		sayfalar.urunler.get(num).click();		
		
		String fiyat = sayfalar.urunun_fiyati.getText();		
		util.scrollIntoText("Sepete Ekle");		
		sayfalar.sepete_ekle_butonu.click();		
		sayfalar.kisayol_sepetim.click();
		
		String total_fiyat = sayfalar.toplam_ucret.getText();
		
		total_fiyat = total_fiyat.replace(" TL", "");			
		
		AssertJUnit.assertEquals(total_fiyat, fiyat);
		
		sayfalar.adet_belirle.click();
		
		String iki_tane = sayfalar.iki_adet.getText();
		
		sayfalar.iki_adet.click();
		
		Thread.sleep(3000);
		
		String adet_miktarim = sayfalar.toplam_adet.getText();
		
		AssertJUnit.assertEquals(iki_tane, adet_miktarim);
		
		sayfalar.sepetten_kaldir.click();
		
		sayfalar.evet.click();
		
		AssertJUnit.assertEquals(sayfalar.sepet_bos.isDisplayed(), true);
		
		
		
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