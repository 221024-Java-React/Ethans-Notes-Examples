import React, {useState, useEffect} from 'react';
import { Course } from '../../Types/Course';

interface NewCourse {
    subject: string;
    courseNumber: number;
    courseName: string;
}

interface NewCourseProps {
    newCourse(course:Course): void,
    currentId: number
}

export const NewCourse:React.FC<NewCourseProps> = ({newCourse, currentId}) => {

    /* Alternatively you can do state like this if you wanted
    const [subject, setSubject] = useState<string>("");
    const [courseNumber, setCourseNumber] = useState<number>(0);
    const [courseName, setCourseName] = useState<string>("");
    */

    const [course, setCourse] = useState<NewCourse>({
        subject: "",
        courseNumber: 0,
        courseName: ""
    });

    const handleChange = (e:React.ChangeEvent<HTMLInputElement>) => {
        //Anytime we type in one of our form fields, we want to update our state
        //Use enhanced object notation
        setCourse({
            ...course,
            [e.target.name]: e.target.value
        })
    }

    const handleClick = () => {
        let c = {
            courseId: currentId,
            subject: course.subject,
            courseNumber: course.courseNumber,
            courseName: course.courseName
        };

        newCourse(c);

        setCourse({
            subject: "",
            courseName: "",
            courseNumber: 0
        });

        //If we wanted to reset the input values as well, look into the useRef hook
    }

    useEffect(()=> {
        console.log("State updated: ", course);
    }, [course])

    return(
        <div>
            <h3>Course Subject:</h3>
            <input name="subject" type="text" onChange={handleChange} />
            <h3>Course Number</h3>
            <input name="courseNumber" type="number" onChange={handleChange} />
            <h3>Course Name</h3>
            <input name="courseName" type="text" onChange={handleChange} />
            <button onClick={handleClick}>Submit Course</button>
        </div>
    );

}