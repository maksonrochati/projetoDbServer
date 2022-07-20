package com.steps;

import com.pages.AcessaEbookDaLivrariaPage;
import com.pages.LoginPage;
import com.pages.WebPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AcessaEbookDaLivrariaSteps {
    WebDriver driver;
    AcessaEbookDaLivrariaPage acessaEbook;
    LoginPage objLogin;

    @Dado("que eacesso a pagina login")
    public void que_eacesso_a_pagina_login() {
        driver = WebPage.createChrome();
        acessaEbook = new AcessaEbookDaLivrariaPage(driver);
        objLogin = new LoginPage(driver);
    }

    @Dado("informo usuario {string} e senha {string}")
    public void informo_usuario_e_senha(String nomeUsuario, String senha) {
        objLogin.setNomeUsuario(nomeUsuario);
        objLogin.setSenha(senha);
        objLogin.clickButtonRegistro();
    }

    @Quando("acessar a livraria")
    public void acessar_a_livraria() {
        acessaEbook.clickButtonAcessarLivraria();
    }

    @Quando("selecionar o livro {string}")
    public void selecionar_o_livro(String livro) {
        acessaEbook.setLivroCampoDePesquisa(livro);
        acessaEbook.clickLivro();
        String valorCodigoISNN = acessaEbook.getCodigoISBN();
        String nomeAutor = acessaEbook.getNomeDoAutor();
        Assert.assertEquals(valorCodigoISNN, "9781449365035");
        Assert.assertEquals(nomeAutor, "Axel Rauschmayer");
    }

    @Quando("adicionar o livro a minha colecao")
    public void adicionar_o_livro_a_minha_colecao() {
        acessaEbook.clickButtonAdicionarLivro();
    }

    @Quando("voltar a pagina de perfil")
    public void voltar_a_pagina_de_perfil() {
        acessaEbook.setVoltaAPaginaDePerfil();
    }

    @Entao("deve visualizar o livro adionado na pagina de perfil")
    public void deve_visualizar_o_livro_adionado_na_pagina_de_perfil() {
        String validaPaginaPerfil = acessaEbook.validaQueEstaNaPaginaDePerfil();
        String nomeDoLivroAdicionado = acessaEbook.validaLivroAdicionado();
        Assert.assertEquals(validaPaginaPerfil, "Profile");
        Assert.assertEquals(nomeDoLivroAdicionado, "Speaking JavaScript");
        driver.close();
    }
}
