package Produto;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testeRetirarQuantidadeProduto {
	
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
		
	}
	
	
	
	@Test
	public void test() {
		
		String quantidadeAtualText = pagina.findElementByXPath("/html/body/table/tbody/tr[2]/td[5]").getText();
		
		int quantidadeAtual = Integer.valueOf(quantidadeAtualText);
		
		WebElement etRetirar = pagina.findElementByXPath("/html/body/table/tbody/tr[2]/td[10]/form/input[1]");
		etRetirar.sendKeys("3");
		
		WebElement btnRetirar = pagina.findElementByXPath("/html/body/table/tbody/tr[2]/td[10]/form/input[2]");
		btnRetirar.click();
		
		int quantidadeDepois = quantidadeAtual - 3;
		
		if(quantidadeDepois == quantidadeAtual) {
			JOptionPane.showMessageDialog(null, "Erro ao retirar quantidade do produto");
		}else {
			JOptionPane.showMessageDialog(null, "Quantidade alterada com sucesso!");
		}
		
		
		
		
	}
	
	
	
	

	@After
	public void depois() {
		pagina.close();
		
	}
	

	

}
