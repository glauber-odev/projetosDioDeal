"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
function addNumber(x, y) {
    return x + y;
}
;
function helloName(nome) {
    return `Hello, ${nome}`;
}
;
let numero = addNumber(4, 7);
console.log(numero);
console.log(helloName("Gláuber"));
function callToPhone(numero) {
    return numero;
}
console.log(callToPhone(numero));
function getNameDB(id) {
    return __awaiter(this, void 0, void 0, function* () {
        return "Jorge";
    });
}
;
console.log(getNameDB(2));
