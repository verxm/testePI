package Login;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class telaLoginValido {
	
	FirefoxDriver pagina;
	private WebElement btnSair;
	
	
	@Before
	public void antes() {
		System.setProperty("webdriver.gecko.driver", "C:\\uce13\\geckodriver.exe");
		pagina = new FirefoxDriver();
		pagina.get("https://10.10.139.4/n162/ClinicaOftalmo/index.php");
		
	}
	
	
	
	@Test
	public void test() {
		WebElement email = pagina.findElementById("email"); 
		WebElement senha = pagina.findElementById("senha");
		WebElement entrar = pagina.findElementByClassName("entrar");
		
		email.sendKeys("bruno@br.com");
		senha.sendKeys("123456");
		entrar.click();
		
		try {
			btnSair = pagina.findElementByXPath("/html/body/header/a[3]/button");
			JOptionPane.showMessageDialog(null, "Teste de login realizado com êxito");
			
		}catch (Exception e) {
			String mensagem = "Erro no login";
			JOptionPane.showMessageDialog(null, mensagem);
		}
		
		
		
	}
	
	
	@After
	public void depois() {
		pagina.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
