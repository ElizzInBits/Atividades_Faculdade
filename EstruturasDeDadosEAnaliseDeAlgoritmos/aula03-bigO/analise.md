# Análise de Complexidade Assintótica — Big-O

Estruturas de Dados e Análise de Algoritmos
Aula 03 – Notação Assintótica

---

## Exercício 1

```python
def verificar_primeiro(lista):
    if len(lista) == 0:
        return None
    return lista[0]
```

Complexidade: O(1)

Essa função só faz duas coisas: checa se a lista tá vazia e retorna o primeiro elemento. Nenhuma das duas depende do tamanho da lista, então o tempo de execução é sempre o mesmo independente de ter 10 ou 10 mil elementos.

---

## Exercício 2

```python
def somar_lista(lista):
    total = 0
    for elemento in lista:
        total += elemento
    return total
```

Complexidade: O(n)

Tem um loop que passa por cada elemento da lista uma vez.
Se a lista dobrar de tamanho, o número de operações também dobra. Baicamente o crescimento é direto e proporcional ao tamanho da entrada.

---

## Exercício 3

```python
def busca_binaria(lista, alvo):
    esquerda, direita = 0, len(lista) - 1
    while esquerda <= direita:
        meio = (esquerda + direita) // 2
        if lista[meio] == alvo:
            return meio
        elif lista[meio] < alvo:
            esquerda = meio + 1
        else:
            direita = meio - 1
    return -1
```

Complexidade: O(log n)

A cada iteração, o algoritmo vai descartar metade dos elementos restantes. Então mesmo com uma lista enorme, o número de passos cresce bem devagar. Com 1024 elementos, por exemplo, são no máximo 10 iterações (log₂ de 1024 = 10).

---

## Exercício 4

```python
def pares_com_soma(lista, alvo):
    for i in range(len(lista)):
        for j in range(i + 1, len(lista)):
            if lista[i] + lista[j] == alvo:
                print(lista[i], lista[j])
```

Complexidade: O(n²)

Dois loops aninhados: para cada elemento, o código compara com todos os outros que vem depois. O total de comparações fica em torno de n*(n-1)/2, que na prática é O(n²). Dobrar a lista quadruplica o trabalho.

---

## Exercício 5

```python
def imprimir_pares_e_soma(lista):
    for i in range(len(lista)):
        print(lista[i])
    for i in range(len(lista)):
        for j in range(len(lista)):
            print(lista[i], lista[j])
```

Complexidade: O(n²)

O primeiro loop é O(n), mas o segundo bloco tem dois loops aninhados que juntos são O(n²). Quando é somado O(n) + O(n²), o termo que domina é o n², então a complexidade final fica O(n²).

---

## Exercício 6

```python
def potencias_de_dois(n):
    i = 1
    while i < n:
        print(i)
        i *= 2
```

Complexidade: O(log n)

O valor de `i` dobra a cada iteração, então o loop não precisa de muitas voltas para chegar em `n`. Para n = 1024, são apenas 10 iterações. O número de passos cresce de forma logarítmica.

---

## Exercício 7

```python
def fibonacci_recursivo(n):
    if n <= 1:
        return n
    return fibonacci_recursivo(n - 1) + fibonacci_recursivo(n - 2)
```

Complexidade: O(2ⁿ)

Cada chamada gera mais duas chamadas, que geram mais duas e assim por diante. A árvore de chamadas cresce de forma exponencial. Para n = 30, já são mais de um milhão de chamadas.

---

## Exercício 8

```python
def ordenacao_bolha(lista):
    n = len(lista)
    for i in range(n):
        for j in range(0, n - i - 1):
            if lista[j] > lista[j + 1]:
                lista[j], lista[j + 1] = lista[j + 1], lista[j]
    return lista
```

Complexidade: O(n²)

Dois loops aninhados percorrem a lista comparando elementos adjacentes. O loop interno vai diminuindo a cada passagem, mas o total de comparações ainda fica em n*(n-1)/2, que é O(n²).

---

## Exercício 9

```python
def produto_de_matrizes(A, B, n):
    C = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            for k in range(n):
                C[i][j] += A[i][k] * B[k][j]
    return C
```

Complexidade: O(n³)

Três loops aninhados, cada um rodando `n` vezes. O total de operações é n × n × n = n³. Para matrizes 10x10 já são 1000 operações; para 100x100, um milhão. 

---

## Exercício 10

```python
def merge_sort(lista):
    if len(lista) <= 1:
        return lista
    meio = len(lista) // 2
    esquerda = merge_sort(lista[:meio])
    direita = merge_sort(lista[meio:])
    resultado = []
    i = j = 0
    while i < len(esquerda) and j < len(direita):
        if esquerda[i] <= direita[j]:
            resultado.append(esquerda[i])
            i += 1
        else:
            resultado.append(direita[j])
            j += 1
    resultado.extend(esquerda[i:])
    resultado.extend(direita[j:])
    return resultado
```

Complexidade: O(n log n)

O algoritmo divide a lista ao meio repetidamente (log n níveis) e em cada nível faz O(n) operações para juntar as partes ordenadas. Multiplicando: n × log n. É considerada a complexidade ideal para algoritmos de ordenação baseados em comparação.

---

## Tabela Resumo

| Exercício | Função                  | Complexidade |
|-----------|-------------------------|--------------|
| 1         | verificar_primeiro      | O(1)         |
| 2         | somar_lista             | O(n)         |
| 3         | busca_binaria           | O(log n)     |
| 4         | pares_com_soma          | O(n²)        |
| 5         | imprimir_pares_e_soma   | O(n²)        |
| 6         | potencias_de_dois       | O(log n)     |
| 7         | fibonacci_recursivo     | O(2ⁿ)        |
| 8         | ordenacao_bolha         | O(n²)        |
| 9         | produto_de_matrizes     | O(n³)        |
| 10        | merge_sort              | O(n log n)   |
