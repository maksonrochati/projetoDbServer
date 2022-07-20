#language: pt
Funcionalidade: Acessar Ebook Na Livraria


  Esquema do Cenario: Adicionar livro a coleção com sucesso

    Dado que eacesso a pagina login
    E informo usuario "<nomeUsuario>" e senha "<senha>"
    Quando acessar a livraria
    E selecionar o livro "<nomeDoLivro>"
    E adicionar o livro a minha colecao
    E voltar a pagina de perfil
    Entao deve visualizar o livro adionado na pagina de perfil


    Exemplos:
      |nomeUsuario|senha   |nomeDoLivro        |
      |usuario19  |Usu@rio1|Speaking JavaScript|


