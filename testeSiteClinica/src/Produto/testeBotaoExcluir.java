package Produto;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testeBotaoExcluir {
	
	FirefoxDriver pagina;
	
	@Before
	public void antes() {
		System.setProperty("webdriver.gecko.driver", "C:\\uce13\\geckodriver.exe");
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
		
	}
	
	
	@Test
	public void test() {
		String idProduto = pagina.findElementByXPath("/html/body/table/tbody/tr[2]/td[1]").getText();
		
		WebElement btnExcluir = pagina.findElementByXPath("/html/body/table/tbody/tr[2]/td[9]/a/button");
		btnExcluir.click();
		
		String primeiroProduto = pagina.findElementByXPath("/html/body/table/tbody/tr[2]/td[1]").getText();
		
		if(!primeiroProduto.equals(idProduto)) {
			JOptionPane.showMessageDialog(null, "Produto excluido com sucesso!");
		}else {
			JOptionPane.showMessageDialog(null, "Erro ao excluir produto.");
		}
	}
	
	
	
	
	
	
	
	@After
	public void depois() {
		pagina.close();
		
	}
	
	
	
	
	
	
	
	
	

}
