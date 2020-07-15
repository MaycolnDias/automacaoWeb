package br.com.bootcamp.junit;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomacaoBatista1 {
	//Criar instancia do driver do Chrome.
	private static WebDriver driver;
	private WebDriverWait wait = new WebDriverWait(driver, 10000);
	
	@BeforeAll
	public static void setup() {
		//Setar as propriedades do Chrome Driver.
		System.setProperty("webdriver.chrome.driver","chromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		//Abrir brownser e acessar a URL
		driver.get("https://automacaocombatista.herokuapp.com");
		//Maximizar o Browser
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Começar Automação Web']")).click();
	}
	
	@Test	
	public void criarUsuario() {
	
		Random random = new Random();
		String email = "maycoln.dias"+random.nextInt(1000)+"@gmail.com";
		
		//Identificando um elemento e preenchendo o campo com um texto.
		driver.findElement(By.xpath("//a[text()='Formulário']")).click();
		driver.findElement(By.xpath("//a[text()='Criar Usuários']")).click();
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("Maycoln");
		driver.findElement(By.xpath("//input[@id='user_lastname']")).sendKeys("Dias");
		driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='user_address']")).sendKeys("Avenida Gustavo Adolfo");
		driver.findElement(By.xpath("//input[@id='user_university']")).sendKeys("UNINOVE");
		driver.findElement(By.xpath("//input[@id='user_profile']")).sendKeys("Analista de Suporte");
		driver.findElement(By.xpath("//input[@id='user_gender']")).sendKeys("Masculino");
		driver.findElement(By.xpath("//input[@id='user_age']")).sendKeys("33");
		driver.findElement(By.xpath("//input[@name='commit']")).click();
		
		//Atribuindo o texto da mensagem na tela para a variável
		String mensagem = driver.findElement(By.xpath("//p[@id='notice']")).getText();
		
		//Validando se a mensagem que eu necessito está sendo exibida na tela.
		Assertions.assertEquals("Usuário Criado com sucesso", mensagem);
		
		//Fechando meu navegador
		//driver.quit();
	}
	@Test
	public void radioCheckBox() {
		
		driver.findElement(By.xpath("//a[text()='Busca de elementos']")).click();
		WebElement link = driver.findElement(By.xpath("//a[text()='Radio e Checkbox']"));
		wait.until(ExpectedConditions.visibilityOf(link));
		link.click();
	}
	
	@Test
	public void select() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[text()='Busca de elementos']")).click();
		WebElement link = driver.findElement(By.xpath("//a[text()='Dropdown e Select']"));
		wait.until(ExpectedConditions.visibilityOf(link));
		link.click();
		driver.findElement(By.xpath("//label[text()='Desenho Favorito']/preceding-sibling::div[@class='select-wrapper']")).click();
		driver.findElement(By.xpath("//span[text()='Naruto']")).click();
		
		//Clica direto pelo javascript indiferente se a opção esteja na tela ou não,
		//utilizado quando o click do Selenium é mais rápido que a atualização de tela
		// e ele entende que o item ainda não está clicável.
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement segundaLista = driver.findElement(By.xpath("//span[text()='Ronaldo']/ancestor::ul/preceding-sibling::input"));
		js.executeScript("arguments[0].click;", segundaLista);
		
		WebElement itemSegundaLista = driver.findElement(By.xpath("//span[text()='Ronaldinho Gaucho']"));
		js.executeScript("arguments[0].click()", itemSegundaLista);
		
		WebElement terceiraLista = driver.findElement(By.xpath("//span[text()='Brasil']/ancestor::ul/preceding-sibling::input"));
		js.executeScript("arguments[0].click();", terceiraLista);
		
		WebElement itemTerceiraLista = driver.findElement(By.xpath("//span[text()='Inglaterra']"));
		js.executeScript("arguments[0].click();", itemTerceiraLista);
		
		driver.findElement(By.xpath("//span[text()='Homem']/ancestor::ul/preceding-sibling::input")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Homem']")));
		driver.findElement(By.xpath("//span[text()='Homem']")).click();
		
		driver.findElement(By.xpath("//span[text()='Masculino']/ancestor::ul/preceding-sibling::input")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Masculino']")));
		driver.findElement(By.xpath("//span[text()='Masculino']")).click();
		
		
		WebElement listaSelecao = driver.findElement(By.xpath("//select[@id='dropdown']"));
		Select listaDesenhoFavorito = new Select(listaSelecao);
		listaDesenhoFavorito.selectByIndex(3);
//		//listaDesenhoFavorito.selectByValue("2");
//		//listaDesenhoFavorito.selectByVisibleText("Firefox");
	}
}
