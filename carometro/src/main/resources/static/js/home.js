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
    <div id="telaEditarPerfil">
      <div id="editarPerfil">
        <h1 class="tituloEditarPerfil">Editar Perfil</h1>
        <p class="texto3">Personalize suas <strong class="destaque3">informações</strong>.</p>
      </div>
            
      <div id="formularioAcesso3">
        <form id="formularioPerfil">
          <input type="text" id="identificador" placeholder="Identificador" value="@IdentificadorUsuario">
          <input type="text" id="nome" placeholder="Nome" value="Nome Usuário">
          <input type="text" id="sobrenome" placeholder="Sobrenome">
          <input type="text" id="idade" placeholder="Idade">
          <input type="text" id="descricao" placeholder="Descrição do perfil" value="Descrição Bio">
          <input type="text" id="sobre" placeholder="Sobre">
          
          <input type="text" id="rede1" placeholder="Rede Social 1">
          <input type="text" id="rede2" placeholder="Rede Social 2">
          <input type="text" id="rede3" placeholder="Rede Social 3">
          
          <div id="botoes"> 
            <button type="submit" id="gravarEdicao">Gravar</button>
          </div>
        </form>
      </div>

      <div id="formacoesAcademicas">
        <h3>Formações Acadêmicas</h3>
        <div id="listaAcademica">
          <!-- As formações serão adicionadas aqui dinamicamente -->
        </div>
        <button type="button" class="btn-adicionar" id="adicionarAcademico">+ Adicionar Formação</button>
      </div>

      <div id="experienciasProfissionais">
        <h3>Experiências Profissionais</h3>
        <div id="listaProfissional">
          <!-- As experiências serão adicionadas aqui dinamicamente -->
        </div>
        <button type="button" class="btn-adicionar" id="adicionarProfissional">+ Adicionar Experiência</button>
      </div>

      <div id="certificacoes">
        <h3>Certificações</h3>
        <div id="listaCertificados">
          <!-- As certificações serão adicionadas aqui dinamicamente -->
        </div>
        <button type="button" class="btn-adicionar" id="adicionarCertificado">+ Adicionar Certificação</button>
      </div>

      <button type="button" id="voltar">Voltar</button>
    </div>
  `;

  document
    .getElementById("adicionarAcademico")
    .addEventListener("click", adicionarFormacaoAcademica);
  document
    .getElementById("adicionarProfissional")
    .addEventListener("click", adicionarExperienciaProfissional);
  document
    .getElementById("adicionarCertificado")
    .addEventListener("click", adicionarCertificacao);

  adicionarFormacaoAcademica();

  const btnVoltar = document.getElementById("voltar");
  btnVoltar.addEventListener("click", perfil);

  const btnPerfil = document.getElementById("btnPerfil");
  btnPerfil.addEventListener("click", perfil);
}

function adicionarFormacaoAcademica() {
  const container = document.getElementById('listaAcademica');
  const id = Date.now(); 
  
  container.innerHTML += `
    <div class="experiencia-container" id="academico-${id}">
      <h4>Formação Acadêmica</h4>
      <input type="text" placeholder="Nome da Instituição" class="faculdade">
      <input type="text" placeholder="Nome do Curso" class="curso">
      <input type="text" placeholder="mês/ano inicial" class="mesAnoInicialAcad">
      <input type="text" placeholder="mês/ano final" class="mesAnoFinalAcad">
      <input type="text" placeholder="Competências" class="competenciasAcad">
      <button type="button" class="btn-remover-experiencia" onclick="removerExperiencia('academico-${id}')">Remover</button>
    </div>
  `;
}

function adicionarExperienciaProfissional() {
  const container = document.getElementById('listaProfissional');
  const id = Date.now();
  
  container.innerHTML += `
    <div class="experiencia-container" id="profissional-${id}">
      <h4>Experiência Profissional</h4>
      <input type="text" placeholder="Empresa" class="empresa">
      <input type="text" placeholder="Cargo" class="cargo">
      <input type="text" placeholder="mês/ano inicial" class="mesAnoInicialProf">
      <input type="text" placeholder="mês/ano final" class="mesAnoFinalProf">
      <input type="text" placeholder="Competências" class="competenciasProf">
      <button type="button" class="btn-remover-experiencia" onclick="removerExperiencia('profissional-${id}')">Remover</button>
    </div>
  `;
}

function adicionarCertificacao() {
  const container = document.getElementById('listaCertificados');
  const id = Date.now();
  
  container.innerHTML += `
    <div class="experiencia-container" id="certificado-${id}">
      <h4>Certificação</h4>
      <input type="text" placeholder="Título" class="titulo">
      <input type="text" placeholder="mês/ano de emissão" class="mesAnoCertificado">
      <input type="text" placeholder="Competências" class="competenciasCertificados">
      <button type="button" class="btn-remover-experiencia" onclick="removerExperiencia('certificado-${id}')">Remover</button>
    </div>
  `;
}

function removerExperiencia(id) {
  const elemento = document.getElementById(id);
  if (elemento) {
    elemento.remove();
  }
}

function configurarPerfil() {}

perfil();
