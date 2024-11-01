//decorators
//Factory
function apiVersion(version: string){
    return (target: any) => {
        Object.assign(target.prototype, {__version: version, __name: "Gláuber"});
    };
};


@apiVersion("1.10")
class Api{}

let api = new Api();
console.log(api.__version, api.__name);