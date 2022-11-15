//Arrow functions, redefined how we create function expressions

let sayHello = (name) => console.log("Hello " + name);

//To call the function, you do the same as your function expressions
sayHello("Ethan");

//We can simplify that string contatentation with template literals
let sayHello2 = (name) => console.log(`Hello ${name}`);
sayHello2("Ethan");

//We can even pass entire functions/equations into the template literal
let calucate = (num1, num2, func) => {
    switch(func){
        case "ADD":
            return `The sum is: ${num1 + num2}`;
        case "SUB":
            return `The difference is ${num1 - num2}`;
        case "MULT":
            return `The product is ${num1 * num2}`;
        case "DIV":
            return `The quotient is ${num1 / num2}`;
        default:
            return "I didn't understand"
    }
}

console.log(calucate(2,3,"ADD"));
console.log(calucate(5,3,"SUB"));
console.log(calucate(5,3,"MULT"));
console.log(calucate(5,3,"DIV"));

//A realistic way to do callback
var getData = function(callback) {
    console.log("getting our data...");
    console.log("data loaded...");
    var data = {
        name: "Ethan",
        title: "Senior Trainer",
        company: "Revature"
    }
    callback(data);
}

//Typically we will write the callback function with an arrow function in the function parameters
getData((data)=> {
    console.log("The data was: ", data)
});

//Spread Operator, allows you to break apart arrays

//Use it to break the array up to pass data into functions
function sum(x,y,z){
    return x + y + z;
}

let numbers = [1,2,3];

//This will takes the numbers array
//And input each index as individual numbers
console.log(sum(...numbers));

//Another thing that spread is useful for is appending data to an array
let newNumber = 4;

numbers = [...numbers, newNumber]; //numbers = [1,2,3,4]
//numbers = [newNumber, ...numbers] -> numbers = [4,1,2,3]

console.log(numbers);

let state = {
    user: {
        name: "Ethan",
        company: "Revature"
    },
    cart: []
};

state = {
    ...state,
    cart: ['Apples', 'Oranges']
};

//Rest operator, is just like var args
function sumRest(...args){
    let sum = 0;
    for(a of args){
        sum+=a;
    }
    return sum;
}

console.log(sumRest(1,2,3,4));

//ES6 Feature called Object Destructuring
const user = {
    id: 1,
    name: "Ethan",
    isVerified: true
};

//What if we wanted to take all the properties and store them in a variable to use elsewhere

const {id, name, isVerified} = user;

console.log(`The users id is: ${id}`);

//ES6 Featured called enhanced objects
//Allows you to omit the colon when creating properties of an object when the variable you are using matches the property name
//Assume that our user has properties id, name, isVerified
/*
const enhancedUser = {
    id: id,
    name: name,
    isVerified: isVerified
}
*/
const enhancedUser = {
    id,
    name,
    isVerified
}

console.log(enhancedUser);

//The other cool thing about enhanced objects is the ability to programmatically assign keys and properties
let key = "fruit";
let value = "apples";

let func = () => {
    console.log("Attach a function to an enhanced object");
}

let newObj = {
    [key]: value,
    //Set any functions for the object without a colon as well
    //coolFunction: func
    func
}

console.log(newObj);

newObj.func();