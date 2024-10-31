"use strict";
;
const robotInstance = {
    id: 2,
    nome: "ciborg",
    sayHello: function () {
        return `Hello, I'm ${this.nome}`;
    }
};
class Pessoa {
    constructor(id, nome) {
        this.id = id;
        this.nome = nome;
    }
    sayHello() {
        return `Hello, I'm ${this.nome}`;
    }
    ;
}
let p = new Pessoa(333, "Digimon");
console.log(p.sayHello());
