#language: pt

Funcionalidade: Adicionar um produto ao carrinho de compras

@Conta
Cenário: Cadastrar uma nova conta
Quando eu abrir a aplicação
E clicar no botão de cadastro
E inserir "usuariodeteste@outlook.com" como email de acesso
E digitar "20211504" como senha
E digitar "20211504" para confirmar a senha
E inserir "82917318023" como CPF
E inserir "81560615" como CEP
E clicar em cadastrar
Então a área do cliente será exibida
