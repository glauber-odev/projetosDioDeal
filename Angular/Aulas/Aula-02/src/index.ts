type Heroi = {
    nome: string;
    vulgo: string;
};

// console.log("Hello world!");
function printarObjeto(pessoa: Heroi){
    console.log(pessoa);
};

printarObjeto({
    nome : "Bruce Wayne",
    vulgo : "Batman",
});