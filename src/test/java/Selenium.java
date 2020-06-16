import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;

public class Selenium {
    //Criar instancia do driver do chrome
    private static WebDriver driver = new ChromeDriver();

    @BeforeAll
    public static void setup(){
        //Setar as propriedades do chrome Driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        //Abrir browser e acessar a URL
        driver.get("https://automacaocombatista.herokuapp.com");
        //Maximizando o Browser Windows
        //driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[text()='ComeÃ§ar AutomaÃ§Ã£o Web']")).click();
        //Maximizando o Browser Mac/Linux
        driver.manage().window().fullscreen();
    }

    @Test
    public void criarUsuario(){

        Random random = new Random();
        String email = random.nextInt(10000)+"@bootcamp.com.br";

        //Identificando um elemento e preenchendo o campo com um texto
        driver.findElement(By.xpath("//a[text()='FormulÃ¡rio']")).click();
        driver.findElement(By.xpath("//a[text()='Criar UsuÃ¡rios']")).click();
        driver.findElement(By.id("user_name")).sendKeys("Marcos");
        driver.findElement(By.id("user_lastname")).sendKeys("Barbosa");
        driver.findElement(By.id("user_email")).sendKeys(email);
        driver.findElement(By.id("user_address")).sendKeys("Avenida Trindade");
        driver.findElement(By.id("user_university")).sendKeys("Nenhuma");
        driver.findElement(By.id("user_profile")).sendKeys("Qa");
        driver.findElement(By.id("user_gender")).sendKeys("M");
        driver.findElement(By.id("user_age")).sendKeys("18");

        //Clicando no botao Criar
        driver.findElement(By.name("commit")).click();

        //Atribuindo o texto da mensagem na tela para a variÃ¡vel
        String mensagem = driver.findElement(By.xpath("//p[@id='notice']")).getText();

        //Validando se a mensagem que eu necessito estÃ¡ sendo exibida na tela
        Assertions.assertEquals("UsuÃ¡rio Criado com sucesso", mensagem);
    }

    @Test
    public void radioCheckBox(){
        driver.findElement(By.xpath("//a[text()='Busca de elementos']")).click();
        driver.findElement(By.xpath("//a[text()='Radio e Checkbox']")).click();
        

    }

    @AfterAll
    public static void fecharBrowser(){
        //Fechando meu navagador
        driver.quit();
    }
}
