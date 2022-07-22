# projetoDbServer

## Ferramentas utilizadas:
- [Maven](https://maven.apache.org/ "Maven")
- [Java](https://www.java.com/pt_BR/ "Java")
- [JUnit](https://junit.org/junit4/ "JUnit")
- [Selenium](https://www.seleniumhq.org/ "Selenium")
- [ChromeDriver](https://chromedriver.chromium.org/downloads "ChromeDriver")
- [Cucumber](https://cucumber.io/ "Cucumber")
- [PageFactory](https://github.com/SeleniumHQ/selenium/wiki/PageFactory "PageFactory")
- [PageObject (pattern)](https://martinfowler.com/bliki/PageObject.html "PageObject")

## Arquitetura:

```
└── src
    └── test
        ├── java
        │   ├── pages
        │   │   ├── CommonPage.java
        │   │   ├── EcommerceMainPage.java
        │   │   └── EcommerceMainPageElementMap.java
        │   ├── steps
        │   │   ├── CommonSteps.java
        │   │   └── EcommerceMainSteps.java
        │   ├── tests
        │   │   └── RunTest.java
        │   
        └── resources
            ├── driver
            │  └── READ.txt
            └── features
            │  └── Pesquisa.feature
            └── cucumber.properties
```

### Arquitetura - Bibliotecas utilizadas

Neste projeto foram utilizadas 6 bibliotecas:
- [selenium-java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java "selenium-java")
- [junit](https://mvnrepository.com/artifact/junit/junit "junit")
- [cucumber-java](https://mvnrepository.com/artifact/io.cucumber/cucumber-java "cucumber-java")
- [cucumber-junit](https://mvnrepository.com/artifact/io.cucumber/cucumber-junit "cucumber-junit")
- [cucumber-jvm-deps](https://mvnrepository.com/artifact/io.cucumber/cucumber-jvm-deps "cucumber-jvm-deps")
- [rest-assured](https://mvnrepository.com/artifact/io.rest-assured/rest-assured "rest-assured")

### Arquitetura - Mapeamento dos elementos
Para mapear os elementos foi utilizado a biblioteca do selenium PageFactory, responsável por abstrair os elementos para uma classe única e para facilitar a escrita e manutenção. Por padrão os elementos são armazenados nas classes com o padrão <NomeClasse>PageElementMap. Detalhes da implementação e exemplos:
- WebElement - responsável por identificar os elementos como Web;
- FindBy - responsável por mapear, através de anotações, os seletores dos WebElements

Após mapeados, é necessário "inicializar" os elementos na classe em que serão utilizadas. Por padrão, os elementos são utilizados nas classe <NomeDaClasse>Page correspondentes. Para inicializar os elementos, siga o exemplo abaixo:

`PageFactory.initElements(driver, classe)`

### Arquitetura - Interação com elementos da página
Para interagir com elementos da página, conforme o padrão Page Objects, criamos uma classe de Page para cada página ou grupo de páginas do sistema. Abaixo detalhes da implementação e exemplos:

### Arquitetura - Cucumber e Definições de steps
Para criação dos testes, o passo a passo é definido em arquivos .feature, dentro do diretório resources/features. Estes arquivos contém o detalhamento do teste que será executado. Para isso utilizamos o Cucumber.
Para cada passo utilizado neste arquivo, deve ser criada uma definição de Steps
correspondente. Os arquivos de steps serão criados no diretório steps.

### Arquitetura - Execução dos testes
Para execução dos testes, utilizamos classe JUnit, em conjunto com anotações do CucumberOptions para facilitar a criação de suítes de testes com diferentes configurações.

Para executar o teste, basta clicar com o botão direito sobre a classe, e selecionar "Run <NomeDaClasseDeExecucao>". 
É possível executar com maven também, através do comando: `mvn clean test `

### Arquitetura - ChromeDriver

Por conveniência, faça o download do chromedriver adequado para o seu sistema operacional e adicione no diretório resources/drivers.
Local para download: https://chromedriver.chromium.org/downloads.

### Report
No report das execuções foi utilizado o do cucumber.io onde ao final de cada execução ele gera uma View de report passandos os dados da execução.
Dentro do arquivo `cucumber.properties` está a configuração do report.
Exemplo de report:
`
 https://reports.cucumber.io/reports/677da11e-9a3f-4ff2-962e-130f3b922f10
`

### Considerações
Ao realizar os testes foi identificado um problema com a parte de editar um contato via API a mesma estava sem funcionar, foram testados outros endpoists também de edição da página e a mesma não funcionou.
Outro ponto a discutir foi o uso do reCaptcha na página de cadastro de usuário, apesar de conseguir selecionar em alguns momentos do testes foi necessário intervir manualmente no reCaptcha para prosseguir com o teste.
 


