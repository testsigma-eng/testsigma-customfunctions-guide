package com.testsigma.customfunc.examples;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.testsigma.customfunc.common.CustomTestStep;
import com.testsigma.customfunc.common.TestsigmaCustomFunctions;
import com.testsigma.customfunc.result.ResultConstants;
import com.testsigma.customfunc.result.TestStepResult;
import com.testsigma.testengine.exceptions.TestsigmaTestdataNotFoundException;

public class ValidateResponseXml extends TestsigmaCustomFunctions{
    @SuppressWarnings("unchecked")
    @CustomTestStep
    public TestStepResult updateTestData(String name, String rName) throws TestsigmaTestdataNotFoundException, Exception {
        driver.get("http://demo5kentico10.raybiztech.com/published/Executing/ProcessDomainPortfolio");

        Thread.sleep(6000);

       driver.findElement(By.xpath("//input[@name='p$lt$ctl00$Marcaria_RSSPublished$txtUserName']")).sendKeys("rbt");

               					      driver.findElement(By.xpath("//input[@name='p$lt$ctl00$Marcaria_RSSPublished$txtPassword']")).sendKeys("ray1@3");

        driver.findElement(By.xpath("//input[@name='p$lt$ctl00$Marcaria_RSSPublished$btnLogin']")).click();

        Thread.sleep(3000);

        //System.out.println(d.getPageSource());

        WebElement w = driver.findElement(By.tagName("body"));

        String bodytext = w.getText().substring(w.getText().indexOf("<rss"));

        
      
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         InputStream stream = new ByteArrayInputStream(bodytext.getBytes(StandardCharsets.UTF_8));
         Document doc = dBuilder.parse(stream);
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
         NodeList nList = doc.getElementsByTagName("item");
         
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            Element eElement = (Element) nNode;
            String content = eElement.getElementsByTagName("g:FullDomName").item(0).getTextContent();
            String domain = getTestDataParamterValue(name);
            if(content.equals(domain)){
            	 String item = eElement.getElementsByTagName("g:ItemID").item(0).getTextContent();
            	 setRuntimeData(rName, item);
              	 break;
            }
         }
     	
        TestStepResult result= new TestStepResult();
        result.setStatus(ResultConstants.SUCCESS);
        result.setMessage("custom step Executed successfully");
        return result;
    }
}