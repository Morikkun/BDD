#language: pt

Funcionalidade: Adicionar um produto ao carrinho de compras

@Conta
Cenário: Criar massa de dados
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
E inserir "29" "Setembro" "1998" como data de nascimento
E inserir "11" "40028922" como telefone fixo
E inserir "11" "999991111" como telefone celular
E inserir "189" como número da residência
E inserir "casa" como complemento
E inserir "Padaria harmonia" como ponto de referência
E concordar em receber newsletter
E indicar que conheceu a loja através do "Google"
E concordar com os termos de uso
Então clicar em concluir
