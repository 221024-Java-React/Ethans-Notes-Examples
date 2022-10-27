import abstraction.MathCourse;

public class AbstractionDriver {
    public static void main(String[] args) throws Exception {

        // We can now create an instance of our MathCourse and see that we have access
        // to all of the methods and states from the abstract class we extended and
        // interfaces we
        // implemented
        MathCourse mc = new MathCourse(201, 4 /* t */);

        // We can get access to the name and schoolYear properties from the abstract
        // class
        System.out.println(mc.name + " is meant for students in the grade " + mc.schoolYear);

        // We can call the concrete method from the Course class
        mc.startCourse();

        // We have access to methods and properties from Subject Interface
        mc.printCourseIsActive();

        System.out.println("It includes topics such as: ");
        // The actual list of topics is provided by the SimpleMath interface
        for (String topic : mc.getTopics()) {
            System.out.println(topic);
        }

        // Then we provided implementation for each of the SimpleMath methods in the
        // MathCourse class
        mc.teachAdding(2, 4);
        mc.teachSubtraction(10, 3);
        mc.teachMultiplication(5, 3);
        mc.teachDivision(10, 3);

        // We are now done teaching math for the day
        mc.endCourse();

    }
}
