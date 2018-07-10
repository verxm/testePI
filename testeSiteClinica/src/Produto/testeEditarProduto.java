package Produto;

import javax.swing.JOptionPane;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class testeEditarProduto {
	
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
		
		
		
		
		
		
		
		
		
		//TESTAR SE OS DADOS ESTÃO SENDO SETADOS NO FORMULARIO
		String nomeProduto = pagina.findElementByXPath("/html/body/table/tbody/tr[2]/td[3]").getText();
		String precoProduto = pagina.findElementByXPath("/html/body/table/tbody/tr[2]/td[4]").getText();
		String quantidadeProduto = pagina.findElementByXPath("/html/body/table/tbody/tr[2]/td[5]").getText();
		String categoriaProduto = pagina.findElementByXPath("/html/body/table/tbody/tr[2]/td[6]").getText();
		String codBarraProduto = pagina.findElementByXPath("/html/body/table/tbody/tr[2]/td[7]").getText();

		
		WebElement btnEditar = pagina.findElementByXPath("/html/body/table/tbody/tr[2]/td[8]/a/button");
		btnEditar.click();
		
		boolean valoresSetados = true;
		
		String nomeFormulario = pagina.findElementByXPath("/html/body/form/input[1]").getText();
		if(!nomeFormulario.equals(nomeProduto)) {
			valoresSetados = false;
		}
		
		String precoFormulario = pagina.findElementByXPath("/html/body/form/input[2]").getText();
		if(!precoFormulario.equals(precoProduto)) {
			valoresSetados = false;
		}
		
		String quantidadeFormulario = pagina.findElementByXPath("/html/body/form/input[3]").getText();
		if(!quantidadeFormulario.equals(quantidadeProduto)) {
			valoresSetados = false;
		}
		
		String codBarrasFormulario = pagina.findElementByXPath("/html/body/form/input[4]").getText();
		if(!codBarraProduto.equals(codBarrasFormulario)) {
			valoresSetados = false;
		}
		
		Select categorias = new Select(pagina.findElementByXPath("/html/body/form/select"));
		String categoriaSelecionada = categorias.getFirstSelectedOption().getText();
		if(!categoriaSelecionada.equals(categoriaProduto)) {
			valoresSetados = false;
		}
		
		
		if(valoresSetados == false) {
			JOptionPane.showMessageDialog(null, "Os dados do produto não estão sendo setados no formulário ao clicar no botão EDITAR");
		}
		
		
		
		
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
		
		etNome.sendKeys("Primeiro");
		etPreco.sendKeys("50");
		etQuantidade.sendKeys("30");
		etCodigoBarras.sendKeys("134445");
		categoria.selectByIndex(1);
		
		btnSalvar.click();
			
		try {
			WebElement botaoConfirmaTeste = pagina.findElementByXPath("/html/body/a/button");
			JOptionPane.showMessageDialog(null, "Produto editado com sucesso");
		} catch (Exception e) {
			String mensagem = "Teste encontrou algum erro pois não chegou ao resultado esperado";
			JOptionPane.showMessageDialog(null, mensagem);
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
