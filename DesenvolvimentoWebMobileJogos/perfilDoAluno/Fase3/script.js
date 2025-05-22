function adicionarUC(){
    const novaUC = prompt("Digite o nome da nova UC: ")
    if (novaUC && novaUC.trim() !== "") {
        const li = document.createElement("li");
        li.innerHTML = '${novaUC} <button onclick="moveUp(this)">⬆️</button> <button onclick="moveDown(this)">⬇️</button>';
        document.getElementsById("uc-lista").appendChild(li);
        
    }
}

function moveUp(bnt){
    const li = bnt.parentElement;
    const prev = li.previousElementSibling;
    if(prev) {
        li.parentElement.insertBefore(li, prev);
    }
}

function moveDown(bnt){
    const li = bnt.parentElement;
    const next = li.nextElementSibling;
    if(next) {
        li.parentElement.insertBefore(next, li);
    }
}

function validarCPF(cpf){
    const regex = /^\d{3}\.\d{3}\.\d{3}-\d{2}$/;
    return regex.test(cpf);
}

function validarEmail(email) {
  const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return regex.test(email);
}

document.getElementById("cpf").addEventListener("blur", function() {
    const erro = document.getElementById("cpf-incorreto");
    if (!validarCPF(this.value)){
        erro.textContent = "CPF inválido."
    } else {
        erro.textContent = "";
    }
});

document.getElementById("email").addEventListener("blur", function () {
  const erro = document.getElementById("email-error");
  if (!validarEmail(this.value)) {
    erro.textContent = "E-mail inválido.";
  } else {
    erro.textContent = "";
  }
});

function adicionarInfoPerfil() {
  const texto = document.getElementById("nova-info").value.trim();
  const paragrafo = document.getElementById("perfil-pessoal-texto");
  if (texto !== "") {
    paragrafo.innerHTML += " " + texto;
    document.getElementById("nova-info").value = "";
  }
}

