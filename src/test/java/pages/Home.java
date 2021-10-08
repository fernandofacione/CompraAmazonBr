package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
    // Classe de Mapeamento possui 3 se��es
    // 1 - Mapeamento de Elementos (Atributos)
    // 2 - Construtor entre os Elementos e os Passos
    // 3 - Fun��es e M�todos Mapeados

    // 1 - Mapeamento
    WebDriver driver;

    @FindBy(id = "twotabsearchtextbox")
    WebElement caixaPesquisa; //txtPesquisa
    // Similar ao que faziamos antes:
    // driver.findElement(By.id("searchText"))

    @FindBy(id = "nav-search-submit-button")
    WebElement botaoProcurar; //btnProcurar

    // 2 - Construtor

    public Home(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    // 3 - Fun��es e M�todos
    public void pesquisarProduto(String produto){
        caixaPesquisa.click();            // clicar na caixa
        caixaPesquisa.clear();            // limpar a caixa
        caixaPesquisa.sendKeys(produto);    // escrever na caixa
    }
    public void clicarLupa(){
        botaoProcurar.click();              // clicar no bot�o
    }

}
