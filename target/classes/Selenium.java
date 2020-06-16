import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {

@Test
    public void criarUsuario(){
    //Setar as propriedades do chrome Driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //Criar instancia do driver do chrome
        WebDriver driver = new ChromeDriver();
        //Abrir browser e acessar a URL
        driver.get("https://automacaocombatista.herokuapp.com/users/new");
        //Identificando um elemento e preenchendo o campo com um texto
        driver.findElement(By.id("user_name")).sendKeys("Maycoln");
        driver.findElement(By.id("user_lastname")).sendKeys("Glauco");

        //Fechando meu navagador
//        driver.quit();
    }


}
