package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.builder.ProdutoBuilder;
import automatizado.page.ControleDeProdutoPO;
import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTest extends BaseTest{
    
    private static LoginPO loginPage;
    private static ControleDeProdutoPO controleProdutoPage;

    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

        controleProdutoPage = new ControleDeProdutoPO(driver);
        assertEquals(controleProdutoPage.obterTituloPagina(), "Controle de Produtos");
    }

    @Test
    public void TC000_deveAbrirModalParaCadastroAoClicarNoBotaoCriar(){
        controleProdutoPage.buttonAdicionar.click();
        controleProdutoPage.buttonAdicionar.click();

        String titulo = controleProdutoPage.tituloModal.getText();
        assertEquals("Produto", titulo);
        controleProdutoPage.buttonSair.click();
        controleProdutoPage.buttonSair.click();//É preciso clicar nos botões duas vezes na primeira vez, erro que seria passado pro dev.
    }

    @Test
    public void TC001_deveManterNaMesmaPáginaAoClicarNaLogoDeControleDeProdutos(){
        controleProdutoPage.linkControledeprodutos.click();
        //controleProdutoPage.linkControledeprodutos.click(); //** Duas vezes apenas se testar esse caso separadamente
        String tabela = controleProdutoPage.columnheaderCodigo.getText();
        assertEquals("Código", tabela);
    }

    @Test
    public void TC002_deveVoltarParaTelaDeLoginAoClicarNaOpçãoDeVoltarQueEstáNaBarraDeTitulo(){
        controleProdutoPage.linkVoltar.click();
        assertEquals(loginPage.obterTituloPagina(), "Login");
        loginPage.executarAcaoDeLogar("admin@admin.com","admin@123");
    }

    /*@Test
    public void TC010_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos(){
        controleProdutoPage.buttonAdicionar.click();
        controleProdutoPage.cadastrarProduto("0001", "Martelo", 10, 59.9, "");

        String mensagem = controleProdutoPage.spanMensagem.getText();
        assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
    }*/

    @Test
    public void TC0100_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos(){
        controleProdutoPage.buttonAdicionar.click();
        controleProdutoPage.buttonAdicionar.click();
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage); //Aqui cria o objeto para adicionar na tela
        produtoBuilder
        .adicionarData("null")
        .builder();//Aqui ele realmente adiciona as informações na tela.
        
        String mensagem = controleProdutoPage.spanMensagem.getText();
        assertEquals("Todos os campos são obrigatórios para o cadastro!", mensagem);
    }
}
