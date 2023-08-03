package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{

    //#region Região dos WebElement
    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;

    @FindBy(css = "form.form-login>div.alert>span") //pegou dentro do form e do login, uma query
    public WebElement spanMensagem;
    //#endregion Região dos WebElement
    //#region Construtores
    /**
     * Construtor padrão para criação de uma nova instancia da pagina de Login.
     * @param driver
     */
    public LoginPO(WebDriver driver) {
        super(driver);
    }
    //#endregion Construtores
    //#region Métodos
    /*Método que obtém a mensagem disparada na tela. */
    public String obterMensagem(){
        return this.spanMensagem.getText();
    }
    
    /**
     * Método que tenta executar a ação de logar no sistema.
     * @param email Email para tentativa de login.
     * @param senha Senha para tentativa de login.
     */
    public void executarAcaoDeLogar(String email, String senha){
        escrever(inputEmail, email);
        escrever(inputSenha, senha);
        buttonEntrar.click(); 
    }
    //#endregion Métodos
}
