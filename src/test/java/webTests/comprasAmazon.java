package webTests;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertEquals;

public class comprasAmazon {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void iniciar() {
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/94/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize(); // Maximizar a janela

        wait = new WebDriverWait(driver,5,1); // espera até 60 segundos

        System.out.println("0 - Antes do Teste iniciar");
    }

    @After
    public void finalizar() {
        driver.quit();
        System.out.println("Z - Depois do Teste finalizar");
    }


    @Dado("^que acesso o site da Amazon$")
    public void queAcessoOSiteDaAmazon() {
        driver.get("https://www.amazon.com.br");
        System.out.println("1 - Acessou o site");
    }

    @Quando("^pesquiso por \"([^\"]*)\"$")
    public void pesquisoPor(String produto) {
        driver.findElement(By.id("nav-search-bar-form")).click();                //Opcional
        driver.findElement(By.id("nav-search-bar-form")).clear();                //Opcional
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.chord(produto)); // Escreve o nome do curso letra por letra
        System.out.println("2 - Digitou o nome do produto como " + produto);
    }

    @E("^clico na Lupa$")
    public void clicoNaLupa() {
        driver.findElement(By.id("nav-search-submit-button")).click();
        System.out.println("3 - Clicou na lupa");
    }

    @Entao("^vejo a lista de resultados para o produto \"([^\"]*)\"$")
    public void vejoAListaDeResultadosParaOProduto(String produto) {
        String textoEsperado = "Produtos › \"" + produto + "\"";
        wait.until(ExpectedConditions.textToBe(By.cssSelector("h2"), textoEsperado));
        assertEquals(driver.findElement(By.cssSelector("h2")).getText(), "Cursos › \"" + produto + "\"");
        System.out.println("4 - Exibiu a lista de resultados para o produto " + produto);
    }

    @Quando("^clico em Matricule-se$")
    public void clicoEmMatriculeSe() {
        driver.findElement(By.cssSelector("span.comprar")).click();
        System.out.println("5 - Clicou em Matricule-se");
    }

    @Entao("^confirmo o nome do curso como \"([^\"]*)\" e o preco de \"([^\"]*)\"$")
    public void confirmoONomeDoCursoComoEOPrecoDe(String curso, String preco) {
        //wait.until(ExpectedConditions.textToBe(By.cssSelector("span.item-title"),curso));

        wait.until(ExpectedConditions.textToBe(By.cssSelector("span.item-title"),curso));
        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText(), curso);
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(), preco);
        System.out.println("6 - Confirmou o nome como " + curso + " e o preco do curso como " + preco);

    }

    @E("^pressiono Enter$")
    public void pressionoEnter() {
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
        System.out.println("3a - Pressionou o Enter");
    }

    @Quando("^clico na imagem de um curso$")
    public void clicoNaImagemDeUmCurso()  {


        WebElement ele = driver.findElement(By.xpath("//body/main[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/a[1]"));

        Actions action = new Actions(driver);
        action.moveToElement(ele).perform();

        ele.click();

        System.out.println("3 - Clicou no curso");
    }

    @Entao("^vejo a pagina com detalhes do curso$")
    public void vejoAPaginaComDetalhesDoCurso() {
        wait.until(ExpectedConditions.titleIs("Mantis - Iterasys"));
        assertEquals(driver.getTitle(),"Mantis - Iterasys");
        System.out.println("4 - Exibiu a página de detalhes do curso");
    }

    @E("^clico no botao Ok do popup da LGPD$")
    public void clicoNoBotaoOkDoPopupDaLGPD() {
        driver.findElement(By.cssSelector("a.cc-btn.cc-dismiss")).click();
        System.out.println("2 - Clicou no botão ok do popup");
    }
}