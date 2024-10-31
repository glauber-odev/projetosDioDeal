//interface x type
type robot = {
    readonly id: number;
    nome: string;
};

interface robot1 {
    id: number | string;
    nome: string;
    sayHello(): string;
};


const robotInstance : robot1 = {
    id: 2,
    nome: "ciborg",
    sayHello: function (): string {
        return `Hello, I'm ${this.nome}`;
    }
};

class Pessoa implements robot1 {
    id: string | number;
    nome: string;

    constructor(id: string | number, nome: string){
        this.id = id;
        this.nome = nome;
    }

    sayHello(): string {
        return `Hello, I'm ${this.nome}`;
    };
    
}

let p = new Pessoa(333, "Gustsman");
console.log(p.sayHello())