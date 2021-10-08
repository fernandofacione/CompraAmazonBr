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
        driver.get("https://www.amazon.com.br/");
        System.out.println("1 - Acessou o site");
    }

    @Quando("^pesquiso por \"([^\"]*)\"$")
    public void pesquisoPor(String produto) {
        driver.findElement(By.id("twotabsearchtextbox")).click();                //Opcional
        driver.findElement(By.id("twotabsearchtextbox")).clear();                //Opcional
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
        String textoEsperado = produto;
        wait.until(ExpectedConditions.textToBe(By.cssSelector("h2"), textoEsperado));
        assertEquals(driver.findElement(By.cssSelector("h2")).getText(), produto);
        System.out.println("4 - Exibiu a lista de resultados para o produto " + produto);
    }

    @Quando("^clico sobre o produto definido$")
    public void clicoSobreOProduto() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[3]/div[2]/div[3]/div[1]/span[1]/div[1]/div[1]/span[1]/a[1]")).click();
        System.out.println("5 - Clicou No Produto Definido");
    }

    @Quando("^clico adicionar produto no carrinho$")
    public void clicoBotaoAdicionarCarrinho() {
        driver.findElement(By.id("add-to-cart-button")).click();
        System.out.println("6 - Clicado Para Adicionar Produto No Carrinho");
    }

    @Quando("^acesso carrinho de compras$")
    public void clicoCarrinhoDeCompras() {
        driver.findElement(By.id("nav-cart-count")).click();
        System.out.println("7 - Clicado Para ir ao Carrinho de Compras");
    }

    @Entao("^confirmo o nome do produto como \"([^\"]*)\" e o preco de \"([^\"]*)\"$")
    public void confirmoONomeDoCursoComoEOPrecoDe(String produto, String preco) {
        //wait.until(ExpectedConditions.textToBe(By.cssSelector("span.item-title"),curso));

        wait.until(ExpectedConditions.textToBe(By.cssSelector("body.a-m-br.a-aui_149818-c.a-aui_152852-c.a-aui_157141-c.a-aui_160684-c.a-aui_57326-c.a-aui_72554-c.a-aui_accessibility_49860-c.a-aui_attr_validations_1_51371-c.a-aui_bolt_62845-c.a-aui_pci_risk_banner_210084-c.a-aui_perf_130093-c.a-aui_tnr_v2_180836-c.a-aui_ux_113788-c.a-aui_ux_114039-c.a-aui_ux_138741-c.a-aui_ux_145937-c.a-aui_ux_60000-c:nth-child(2) div.a-container.sc-background-dark:nth-child(5) div.a-section.a-spacing-none div.a-fixed-right-flipped-grid:nth-child(3) div.a-fixed-right-grid-inner div.a-fixed-right-grid-col.sc-retail-cart-column-spacing.a-col-left:nth-child(2) div.a-cardui.sc-card-style.sc-list.sc-java-remote-feature.celwidget.sc-grid-view.sc-grid-full-width.sc-card-spacing-top-none:nth-child(1) div.a-cardui-body.a-scroller-none div.a-section.a-spacing-mini.a-spacing-top-medium-plus.sc-list-body.sc-java-remote-feature:nth-child(7) div.a-row.sc-list-item.sc-java-remote-feature div.sc-list-item-content div.a-row.a-grid-vertical-align.a-grid-top.sc-list-item-content-inner div.sc-item-content-group ul.a-unordered-list.a-nostyle.a-vertical.a-spacing-base li.a-spacing-mini:nth-child(1) span.a-list-item a.a-link-normal.sc-product-link span.a-size-base-plus.a-color-base.sc-product-title span.a-truncate.a-size-base-plus > span.a-truncate-cut"),produto));
        assertEquals(driver.findElement(By.cssSelector("body.a-m-br.a-aui_149818-c.a-aui_152852-c.a-aui_157141-c.a-aui_160684-c.a-aui_57326-c.a-aui_72554-c.a-aui_accessibility_49860-c.a-aui_attr_validations_1_51371-c.a-aui_bolt_62845-c.a-aui_pci_risk_banner_210084-c.a-aui_perf_130093-c.a-aui_tnr_v2_180836-c.a-aui_ux_113788-c.a-aui_ux_114039-c.a-aui_ux_138741-c.a-aui_ux_145937-c.a-aui_ux_60000-c:nth-child(2) div.a-container.sc-background-dark:nth-child(5) div.a-section.a-spacing-none div.a-fixed-right-flipped-grid:nth-child(3) div.a-fixed-right-grid-inner div.a-fixed-right-grid-col.sc-retail-cart-column-spacing.a-col-left:nth-child(2) div.a-cardui.sc-card-style.sc-list.sc-java-remote-feature.celwidget.sc-grid-view.sc-grid-full-width.sc-card-spacing-top-none:nth-child(1) div.a-cardui-body.a-scroller-none div.a-section.a-spacing-mini.a-spacing-top-medium-plus.sc-list-body.sc-java-remote-feature:nth-child(7) div.a-row.sc-list-item.sc-java-remote-feature div.sc-list-item-content div.a-row.a-grid-vertical-align.a-grid-top.sc-list-item-content-inner div.sc-item-content-group ul.a-unordered-list.a-nostyle.a-vertical.a-spacing-base li.a-spacing-mini:nth-child(1) span.a-list-item a.a-link-normal.sc-product-link span.a-size-base-plus.a-color-base.sc-product-title span.a-truncate.a-size-base-plus > span.a-truncate-cut")).getText(), produto);
        assertEquals(driver.findElement(By.cssSelector("body.a-m-br.a-aui_149818-c.a-aui_152852-c.a-aui_157141-c.a-aui_160684-c.a-aui_57326-c.a-aui_72554-c.a-aui_accessibility_49860-c.a-aui_attr_validations_1_51371-c.a-aui_bolt_62845-c.a-aui_pci_risk_banner_210084-c.a-aui_perf_130093-c.a-aui_tnr_v2_180836-c.a-aui_ux_113788-c.a-aui_ux_114039-c.a-aui_ux_138741-c.a-aui_ux_145937-c.a-aui_ux_60000-c:nth-child(2) div.a-container.sc-background-dark:nth-child(5) div.a-section.a-spacing-none div.a-fixed-right-flipped-grid:nth-child(3) div.a-fixed-right-grid-inner div.a-fixed-right-grid-col.sc-retail-cart-column-spacing.a-col-left:nth-child(2) div.a-cardui.sc-card-style.sc-list.sc-java-remote-feature.celwidget.sc-grid-view.sc-grid-full-width.sc-card-spacing-top-none:nth-child(1) div.a-cardui-body.a-scroller-none div.a-section.a-spacing-mini.a-spacing-top-medium-plus.sc-list-body.sc-java-remote-feature:nth-child(7) div.a-row.sc-list-item.sc-java-remote-feature div.sc-list-item-content div.a-row.a-grid-vertical-align.a-grid-top.sc-list-item-content-inner div.sc-item-content-group ul.a-unordered-list.a-nostyle.a-vertical.a-spacing-base p.a-spacing-mini:nth-child(2) > span.a-size-medium.a-color-base.sc-price.sc-white-space-nowrap.sc-product-price.a-text-bold")).getText(), preco);
        System.out.println("6 - Confirmou o nome como " + produto + " e o preco do curso como " + preco);

    }

    @E("^pressiono Enter$")
    public void pressionoEnter() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
        System.out.println("3a - Pressionou o Enter");
    }



}