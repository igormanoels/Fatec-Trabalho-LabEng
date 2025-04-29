
let traducoes = {};

fetch("/lang/traducoes.json")
  .then((response) => response.json())
  .then((data) => {
    traducoes = data;
    trocarIdioma("pt"); // Define o idioma padrão depois que carregar
  })
  .catch((error) => console.error("Erro ao carregar traduções:", error));

function trocarIdioma(idioma) {
  const lang = traducoes[idioma];
  if (lang) {
    document.querySelector(".titulo").innerText = lang.title;
    document.querySelector(".texto]").innerText = lang.email;
    document.querySelector(".senha").innerText = lang.password;
    document.querySelector(".usuario").innerText = lang.login;
  }
}

document.getElementById("idioma").addEventListener("change", (e) => {
  trocarIdioma(e.target.value);
});