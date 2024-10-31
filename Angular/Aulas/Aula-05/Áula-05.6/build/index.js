"use strict";
function concatArray(...itens) {
    return new Array().concat(...itens);
}
;
const numArray = concatArray([1, 7], [5]);
const strArray = concatArray(["Miguel", "Roberto"], ["Marcílio"]);
console.log(numArray);
console.log(strArray);
