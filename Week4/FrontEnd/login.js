//First thing we want to do is select that form element
let loginForm = document.getElementById("login");

//Add an event listener to our form to listen for a submit event
loginForm.addEventListener("submit", login);

function login(e){
    //We want to prevent the default action of the form so we can see the data and not reload the page
    e.preventDefault();
    console.log("Login form submitted");
    let email = document.getElementById("emailInput").value;
    let password = document.getElementById("passwordInput").value;

    //We might want to turn this into a json object to send to the backend
    let user = {
        email,
        password
    }

    //Use fetch to login the user
    const URL = "http://localhost:8000/person/login";
    fetch(URL, {
        method: "POST",
        body: JSON.stringify(user)
    })
    .then((response) => {
        if(response.ok){
            return response.json();
        } else {
            throw Error("Username or password incorrect");
        }
    })
    .then((data) => {
        if(data.type === "TEACHER"){
            window.location.href = "./teacher.html";
        }
        else {
            //do some other logic
            window.location.href = "./student.html";
        }
    })
    .catch(e => {
        let errorMessage = document.getElementById("error-message");
        errorMessage.innerHTML = "<h3>Username or password incorrect</h3>"
    });

}