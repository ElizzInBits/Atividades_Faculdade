use std::time::{Instant, Duration};

/// Estrutura para armazenar os resultados
struct Resultado {
    tamanho: usize,
    alvo: i32,
    ops_simples: usize,
    ops_interrupcao: usize,
    tempo_simples: Duration,
    tempo_interrupcao: Duration,
}

/// Busca sequencial simples - sempre vai percorrer todo o vetor
fn busca_sequencial_simples(vetor: &[i32], alvo: i32) -> (Option<usize>, usize) {
    let mut operacoes = 0;
    let mut resultado = None;

    for i in 0..vetor.len() {
        operacoes += 1;
        if vetor[i] == alvo {
            resultado = Some(i);
        }
    }

    (resultado, operacoes)
}

/// Busca sequencial com interrupção antecipada
fn busca_sequencial_interrompida(vetor: &[i32], alvo: i32) -> (Option<usize>, usize) {
    let mut operacoes = 0;

    for i in 0..vetor.len() {
        operacoes += 1;
        if vetor[i] == alvo {
            return (Some(i), operacoes);
        }
    }

    (None, operacoes)
}

/// Gera um vetor com valores de 1 até n
fn gerar_vetor(tamanho: usize) -> Vec<i32> {
    (1..=tamanho as i32).collect()
}

/// Executa experimento comparativo entre os dois algoritmos
fn executar_experimento(tamanho: usize, alvo: i32) -> Resultado {
    let vetor = gerar_vetor(tamanho);

    println!("\n{}", "=".repeat(60));
    println!("Tamanho do vetor: {}", tamanho);
    println!("Elemento procurado: {}", alvo);
    println!("{}", "-".repeat(60));

    // Busca Sequencial Simples
    let inicio = Instant::now();
    let (resultado1, ops1) = busca_sequencial_simples(&vetor, alvo);
    let tempo1 = inicio.elapsed();

    println!("\n BUSCA SEQUENCIAL SIMPLES:");
    println!(" Resultado: {:?}", resultado1);
    println!(" Operações: {}", ops1);
    println!(" Tempo: {:?}", tempo1);

    // Busca Sequencial com Interrupção
    let inicio = Instant::now();
    let (resultado2, ops2) = busca_sequencial_interrompida(&vetor, alvo);
    let tempo2 = inicio.elapsed();

    println!("\n BUSCA SEQUENCIAL COM INTERRUPÇÃO:");
    println!(" Resultado: {:?}", resultado2);
    println!(" Operações: {}", ops2);
    println!(" Tempo: {:?}", tempo2);

    // Análise Comparativa
    println!("\n ANÁLISE COMPARATIVA:");
    println!(" Diferença de operações: {} operações", ops1.saturating_sub(ops2));
    if tempo1 > tempo2 {
        println!(" Algoritmo com interrupção foi mais rápido");
    } else if tempo2 > tempo1 {
        println!(" Algoritmo simples foi mais rápido (provavelmente devido à variação)");
    } else {
        println!(" Tempos praticamente iguais");
    }
    println!("{}", "=".repeat(60));

    Resultado {
        tamanho,
        alvo,
        ops_simples: ops1,
        ops_interrupcao: ops2,
        tempo_simples: tempo1,
        tempo_interrupcao: tempo2,
    }
}

/// Imprime tabela resumo dos resultados
fn imprimir_tabela_resultados(resultados: &[Resultado]) {
    println!("\n RESULTADOS RESUMIDOS\n");
    println!("{:<12} {:<10} {:<20} {:<25} {:<20} {:<20}",
        "Tamanho", "Alvo", "Operações Simples", "Operações Interrupção", "Tempo Simples", "Tempo Interrupção");

    for r in resultados {
        println!("{:<12} {:<10} {:<20} {:<25} {:<20?} {:<20?}",
            r.tamanho, r.alvo, r.ops_simples, r.ops_interrupcao, r.tempo_simples, r.tempo_interrupcao);
    }
}

fn main() {
    println!("\n EXPERIMENTO: COMPARAÇÃO DE ALGORITMOS DE BUSCA\n");

    let mut resultados: Vec<Resultado> = Vec::new();

    // Cenário 1: Elemento no início
    resultados.push(executar_experimento(1_000, 5));
    resultados.push(executar_experimento(100_000, 5));
    resultados.push(executar_experimento(1_000_000, 5));

    // Cenário 2: Elemento no meio
    resultados.push(executar_experimento(1_000, 500));
    resultados.push(executar_experimento(100_000, 50_000));
    resultados.push(executar_experimento(1_000_000, 500_000));

    // Cenário 3: Elemento no final
    resultados.push(executar_experimento(1_000, 1_000));
    resultados.push(executar_experimento(100_000, 100_000));
    resultados.push(executar_experimento(1_000_000, 1_000_000));

    // Cenário 4: Elemento inexistente
    resultados.push(executar_experimento(1_000, -1));
    resultados.push(executar_experimento(100_000, -1));
    resultados.push(executar_experimento(1_000_000, -1));

    println!("\n✅ Experimento concluído!\n");

    // Imprimir tabela resumo com os resultados reais
    imprimir_tabela_resultados(&resultados);
}