package br.com.bootcamp.junit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.TestCase;

public class SrBarriga1 extends TestCase {

		private static WebDriver driver;
		//private WebDriverWait wait = new WebDriverWait(driver, 10000);

		@BeforeAll
		public static void setup() {
			System.setProperty("webdriver.chrome.driver","chromeDriver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://srbarriga.herokuapp.com/login");
			driver.manage().window().maximize();	
			
		}
		@Test
		public void teste1() {
			
			driver.findElement(By.xpath("//a[text()='Novo usuário?']")).click();
			VariaveisEstaticas.setNome("Maycoln");
			VariaveisEstaticas.setEmail("maycoln.yaman234@teste.com");
			VariaveisEstaticas.setPassword("TEste12145");
			driver.findElement(By.id("nome")).sendKeys(VariaveisEstaticas.getNome());
			driver.findElement(By.id("email")).sendKeys(VariaveisEstaticas.getEmail());
			driver.findElement(By.id("senha")).sendKeys(VariaveisEstaticas.getPassword());
			driver.findElement(By.xpath("//input[@value='Cadastrar' and @type='submit']")).click();

		}
		@Test
		public void teste2() {
		
			driver.findElement(By.xpath("//a[text()='Login']")).click();
			driver.findElement(By.id("email")).sendKeys(VariaveisEstaticas.getEmail());
			driver.findElement(By.id("senha")).sendKeys(VariaveisEstaticas.getPassword());
			driver.findElement(By.xpath("//button[@type='submit' and text()='Entrar']")).click();
		}


}
