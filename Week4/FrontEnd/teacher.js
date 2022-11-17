let subject = document.getElementById("subject");

subject.addEventListener("change", (e) => {
    console.log(e.target.value);
});

let btn = document.getElementById("new-course-btn");
btn.addEventListener("click", newCourse);

let toggleCreate = document.getElementById("toggle-create");
toggleCreate.addEventListener("click", toggleCreateCourse)

let toggleAssign = document.getElementById("toggle-assign");
toggleAssign.addEventListener("click", toggleAssignTeacher);

document.getElementById("assign-teacher").addEventListener("submit", assignTeacher);

//We want to make this function asynchronous
async function newCourse(){
    let subject = document.getElementById("subject").value;
    let courseNumber = new Number(document.getElementById("courseNumber").value);
    let courseName = document.getElementById("courseName").value;

    if(!subject && !courseNumber && !courseName) return;

    let course = {
        subject,
        courseNumber,
        courseName
    }

    const URL="http://localhost:8000/course"

    //Now we can use the await keyword in the function
    let req = await fetch(URL, {
        method: "POST",
        body:  JSON.stringify(course)
    });

    //Know we need the data out of the result
    let body = await req.text();

    console.log(body);

    document.getElementById("new-course").reset();

    toggleCreateCourse()
}

async function assignTeacher(e){
    e.preventDefault();

    let courseId = new Number(document.getElementById("courseId").value);
    let subject = document.getElementById("subjectA").value;
    let courseNumber = new Number(document.getElementById("courseNumberA").value);
    let courseName = document.getElementById("courseNameA").value;
    let teacherId = new Number(document.getElementById("teacherId").value);

    let update = {
        courseId,
        subject,
        courseNumber,
        courseName,
        teacher: {
            id: teacherId
        }
    };

    try{
        let req = await fetch("http://localhost:8000/course", {
            method: "PUT",
            body: JSON.stringify(update)
        });
        
        let response = await req.text();

        console.log(response);
    } catch(e){
        console.log("Something went wrong with the request");
    }

    toggleAssignTeacher();
}

function toggleCreateCourse(){

    console.log("Clicked");

    let form = document.getElementById("new-course");

    if(form.hasAttribute("hidden")){
        form.removeAttribute("hidden");
        btn.removeAttribute("hidden");
    } else{
        form.setAttribute("hidden", "");
        btn.setAttribute("hidden", "");
    }
}

function toggleAssignTeacher(){

    console.log("Clicked");

    let form = document.getElementById("assign-teacher");

    if(form.hasAttribute("hidden")){
        form.removeAttribute("hidden");
    } else{
        form.setAttribute("hidden", "");
    }
}