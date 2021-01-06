/*package com.segurosbolivar.automation.commons;

public class practica {
    RemoteWebDriver driver;
    //	@Test
    void naukriLocalRunUsingChrome() {
        ChromeOptions op = new ChromeOptions();
        op.setHeadless(true);
        driver = new ChromeDriver(op);
        driver.get("https://www.naukri.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement uploadEle = driver.findElementByCssSelector("#file_upload");
        uploadEle.sendKeys(getFile());
        String errorMsg = driver.findElementByCssSelector(".error-header .error").getText();
        System.out.println(errorMsg);
        driver.quit();
    }



    @Test
    void naukriLocalRunUsingIE() {
        driver = new InternetExplorerDriver();
        driver.get("https://www.naukri.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement uploadEle = driver.findElementByCssSelector("#file_upload");
        uploadEle.sendKeys(getFile());
        String errorMsg = driver.findElementByCssSelector(".error-header .error").getText();
        System.out.println(errorMsg);
        driver.quit();
    }

    //	@Test
    void uploadMultipleFiles() {
        driver = new ChromeDriver();
        driver.get("https://files.fm/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement uploadEle = driver.findElementByXPath("//input[@type='file'][2]");
        LocalFileDetector detector = new LocalFileDetector();
        ((RemoteWebElement)uploadEle).setFileDetector(detector);
        File file1 = detector.getLocalFile("./files/yeah.gif");
        File file2 = detector.getLocalFile("./files/what.gif");
        uploadEle.sendKeys(file1.getAbsolutePath(), "\n",file2.getAbsolutePath());
//		String errorMsg = driver.findElementByCssSelector(".error-header .error").getText();
//		System.out.println(errorMsg);
        driver.quit();
    }

    DesiredCapabilities caps;
    private DesiredCapabilities capabilities() {
        caps = new DesiredCapabilities();
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "80");
        caps.setCapability("name", "koushikchatterje4's First Test");
        return caps;
    }

    //	    @Test()
    void naukri() throws MalformedURLException {
        DesiredCapabilities caps = capabilities();
        driver = new RemoteWebDriver(new URL(Cred.URL), caps);
        driver.manage().window().maximize();
        driver.get("https://www.naukri.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement uploadEle = driver.findElementById("file_upload");
        LocalFileDetector detector = new LocalFileDetector();
        ((RemoteWebElement)uploadEle).setFileDetector(detector);
        uploadEle.sendKeys(getFile());
        String errorMsg = driver.findElementByCssSelector(".error-header .error").getText();
        System.out.println(errorMsg);
        driver.quit();
    }

    String getFile() {
        return new File("./files/yeah.gif").getAbsolutePath();
    }
}
}*/
