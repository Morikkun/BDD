#language: pt

Funcionalidade: Rastreamento de passagens de Avião


@Passed
Cenário: Deve criar steps genéricos para esses passos

Dado que o ticket é AF345
E que o valor da passagem é R$ 230,45
E que o nome do passageiro é "Fulano da Silva"
E que o telefone do passageiro é 9999-9999
Quando criar os steps
Então o teste vai funcionar

@Passed
Cenário: Deve reaproveitar os steps "Dado" do cenário anterior
Dado que o ticket é AB167
E que o ticket especial é AB167
E que o valor da passagem é R$ 1120,23
E que o nome do passageiro é "Cicrano de Oliveira"
E que o telefone do passageiro é 9888-8888

Cenário: Deve negar todos os steps "Dado" dos cenários anteriores
Dado que o ticket é CD123
E que o ticket é AG1234
E que o valor da passagem é R$ 1.1345,56
E que o nome do passageiro é "Beltrano Souza Matos de Alcântara Azevedo"
E que o telefone do passageiro é 1234-5678
E que o telefone do passageiro é 999-2235