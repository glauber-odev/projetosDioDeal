//funções tipadas
function addNumber(x: number, y: number): number{
    return x + y;
};


//outra função
function helloName(nome: string): string{
    return `Hello, ${nome}`;
};

let numero: number = addNumber(4,7);
console.log(numero);

console.log(helloName("Gláuber"));


function callToPhone(numero: number | string): string | number {
    return numero;
}

console.log(callToPhone(numero));

//funções assíncronas
async function getNameDB(id: number): Promise<string>{
    return "Jorge";
};

console.log(getNameDB(2));