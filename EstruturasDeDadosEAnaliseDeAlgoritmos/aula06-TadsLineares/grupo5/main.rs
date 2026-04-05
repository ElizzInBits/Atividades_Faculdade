use std::collections::VecDeque;
use std::time::Instant;

fn main() {

    // 17. Comparação de desempenho entre Vec ingênua, VecDeque e fila circular
    const N: usize = 10_000;

    // Vec ingênua: enqueue = push, dequeue = remove(0) — O(n) por remoção
    let inicio = Instant::now();
    let mut fila_vec: Vec<i32> = Vec::new();
    for i in 0..N { fila_vec.push(i as i32); }
    for _ in 0..N { fila_vec.remove(0); }
    println!("Vec ingênua:     {:?}", inicio.elapsed());

    // VecDeque: enqueue = push_back, dequeue = pop_front — O(1) amortizado
    let inicio = Instant::now();
    let mut fila_deque: VecDeque<i32> = VecDeque::new();
    for i in 0..N { fila_deque.push_back(i as i32); }
    for _ in 0..N { fila_deque.pop_front(); }
    println!("VecDeque:        {:?}", inicio.elapsed());

    // Fila circular manual com array de tamanho fixo
    struct FilaCircular {
        buffer: Vec<i32>,
        head: usize,
        tail: usize,
        tamanho: usize,
        capacidade: usize,
    }

    impl FilaCircular {
        fn new(capacidade: usize) -> Self {
            Self {
                buffer: vec![0; capacidade],
                head: 0,
                tail: 0,
                tamanho: 0,
                capacidade,
            }
        }

        // Insere no fundo usando módulo para circular
        fn enqueue(&mut self, valor: i32) {
            self.buffer[self.tail] = valor;
            self.tail = (self.tail + 1) % self.capacidade;
            self.tamanho += 1;
        }

        // Remove da frente avançando head com módulo
        fn dequeue(&mut self) -> Option<i32> {
            if self.tamanho == 0 { return None; }
            let valor = self.buffer[self.head];
            self.head = (self.head + 1) % self.capacidade;
            self.tamanho -= 1;
            Some(valor)
        }
    }

    let inicio = Instant::now();
    let mut fila_circular = FilaCircular::new(N);
    for i in 0..N { fila_circular.enqueue(i as i32); }
    for _ in 0..N { fila_circular.dequeue(); }
    println!("Fila circular:   {:?}", inicio.elapsed());

    println!("-----------------------------------");

    // 18. Quando usar qual TAD?
    println!("18. Quando usar qual TAD?");
    println!();
    println!("(a) Ctrl+Z em editor de texto");
    println!("    -> PILHA (Vec como pilha)");
    println!("    Cada ação é empilhada. Desfazer = pop. Estrutura LIFO natural.");
    println!();
    println!("(b) Pedidos de restaurante em ordem");
    println!("    -> FILA (VecDeque)");
    println!("    Pedidos chegam e são atendidos na ordem de chegada. Estrutura FIFO.");
    println!();
    println!("(c) Verificar tags HTML bem formadas");
    println!("    -> PILHA (Vec como pilha)");
    println!("    Cada tag aberta é empilhada. Ao fechar, verifica se o topo bate. LIFO.");
    println!();
    println!("(d) Navegar arquivos de diretório em largura (BFS)");
    println!("    -> FILA (VecDeque)");
    println!("    BFS processa nós nível a nível. Enfileira filhos, processa na ordem. FIFO.");
    println!();
    println!("(e) Verificar se sequência de palavras é palíndromo");
    println!("    -> DEQUE (VecDeque)");
    println!("    Compara extremidades simultaneamente com pop_front e pop_back.");

    println!("-----------------------------------");

    // 19. Fila com iteração controlada — processar em lotes
    fn processar_em_lotes(fila: &mut VecDeque<i32>, tamanho_lote: usize) {
        let mut numero_lote = 1;

        while !fila.is_empty() {
            let mut lote: Vec<i32> = Vec::new();

            // Drena até tamanho_lote elementos da frente da fila
            for _ in 0..tamanho_lote {
                if let Some(valor) = fila.pop_front() {
                    lote.push(valor);
                } else {
                    break;
                }
            }

            println!("Lote {}: {:?}", numero_lote, lote);
            numero_lote += 1;
        }
    }

    let mut fila: VecDeque<i32> = (1..=10).collect();
    println!("Fila original: {:?}", fila);
    processar_em_lotes(&mut fila, 3);

    println!("-----------------------------------");

    // 20. Mini-projeto — Round Robin
    struct Processo {
        nome: String,
        tempo_restante: u32,
    }

    fn round_robin(processos: Vec<(&str, u32)>, quantum: u32) {
        // Cria a fila de processos a partir da lista de entrada
        let mut fila: VecDeque<Processo> = processos
            .into_iter()
            .map(|(nome, tempo)| Processo { nome: nome.to_string(), tempo_restante: tempo })
            .collect();

        let mut tempo_total = 0;

        println!("Iniciando Round Robin (quantum = {}):", quantum);

        while let Some(mut processo) = fila.pop_front() {
            // Executa pelo quantum ou pelo tempo restante, o que for menor
            let executado = processo.tempo_restante.min(quantum);
            processo.tempo_restante -= executado;
            tempo_total += executado;

            println!(
                "  t={:>3} | Executando '{}' por {} unidades | restante: {}",
                tempo_total, processo.nome, executado, processo.tempo_restante
            );

            // Se ainda tem tempo restante, volta para o fim da fila
            if processo.tempo_restante > 0 {
                fila.push_back(processo);
            } else {
                println!("         '{}' finalizado em t={}", processo.nome, tempo_total);
            }
        }

        println!("Todos os processos finalizados. Tempo total: {}", tempo_total);
    }

    let processos = vec![
        ("P1", 10),
        ("P2", 4),
        ("P3", 7),
    ];

    round_robin(processos, 3);
}
