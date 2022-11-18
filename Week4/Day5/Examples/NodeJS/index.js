//We can write normal old JS
//To import we use the import keyword, and if you did not export default you must put everything
// you want to import in curly braces
import {people, sayHello} from "./moduleExample.js";


console.log("I am javascript running outside of a browser");

/*
fetch("https://pokeapi.co/api/v2/pokemon/pikachu")
.then((res) => res.json())
.then((data) => console.log(data));
*/

console.log(people);

sayHello(people[1]);