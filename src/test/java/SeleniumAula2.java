import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumAula2 {
	//Criar instancia do driver do Chrome.
	private static WebDriver driver;
	private WebDriverWait wait = new WebDriverWait(driver, 100);
	
	@BeforeAll
	public static void setup() {
		//Setar as propriedades do Chrome Driver.
		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		//Abrir brownser e acessar a URL
		driver.get("https://automacaocombatista.herokuapp.com");
		//Maximizar o Browser
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Começar Automação Web']")).click();
	}
	
//	@Test	
//	public void criarUsuario() {
//	
//		Random random = new Random();
//		String email = "maycoln.dias"+random.nextInt(1000)+"@gmail.com";
//		
//		//Identificando um elemento e preenchendo o campo com um texto.
//		driver.findElement(By.xpath("//a[text()='Formulário']")).click();
//		driver.findElement(By.xpath("//a[text()='Criar Usuários']")).click();
//		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("Maycoln");
//		driver.findElement(By.xpath("//input[@id='user_lastname']")).sendKeys("Dias");
//		driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(email);
//		driver.findElement(By.xpath("//input[@id='user_address']")).sendKeys("Avenida Gustavo Adolfo");
//		driver.findElement(By.xpath("//input[@id='user_university']")).sendKeys("UNINOVE");
//		driver.findElement(By.xpath("//input[@id='user_profile']")).sendKeys("Analista de Suporte");
//		driver.findElement(By.xpath("//input[@id='user_gender']")).sendKeys("Masculino");
//		driver.findElement(By.xpath("//input[@id='user_age']")).sendKeys("33");
//		driver.findElement(By.xpath("//input[@name='commit']")).click();
//		
//		//Atribuindo o texto da mensagem na tela para a variável
//		String mensagem = driver.findElement(By.xpath("//p[@id='notice']")).getText();
//		
//		//Validando se a mensagem que eu necessito está sendo exibida na tela.
//		Assertions.assertEquals("Usuário Criado com sucesso", mensagem);
//		
//		//Fechando meu navegador
//		//driver.quit();
//	}
//	@Test
//	public void radioCheckBox() {
//		
//		driver.findElement(By.xpath("//a[text()='Busca de elementos']")).click();
//		WebElement link = driver.findElement(By.xpath("//a[text()='Radio e Checkbox']"));
//		wait.until(ExpectedConditions.visibilityOf(link));
//		link.click();
//	}
//	
	@Test
	public void select() {
		
		driver.findElement(By.xpath("//a[text()='Busca de elementos']")).click();
		WebElement link = driver.findElement(By.xpath("//a[text()='Dropdown e Select']"));
		wait.until(ExpectedConditions.visibilityOf(link));
		link.click();
		driver.findElement(By.xpath("//label[text()='Desenho Favorito']/preceding-sibling::div[@class='select-wrapper']")).click();
		driver.findElement(By.xpath("//span[text()='Naruto']")).click();
		
		//driver.findElement(By.xpath("//div[@class='select-wrapper' and descendant::span[text()='Ronaldo']]")).click();
		//driver.findElement(By.xpath("//span[text()='Ronaldinho Gaucho']")).click();
		//WebElement listaSelecao = driver.findElement(By.xpath("//select[@id='dropdown']"));
		//Select listaDesenhoFavorito = new Select(listaSelecao);
		//listaDesenhoFavorito.selectByIndex(1);
		//listaDesenhoFavorito.selectByValue("2");
		//listaDesenhoFavorito.selectByVisibleText("Firefox");
	}
}
