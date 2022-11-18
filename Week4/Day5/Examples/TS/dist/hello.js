"use strict";
//Declaring a variable
//we still use let, var, const
let num = 10;
//Its not legal to change the datatype now
//num = "some string";
//Arrays will be slightly different because you have to declare the datatype being stored
//let numberArray : number[] = [1,2,3,4];
let numberArray = new Array();
numberArray.push(5);
numberArray.push(9.5);
numberArray.push(-5);
//We can only put number types, nothing else
//numberArray.push("Some string");
console.log(numberArray);
//Creating classes with Typescript
class Animal {
    //We must have a constructor if the class has properites
    constructor(name, species) {
        this.name = name;
        this.species = species;
    }
    //We can have normal old methods in the class
    speak() {
        return `The animal ${this.name} says hello`;
    }
    //we can also have void methods, aka methods that return nothing
    move(feet) {
        console.log(`The animal ${this.name} moved ${feet} feet`);
    }
    //Getters and setters will act like properties rather than methods
    get getName() {
        return this.name;
    }
    set setName(name) {
        this.name = name;
    }
    get getSpecies() {
        return this.species;
    }
    set setSpecies(species) {
        this.species = species;
    }
}
//To create a new object of this class, use the new keyword with the constructor
let gabi = new Animal('Gabi', 'Cat');
//To use the mutators, we do not need to use parenthesis because we access them like properties
console.log(gabi.getName);
console.log(gabi.speak());
gabi.setSpecies = "Calico Cat";
console.log(gabi);
//Inheritance with classes in TS
class Dog extends Animal {
    constructor(name) {
        super(name, "Dog");
    }
    bark() {
        console.log("arf arf");
    }
    speak() {
        return `The dog ${this.getName} barks hello`;
    }
}
let leia = new Dog("Leia");
console.log(leia);
leia.setSpecies = "Shipooh";
console.log(leia);
leia.move(5);
leia.bark();
console.log(leia.speak());
//When we want to use this interface
let user1 = {
    username: "Leroy",
    password: "Jenkins",
    login: (() => { return true; })
};
let user2 = {
    username: "Steve",
    password: "I mine blocks",
    phone: 5555555555,
    login: (() => { return true; })
};
console.log(user1);
console.log(user2.login());
