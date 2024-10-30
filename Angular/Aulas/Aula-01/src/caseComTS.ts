type Hero = {
    nome: string;
    vulgo: string;
    telefone: string;
};

function liga(hero: Hero){
    console.log("Ligando para : " + hero.telefone);
};

ligar({
    nome : "Steve Rogers",
    vulgo : "Capitão América",
    telefone : "11 994345532"
});