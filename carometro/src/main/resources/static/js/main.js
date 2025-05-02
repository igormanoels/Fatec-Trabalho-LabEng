
const scriptPrincipal = document.getElementById("principal");

function recuperarSenha() {
    scriptPrincipal.innerHTML = `
            <div id="notificacoes">
                <h1 class="titulo">Encontre sua conta</h1>
                <p class="texto">Insira seu <strong>email</strong> ou número de <strong>telefone</strong> para recuperar sua conta.</p>
            </div>
            
            <div id="formularioAcesso">
                <form id="formulario">
                    <input type="text" id="nome" placeholder="Nome">
                    <button type="button" id="voltar">voltar</button>
                    <button type="submit">Recuperar senha</button>
                </form>
            </div>
    `;

    const btnVoltar = document.getElementById('voltar');
    btnVoltar.addEventListener("click", telaInicial)
}

function registrar() {
    scriptPrincipal.innerHTML = `
            <div id="notificacoes">
                <h1 class="titulo">Criar uma nova conta</h1>
                <p class="texto">É <strong>rápido</strong>, é <strong>fácil</strong>.</p>
            </div>
            
            <div id="formularioAcesso">
                <form id="formulario">
                    <input type="text" id="nome" placeholder="Nome">
                    <input type="text" id="sobrenome" placeholder="Sobrenome">
                    <input type="text" id="email" placeholder="Informe seu email">
                    <input type="text" id="telefone" placeholder="Telefone: XX-XXXXX-XXXX">
                    <input type="password" id="senha" placeholder="Digite sua senha">
                    <input type="password" id="senhaRepetida" placeholder="Repita sua senha">
                    <button type="button" id="voltar">voltar</button>
                    <button type="submit">Registar-se</button>
                </form>
            </div>
    `;

    const btnVoltar = document.getElementById("voltar");
    btnVoltar.addEventListener("click", telaInicial);
}

function telaInicial() {
    scriptPrincipal.innerHTML = `
            <div id="notificacoes">
                <h1 class="titulo">Carômetro</h1>
                <p class="texto">Conectando <strong>talentos</strong>, construindo <strong>futuros</strong>. O seu portfólio universitário começa aqui!</p>
            </div>
            
            <div id="formularioAcesso">
                <form id="formulario">
                    <input type="text" id="identificacao" name="identificacao" placeholder="Email ou Telefone">
                    <input type="password" id="senhaAcesso" name="senhaAcesso" placeholder="Senha">
                    <button type="submit">Entrar</button>
                    <button type="button" id="recuperarSenha">Esqueceu a senha?</button>
                    <button type="button" id="registrar">Registrar-se</button>
                </form>
            </div>
    `;
    const btnRecuperarSenha = document.getElementById("recuperarSenha");
    const btnRegistarUsuario = document.getElementById("registrar");
   
    btnRegistarUsuario.addEventListener("click", registrar);
    btnRecuperarSenha.addEventListener("click", recuperarSenha);
}

telaInicial();