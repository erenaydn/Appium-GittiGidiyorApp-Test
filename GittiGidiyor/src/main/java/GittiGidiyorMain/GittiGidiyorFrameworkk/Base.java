package GittiGidiyorMain.GittiGidiyorFrameworkk;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	
	public AppiumDriverLocalService startServer() 
	{
		boolean flag = checkIfServerIsRunning(4723);
		
		if(!flag) 
		{
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		
		return service;
	}
	
	public static boolean checkIfServerIsRunning(int port) 
	{
		boolean isServerRunning = false;
		
		ServerSocket serverSocket;
		
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		
		return isServerRunning;
	}
	
	public static void startEmulator() throws IOException, InterruptedException 
	{
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\emulator.bat");
		Thread.sleep(6000);
	}
	
	

	public static AndroidDriver<AndroidElement> Capabilities(String appName) throws IOException, InterruptedException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\GittiGidiyorMain\\GittiGidiyorFrameworkk\\global.properties");
		
		Properties prop = new Properties();
		prop.load(fis);
		
		
		
		File f = new File("src");
		File fs = new File(f,(String) prop.get(appName));
		
		String device = (String) prop.get("device");
		
		//String device = System.getProperty("deviceName");
		
		
		
		if(device.contains("emulator-5554")) 
		{
			startEmulator();
		}
		
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
			
		
		
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Uiautomator2");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.VERSION, "8.1");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,50 );
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		cap.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "com.*");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		return driver;
		
	}
	
	
	public static void getScreenshot(String s) throws IOException 
	{
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\"+s+".png"));
	}

}