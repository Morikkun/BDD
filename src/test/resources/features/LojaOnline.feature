#language: pt

Funcionalidade: Validar funcionalidade de cadastro

@C
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

@C
Cenário: Não deve acessar a aplicação com um e-mail incorreto
Dado que estou acessando a aplicação
Quando clico no botão LOGIN | CADASTRAR para entrar na minha conta
E entro com o e-mail "usuariodeteste20222021@outlook.com"
E entro com a senha "HOje2021"
E quando clico em entrar
Então sou notificado de que meu e-mail ou senha estão incorretos

@c
Cenário: Não deve acessar a aplicação com senha incorreta
Dado que estou acessando a aplicação
Quando clico no botão LOGIN | CADASTRAR para entrar na minha conta
E entro com o e-mail "usuariodeteste20212021@outlook.com"
E entro com a senha "HOje2022"
E quando clico em entrar
Então sou notificado de que meu e-mail ou senha estão incorretos

@Conta
Cenário: Deve exibir um alerta ao tentar logar só com o e-mail
Dado que estou acessando a aplicação
Quando clico no botão LOGIN | CADASTRAR para entrar na minha conta
E entro com o e-mail "usuariodeteste20212021@outlook.com"
E quando clico em entrar
Então um alerta me informa que preciso inserir a senha

@Conta
Cenário: Deve exibir um alerta ao tentar logar só com a senha
Dado que estou acessando a aplicação
Quando clico no botão LOGIN | CADASTRAR para entrar na minha conta
E entro com a senha "HOje2022"
E quando clico em entrar
Então um alerta me informa que preciso inserir o login/email