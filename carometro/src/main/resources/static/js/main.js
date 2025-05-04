
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
                        <input id="identificacao2" type="text" id="nome" placeholder="Informe seu email ou telefone">
                    </div>
                    <div id="botoes">
                        <button type="button" id="voltar">voltar</button>
                        <button type="submit" id="recuperar">Recuperar senha</button>
                    </div>
                </form>
            </div>
        </div>
    `;

    const btnVoltar = document.getElementById('voltar');
    btnVoltar.addEventListener("click", telaInicial)

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
                        <button type="submit" id="registrar2">Registar-se</button>
                    </div>
                </form>
            </div>
        </div>
    `;

    const btnVoltar = document.getElementById("voltar2");
    btnVoltar.addEventListener("click", telaInicial);

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
                    <input type="text" id="identificacao" name="identificacao" placeholder="Email ou Telefone">
                    <input type="password" id="senhaAcesso" name="senhaAcesso" placeholder="Senha">
                    <button type="submit" id="entrar">Entrar</button>
                    <button type="button" id="recuperarSenha">Esqueceu a senha?</button>
                    <button type="button" id="registrar">Registrar-se</button>
                </form>
            </div>
        </div>
    `;
    const btnRecuperarSenha = document.getElementById("recuperarSenha");
    const btnRegistarUsuario = document.getElementById("registrar");
    
    btnRegistarUsuario.addEventListener("click", registrar);
    btnRecuperarSenha.addEventListener("click", recuperarSenha);
    
    trocarCorMenu("#CF2E2E");
}

function trocarCorMenu(cor){
    const menu = document.querySelectorAll("#menu li a");
    
    menu.forEach((link) => {
        link.style.color = cor;
    });
}

telaInicial();