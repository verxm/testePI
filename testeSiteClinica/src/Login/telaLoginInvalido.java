package Login;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class telaLoginInvalido {
	
	FirefoxDriver pagina;
	private WebElement btnSair;
	
	
	@Before
	public void antes() {
		System.setProperty("webdriver.gecko.driver", "C:\\uc13\\geckodriver.exe");
		pagina = new FirefoxDriver();
		pagina.get("https://10.10.139.4/n162/ClinicaOftalmo/index.php");
		
	}
	
	
	
	@Test
	public void test() {
		WebElement email = pagina.findElementById("email"); 
		WebElement senha = pagina.findElementById("senha");
		WebElement entrar = pagina.findElementByClassName("entrar");
		
		email.sendKeys("davi.santos@linx.com");
		senha.sendKeys("123456");
		entrar.click();
		
		try {
			btnSair = pagina.findElementByXPath("/html/body/header/a[3]/button");
			JOptionPane.showMessageDialog(null, "Teste de Login Inválido apresentando erro. O login ou senha que não constam no banco deram acesso ao site");
			
		}catch (Exception e) {
			String mensagem = "Teste de Login Inválido realizado com êxito!";
			JOptionPane.showMessageDialog(null, mensagem);
		}
		
		
	}
	
	
	
	@After
	public void depois() {
		pagina.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
