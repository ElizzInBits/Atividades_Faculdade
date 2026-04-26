# Estudo de Caso A1 — O Problema da Entrega Inteligente
## FastBite


### Questão 1 

#### a) O problema de roteamento da FastBite pertence à classe P, NP ou NP-Completo? Justifique sua resposta com base na definição formal de cada classe.

O problema da FastBite pertence a classe NP-Completo, pois dada a solução uma atribuição completa de pedidos a entregadores e uma sequencia de coletas e entregas para cada um é possível verificar em tempo polinomial se ela é valida. 
Basta percorrer a sequencia de cada entregador, somar as distancias, checar se a capacidade máxima é suprida e verificar se os pedidos urgentes foram entregues dentro do prazo. 
Com isso toda essa verificação é 0(n .k), onde n é o número de pedidos e k é numero de paradas por entregador.
Contudo o tudo o problema de roteamento da FastBite é uma instancia do VRP **Problema de Roteamento de Veículos**,  por sua vez, é um problema NP-Completo.
Como o problema da FastBite se se reduz ao TSP em tempo polinomial, o TSP é NP-Completo o problema da FastBite também será **NP-Completo**.
Sendo assim, o problema da FastBite não pertence a P porque não existe algoritmo polinomial conhecido para resolver de forma ótima. o problema da FastBite pertence a NP pois é uma classe onde problemas cunja a solução pode ser verificada em tempo polinomial e Completa pois ele entra em um subconjunto de NP cojo problemas são os mais dificeis da classe.

#### b) Demonstre, de forma intuitiva, que o problema da FastBite pode ser reduzido ao TSP. Para isso,descreva como transformar uma instância do problema de roteamento da FastBite em uma instância do TSP. (Não é necessária prova formal — uma descrição clara e fundamentada é suficiente.)

No TSP Clássico é dado um conjunto de cidade e as distâncias entre elas e qual é o menor circuito que é possivel visitar cada cidade exatamente uma vez e voltar para o ponto inicial.
Para transformar o problema da FastBite em TSP é necessário definir cada ponto relevante no cenário (Posição do restaurante e a posição do cliente de cada pedido com a posição incial do entregador), para cada par de nós, se define uma aresta  com peso igual à distância entre os dois pontos. A posição atual do entregador é o ponto de origem do circuito, cada pedido impões que o nó "restaurante" seja visitado antes do nó "cliente". Isso equivale a impor uma restrição de precedência do TSP.
O objetivo é minimizar o tempo total de deslocamento do entregador o que equivale a encontrar o menor caminho.
Portanto, qualquer instância do roteamento de um entregado da FastBite pode ser convertida diretamente em uma instancia do TSP, com a adição de restrições de precendencia. 


#### c) Por que a solução por força bruta é inviável para o problema da FastBite em produção? Calcule ou estime a quantidade de permutações possíveis de entregas para um cenário com:

##### 8 pedidos
##### 3 entregadores (cada um com até 3 pedidos)

#### Mostre o raciocínio combinatório e indique a complexidade assintótica resultante.

A solução por força bruta não é viável pois o espaço de soluções cresce de forma explosiva, combinando o número de maneiras de atribuir os pedidos com o número de maneiras de rotear as paradas.

O número de maneiras de fazer essa distribuição pode ser pelo número de particionamentos de 8 elementos em grupos de até 3.

Escolher 3 pedidos para E1, depois até 3 dos restantes para E2 e os demais para E3.

3 pedidos para o entregador 1
3 pedidos para o entregador 2
os 2 restantes vão para o entregador 3

$$
\binom{8}{3} = \frac{8!}{3!\,5!}
$$


$$
= \frac{8 \cdot 7 \cdot 6 \cdot 5!}{(3 \cdot 2 \cdot 1)\cdot 5!}
= \frac{8 \cdot 7 \cdot 6}{3 \cdot 2 \cdot 1}
= 56
$$


$$
\binom{5}{3} = \frac{5!}{3!\,2!}
$$

$$
= \frac{5 \cdot 4 \cdot 3 \cdot 2!}{(3 \cdot 2 \cdot 1)\cdot 2!}
= \frac{5 \cdot 4 \cdot 3}{3 \cdot 2 \cdot 1}
= 10
$$

$$
\binom{2}{2} = 1
$$

$$
56  \cdot 10 \cdot 1 = 560 \text{ atribuições}
$$

Para cada atribuição, é necessário definir a ordem de coleta e entrega. Para um entregador com $k$ pedidos, ele fará $2k$ paradas no total. O total de permutações seria $(2k)!$. Mas como cada restaurante deve ser visitado antes do cliente pode ser dividido o total de permutações por 2 para cada pedido:

$$\frac{(2k)!}{2^k}$$

