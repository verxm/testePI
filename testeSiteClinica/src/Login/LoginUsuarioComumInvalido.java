package Login;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginUsuarioComumInvalido {
	
	FirefoxDriver pagina;
	private WebElement btnSair;
	
	
	@Before
	public void antes() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\181620013.SENACINFO\\eclipse\\java-oxygen\\eclipse\\geckodriver.exe");
		pagina = new FirefoxDriver();
		pagina.get("https://10.10.139.4/n162/ClinicaOftalmo/index.php");
		
	}
	
	
	
	@Test
	public void test() {
		WebElement email = pagina.findElementById("email"); 
		WebElement senha = pagina.findElementById("senha");
		WebElement entrar = pagina.findElementByClassName("entrar");
		
		email.sendKeys("teste@br.com");
		senha.sendKeys("1236");
		entrar.click();
		
		try {
			btnSair = pagina.findElementByXPath("/html/body/header/a[3]/button");
			JOptionPane.showMessageDialog(null, "Falha no teste de login de usuário comum inválido");
			
		}catch (Exception e) {
			String mensagem = "Teste de login de usuário comum inválido realizado com êxito";
			JOptionPane.showMessageDialog(null, mensagem);
		}
		
		
		
		
	}
	
	
	
	
	
	
	@After
	public void depois() {
		pagina.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
