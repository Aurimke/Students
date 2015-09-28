package services.impl;

import model.Student;
import services.SortService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aurimas on 28/09/15.
 */
public class MergeSortServiceImpl implements SortService {

    @Override
    public List<Student> sort(List<Student> students) {
        List<Student> forSorting = new ArrayList<Student>();
        forSorting.addAll(students);
        sortRecursive(forSorting, 0, forSorting.size());
        return forSorting;
    }

    public static void sortRecursive(List<Student> forSorting, int low, int high) {
        int N = high - low;
        if (N <= 1)
            return;
        int mid = low + N / 2;
        // recursively sort
        sortRecursive(forSorting, low, mid);
        sortRecursive(forSorting, mid, high);
        // merge two sorted subarrays
        Student[] temp = new Student[N];
        int i = low, j = mid;
        for (int k = 0; k < N; k++) {
            if (i == mid)
                temp[k] = forSorting.get(j++);
            else if (j == high)
                temp[k] = forSorting.get(i++);
            else if (forSorting.get(j).getPerformance() > forSorting.get(i).getPerformance())
                temp[k] = forSorting.get(j++);
            else
                temp[k] = forSorting.get(i++);
        }
        for (int k = 0; k < N; k++) {
            forSorting.set(low + k, temp[k]);
        }
    }

}
