#language: pt


Funcionalidade: Aprender Cucumber
Quero aprender Cucumber para automatizar meus critérios de aceitação

@Contador
Cenário: Contador
Dado um contador que inicia em 15
Quando o incremento em 3
Então seu resultado final é 18

@Contador
Cenário: Outro contador
Dado um contador que inicia em 20
Quando o incremento em 8
Então seu resultado final é 28

@Entrega
Cenário: Prazo de entrega
Dado que o prazo de entrega é 15/02/2020
Quando a entrega atrasar em 2 dias
Então a entrega será feita em 17/02/2020

@Entrega
Cenário: Prazo de entrega da China
Dado que o prazo de entrega é 15/02/2020
Quando a entrega atrasar em 2 meses
Então a entrega será feita em 15/04/2020