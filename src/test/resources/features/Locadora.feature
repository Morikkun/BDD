#language: pt

Funcionalidade: Como um usuário  quero cadastrar aluguéis de filmes para Controlar preços e datas de entrega

@Locadora
Cenário: Deve alugar um filme com sucesso
Dado um filme com estoque de 2 unidades
E que o preço de aluguel seja R$ 3,00
Quando alugar
Então o preço do aluguel será R$ 3,00
E a data de entrega será no dia seguinte
E o estoque do filme será 1 unidade

@Locadora
Cenário: Não deve alugar filme sem estoque 
Dado um filme com estoque de 0 unidades
Quando alugar 
Então não será possível por falta de estoque
E o estoque do filme será 0 unidade

@Locadora
Cenário: Deve dar condições especiais para categoria estendida
Dado um filme com estoque de 2 unidades
E que o preço de aluguel seja R$ 4,00
E que o tipo do aluguel seja estendido
Quando alugar
Então o preço do aluguel será R$ 8,00
E a data de entrega será em 3 dias
E a pontuação recebida será de 2 pontos