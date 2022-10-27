package abstraction;

public interface Subject {

    boolean isActive = true;

    String[] getTopics();

    default void printCourseIsActive() {
        System.out.println("This course is currently being taught t/f: " + isActive);
    }

}
