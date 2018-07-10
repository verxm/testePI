package Categoria;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testeBotaoCategorias {
	
	FirefoxDriver pagina;
	
	
	@Before
	public void antes() {
		System.setProperty("webdriver.gecko.driver", "C:\\uc13\\geckodriver.exe");
		pagina = new FirefoxDriver();
		pagina.get("https://10.10.139.4/n162/ClinicaOftalmo/index.php");
		
		WebElement email = pagina.findElementById("email"); 
		WebElement senha = pagina.findElementById("senha");
		WebElement entrar = pagina.findElementByClassName("entrar");
		
		email.sendKeys("bruno@br.com");
		senha.sendKeys("123456");
		entrar.click();
		
		WebElement btncategoria = pagina.findElementByXPath("/html/body/header/a[2]/button");
		btncategoria.click();
		
	}
	
	@Test
	public void test() {
		
		WebElement nome = pagina.findElementByXPath("/html/body/form/input[1]");
		WebElement salvar = pagina.findElementByXPath("/html/body/form/input[2]");
		
		nome.sendKeys("arrozPrimeiro");
		salvar.click();
	
		
	}
	
	
	@After
	public void depois() {
		pagina.close();
		
	}
	

}
