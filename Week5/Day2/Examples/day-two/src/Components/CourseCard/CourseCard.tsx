import React from 'react';
import { Course } from '../../Types/Course';

export const CourseCard:React.FC<Course> = ({courseId, subject, courseNumber, courseName, teacher}) => {
    return(
        <div className="course-card">
            <h1>{`${subject}${courseNumber}`}</h1>
            <h2>{courseName}</h2>
            {teacher ? <p>{teacher}</p> : <p>To be determined</p>}
        </div>
    )
}