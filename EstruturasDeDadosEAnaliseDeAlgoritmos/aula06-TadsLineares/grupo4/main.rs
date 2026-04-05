use std::collections::VecDeque;

fn main() {

    // 14. Palíndromo com Deque
    fn verificar_palindromo(texto: &str) -> bool {
        // Filtra espaços e converte para minúsculas, armazenando em um VecDeque<char>
        let mut deque: VecDeque<char> = texto
            .chars()
            .filter(|c| !c.is_whitespace())
            .map(|c| c.to_lowercase().next().unwrap())
            .collect();

        // Compara o primeiro e o último caractere até o deque ter 1 ou 0 elementos
        while deque.len() > 1 {
            if deque.pop_front() != deque.pop_back() {
                return false;
            }
        }

        true
    }

    let frase = "A man a plan a canal Panama";
    println!("\"{}\" é palíndromo? {}", frase, verificar_palindromo(frase)); // true

    let frase2 = "hello";
    println!("\"{}\" é palíndromo? {}", frase2, verificar_palindromo(frase2)); // false

    println!("-----------------------------------");

    // 15. Janela deslizante máxima
    fn janela_maxima(vetor: &[i32], k: usize) -> Vec<i32> {
        let mut resultado: Vec<i32> = Vec::new();
        // O deque armazena índices dos elementos candidatos ao máximo
        let mut deque: VecDeque<usize> = VecDeque::new();

        for i in 0..vetor.len() {
            // Remove índices que saíram da janela atual
            if let Some(&frente) = deque.front() {
                if frente + k <= i {
                    deque.pop_front();
                }
            }

            // Remove do fundo índices de elementos menores que o atual
            // pois nunca serão o máximo enquanto o atual estiver na janela
            while let Some(&tras) = deque.back() {
                if vetor[tras] <= vetor[i] {
                    deque.pop_back();
                } else {
                    break;
                }
            }

            deque.push_back(i);

            // Só começa a registrar resultados quando a primeira janela estiver completa
            if i + 1 >= k {
                resultado.push(vetor[*deque.front().unwrap()]);
            }
        }

        resultado
    }

    let vetor = vec![1, 3, -1, -3, 5, 3, 6, 7];
    let k = 3;
    println!("Vetor: {:?}", vetor);
    println!("Janela k={}: máximos = {:?}", k, janela_maxima(&vetor, k)); // [3, 3, 5, 5, 6, 7]

    println!("-----------------------------------");

    // 16. Fila de tarefas com prioridade de frente
    struct FilaTarefas {
        deque: VecDeque<String>,
    }

    impl FilaTarefas {
        fn new() -> Self {
            Self { deque: VecDeque::new() }
        }

        // Tarefas urgentes entram na frente
        fn adicionar_urgente(&mut self, tarefa: &str) {
            self.deque.push_front(tarefa.to_string());
        }

        // Tarefas normais entram no fundo
        fn adicionar_normal(&mut self, tarefa: &str) {
            self.deque.push_back(tarefa.to_string());
        }

        // Todas as tarefas são removidas da frente (FIFO com prioridade)
        fn processar(&mut self) -> Option<String> {
            self.deque.pop_front()
        }
    }

    let mut fila = FilaTarefas::new();
    fila.adicionar_normal("Tarefa A");
    fila.adicionar_normal("Tarefa B");
    fila.adicionar_urgente("URGENTE: Tarefa C"); // vai para a frente
    fila.adicionar_normal("Tarefa D");
    fila.adicionar_urgente("URGENTE: Tarefa E"); // vai para a frente

    println!("Processando tarefas:");
    while let Some(tarefa) = fila.processar() {
        println!("  -> {}", tarefa);
    }
    // Ordem esperada: URGENTE E, URGENTE C, Tarefa A, Tarefa B, Tarefa D
}
