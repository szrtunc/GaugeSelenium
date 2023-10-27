package org.example;


import Page.AutomationWebPage;
import com.thoughtworks.gauge.Step;
import driver.ConfigReader;
import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class StepImplementation {

    WebDriver driver;
    AutomationWebPage webPage=new AutomationWebPage();

    @Step("Go to Website")
    public void gotoGetStartedPage() throws InterruptedException {
        driver= DriverFactory.getDriver();
        driver.get(ConfigReader.getProperty("baseUrl"));
    }

    @Step("Sing Up")
    public void signUpMethod() throws InterruptedException{
        WebElement x=driver.findElement(By.xpath("//input[@id='email']"));
        x.isDisplayed();
        webPage.signUpButton.sendKeys(ConfigReader.getProperty("email"));
        driver.findElement(By.xpath("//img[@id='enterimg']")).click();
    }


    @Step("Register")
    public void register() throws InterruptedException{

        String name=ConfigReader.getProperty("name");
        String lastName=ConfigReader.getProperty("lastname");
        String address=ConfigReader.getProperty("address");
        String emailAddress=ConfigReader.getProperty("emailAddress");
        String phone=ConfigReader.getProperty("phone");
        String gender=ConfigReader.getProperty("gender");

        Actions actions=new Actions(driver);
        actions.sendKeys(webPage.firstNameBox,name+Keys.TAB)
                .sendKeys(lastName+Keys.TAB)
                .sendKeys(address+Keys.TAB)
                .sendKeys(emailAddress+Keys.TAB)
                .sendKeys(phone).perform();

        if(gender.matches("male") ||gender.matches("erkek")){
            webPage.genderMaleRadio.click();
        }else{
            webPage.genderFeMaleRadio.click();
        }

        String[] hobbies=ConfigReader.getPropertyArray("hobbies");
        for(String hobbie:hobbies){
            if(hobbie.equals("Cricket")){
                driver.findElement(By.xpath("//input[@id='checkbox1']")).click();
            } else if (hobbie.equals("Movies")) {
                driver.findElement(By.xpath("//input[@id='checkbox2']")).click();
            } else if (hobbie.equals("Hockey")) {
                driver.findElement(By.xpath("//input[@id='checkbox3']")).click();
            }else{
                System.out.println("Invalid hobby: " + hobbie);
            }
        }

        webPage.languagesBox.click();
        String[] languages=ConfigReader.getPropertyArray("languages");

        for(String language:languages){
            for(WebElement item:webPage.items){
                if(item.getText().equalsIgnoreCase(language.trim())){
                    item.click();
                    break;
                }
            }
        }
        driver.findElement(By.xpath("//label[text()='Skills']")).click();  //boşluğa tıklamak için

        webPage.skillsBox.click();
        String skill=ConfigReader.getProperty("skill");

        for(WebElement x:webPage.skillsAll) {
            if (x.getText().equalsIgnoreCase(skill.trim())) {
                x.click();
                break;
            }
        }

        webPage.countryArrow.click();
        String country=ConfigReader.getProperty("country");
        String formattedCountry=country.substring(0,1).toUpperCase()+ country.substring(1).toLowerCase();
        Select select=new Select(webPage.countryDropDown);
        select.selectByVisibleText(formattedCountry);
        webPage.countryArrow.click();


        String [] dateOfBirth=ConfigReader.getPropertyArray("dateOfBirth");

        webPage.yearBoxButton.click();
        for(WebElement year:webPage.yearBox){
            for(String a:dateOfBirth){
                if(year.getText().equalsIgnoreCase(a.trim())){
                    year.click();
                    break;
                }
            }
        }webPage.yearBoxButton.click();


        webPage.monthBoxButton.click();
        for(WebElement month:webPage.monthBox){
            for(String a:dateOfBirth){
                if(month.getText().equalsIgnoreCase(a.trim())){
                    month.click();
                    break;
                }
            }
        }webPage.monthBoxButton.click();


        webPage.dayBoxButton.click();
        for(WebElement day:webPage.dayBox){
            for(String a:dateOfBirth){
                if(day.getText().equalsIgnoreCase(a.trim())){
                    day.click();
                    break;
                }
            }
        }webPage.dayBoxButton.click();

        String password=ConfigReader.getProperty("password");
        webPage.passwordBox.sendKeys(password);
        webPage.confirmPasswordBox.sendKeys(password);

        webPage.submitButton.click();

    }




}
