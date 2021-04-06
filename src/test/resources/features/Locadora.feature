#language: pt

Funcionalidade: Como um usuário  quero cadastrar aluguéis de filmes para Controlar preços e datas de entrega


@Locadora
Esquema do Cenário: Deve alugar o filme em determinadas condições
Dado um filme com estoque de 2 unidades
E que o preço de aluguel seja R$ <preco>
E que o tipo do aluguel seja <tipo>
Quando alugar
Então o preço do aluguel será R$ <precoFinal>
E a data de entrega será em <diasParaEntrega> dias
E a pontuação recebida será de <pontuacaoCliente> pontos

Exemplos:
|  preco |    tipo    |  precoFinal  |  diasParaEntrega  |  pontuacaoCliente  |
|  4,00  |   comum    |     4,00     |        1          |          1         |
|  4,00  | estendido  |     8,00     |        3          |          2         |
|  5,00  |  semanal   |    15,00     |        7          |          3         |

@Locadora
Cenário: Não deve alugar filme sem estoque 
Dado um filme com estoque de 0 unidades
Quando alugar 
Então não será possível por falta de estoque
E o estoque do filme será 0 unidade


