package Produto;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class testeCadastroProduto {
	
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
		
		btnSalvar.click();
			
		try {
			WebElement botaoConfirmaTeste = pagina.findElementByXPath("/html/body/a/button");
			JOptionPane.showMessageDialog(null, "Produto Cadastrado com sucesso");
		} catch (Exception e) {
			String mensagem = "Teste encontrou algum erro pois não chegou ao resultado esperado";
			JOptionPane.showMessageDialog(null, mensagem);
		}
		
		
		
	}
	
	
	
	@After
	public void depois() {
		pagina.close();
		
	}
	
	
	
	

}
