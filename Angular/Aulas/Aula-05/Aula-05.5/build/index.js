"use strict";
class Character {
    constructor(strength, skill) {
        this.strength = strength;
        this.skill = skill;
    }
    ;
    attack() {
        console.log(`Attack with ${this.strength} points`);
    }
    ;
}
;
let snort = new Character(99, 25);
snort.attack();
