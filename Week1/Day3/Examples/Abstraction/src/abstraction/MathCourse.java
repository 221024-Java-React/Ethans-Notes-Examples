package abstraction;

public class MathCourse extends Course implements SimpleMath {

    // private Teacher instructor;

    public MathCourse(int classId, int roomNum /* ,Teacher t */) {
        super("Intro to Basic Math", classId, roomNum);
        // this.instructor = t;
    }

    @Override
    public void teachAdding(int a, int b) {
        System.out.println("We can add a + b to get: " + (a + b));

    }

    @Override
    public void teachSubtraction(int a, int b) {
        System.out.println("We can subtract a - b to get: " + (a - b));
    }

    @Override
    public void teachDivision(double a, double b) {
        System.out.println("We can divide a by b to get: " + (a / b));

    }

    @Override
    public void teachMultiplication(double a, double b) {
        System.out.println("We can multiply a by b to get: " + (a * b));

    }

    @Override
    public String[] getTopics() {
        // We can get the list of topics from our SimpleMath interface
        return topics;
    }

    @Override
    public void endCourse() {
        System.out.println("This course is now complete");
    }

}
