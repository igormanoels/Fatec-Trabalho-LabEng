const scriptPrincipal = document.getElementById("principal");
const dados = JSON.parse(localStorage.getItem("dados"));

//teste
if (dados) {
  alert(`User: ${dados.nome}\nLogin: ${dados.email}, senha: ${dados.senha}`);
}

document.addEventListener("DOMContentLoaded", function () {
  const inputPesquisa = document.getElementById("pesquisaPerfil");

  inputPesquisa.addEventListener("keypress", function (e) {
    if (e.key === "Enter") {
      e.preventDefault();
      const termoPesquisa = this.value.trim();

      if (termoPesquisa.includes("@")) {
        alert("Termo válido - executando pesquisa");
        pesquisarPerfil(termoPesquisa);
      } else {
        alert("Termo inválido - não contém @");
      }
    }
  });
});

function pesquisarPerfil(termo) {
  alert(`Função pesquisarPerfil executada com: ${termo}`);
}

function perfil() {
  scriptPrincipal.innerHTML = `
            <div id="bio">
                <div id="bio_superior">
                    <div id="foto">Foto</div>
                    <div id="infoBio">
                        <p id="identificadorPerfil">@IdentificadorUsuario</p>
                        <p id="nomePerfil">Nome Usuário, idade</p>
                        <p id="descricaoPerfil">Descrição Bio</p>
                    </div>
                </div>
                <div id="bio_inferior">
                    <a href="#">Instagram</a>
                    <a href="#">LinkedIn</a>
                    <a href="#">GitHub</a>
                </div>
            </div>


            <div id="numerosPerfil">
                <div id="visualizacoes">
                    <p id="qtdVisualizacoes">0</p>
                    <p>Visualizações do Perfil</p>
                </div>
                <div id="seguidores">
                    <p id="qtdSeguidores">0</p>
                    <p>Seguidores</p>
                </div>
                <div id="comentarios">
                    <p id="qtdComentarios">0</p>
                    <p>Comentários</p>
                </div>
            </div>

            <div id="apresentacaoEcomentarios">
                <div id="apresentacao">
                    <h3>Apresentação</h3>
                    <p>Ainda não há dados no perfil.</p>
                </div>
                <div id="comentarios">
                    <h3>Seção de Comentários</h3>
                    <p id="comentario">Ainda não há comentário no perfil.</p>
                </div>
            </div>
  `;

  const btnVoltar = document.getElementById("btnEditarPerfil");
  btnVoltar.addEventListener("click", editarPerfil);
}

function editarPerfil() {
  scriptPrincipal.innerHTML = `
    <div>
      <button type="submit" id="voltar">Voltar</button>
      <button type="submit" id="gravar">Gravar</button>
    </div>
  `;

  const btnVoltar = document.getElementById("voltar");
  btnVoltar.addEventListener("click", perfil);

}

function configurarPerfil() {}

perfil();
