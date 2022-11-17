let element = document.getElementById("timeout");
document.getElementById("start-timeout").addEventListener("click", start);
document.getElementById("stop-timeout").addEventListener("click", stopTimeout);
document.getElementById("start-interval").addEventListener("click", startInterval);
document.getElementById("stop-interval").addEventListener("click", stopInterval);

let timeout;

let interval;

function start(){
    element.innerText = "Timeout started...";

    //do some callback function, after so many miliseconds
    timeout = setTimeout(()=> {
        element.innerText = "Timeout Finished";
    }, 5000);
}

function stopTimeout(){
    clearTimeout(timeout);
    element.innerText = "Timeout was canceled";
}

function startInterval(){
    document.getElementById("sound1").play();
    interval = setInterval(()=> {
        let body = document.getElementsByTagName("body")[0];
        body.setAttribute("style", `background-color: ${disco()}`);
    }, 100);
}

function stopInterval(){
    document.getElementById("sound1").pause();
    clearInterval(interval);
    let body = document.getElementsByTagName("body")[0];
    body.setAttribute("style", `background-color: white}`);
}

function disco(){

    const possiblities = [0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F'];

    let value = '#';

    for(let i=0; i<6; i++){
        value += possiblities[Math.floor(Math.random() * 16)]
    }

    return value;

}