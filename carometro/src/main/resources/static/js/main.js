const scriptPrincipal = document.getElementById("principal");

function recuperarSenha() {
  scriptPrincipal.innerHTML = `
        <div id="telaRecuperar">
            <div id="notificacoes2">
                <h1 class="titulo2">Encontre sua conta</h1>
                <p class="texto2">Insira seu <strong class="destaque2">email</strong> ou número de <strong class="destaque2">telefone</strong> para recuperar sua conta.</p>
            </div>
            
            <div id="formularioAcesso2">
                <form id="formularioRecuperar">
                    <div>
                        <input type="text" id="identificacaoRecuperar" placeholder="Informe seu email ou telefone">
                    </div>
                    <div id="botoes">
                        <button type="button" id="voltar">voltar</button>
                        <button type="submit" id="recuperar">Recuperar senha</button>
                    </div>
                </form>
            </div>
        </div>
    `;

  const btnVoltar = document.getElementById("voltar");
  btnVoltar.addEventListener("click", telaInicial);

  trocarCorMenu("#09694c");
}

function registrar() {
  scriptPrincipal.innerHTML = `
        <div id="telaRegistro">
            <div id="notificacoes3">
                <h1 class="titulo3">Criar uma nova conta</h1>
                <p class="texto3">É <strong class="destaque3">rápido</strong>, é <strong class="destaque3">fácil</strong>.</p>
            </div>
            
            <div id="formularioAcesso3">
                <form id="formularioRegistro">
                    <input type="text" id="nome2" placeholder="Nome">
                    <input type="text" id="sobrenome2" placeholder="Sobrenome">
                    <input type="text" id="email2" placeholder="Informe seu email">
                    <input type="text" id="telefone2" placeholder="Telefone: XX-XXXXX-XXXX">
                    <input type="password" id="senha2" placeholder="Digite sua senha">
                    <input type="password" id="senhaRepetida2" placeholder="Repita sua senha">
                    <div id="botoes2"> 
                        <button type="button" id="voltar2">voltar</button>
                        <button type="submit" id="registrar2">Registrar-se</button>
                    </div>
                </form>
            </div>
        </div>
    `;

  const formularioRegistro = document.getElementById("formularioRegistro");

  formularioRegistro.addEventListener("submit", async (event) => {
    event.preventDefault();

    const usuario = {
      nome: document.getElementById("nome2").value,
      sobrenome: document.getElementById("sobrenome2").value,
      email: document.getElementById("email2").value,
      telefone: document.getElementById("telefone2").value,
      senha: document.getElementById("senha2").value,
    };

    const senhaRepetida = document.getElementById("senhaRepetida2").value;

    if (usuario.senha !== senhaRepetida) {
      alert("As senhas não coincidem!");
      return;
    }

    try {
      const resposta = await fetch("http://localhost:8080/api/usuarios", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(usuario),
      });

      if (resposta.ok) {
        alert("Usuário registrado com sucesso!");
        telaInicial();
      } else {
        const erro = await resposta.text();
        alert("Erro ao registrar: " + erro);
      }
    } catch (erro) {
      alert("Erro de conexão com a API.");
      console.error(erro);
    }
  });

  document.getElementById("voltar2").addEventListener("click", telaInicial);

  trocarCorMenu("#243E63");
}

function telaInicial() {
  scriptPrincipal.innerHTML = `
        <div id="telaInicial">
            <div id="notificacoes">
                <h1 class="titulo">Carômetro</h1>
                <p class="texto">Conectando <strong class="destaque">talentos</strong>, construindo <strong class="destaque">futuros</strong>. O seu portfólio universitário começa aqui!</p>
            </div>
            
            <div id="formularioAcesso">
                <form id="formularioLogin">
                    <input type="text" id="identificacao" placeholder="Email ou Telefone">
                    <input type="password" id="senhaAcesso" placeholder="Senha">
                    <button type="submit" id="entrar">Entrar</button>
                    <button type="button" id="recuperarSenha">Esqueceu a senha?</button>
                    <button type="button" id="registrar">Registrar-se</button>
                </form>
            </div>
        </div>
    `;

  const formularioLogin = document.getElementById("formularioLogin");

  formularioLogin.addEventListener("submit", async (event) => {
    event.preventDefault();

    const login = {
      email: document.getElementById("identificacao").value,
      senha: document.getElementById("senhaAcesso").value,
    };

    try {
      const resposta = await fetch("http://localhost:8080/api/usuarios/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(login),
      });

      if (resposta.ok) {
        const dados = await resposta.json();
        alert("Bem-vindo, " + dados.nome + "!");
        window.location.href = "home.html";
      } else {
        alert("Credenciais inválidas.");
      }
    } catch (erro) {
      alert("Erro de conexão com a API.");
      console.error(erro);
    }
  });

  document
    .getElementById("recuperarSenha")
    .addEventListener("click", recuperarSenha);
  document.getElementById("registrar").addEventListener("click", registrar);

  trocarCorMenu("#CF2E2E");
}

function trocarCorMenu(cor) {
  document.querySelectorAll("#menu li a").forEach((link) => {
    link.style.color = cor;
  });
}

telaInicial();
