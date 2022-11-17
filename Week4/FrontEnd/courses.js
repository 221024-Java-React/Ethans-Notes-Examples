//Immediately invoked function
(function loadCourses(){
    console.log("Loading courses...");

    const URL = "http://localhost:8000/course"

    //Fetch does a get request by default
    fetch(URL)
    .then((response) => response.json())
    .then((data) => {
        populateCourses(data);
    });

})();

function populateCourses(courses){
    let coursesDiv = document.getElementById("courses");

    for(let course of courses) {
        //Create an individual element for each course, then append that element to the page
        let courseInfo = document.createElement("div");
        courseInfo.setAttribute("class", "course-card");

        let {subject, courseNumber, courseName, teacher} = course;

        let title = document.createElement("h2");
        title.innerText = `${subject} ${courseNumber}`;

        let name = document.createElement("h3");
        name.innerText = courseName;

        let instructor = document.createElement("p");
        instructor.innerText = teacher ? `${teacher.firstName} ${teacher.lastName}` : "TBD";

        courseInfo.appendChild(title);
        courseInfo.appendChild(name);
        courseInfo.appendChild(instructor);

        coursesDiv.appendChild(courseInfo);
    }
}