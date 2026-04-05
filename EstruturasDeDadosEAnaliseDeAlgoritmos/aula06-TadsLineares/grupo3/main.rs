use rand::Rng; // Para gerar números aleatórios

fn main() {

    // 10. Simulador de fila de banco
    fn simular_fila_banco(num_clientes: usize) {
        let mut fila: Vec<usize> = Vec::new();
        let mut rng = rand::thread_rng();
        let mut total_espera = 0;

        // Gerar intervalos de chegada dos clientes
        for _ in 0..num_clientes {
            let intervalo = rng.gen_range(1..5); // Intervalo de 1 a 4 unidades de tempo
            fila.push(intervalo);
        }

        // Atendimento dos clientes
        let mut tempo_atual = 0;
        for espera in fila {
            tempo_atual += espera;
            total_espera += tempo_atual;
        }

        // Calculando a média de espera
        let media_espera = total_espera as f64 / num_clientes as f64;
        println!("Tempo médio de espera: {:.2}", media_espera);
    }

    // Exemplo de simulação com 10 clientes
    simular_fila_banco(10);
    println!("-----------------------------------");

    // 11. Impressora compartilhada
    #[derive(Clone)]  // Deriva o trait Clone
    struct Trabalho {
        nome: String,
        paginas: u32,
    }

    fn simular_impressora() {
        let mut fila: Vec<Trabalho> = Vec::new();

        // Adicionando trabalhos na fila
        fila.push(Trabalho { nome: "Doc1".to_string(), paginas: 5 });
        fila.push(Trabalho { nome: "Doc2".to_string(), paginas: 3 });
        fila.push(Trabalho { nome: "Doc3".to_string(), paginas: 10 });

        // Imprimindo os trabalhos na ordem de chegada
        while let Some(trabalho) = fila.get(0).cloned() { // FIFO
            fila.remove(0); // Remove o primeiro item da fila
            println!("Imprimindo {} ({} páginas)", trabalho.nome, trabalho.paginas);
        }
    }

    simular_impressora();
    println!("-----------------------------------");

  
    // 12. Buffer circular de mensagens

    struct FilaCircular {
        buffer: Vec<String>,
        capacidade: usize,
    }

    impl FilaCircular {
        fn new(capacidade: usize) -> Self {
            Self { buffer: Vec::new(), capacidade }
        }

        fn adicionar(&mut self, msg: &str) {
            if self.buffer.len() == self.capacidade {
                self.buffer.remove(0); // Remove a mensagem mais antiga
            }
            self.buffer.push(msg.to_string());
        }

        fn imprimir(&self) {
            for (i, msg) in self.buffer.iter().enumerate() {
                println!("{}: {}", i + 1, msg);
            }
        }
    }

    // Testando o buffer circular com capacidade 3
    let mut buf = FilaCircular::new(3);
    buf.adicionar("msg1");
    buf.adicionar("msg2");
    buf.adicionar("msg3");
    buf.adicionar("msg4"); // Sobrescreve a msg1
    buf.imprimir();
    println!("-----------------------------------");


    // 13. Fila de prioridade manual

    struct Item {
        nome: String,
        prioridade: u32,
    }

    struct FilaPrioridade {
        fila: Vec<Item>,
    }

    impl FilaPrioridade {
        fn new() -> Self {
            Self { fila: Vec::new() }
        }

        fn adicionar(&mut self, item: Item) {
            self.fila.push(item);
            // Ordena a fila: itens com prioridade maior vêm primeiro
            self.fila.sort_by(|a, b| b.prioridade.cmp(&a.prioridade));
        }

        fn remover(&mut self) -> Option<Item> {
            if self.fila.is_empty() {
                None
            } else {
                Some(self.fila.remove(0)) // Remove o primeiro item da fila
            }
        }
    }

    // Testando a fila de prioridade
    let mut fp = FilaPrioridade::new();
    fp.adicionar(Item { nome: "A".to_string(), prioridade: 1 });
    fp.adicionar(Item { nome: "B".to_string(), prioridade: 3 });
    fp.adicionar(Item { nome: "C".to_string(), prioridade: 2 });

    // Removendo e atendendo os itens
    while let Some(it) = fp.remover() {
        println!("Atendendo {} com prioridade {}", it.nome, it.prioridade);
    }
}