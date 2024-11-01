//decorators
function MinLength(length: number){
 return (target: any, key: string) => {
    let _value: string = target[key];

    const getter = () => _value;
    //value abaixo é o valor advindo do construtor
    const setter = (value: string) => {
        //validação se valor maior que o parâmetro do decorator
        if(value.length < length){
            throw new Error(`Tamanho menor do que ${length}`);            
        } else {
            _value = value;
        };
    };
    
    Object.defineProperty(target, key, {
        get: getter,
        set: setter,
    });
 };
}


class Api{

    @MinLength(3)
    name: string;

    constructor(name: string){
        this.name = name;
    };

};

let api = new Api("Example");
console.log(api.name);
