#language: pt
Funcionalidade: Contatos


  Cenario: Listar contato com sucesso

    Dado que eu tenha um endpoint valido para lista o usuario
    Quando enviar a requisicao ao servidor
    Entao valido dados e status code de resposta

  Cenario: Criar contato com sucesso

    Dado que eu tenha um endpoint valido para criar o usuario
    Quando envio requisicao para o servidor
    Entao valido os dados e status code de resposta

  Cenario: Editar contato com sucesso

    Dado que eu tenha um endpoint valido para editar o usuario
    Quando envio a requisicao ao servidor
    Entao devo validar os dados e status code de resposta

  Cenario: Deletar contato com sucesso

    Dado que eu tenha um endpoint valido para deletar o usuario
    Quando eu enviar a requisicao ao servidor
    Entao devo validar dados e status code de resposta

