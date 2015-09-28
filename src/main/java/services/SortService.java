package services;

import model.Student;

import java.util.List;

/**
 * Created by Aurimas on 28/09/15.
 */
public interface SortService {

    /**
     * Sorts Students by performance (DESC order)
     * @param students
     * @return sorted list
     */
    List<Student> sort(List<Student> students);

}
