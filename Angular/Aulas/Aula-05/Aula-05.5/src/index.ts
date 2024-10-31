class Character{
    name?: string;
    strength: number = 45;
    skill: number;

    constructor(strength: number, skill: number){
        this.strength = strength;
        this.skill = skill;
    };

    attack(): void{
        console.log(`Attack with ${this.strength} points`);
    };
};



class Magician extends Character{
    magicPoints: number;
    constructor(numero: number, skill: number, name: string, magicPoints: number){
        super(numero, skill);
        this.name = name;
        this.magicPoints = magicPoints;
    };
};

let snort = new Character(99, 25);
snort.attack();
let magic = new Magician(213214, 53, "Magico", 32490);