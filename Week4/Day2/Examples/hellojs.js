//Our first JS file, lets play with some datatypes and variables
//Strings are just text surrounded by quotes
var string1 = 'hello this is a valid string in js';
var string2 = "hello this also a valid string in js";
var string3 = "You can't easily do things like this with java";
var string4 = 'You can make a "quote" very easily';

//If we wanted to print something to console in the browser, you use console.log()
console.log("string 1:", string1);
console.log("string 2:", string2);
console.log("string 3:", string3);
console.log("string 4:", string4);

//Chris' crazy banana console.log
console.log(('b' + 'a' + + 'a' + 'a').toLowerCase());


//The number datatype
var num1 = 5;
var num2 = 3.14;

//We also have the special number types
var inf = Infinity;

var nan = NaN;

console.log("number 1:", num1);
console.log("number 2:", num2);
console.log("To inifinity:", inf);
console.log("Not a number:", nan);

//boolean true or false
var t = true;
var f = false;

console.log(t);
console.log(f);

//null vs undefined
//null is going to refer to being nothing/void of a value
//You have to manually set null values
var n = null;

//undefined, literally means the value has yet to be defined
var u;

//So variable n is null, and variable u is undefined
console.log(n);
console.log(u);

//Objects are key value pairs wrapped in curly braces with a name
let ethan = {
    name: "Ethan McGill",
    title: "Senior Trainer",
    company: "Revature"
};

//We have two ways of accessing the properties of this object
//The first way is dot notation
//If we want to get the value of ethans name
console.log(ethan.name);

//The second way of getting a properties value is with the bracket notation
//If we want to get ethans title
console.log(ethan["title"]);

//We can also change property values using either of those notations
ethan.title = "Lead Trainer";

ethan["name"] = "Ethan";

console.log(ethan);

//We can add properties like this
ethan.lastName = "McGill";

ethan["salary"] = 100000000;

console.log(ethan);

//Creating an array
var arr = [];

//We can either set values using the brackets, or use the built in push method
arr[0] = "hello";
arr.push("world");

console.log(arr);

//Removing values, you can either use slice or pop
arr.pop();
console.log(arr);

arr.push(num1);
arr.push(string1);
arr.push(ethan);

var arr2 = [];
arr2.push(1);
arr2.push(2);
arr2.push(3);
arr.push(arr2);
console.log(arr);

//Remove index 2
arr.splice(2,1);

console.log(arr);

//We can also reassign different indexes
arr[0] = "Hello World";

console.log(arr);

//Some of our control flow/Operators
//Special for loops

//Special for loop for looping through the indexes of an array
for(var i of arr){
    console.log(i);
}

//Test mark and joshs theory
/*
for(var val of ethan){
    console.log(val);
}
*/

//Special for loop for looping through the keys of an object
for(var key in ethan){
    //console.log(key);
    //Use that key information from the loop to get the values
    console.log(key, ":", ethan[key]);
}

//Take a look at our different comparisons
//Loose comparison, since the value of both are 3, it will return true, even though one is a string and the other is a number
console.log("3" == 3);

//Strict comparison, will check the value AND the type of the data before returning
console.log("3" === 3);

//Falsy values
var emptyString = "hello";
var undefinedValue;
var zero = 0;
var noValue = null;

//If we put any of these values in an if statement, they will return false
if(emptyString){
    console.log("The string is not empty");
} else {
    console.log("The string is empty");
}

//Check the variable for a value

if(undefinedValue){
    console.log(undefinedValue);
} else {
    console.log("The value has yet to be set, lets set it to an empty object");
    undefinedValue = {
        age: 12,
        career: "Building"
    };
}


undefinedValue.name = "Bob";

console.log(undefinedValue);
