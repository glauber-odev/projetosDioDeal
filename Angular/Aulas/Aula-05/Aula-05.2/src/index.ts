
//array
let dados: string[] = ["Allan", "Jorge", "Marcelo"];
let dados2: Array<string> = ["Allan", "Jorge", "Marcelo"];

//Array Multi type
let infos: (string | number)[] = ["Allan", 20, "Marcelo", 60];

//Tuplas
let boleto: [string, number, number] = ["agua conta", 199.9, 45924303];

//ordenação de datas
dados.pop();

//formato de hora
let aniversario: Date = new Date("2022-12-01 08:45");
console.log(aniversario.toString());