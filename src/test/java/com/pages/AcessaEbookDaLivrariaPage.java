package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AcessaEbookDaLivrariaPage {
    public WebDriver driver;

    @FindBy(id = "searchBox")
    WebElement campoPesquisa;

    @FindBy(xpath = "//a[text()='Speaking JavaScript']")
    WebElement livro;

    @FindBy(xpath = "//button[text()='Add To Your Collection']")
    WebElement botaoAdicionarLivro;

    @FindBy(xpath = "//label[text()='9781449365035']")
    WebElement codigoISBN;

    @FindBy(xpath = "//div[@id='author-wrapper']//label[text()='Axel Rauschmayer']")
    WebElement nomeAutor;

    @FindBy(xpath = "//div[@class='rt-tbody'] //a[text()='Speaking JavaScript']")
    WebElement nomeDoLivroAdicionado;

    @FindBy(css = " .main-header")
    WebElement tituloDaPaginadePerfil;


    public AcessaEbookDaLivrariaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickButtonAcessarLivraria() {
        WebElement botaoLivraria = driver.findElement(By.xpath("//div/button[@id='gotoStore']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", botaoLivraria);

    }

    public void setLivroCampoDePesquisa(String livro) {
        campoPesquisa.sendKeys(livro);
    }

    public void clickLivro() {
        livro.click();
    }

    public void clickButtonAdicionarLivro() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", "");
        botaoAdicionarLivro.click();
    }

    public void setVoltaAPaginaDePerfil() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.get("https:demoqa.com/profile");
    }

    public String getCodigoISBN() {
        return codigoISBN.getText();
    }

    public String getNomeDoAutor() {
        return nomeAutor.getText();
    }

    public String validaLivroAdicionado() {
        return nomeDoLivroAdicionado.getText();
    }

    public String validaQueEstaNaPaginaDePerfil() {
        return tituloDaPaginadePerfil.getText();
    }
}
