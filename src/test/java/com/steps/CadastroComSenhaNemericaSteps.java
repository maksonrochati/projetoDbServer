package com.steps;

import com.pages.CadastroComSenhaNemericaPage;
import com.pages.WebPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CadastroComSenhaNemericaSteps {

    WebDriver driver;
    CadastroComSenhaNemericaPage realizaCadastroNumerico;

    @Dado("que esteja na pagina login")
    public void que_esteja_na_pagina_de_login() {
        driver = WebPage.createChrome();
        realizaCadastroNumerico = new CadastroComSenhaNemericaPage(driver);
    }
    @Dado("seleciono o botao novo usuario")
    public void clico_no_botao_novo_usuario() {
        realizaCadastroNumerico.clickButtonNovoUsuario();
    }
    @Quando("informo primeiro nome {string} e o sobrenome {string}")
    public void informo_primeiro_nome_e_sobrenome(String primeiroNome, String sobrenome) {

        realizaCadastroNumerico.setPrimeiroNome(primeiroNome);
        realizaCadastroNumerico.setSobrenome(sobrenome);
    }
    @Quando("informo nome de usuario {string} e a senha {string}")
    public void informo_nome_de_usuario_e_senha(String nomeUsuario, String senha) {
        realizaCadastroNumerico.setNomeUsuario(nomeUsuario);
        realizaCadastroNumerico.setSenha(senha);
    }
    @Quando("seleciono que não sou robo")
    public void clico_que_não_sou_robo() {
        realizaCadastroNumerico.clickCheckboxNaoSouRobo();
    }
    @Quando("clico no botao registrar")
    public void clico_no_botao_para_registro() {
        realizaCadastroNumerico.clickButtonRegistro();
    }
    @Entao("deve retornar mensagem de erro")
    public void deve_retornar_mensagem_de_erro() {
        String msgErro = realizaCadastroNumerico.getMensagemDeErro();
        Assert.assertEquals(msgErro, "Passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer.");
        driver.close();
    }



}


