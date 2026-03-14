# Exercício 1 - O(1)
def verificar_primeiro(lista):
    if len(lista) == 0:
        return None
    return lista[0]


# Exercício 2 - O(n)
def somar_lista(lista):
    total = 0
    for elemento in lista:
        total += elemento
    return total


# Exercício 3 - O(log n)
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


# Exercício 4 - O(n²)
def pares_com_soma(lista, alvo):
    for i in range(len(lista)):
        for j in range(i + 1, len(lista)):
            if lista[i] + lista[j] == alvo:
                print(lista[i], lista[j])


# Exercício 5 - O(n²)
def imprimir_pares_e_soma(lista):
    for i in range(len(lista)):
        print(lista[i])
    for i in range(len(lista)):
        for j in range(len(lista)):
            print(lista[i], lista[j])


# Exercício 6 - O(log n)
def potencias_de_dois(n):
    i = 1
    while i < n:
        print(i)
        i *= 2


# Exercício 7 - O(2^n)
def fibonacci_recursivo(n):
    if n <= 1:
        return n
    return fibonacci_recursivo(n - 1) + fibonacci_recursivo(n - 2)


# Exercício 8 - O(n²)
def ordenacao_bolha(lista):
    n = len(lista)
    for i in range(n):
        for j in range(0, n - i - 1):
            if lista[j] > lista[j + 1]:
                lista[j], lista[j + 1] = lista[j + 1], lista[j]
    return lista


# Exercício 9 - O(n³)
def produto_de_matrizes(A, B, n):
    C = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            for k in range(n):
                C[i][j] += A[i][k] * B[k][j]
    return C


# Exercício 10 - O(n log n)
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


# Testes básicos para execução local
if __name__ == "__main__":
    lista = [1, 3, 5, 7, 9, 11]

    print("Ex1:", verificar_primeiro(lista))
    print("Ex2:", somar_lista(lista))
    print("Ex3:", busca_binaria(lista, 7))
    print("Ex4 - pares com soma 10:"); pares_com_soma(lista, 10)
    print("Ex5 - pares e soma:"); imprimir_pares_e_soma([1, 2, 3])
    print("Ex6 - potencias de 2 até 16:"); potencias_de_dois(16)
    print("Ex7 - fibonacci(6):", fibonacci_recursivo(6))
    print("Ex8 - bubble sort:", ordenacao_bolha([5, 3, 1, 4, 2]))
    A = [[1, 2], [3, 4]]
    B = [[5, 6], [7, 8]]
    print("Ex9 - produto de matrizes:", produto_de_matrizes(A, B, 2))
    print("Ex10 - merge sort:", merge_sort([5, 3, 1, 4, 2]))
