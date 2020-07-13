import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.bootcamp.VariaveisEstaticas;

public class SrBarriga {

	private static WebDriver driver;
	//private WebDriverWait wait = new WebDriverWait(driver, 10000);

	@BeforeAll
	public static void setup() {
		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://srbarriga.herokuapp.com/login");
		driver.manage().window().fullscreen();	
		
	}
	@Test
	public static void teste1() {
	
		driver.findElement(By.xpath("//a[text()='Novo usuário?']"));
		VariaveisEstaticas.setNome("Maycoln");
		VariaveisEstaticas.setEmail("maycoln12345@teste.com");
		VariaveisEstaticas.setPassword("TEste1214");
		driver.findElement(By.id("nome")).sendKeys(VariaveisEstaticas.getNome());
		driver.findElement(By.id("email")).sendKeys(VariaveisEstaticas.getEmail());
		driver.findElement(By.id("senha")).sendKeys(VariaveisEstaticas.getPassword());
		driver.findElement(By.xpath("//input[@value='Cadastrar' and @type='submit']")).click();

	}
	
	public static void teste2() {
		driver.findElement(By.xpath("//a[text()='login']")).click();
		driver.findElement(By.id("email")).sendKeys(VariaveisEstaticas.getEmail());
		driver.findElement(By.id("senha")).sendKeys(VariaveisEstaticas.getPassword());
		driver.findElement(By.xpath("//button[@type='submit' and text()='Entrar']")).click();
	}

}
