package Produto;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class testeCadastroProduto {
	
	FirefoxDriver pagina;
	
	
	
	@Before
	public void antes() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\181620013.SENACINFO\\eclipse\\java-oxygen\\eclipse\\geckodriver.exe");
		pagina = new FirefoxDriver();
		pagina.get("https://10.10.139.4/n162/ClinicaOftalmo/index.php");
		
		WebElement email = pagina.findElementById("email"); 
		WebElement senha = pagina.findElementById("senha");
		WebElement entrar = pagina.findElementByClassName("entrar");
		
		email.sendKeys("bruno@br.com");
		senha.sendKeys("123456");
		entrar.click();
		
		WebElement produto = pagina.findElementByXPath("/html/body/header/a[1]/button");
		produto.click();
		
		WebElement cadastrarProduto = pagina.findElementByXPath("/html/body/a/button");
		cadastrarProduto.click();
		
	}
	
	
	
	
	@Test
	public void test() {
		
		WebElement etNome = pagina.findElementByName("nome");
		WebElement etPreco = pagina.findElementByName("preco");
		WebElement etQuantidade = pagina.findElementByName("quantidade");
		WebElement etCodigoBarras = pagina.findElementByName("codBarras");
		Select categoria;
		categoria = new Select(pagina.findElementByName("categoria"));
		WebElement btnSalvar = pagina.findElementByXPath("/html/body/form/input[6]");
		
		etNome.sendKeys("Coca-Cola");
		etPreco.sendKeys("10");
		etQuantidade.sendKeys("30");
		etCodigoBarras.sendKeys("132321145");
		categoria.selectByIndex(2);
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
