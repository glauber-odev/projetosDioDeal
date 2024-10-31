//o '...' spread operator
function concatArray<T>(...itens: T[]): T[]{
    return new Array().concat(...itens);
};

const numArray = concatArray<number[]>([1,7], [5]);
const strArray = concatArray<string[]>(["Miguel", "Roberto"], ["Marcílio"]);
console.log(numArray);
console.log(strArray);
