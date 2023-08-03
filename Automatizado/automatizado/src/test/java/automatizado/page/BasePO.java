package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para criação das novas PagesObjects.
 * Toda as pages devem ser herdadas desta classe.
 */
public abstract class BasePO {
    
    /**Driver base que será usado pelas pages. */
    protected WebDriver driver;

    /**
     * Construtor base para criação da fabrica de elementos.(PageFactory).
     * @param driver Driver da página atual.
     */
    public BasePO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Método que retorna o titulo da pagina atual.
     * @return
     */
    public String obterTituloPagina(){
        return driver.getTitle();
    }

    /**
     * Método que sabe escrever em qualquer WebElement do tipo input.
     * @param input
     * @param texto
     */
    public void escrever(WebElement input, String texto){ //exemplo da lógica feita no LoginTest
        input.clear();
        input.sendKeys(texto + Keys.TAB);
    }
}
