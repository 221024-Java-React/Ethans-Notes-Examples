//Hoisting will take function and variable declarations and move them to the top of their scope
function testLetHoist(str){
    console.log("Inisde the test let hoist");
    console.log(str);
}

testLetHoist(global);
//testLetHoist(globalLet);

//Global scoped variable
//Since this variable is globally scoped, and using the var keyword, it will be available to the testLetHoist
//function, even though we are declaring the variable after the method call
var global = 20;

//The let keyword is preventing this variable from being hoisted to the top of the script above the function call
//causing an error in the console
let globalLet = 20;

//Lets try to access the function scope variable
//console.log(functionScope);

hoistMe();

function hoistMe(){
    //Function scope variables
    //Here even though we are using the var keyword, it will only be hoisted to the top of its scope,
    //Which is function scope
    var functionScope = 11;
    console.log("Inside of the hoist me function: ", global);
    if(global > functionScope){
        //Since we are in an if statement, this variable is block scope
        //However, if we use the var keyword, it will be  hoisted to the top of the function
        //var blockScope = 30;
        let blockScope = 30;
    }

    //After we have used the let keyword, the blockScope variable no longer hoists, and it stays in blockscope
    console.log(blockScope);

}