E1 (3 pedidos, $k=3$): $\frac{6!}{2^3} = \frac{720}{8} = 90$ rotas válidas
E2 (3 pedidos, $k=3$): $\frac{6!}{2^3} = \frac{720}{8} = 90$ rotas válidas
E3 (2 pedidos, $k=2$): $\frac{4!}{2^2} = \frac{24}{4} = 6$ rotas válidas


Sendo assim, multiplicando as atribuições pelas permutações de cada entrgador temos: 

$$560 \cdot 90 \cdot 90 \cdot 6 = 27.216.000 \text{ combinações}$$


A Cmplexidade da solução por força bruta tem um crescimento fatorial/exponencial. Com multiplos entregadores e atribuições, a explosão combinatória é da ordem de:

$$O\left(m^n \cdot \frac{(2k)!}{2^k}\right)$$

onde $n$ é o número de pedidos, $m$ é o número de entregadores e $k$ é a média de pedidos por entregador.Para um cenário de pico com 50 pedidos e 20 entregadores, o número de combinações assumiria proporções astronômicas (superando $10^{64}$), o que torna inevitável e matematicamente impossível qualquer tentativa de avaliação exaustiva dentro do limite operacional de 2 segundos exigido pela FastBite.




## Questão 2 

### a) 
Considerando o lote da seção de dados (P1 a P5) e entregadores (E1 a E3):

O algoritmo pega o primeiro pedido não atribuído, digamos P2 (Restaurante em A(1,1)).

Busca o entregador mais próximo. E1 está em (1,1). Distância = 0. Atribui P2 a E1.

O algoritmo avalia o próximo pedido, P1 (Restaurante em A(0,2)). E1 está em (1,1) e E2 em (5,3). O mais próximo disponível é E1 (distância 2). Atribui P1 a E1.

O entregador E1 agora tem P1 e P2. Para o roteamento, ele está em (1,1). O ponto mais próximo é a coleta de P2 (distância 0). Ele coleta P2.

Em seguida, E1 olha o próximo nó mais próximo (Coleta P1, Entrega P1 ou Entrega P2). Vai ao mais próximo iterativamente, e assim sucessivamente para todos os entregadores.

### b)
É um algoritmo guloso porque toma a decisão que parece ser a mais vantajosa naquele momento imediato, sem avaliar as consequências de longo prazo para o sistema. A propriedade aplicada é a de que "o entregador mais próximo geometricamente do ponto inicial" resolverá a entrega mais rápido.

### c)
Usando os dados: P2 é Padrão, mas seu restaurante está na mesma coordenada inicial de E1 (1,1). O algoritmo guloso atribui imediatamente P2 a E1. No entanto, P1 é Urgente, precisa ser entregue em 5 min, e seu restaurante está em (0,2), muito próximo a E1.
Se E1 for engolido pela entrega de P2 (indo até o Setor C em 7,2), ele se afasta de P1. O próximo entregador, E2 (5,3), terá que atravessar o mapa para buscar P1 em (0,2), estourando o tempo limite de 5 minutos do pedido Urgente. Uma visão global teria atribuído P1 a E1, e P2 a E2 ou E3, salvando o prazo.

### d)
A complexidade de tempo para a atribuição é de $O(n \cdot m)$, pois para cada um dos $n$ pedidos iteramos sobre $m$ entregadores para achar o menor custo. Para o roteamento guloso de cada entregador (com $k$ paradas), a busca pelo nó mais próximo custa $O(k^2)$. A complexidade assintótica total é de $O(n \cdot m + m \cdot k^2)$. Sendo polinomial e de baixo grau, ela é extremamente rápida e rodaria com folga em menos de 2 segundos.



## Questão 3

## a)
Sim, a programação dinâmina é aplicável para resolver o problema de rotemento isoladode um único entregador.
esse pequeno problema é uma variação do TSP com restrições de precendencia. Ele possui as duas propriedade essensiais para PD, o caminho ótimo contem subcaminhos ótimos e sobreposição de subproblemas. Ao enumerar rotas, os mesmos subconjuntos de paradas são recalculados multiplas vezes.

A PD tentaria responder a pergunta de "Qual é o custo mínimo em distancia ou tempo para visitar um subconjunto de paradas s, respeitando que coletas acontecam antes das entregas e terminar no nó atual?"

A PD resolve a sobreposição armazenando o resultados em uma tabela, que cobra um presso alto em espaço. Sendo N o numero total de paradas (N=2K, pois cada pedido tem coleta e entrega).
Complexidade de Tempo: $O(N^2 \cdot 2^N)$
Complexidade de espaço: $O(N \cdot 2^N)$

Devido ao fator exponencial $2^N$, a memória que é exigida para armazenar os estados, acabaria estourando a RAM e ultrapassaria a janela de 2 segundo o partir de k > 1 pedidos (20 paradas). Porém, como a restrição da FastBite define que a capacidade da mochila é de k ≤ 3( No máximo 6 paradas), o espaço acaba sendo minusculo. Portanto para esse cenário, a PD é a solução mais ideal para conseguir traçar a rota exata da mochila de cada entregador.





