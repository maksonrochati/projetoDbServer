package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    @FindBy(id = "userName")
    WebElement nomeUsuario;

    @FindBy(id = "password")
    WebElement senha;

    @FindBy(id = "login")
    WebElement botaoLogin;

    @FindBy(id = "userName-value")
    WebElement usuarioLogado;



    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setNomeUsuario(String strNomeUsuario) {
        JavascriptExecutor js = ( JavascriptExecutor ) driver ;
        js . executeScript ( "window.scrollBy(0,250)" , "" );
        nomeUsuario.sendKeys(strNomeUsuario);
    }

    public void setSenha(String strSenha) {
        senha.sendKeys(strSenha);
    }

    public void clickButtonRegistro() {
        botaoLogin.click();
    }

    public String getValidaNomeUsuarioPaginaDePerfil(){
        String text = usuarioLogado.getText();
        return text;
    }

}
