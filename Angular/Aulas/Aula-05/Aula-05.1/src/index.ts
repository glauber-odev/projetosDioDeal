
// object = sem previsbilidade
let pessoa: object = {
    nome: "Gláuber",
    vulgo: "algum",
    idade: 30
};

//Objeto tipado = com previsibilidade
type Produto = {
    nome: string;
    preco: number;
    unidades: number;
};

let meuProduto: Produto = {
    nome : "Carrinho",
    preco : 20.99,
    unidades : 10
};