package Objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Page_Package {
	
	public Page_Package(AndroidDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	// Anasayfa girdileri
	
	@AndroidFindBy(id = "com.gittigidiyormobil:id/appbar_search_text_autoCompleteTextView")
	public WebElement arama_cubugu;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Klavye, Mouse / Klavye']")
	public WebElement arama_secim;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Sepetim']")
	public WebElement kisayol_sepetim;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Hesabım']")
	public WebElement kisayol_hesabim;
	
	
	// Hesabım sayfası girdileri
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Kullanıcı adı veya e-posta adresi']")
	public WebElement kullanıcı_id;
	
	@AndroidFindBy(id = "com.gittigidiyormobil:id/mail_auth_button")
	public WebElement entry_buton;
	
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Şifreniz']")
	public WebElement password_entry;
	
	@AndroidFindBy(id = "com.gittigidiyormobil:id/btn_login")
	public WebElement loginbuton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Çıkış Yap']")
	public WebElement cikis;
	
	@AndroidFindBy(id = "com.gittigidiyormobil:id/textinput_error")
	public List<WebElement> digerhatalar;
	
	
	// Sepet sayfasi girdileri 
	
	@AndroidFindBy(id = "com.gittigidiyormobil:id/total_price")
	public WebElement toplam_ucret;
	
	@AndroidFindBy(id = "com.gittigidiyormobil:id/spnAmountDownArrow")
	public WebElement adet_belirle;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='2']")
	public WebElement iki_adet;
	
	@AndroidFindBy(id = "com.gittigidiyormobil:id/basketItemProductQuantityTV")
	public WebElement toplam_adet;
	
	@AndroidFindBy(id = "com.gittigidiyormobil:id/txtProductTitle")
	public WebElement urun_ismi;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Sepetinizde ürün bulunmamaktadır.']")
	public WebElement sepet_bos;
	
	@AndroidFindBy(id = "com.gittigidiyormobil:id/txtDelete")
	public WebElement sepetten_kaldir;
	
	@AndroidFindBy(id = "android:id/button1")
	public WebElement evet;
	
	// ürünü secince acilan sayfa girdileri 
	
	@AndroidFindBy(id = "com.gittigidiyormobil:id/btnAddBasket")
	public WebElement sepete_ekle_butonu;
	
	@AndroidFindBy(id = "com.gittigidiyormobil:id/tv_best_deal_price")
	public WebElement urunun_fiyati;
	
	// ürün girdisi 
	
	@AndroidFindBy(id = "com.gittigidiyormobil:id/tv_price")
	public List<WebElement> urunler;
	
}