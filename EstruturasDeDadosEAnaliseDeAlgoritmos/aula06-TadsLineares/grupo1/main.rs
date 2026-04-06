use std::collections::HashMap;

fn main() {

    
// 1. Inversão com push/pop

    fn inverter(mut v: Vec<i32>) -> Vec<i32> {  // A função recebe um vetor de inteiros e retorna um novo vetor com os elementos invertidos.
    let mut invertido = Vec::new(); // Cria um novo vetor vazio para armazenar os elementos invertidos.
    
    while let Some(valor) = v.pop() { // Enquanto houver elementos no vetor original, a função utiliza o método pop() para remover o último elemento do vetor original e armazená-lo na variável valor.
        invertido.push(valor); // O valor removido é adicionado ao vetor invertido usando o método push(), que adiciona o elemento ao final do vetor invertido.
    }

    invertido // é o retorno
    
}
    let v = vec![1, 2, 3, 4, 5];
    let invertido = inverter(v);
    println!("{:?}", invertido);




    //2. Contador de ocorrências com HashMap

    fn contar_letras(v: Vec<char>) -> HashMap<char, i32>{ // A função recebe um vetor de caracteres e retorna um HashMap onde as chaves são os caracteres e os valores são as contagens de ocorrências de cada caractere no vetor.

    let mut contagem = HashMap::new(); // Cria um novo HashMap vazio para armazenar as contagens de letras.

    for letra in &v {
        let  contador = contagem.entry(*letra).or_insert(0); // Para cada letra no vetor, a função utiliza o método entry() para acessar a contagem atual da letra no HashMap. Se a letra ainda não estiver presente, o método or_insert(0) inicializa a contagem com zero.
        *contador +=1; // O contador é incrementado em 1 para cada ocorrência da letra.

        }

        contagem
    }
    
        let texto : Vec<char> = "Tamanduá Bandeira".chars().collect(); //chars converte a string em um vetor de caracteres e collect() coleta os caracteres em um vetor.
        let contagem_letras = contar_letras(texto);
        println!("Contagem das letras:{:?}", contagem_letras);




    // 3. Remoção condicional remover numeros pares

    fn remover_pares(v: Vec<i32>) -> Vec<i32> { // A função recebe um vetor de inteiros e um número específico, e retorna um novo vetor contendo apenas os elementos que são diferentes do número especificado.

         let mut resultado = Vec::new(); // Cria um novo vetor vazio para armazenar os elementos que não são iguais ao número especificado.

        for valor in v {
            if valor %  2 != 0 {
                resultado.push(valor);
            }

        }
        resultado     
    }

    let numeros = vec![1,2,3,4,5,6,7,8,9,10];
    let sempares = remover_pares(numeros);
    println!("Números sem os pares: {:?}", sempares);


    //4. mescla ordenada

    fn mesclar_sort(mut v1: Vec<i32>, v2: Vec<i32>) -> Vec<i32> { 
        v1.extend(v2);
        v1.sort();
        v1
    }

    let a = vec![1,3,5];
    let b = vec![2,4,6];
    let mesclado = mesclar_sort(a.clone(),b.clone());
    println!("Vetor mesclado e ordenado: {:?}", mesclado);


}


