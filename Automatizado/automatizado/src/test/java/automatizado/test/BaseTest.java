package automatizado.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Classe base que serve de herança para todos os testes.
 */
public abstract class BaseTest {

    /** Driver do navegador da página atual, a URL do sistema a ser testado e caminho relativo do driver referente ao path */
    protected static WebDriver driver; 
    private static final String URL_BASE = "file:///C:/Users/gabe-/OneDrive/%C3%81rea%20de%20Trabalho/Automatizado/sistema/login.html";
    private static final String CAMINHO_DRIVER = "src/test/java/automatizado/resource/chromedriver-v11405735.exe";

    /**
     * Método para iniciar o driver do navegador antes de qualquer classe de teste.
     */
    @BeforeClass
    public static void iniciar(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    /**
     * Método que finaliza o driver do navegador depois de qualquer classe de teste.
     */
    @AfterClass
    public static void finalizar(){
        driver.quit();
    }
}


