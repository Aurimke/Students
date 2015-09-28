package services.impl;

import model.Student;
import services.SortService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aurimas on 28/09/15.
 */
public class HeapSortServiceImpl implements SortService {

    @Override
    public List<Student> sort(List<Student> students) {
        List<Student> forSorting = new ArrayList<Student>();
        forSorting.addAll(students);

        int total = forSorting.size() - 1;

        for (int i = total / 2; i >= 0; i--) {
            heapify(forSorting, i, total);
        }

        for (int i = total; i > 0; i--) {
            swap(forSorting, 0, i);
            total--;
            heapify(forSorting, 0, total);
        }

        return forSorting;
    }

    private static void swap(List<Student> forSorting, int a, int b) {
        Student tmp = forSorting.get(a);
        forSorting.set(a, forSorting.get(b));
        forSorting.set(b, tmp);
    }

    private static void heapify(List<Student> forSorting, int i, int total) {
        int lft = i * 2;
        int rgt = lft + 1;
        int grt = i;

        if (lft <= total && forSorting.get(lft).getPerformance() < forSorting.get(grt).getPerformance()) {
            grt = lft;
        }

        if (rgt <= total && forSorting.get(rgt).getPerformance() < forSorting.get(grt).getPerformance()) {
            grt = rgt;
        }

        if (grt != i) {
            swap(forSorting, i, grt);
            heapify(forSorting, grt, total);
        }
    }

}
