package abstraction;

public interface SimpleMath extends Subject {

    int schoolYear = 3;

    String[] topics = { "Adding", "Substracting", "Division", "Mutliplcation" };

    void teachAdding(int a, int b);

    void teachSubtraction(int a, int b);

    void teachDivision(double a, double b);

    void teachMultiplication(double a, double b);

}
