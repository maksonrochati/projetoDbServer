#language: pt
Funcionalidade: Realizar Cadastro Sem Sucesso


  Esquema do Cenario: Cadastrar um usuário com senha numérica

    Dado que esteja na pagina login
    E seleciono o botao novo usuario
    Quando informo primeiro nome "<primeiroNome>" e o sobrenome "<sobrenome>"
    E informo nome de usuario "<nomeUsuario>" e a senha "<senha>"
    E seleciono que não sou robo
    E clico no botao registrar
    Entao deve retornar mensagem de erro


    Exemplos:
      |primeiroNome|sobrenome|nomeUsuario|senha|
      |usuario     |test     |usuarioTest1  |12345|


  Esquema do Cenario: Cadastrar um novo usuário com sucesso

    Dado que esteja na pagina de login
    E seleciono o botao de novo usuario
    Quando informo o primeiro nome "<primeiroNome>" e o sobrenome "<sobrenome>"
    E informo o nome de usuario "<nomeUsuario>" e a senha "<senha>"
    E seleciono que não sou um robo
    E clico no botao de registro
    E volto a pagina de registro
    E clicar no botao para voltar a pagina de login
    E informar nome de usuario "<nomeUsuario>" e senha "<senha>"
    E clicar no botao de login
    Entao deve visualizar a página de perfil e o usuario "<nomeUsuario>" logado

    Exemplos:
      |primeiroNome|sobrenome|nomeUsuario|senha   |
      |usuario     |test     |usuarioTest1  |Usu@rio1|

