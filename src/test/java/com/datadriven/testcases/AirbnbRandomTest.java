package com.datadriven.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Map.*;

public class AirbnbRandomTest {

    public static String url="https://www.airbnb.co.in/";

    public static WebDriver driver;
    public static List<WebElement> elements;
    public static Map<String,WebElement> webElementMap;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        getElementsInList();
        findElementInList("OMG!");

    }
    public static void getElementsInList(){
        elements= driver.findElements(By.xpath("//span[contains(@class,'tamhn2w dir dir-ltr')]"));
         webElementMap =elements.stream()
                .collect(Collectors.toMap(webElement -> webElement.getAttribute("innerHTML"), Function.identity()));
        webElementMap.entrySet().stream().forEach(e-> System.out.println(e.getKey() + "->" + e.getValue().getText()));
//        webElementMap.stream().peek(stringWebElementEntry -> System.out.println(stringWebElementEntry.getKey() + " -> " + stringWebElementEntry.getValue() ));
        /*System.out.println("Number of Airbnb options: "+elements.size());
        System.out.print("URLs");
        String listOfAcc;
        for (int i=0; i<elements.size();i++){
            listOfAcc = elements.get(i).getAttribute("innerHTML");
            System.out.println(listOfAcc);
        }*/

    }

  /*  public void sortedListOfAccomodation(){
        TreeMap<WebElement,WebElement> sortedList = new TreeMap<WebElement,WebElement>();
        sortedList=webElementMap
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2) ->e2,LinkedHashMap::new));

    }
*/

    public static void findElementInList(String e){

        if (elements != null){
            elements.contains(e);
            System.out.println("Element is found!! "+ e);

        }else{
            System.out.println("Enter correct Element!");
        }

    }

/***Build the switchcases**/

}
