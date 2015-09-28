package services.impl;

import model.Student;
import services.SortService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aurimas on 28/09/15.
 */
public class BubbleSortServiceImpl implements SortService {

    @Override
    public List<Student> sort(List<Student> students) {
        List<Student> forSorting = new ArrayList<Student>();
        forSorting.addAll(students);
        boolean flag = true;   // set flag to true to begin first pass

        while (flag) {
            flag = false;    //set flag to false awaiting a possible swap
            for (int j = 0; j < forSorting.size() - 1; j++) {

                Student first = forSorting.get(j);
                Student second = forSorting.get(j + 1);

                if (first.getPerformance() < second.getPerformance()) {
                    //swap elements
                    forSorting.set(j, second);
                    forSorting.set(j + 1, first);
                    flag = true;              //shows a swap occurred
                }
            }
        }

        return forSorting;
    }

}
