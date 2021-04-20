#language: pt

Funcionalidade: Validar funcionalidade de cadastro


Cenário: Não deve cadastrar um usuário com dados já existentes
Dado que estou acessando a aplicação
Quando clico no botão LOGIN | CADASTRAR para fazer meu cadastro
E cadastro com o e-mail "usuariodeteste20212021@outlook.com"
E cadastro com a senha "HOje2021"
E confirmo a senha "HOje2021"
E cadastro com o CPF "82917318023"
E cadsatro com o CEP "81891"-"000"
E clico em cadastrar
Então sou notificado de que o e-mail já está em uso

@Conta
Cenário: Não deve acessar a aplicação com um e-mail incorreto
Dado que estou acessando a aplicação
Quando clico no botão LOGIN | CADASTRAR para entrar na minha conta
E entro com o e-mail "usuariodeteste20222021@outlook.com"
E entro com a senha "HOje2021"
E quando clico em entrar
Então sou notificado de que meu e-mail está incorreto