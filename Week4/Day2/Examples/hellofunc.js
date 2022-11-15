//Functions are reusable peices of code
//We use the function keyword
//The most basic way to create a function
function reverseString(reverseMe){
    var reversed = '';

    //Logic for our function
    //check to see if we got passed a string
    if(typeof reverseMe === 'string'){
        for(var i = reverseMe.length-1; i>=0; i--){
            reversed += reverseMe.charAt(i);
        }
        return reversed;
    } else {
        console.log("This is not a string");
        return null;
    }

}

//To call the function, use the name with parenthesis
console.log(reverseString("Hello"));
console.log(reverseString(45));

///Function expressions, basically functions stored in a variable
//This is possible becuase everything in javascript is a object
//the goal of fizzbuzz is to return fizz if the number is divisible by 3, buzz if the number is divisible by 5
//fizzbuss is the number is divisible by both 3 and 5
var fizzBuzz = function(number){

    //If the number is divisible by both three and five
    if(number % 15 === 0){
        console.log("fizzbuzz");
    }
    else if(number % 5 === 0){
        console.log("buzz");
    }
    else if (number % 3 === 0){
        console.log("fizz");
    }
    else {
        console.log("not divisible");
    }

}

//To call the function expression you use the variable name with parenthesis
fizzBuzz(10);
fizzBuzz(9);
fizzBuzz(45);

//Immediately invoked function expressions
//This convention will run the function as soon as the script loads/as soon as its interpreted
(callMeImmeditately = function(){
    console.log("We will call this function immediately");
})();

function callMeBack(data) {
    console.log("The data we got back: ");
    console.log(data);
}

//Typically we wont define the call back as a "normal function", we will circle back later and show how we typically
//define callback functions
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

getData(callMeBack);

//Default parameters
function calculate(a = 0, b = 0){
    //now the defualt values for a is 0, and the default value for b is 0
    return a + b;
}

//If we dont provide any inputs without a default
console.log(calculate());

//We can now pass in one single value instead of 2
console.log(calculate(4));

function printName(name = ""){
    //tenary statement: expression ? true value : false value
    name !== "" ? console.log(name) : console.log("please prove your name");
}

printName();