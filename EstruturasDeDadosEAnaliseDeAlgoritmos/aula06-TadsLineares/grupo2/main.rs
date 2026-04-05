// use std::collections::HashMap; // Pode remover se não usar HashMap

fn main() {

    // 5. Calculadora RPN (Reverse Polish Notation)
    fn calcular_rpn(expressao: &str) -> f64 {
        let mut pilha: Vec<f64> = Vec::new();

        for token in expressao.split_whitespace() {
            match token {
                "+" => {
                    let b = pilha.pop().expect("Operação inválida");
                    let a = pilha.pop().expect("Operação inválida");
                    pilha.push(a + b);
                },
                "-" => {
                    let b = pilha.pop().expect("Operação inválida");
                    let a = pilha.pop().expect("Operação inválida");
                    pilha.push(a - b);
                },
                "*" => {
                    let b = pilha.pop().expect("Operação inválida");
                    let a = pilha.pop().expect("Operação inválida");
                    pilha.push(a * b);
                },
                "/" => {
                    let b = pilha.pop().expect("Operação inválida");
                    let a = pilha.pop().expect("Operação inválida");
                    pilha.push(a / b);
                },
                _ => {
                    let numero: f64 = token.parse().expect("Número inválido");
                    pilha.push(numero);
                }
            }
        }

        pilha.pop().expect("Expressão inválida")
    }

    let expressao = "1 2 + 4 5 * +"; // Exemplo de RPN
    let resultado = calcular_rpn(expressao);
    println!("Resultado da expressão RPN '{}': {}", expressao, resultado);
    println!("-----------------------------------");
    println!("===================================");
    println!("-----------------------------------");

    // 6. Histórico de navegação
    struct Navegador {
        atual: String,
        back: Vec<String>,
        forward: Vec<String>,
    }

    impl Navegador {
        fn new(home: &str) -> Self {
            Self {
                atual: home.to_string(),
                back: Vec::new(),
                forward: Vec::new(),
            }
        }

        fn visitar(&mut self, url: &str) {
            self.back.push(self.atual.clone());
            self.atual = url.to_string();
            self.forward.clear();
        }

        fn voltar(&mut self) {
            if let Some(url) = self.back.pop() {
                self.forward.push(self.atual.clone());
                self.atual = url;
            }
        }

        fn avancar(&mut self) {
            if let Some(url) = self.forward.pop() {
                self.back.push(self.atual.clone());
                self.atual = url;
            }
        }
    }

    // Testando o navegador
    let mut navegador = Navegador::new("google.com");

    navegador.visitar("rust-lang.org");
    navegador.visitar("github.com");

    println!("Atual: {}", navegador.atual); // github.com

    navegador.voltar();
    println!("Após voltar: {}", navegador.atual); // rust-lang.org

    navegador.avancar();
    println!("Após avançar: {}", navegador.atual); // github.com

    // 7. Desfazer/Refazer usando pilhas
    struct Editor {
        texto: String,
        desfazer_stack: Vec<String>,
        refazer_stack: Vec<String>,
    }

    impl Editor {
        fn new() -> Self {
            Self {
                texto: String::new(),
                desfazer_stack: Vec::new(),
                refazer_stack: Vec::new(),
            }
        }

        fn escrever(&mut self, novo_texto: &str) {
            self.desfazer_stack.push(self.texto.clone());
            self.texto.push_str(novo_texto);
            self.refazer_stack.clear();
        }

        fn desfazer(&mut self) {
            if let Some(estado) = self.desfazer_stack.pop() {
                self.refazer_stack.push(self.texto.clone());
                self.texto = estado;
            }
        }

        fn refazer(&mut self) {
            if let Some(estado) = self.refazer_stack.pop() {
                self.desfazer_stack.push(self.texto.clone());
                self.texto = estado;
            }
        }
    }

    // Testando o editor
    let mut editor = Editor::new();
    editor.escrever("Olá, ");
    editor.escrever("mundo!");          

    println!("Texto atual: {}", editor.texto); // Olá, mundo!                   

    editor.desfazer();
    println!("Após desfazer: {}", editor.texto); // Olá,

    editor.refazer();
    println!("Após refazer: {}", editor.texto); // Olá, mundo!

    // 8. Sequência de símbolos balanceados
    fn simbolos(expressao: &str) -> bool {
        let mut pilha: Vec<char> = Vec::new();

        for c in expressao.chars() {
            match c {
                '(' | '{' | '[' => pilha.push(c),
                ')' => {
                    if pilha.pop() != Some('(') { return false; }
                },
                '}' => {
                    if pilha.pop() != Some('{') { return false; }
                },
                ']' => {
                    if pilha.pop() != Some('[') { return false; }
                },
                _ => {}
            }
        }

        pilha.is_empty()
    }

    let expressao1 = "({[]})";
    let expressao2 = "({[})";
    let expressao3 = "({[]})(";

    println!("Expressão '{}': {}", expressao1, simbolos(expressao1)); // true
    println!("Expressão '{}': {}", expressao2, simbolos(expressao2)); // false
    println!("Expressão '{}': {}", expressao3, simbolos(expressao3)); // false          

    fn corrigir_expressao(expressao: &str) -> String {
        let mut pilha: Vec<char> = Vec::new();
        let mut resultado = String::new();

        for c in expressao.chars() {
            match c {
                '(' | '{' | '[' => { pilha.push(c); resultado.push(c); },
                ')' => {
                    if pilha.pop() != Some('(') { resultado.push('('); }
                    resultado.push(c);
                },
                '}' => {
                    if pilha.pop() != Some('{') { resultado.push('{'); }
                    resultado.push(c);
                },
                ']' => {
                    if pilha.pop() != Some('[') { resultado.push('['); }
                    resultado.push(c);
                },
                _ => resultado.push(c),
            }
        }

        while let Some(c) = pilha.pop() {
            match c {
                '(' => resultado.push(')'),
                '{' => resultado.push('}'),
                '[' => resultado.push(']'),
                _ => {}
            }
        }

        resultado
    }   
    
    println!("Expressão corrigida '{}': {}", expressao2, corrigir_expressao(expressao2)); // ({[]})
    println!("Expressão corrigida '{}': {}", expressao3, corrigir_expressao(expressao3)); // ({[]})()   

    // 9. Pilha com mínimo
    struct StackMin {
        pilha: Vec<i32>,
        min_pilha: Vec<i32>,
    }

    impl StackMin {
        fn new() -> Self {
            Self {
                pilha: Vec::new(),
                min_pilha: Vec::new(),
            }
        }

        fn push(&mut self, x: i32) {
            self.pilha.push(x);
            if self.min_pilha.is_empty() || x <= *self.min_pilha.last().unwrap() {
                self.min_pilha.push(x);
            }
        }

        fn pop(&mut self) -> Option<i32> {
            if let Some(valor) = self.pilha.pop() {
                if valor == *self.min_pilha.last().unwrap() {
                    self.min_pilha.pop();
                }
                Some(valor)
            } else {
                None
            }
        }

        fn min(&self) -> Option<i32> {
            self.min_pilha.last().copied()
        }
    }

    let mut stack = StackMin::new();
    stack.push(5);
    stack.push(3);
    stack.push(7);
    stack.push(2);

    println!("Mínimo: {:?}", stack.min());
    stack.pop();
    println!("Mínimo após pop: {:?}", stack.min());
}