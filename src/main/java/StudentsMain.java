import javax.swing.*;

/**
 * Created by Aurimas on 28/09/15.
 */
public class StudentsMain {

    public static void main(String[] args) {



        createAndShowGUI();

       /* ReadDataService read = new ReadFromFileServiceImpl();
        List<Student> students = read.read("/Users/Desktop/stud.txt");

        SortService sortService = new BubbleSortServiceImpl();
        long start = System.nanoTime();
        List<Student> bubble = sortService.sort(students);
        long elapsedTime = System.nanoTime() - start;

        for (Student s : bubble) {
            System.out.println(s.getPerformance());
        }
        System.out.println(elapsedTime + "  " + bubble.size());

        sortService = new HeapSortServiceImpl();
        start = System.nanoTime();
        List<Student> heap = sortService.sort(students);
        elapsedTime = System.nanoTime() - start;
        for (Student s : heap) {
            System.out.println(s.getPerformance());
        }
        System.out.println(elapsedTime + "  " + heap.size());

        sortService = new MergeSortServiceImpl();
        start = System.nanoTime();
        List<Student> merged = sortService.sort(students);
        elapsedTime = System.nanoTime() - start;
        for (Student s : merged) {
            System.out.println(s.getPerformance());
        }
        System.out.println(elapsedTime + "  " + merged.size());*/

    }

    private static void createAndShowGUI() {

        //Create and set up the window.
        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        ProgramWindow newContentPane = new ProgramWindow();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}
