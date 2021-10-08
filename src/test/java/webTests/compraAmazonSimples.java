// 1 - Pacote
package webTests;

// 2 - Bibliotecas

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Evidencias;
import utils.Logs;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

// 3 - Classe
public class compraAmazonSimples {
    // 3.1 - Atributos

    WebDriver driver;                           // declarar o objeto do Selenium WebDriver
    Evidencias evidencias;
    Logs logs;
    static String dataHora = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());

    // 3.2 - Métodos e Funções

    // Executa 1 vez apenas, no início da execução do script
    @BeforeClass
    public void antesDeTudo() throws IOException {
        logs = new Logs();
        logs.iniciarLogCSV(dataHora);
    }

    // Executa antes de cada @Test
    @BeforeMethod
    public void iniciar(){
        // A - Início
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/94/chromedriver.exe"); // Aponta para onde está o driver do Chrome
        // Instancia o objeto driver como um controlador do Chrome
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);

        evidencias = new Evidencias(); // instanciar

    }

    @AfterMethod
    public void finalizar(){
        // Parte C - Encerramento

        driver.quit(); // Encerra o objeto do Selenium

    }

    @Test
    public void consultarProdutoAmazon() throws IOException {
        String casoDeTeste = "Cafeteira Single, Vermelho, 110v, Cadence";
        // B - Realizar o teste
        logs.registrarCSV(casoDeTeste,"Iniciou o teste");
        driver.get("https://www.amazon.com.br");                              // Abre o site alvo informado
        logs.registrarCSV(casoDeTeste,"Abriu o site");
        evidencias.print(driver, dataHora, casoDeTeste, "Passo 1 - Abriu o site");

        driver.findElement(By.id("twotabsearchtextbox")).click();                        // Clica no campo de pesquisa
        logs.registrarCSV(casoDeTeste,"Clicou na caixa de pesquisa");
        driver.findElement(By.id("twotabsearchtextbox")).clear();                        // Limpa o campo de pesquisa
        logs.registrarCSV(casoDeTeste,"Limpou a caixa de pesquisa");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Cafeteira Single, Vermelho, 110v, Cadence");  // Escreve o nome do produto no campo de pesquisa
        logs.registrarCSV(casoDeTeste,"Abriu o site Amazon");

        evidencias.print(driver, dataHora, casoDeTeste,"Passo 2 - Digitou o Nome do Produto e clicou na lupa");
        driver.findElement(By.id("nav-search-submit-button")).click();                   // Clique na lupa
        logs.registrarCSV(casoDeTeste,"Digitou produto no campo de pesquisa e clicou no botão Lupa");

        evidencias.print(driver, dataHora, casoDeTeste,"Passo 3 - Exibiu a lista de produtos");
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[3]/div[2]/div[3]/div[1]/span[1]/div[1]/div[1]/span[1]/a[1]")).click();
        logs.registrarCSV(casoDeTeste,"Exibiu o resultado da pesquisa");

        evidencias.print(driver, dataHora, casoDeTeste,"Passo 4 - Acessou o produto");
        driver.findElement(By.id("add-to-cart-button")).click();             // Clica no botão adicionar ao carrinho
        logs.registrarCSV(casoDeTeste,"Clicou sobre o produto a ser comprado");

        evidencias.print(driver, dataHora, casoDeTeste,"Passo 5 - Incluiu produto no carrinho");
        driver.findElement(By.id("nav-cart-count")).click();             // Clica no botão do carrinho de compras
        logs.registrarCSV(casoDeTeste,"Clicou no botão Adicionar ao carrinho");
        evidencias.print(driver, dataHora, casoDeTeste,"Passo 6 - Acessou o carrinho de compras");

        assertEquals(driver.findElement(By.cssSelector("body.a-m-br.a-aui_149818-c.a-aui_152852-c.a-aui_157141-c.a-aui_160684-c.a-aui_57326-c.a-aui_72554-c.a-aui_accessibility_49860-c.a-aui_attr_validations_1_51371-c.a-aui_bolt_62845-c.a-aui_pci_risk_banner_210084-c.a-aui_perf_130093-c.a-aui_tnr_v2_180836-c.a-aui_ux_113788-c.a-aui_ux_114039-c.a-aui_ux_138741-c.a-aui_ux_145937-c.a-aui_ux_60000-c:nth-child(2) div.a-container.sc-background-dark:nth-child(5) div.a-section.a-spacing-none div.a-fixed-right-flipped-grid:nth-child(3) div.a-fixed-right-grid-inner div.a-fixed-right-grid-col.sc-retail-cart-column-spacing.a-col-left:nth-child(2) div.a-cardui.sc-card-style.sc-list.sc-java-remote-feature.celwidget.sc-grid-view.sc-grid-full-width.sc-card-spacing-top-none:nth-child(1) div.a-cardui-body.a-scroller-none div.a-section.a-spacing-mini.a-spacing-top-medium-plus.sc-list-body.sc-java-remote-feature:nth-child(7) div.a-row.sc-list-item.sc-java-remote-feature div.sc-list-item-content div.a-row.a-grid-vertical-align.a-grid-top.sc-list-item-content-inner div.sc-item-content-group ul.a-unordered-list.a-nostyle.a-vertical.a-spacing-base li.a-spacing-mini:nth-child(1) span.a-list-item a.a-link-normal.sc-product-link span.a-size-base-plus.a-color-base.sc-product-title span.a-truncate.a-size-base-plus > span.a-truncate-cut")).getText(), "Cafeteira Single, Vermelho, 110v, Cadence");
        logs.registrarCSV(casoDeTeste,"Confirmou o nome do Produto Cafeteira Single, Vermelho, 110v, Cadence");
        assertEquals(driver.findElement(By.cssSelector("body.a-m-br.a-aui_149818-c.a-aui_152852-c.a-aui_157141-c.a-aui_160684-c.a-aui_57326-c.a-aui_72554-c.a-aui_accessibility_49860-c.a-aui_attr_validations_1_51371-c.a-aui_bolt_62845-c.a-aui_pci_risk_banner_210084-c.a-aui_perf_130093-c.a-aui_tnr_v2_180836-c.a-aui_ux_113788-c.a-aui_ux_114039-c.a-aui_ux_138741-c.a-aui_ux_145937-c.a-aui_ux_60000-c:nth-child(2) div.a-container.sc-background-dark:nth-child(5) div.a-section.a-spacing-none div.a-fixed-right-flipped-grid:nth-child(3) div.a-fixed-right-grid-inner div.a-fixed-right-grid-col.sc-retail-cart-column-spacing.a-col-left:nth-child(2) div.a-cardui.sc-card-style.sc-list.sc-java-remote-feature.celwidget.sc-grid-view.sc-grid-full-width.sc-card-spacing-top-none:nth-child(1) div.a-cardui-body.a-scroller-none div.a-section.a-spacing-mini.a-spacing-top-medium-plus.sc-list-body.sc-java-remote-feature:nth-child(7) div.a-row.sc-list-item.sc-java-remote-feature div.sc-list-item-content div.a-row.a-grid-vertical-align.a-grid-top.sc-list-item-content-inner div.sc-item-content-group ul.a-unordered-list.a-nostyle.a-vertical.a-spacing-base p.a-spacing-mini:nth-child(2) > span.a-size-medium.a-color-base.sc-price.sc-white-space-nowrap.sc-product-price.a-text-bold")).getText(), "R$ 97,79");
        logs.registrarCSV(casoDeTeste,"Confirmou o preço do Produto Cafeteira Single, Vermelho, 110v, Cadence");
        evidencias.print(driver, dataHora, casoDeTeste,"Passo 7 - Exibiu o carrinho de compras");
        logs.registrarCSV(casoDeTeste,"Concluiu o teste");

        }


}
