#language: pt

Funcionalidade: Adicionar um produto ao carrinho de compras

Cenário: Cadastrar uma nova conta
Quando eu abrir a aplicação
E clicar no botão <Cadastro>
E digitar um <nome>
E digitar um <sobrenome>
E inserir um <CPF>
E inserir um <email> de acesso
E digitar a <senha>
E confirmar a <senha>
E clicar em <entrar>
Então a área do cliente será exibida

Cenário: Logar na área do cliente
Quando eu abrir a aplicação
E clicar no botão <entrar>
E digitar o <email>
E digitar a <senha>
E clicar em <Entrar>
Então a área do cliente será exibida

Cenário: Adicionar um produto ao carrinho
Quando eu clicar na <barra-de-pesquisa>
E digitar <produto>
E clicar em <buscar>
E a tela com produtos for exibida
E quando eu clicar no <produto> desejado
E a página com detalhes abrir
E clicar em <comprar>
Então o <produto> deve estar no carrinho
