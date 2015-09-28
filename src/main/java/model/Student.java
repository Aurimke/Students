package model;

/**
 * Created by Aurimas on 28/09/15.
 */
public class Student {

    private String name;
    private float performance;

    public Student(String name, float performance) {
        this.setName(name);
        this.setPerformance(performance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPerformance() {
        return performance;
    }

    public void setPerformance(float performance) {
        this.performance = performance;
    }
}
