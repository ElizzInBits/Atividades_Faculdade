function adicionarUC() {
    const novaUC = prompt("Digite o nome da nova UC:");
    if (novaUC && novaUC.trim() !== "") {
        const li = document.createElement("li");
        li.innerHTML = `${novaUC} <button onclick="moveUp(this)">⬆️</button> <button onclick="moveDown(this)">⬇️</button>`;
        document.getElementById("uc-lista").appendChild(li);
    }
}

function moveUp(btn) {
    const li = btn.parentElement;
    const prev = li.previousElementSibling;
    if (prev) {
        li.parentElement.insertBefore(li, prev);
    }
}

function moveDown(btn) {
    const li = btn.parentElement;
    const next = li.nextElementSibling;
    if (next) {
        li.parentElement.insertBefore(next, li);
    }
}

document.getElementById("add-uc").addEventListener("click", adicionarUC);


function validarCPF(cpf){
    const regex = /^\d{3}\.\d{3}\.\d{3}-\d{2}$/;
    return regex.test(cpf);
}

function validarEmail(email) {
  const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return regex.test(email);
}

function validarCampoCPF() {
    const erro = document.getElementById("cpf-incorreto");
    const valorCPF = document.getElementById("cpf").value;
    if (!validarCPF(valorCPF)) {
        erro.textContent = "CPF inválido.";
    } else {
        erro.textContent = "";
    }
}

document.getElementById("cpf").addEventListener("blur", validarCampoCPF);
document.getElementById("validar-cpf-btn").addEventListener("click", validarCampoCPF);


function validarCampoEmail() {
    const erro = document.getElementById("email-error");
    const valorEmail = document.getElementById("email").value;
    if (!validarEmail(valorEmail)) {
        erro.textContent = "Email inválido.";
    } else {
        erro.textContent = "";
    }
}

document.getElementById("email").addEventListener("blur", validarCampoEmail);
document.getElementById("validar-email-btn").addEventListener("click", validarCampoEmail);


function adicionarInfoPerfil() {
  const texto = document.getElementById("nova-info").value.trim();
  const paragrafo = document.getElementById("perfil-pessoal-texto");
  if (texto !== "") {
    paragrafo.innerHTML += " " + texto;
    document.getElementById("nova-info").value = "";
  }
}

function adicionarInfo() {
  const texto = document.getElementById("nova-info2").value.trim();
  const paragrafo = document.getElementById("perfil-profissional-academico");
  if (texto !== "") {
    paragrafo.innerHTML += " " + texto;
    document.getElementById("nova-info2").value = "";
  }
}


