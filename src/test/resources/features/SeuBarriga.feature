#language: pt

Funcionalidade: Validar funcionalidade de cadastro

@Conta
Cenário: Não deve cadastrar um usuário com dados já existentes
Dado que estou acessando a aplicação
Quando clico no botão LOGIN | CADASTRAR para fazer meu cadastro
E insiro um e-mail "usuariodeteste20212021@outlook.com"
E insiro uma senha "HOje2021"
E confirmo a senha "HOje2021"
E insiro o CPF "82917318023"
E insiro o CEP "81891"-"000"
E clico em cadastrar
Então a mensagem de erro é exibida