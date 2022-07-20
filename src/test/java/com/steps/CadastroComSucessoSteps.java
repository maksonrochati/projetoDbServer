package com.steps;


import com.pages.CadastroComSucessoPage;
import com.pages.LoginPage;
import com.pages.WebPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CadastroComSucessoSteps {
    WebDriver driver;
    CadastroComSucessoPage realizaCadastroSucesso;
    LoginPage objLogin;

    @Dado("que esteja na pagina de login")
    public void que_esteja_na_pagina_de_login() {
        driver = WebPage.createChrome();
        realizaCadastroSucesso = new CadastroComSucessoPage(driver);
    }
    @Dado("seleciono o botao de novo usuario")
    public void seleciono_o_botao_de_novo_usuario() {
        realizaCadastroSucesso.clickButtonNovoUsuario();
    }
    @Quando("informo o primeiro nome {string} e o sobrenome {string}")
    public void informo_o_primeiro_nome_e_o_sobrenome(String primeiroNome, String sobrenome) {
        realizaCadastroSucesso.setPrimeiroNome(primeiroNome);
        realizaCadastroSucesso.setSobrenome(sobrenome);
    }

    @Quando("informo o nome de usuario {string} e a senha {string}")
    public void informo_nome_de_usuario_e_a_senha(String nomeUsuario, String senha) {
        realizaCadastroSucesso.setNomeUsuario(nomeUsuario);
        realizaCadastroSucesso.setSenha(senha);
    }

    @Quando("seleciono que não sou um robo")
    public void seleciono_que_não_sou_um_robo() {
        realizaCadastroSucesso.clickCheckboxNaoSouRobo();
    }
    @Quando("clico no botao de registro")
    public void clico_no_botao_de_registro() {
        realizaCadastroSucesso.clickButtonRegistro();
    }

    @Quando("volto a pagina de registro")
    public void deve_retornar_a_pagina_de_registro() {
      String texto = realizaCadastroSucesso.getValidaRetornoAPaginaCadastro();
        Assert.assertEquals(texto, "Register");


    }

    @Quando("clicar no botao para voltar a pagina de login")
    public void clicar_no_botao_para_voltar_a_pagina_de_login() {
        realizaCadastroSucesso.clickButtonVolteAoLogin();
    }
    @Quando("informar nome de usuario {string} e senha {string}")
    public void informar_nome_de_usuario_e_senha(String nomeDeUsuario, String senha) {
        objLogin = new LoginPage(driver);
        objLogin.setNomeUsuario(nomeDeUsuario);
        objLogin.setSenha(senha);
    }
    @Quando("clicar no botao de login")
    public void clicar_no_botao_de_login() {
        objLogin.clickButtonRegistro();
    }

    @Entao("deve visualizar a página de perfil e o usuario {string} logado")
    public void deve_visualizar_a_página_de_perfi_e_o_usuario_logado(String usuarioLogado) {
        String nomeUsuarioLogado = objLogin.getValidaNomeUsuarioPaginaDePerfil();
        Assert.assertEquals(nomeUsuarioLogado, usuarioLogado);
        driver.close();
    }

}
