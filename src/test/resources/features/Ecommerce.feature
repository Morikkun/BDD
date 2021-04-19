#language: pt

Funcionalidade: Adicionar um produto ao carrinho de compras

@Conta
Cenário: Realizar login na plataforma de ecommerce
Quando eu abro a página inicial da aplicação
E clico no link Login|cadastre-se
Então a seção de login deve ser exibida
E insiro meu email "usuariodeteste20212021@outlook.com"
E insiro minha senha "HOje2021"
E clico em entrar
Então a mensagem "OLÁ, TESTE" deverá aparecer na página
E quando clicar na área do cliente
Então a área do cliente será exibida
