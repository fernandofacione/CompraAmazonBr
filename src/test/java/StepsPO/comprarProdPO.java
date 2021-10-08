package StepsPO;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Home;
import pages.Resultado;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class comprarProdPO {
    WebDriver driver;
    WebDriverWait wait;

    Home home;
    Resultado resultado;

    @Before
    public void iniciar(){
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/94/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 5,1);
        home = new Home(driver);
        resultado = new Resultado(driver);

        System.out.println("Passo 0-Classe");
    }

    @After
    public void finalizar(){
        driver.quit();
        System.out.println("Passo Z-Classe");
    }

    @Dado("^que acesso o site da Amazon  PO$")
    public void queAcessoOSiteDaIterasysPO() {
        driver.get("https://amazon.com.br");
        System.out.println("Passo 1");
    }

    @Quando("^pesquiso por \"([^\"]*)\" PO$")
    public void pesquisoPorProdutoPO(String produto)  {
        home.pesquisarProduto(produto);
        driver.findElement(By.id("twotabsearchtextbox")).click();                //Opcional
        driver.findElement(By.id("twotabsearchtextbox")).clear();                //Opcional
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.chord(produto)); // Nome do produto
        System.out.println("2 - Digitou o nome do curso como " + produto);
    }

    @E("^clico na Lupa PO$")
    public void clicoLupaPO() {
        home.clicarLupa();
        System.out.println("Passo 3");
    }

    @Entao("^vejo a lista de resultados para o produto \"([^\"]*)\" PO$")
    public void vejoAListaDeResultadosParaOProdutoPO(String produto) {
        String textoEsperado = "https://www.amazon.com.br/Cafeteira-Espresso-PrimaLatte-Oster-BVSTEM6701B-017/dp/B076HRL85S/ref=sr_1_1?__mk_pt_BR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=Cafeteira+Expresso+Prima+Latte+II%2C+Vermelho%2C+110v%2C+Oster&qid=1632702286&sr=8-1&ufe=app_do%3Aamzn1.fos.25548f35-0de7-44b3-b28e-0f56f3f96147";
        wait.until(ExpectedConditions.textToBe(resultado.verificarElemento(),textoEsperado));
        assertEquals(resultado.lerIndicadorDeProduto(), textoEsperado);
        System.out.println("Passo 4");
    }

    @Quando("^clico no Produto PO$")
    public void clicoNoProdutoPO() {
        resultado.clicarProduto();
        System.out.println("Passo 5");
    }

    @Quando("^clico em Adicionar ao Carrinho PO$")
    public void clicoAdicionarCarrinhoPO() {
        resultado.clicarCarrinho();
        System.out.println("Passo 6");
    }

    @Entao("^confirmo produto no carrinho PO$")
    public void confirmoONomeDoProdutoPO(String arg0, String arg1)  {
        System.out.println("Passo 7");
    }

}