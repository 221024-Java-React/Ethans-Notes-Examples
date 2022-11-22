import React, {useState, useEffect} from 'react';
import { Course } from '../../Types/Course';
import { NewCourse } from '../NewCourse/NewCourse';
import { CourseCard } from '../CourseCard/CourseCard';
//If were passing in props, it would look like this...
//export const Courses:React.FC<PropType> = ({use object destructuring}) => {}
export const Courses:React.FC = () => {

    //Using state in a function component
    const [courses, setCourses] = useState<Course[]>([]);

    const addCourse = (course:Course):void => {
        setCourses([...courses, course]);
    }

    //We can watch for changes on the component using useEffect
    useEffect(() => {
        //Something that happens with a use effect is loading data
        if(courses.length < 1) {
            console.log("set the new course");
            setCourses([
                {
                    courseId: 1,
                    subject: "Reading",
                    courseNumber: 100,
                    courseName: "Intro to Reading",
                    teacher: "Ethan McGill"
                }
            ]);
        }

        console.log("Use effect called");
        console.log(courses);

        return (() => {
            console.log("Component unmounted");
        })

    }, [courses]);

    return (
        <div className="courses">
            <NewCourse newCourse={addCourse} currentId={courses.length+1}></NewCourse>
            <h1>We offer: {courses.length} courses</h1>
            {
                courses.map((course) => {
                    //Return a component, for each course in the list
                    return (
                        <CourseCard
                            courseId={course.courseId}
                            subject={course.subject}
                            courseNumber={course.courseNumber}
                            courseName={course.courseName}
                            teacher={course.teacher}
                            key={course.courseId}
                        ></CourseCard>
                    );
                })
            }
        </div>
    );

}