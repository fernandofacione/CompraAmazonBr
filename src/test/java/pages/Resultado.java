package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Resultado {
    WebDriver driver;


    @FindBy (css = "h2")
    WebElement indicadorDeProduto;

    @FindBy (css = "#productTitle")
    WebElement btnProduto;

    @FindBy (css = "submit.add-to-cart")
    WebElement btnCarrinho;

    public Resultado(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String lerIndicadorDeProduto() {
        return indicadorDeProduto.getText();

    }

    public void clicarProduto(){
        btnProduto.click();
    }

    public void clicarCarrinho(){
        btnCarrinho.click();

    }

    public By verificarElemento() {
        return By.cssSelector("h2");
    }
}
