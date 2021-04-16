#language: pt

Funcionalidade: Adicionar um produto ao carrinho de compras

@Conta
Cenário: Cadastrar uma nova conta
Quando eu abrir a aplicação
E clicar no botão de cadastro
E inserir "usuariodeteste20212021@outlook.com" como email de acesso
E digitar "HOje2021" como senha
E digitar "HOje2021" para confirmar a senha
E inserir "82917318023" como CPF
E inserir "81560"-"615" como CEP
E clicar em cadastrar
E inserir "Teste" como primeiro nome
E inserir "De Automação" como segundo nome
E inserir o RG "502927355"
E inserir uma data de nascimento
E inserir "40028922" como telefone fixo
E inserir "11999991111" como telefone celular
E inserir "189" como número da residência
E inserir "casa" como complemento
E inserir "Padaria harmonia" como ponto de referência
E concordar com os termos de uso
E clicar em concluir
Então a área do cliente será exibida
