const nome_usuario = '';
const senha_usuario = '';


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

