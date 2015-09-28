import model.Student;
import services.ReadDataService;
import services.SortService;
import services.impl.BubbleSortServiceImpl;
import services.impl.HeapSortServiceImpl;
import services.impl.MergeSortServiceImpl;
import services.impl.ReadFromFileServiceImpl;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Aurimas on 28/09/15.
 */
public class ProgramWindow extends JPanel implements ActionListener {

    protected JButton addFile, sortBubble, sortHeap, sortMerge;
    private List<Student> students;
    protected JTextArea textArea;

    public ProgramWindow() {
        super(new BorderLayout());
        button("Add file", "add", addFile, BorderLayout.WEST);
        button("Sort like bubble", "bubble", sortBubble, BorderLayout.NORTH);
        button("Sort like merge", "merge", sortMerge, BorderLayout.EAST);
        button("Sort like heap", "heap", sortHeap, BorderLayout.SOUTH);
        textArea = new JTextArea(10, 20);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if ("add".equals(e.getActionCommand())) {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Txt", "txt");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(this);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                ReadDataService read = new ReadFromFileServiceImpl();
                this.students = read.read(chooser.getSelectedFile().getPath());
                textArea.setText("Added list size: " + this.students.size());
            }
        }
        if ("heap".equals(e.getActionCommand()) || "bubble".equals(e.getActionCommand()) || "merge".equals(e.getActionCommand())) {
            SortService sortService = new BubbleSortServiceImpl();;
            if ("merge".equals(e.getActionCommand())) {
                sortService = new MergeSortServiceImpl();
            }
            if ("heap".equals(e.getActionCommand())) {
                sortService = new HeapSortServiceImpl();
            }
            long start = System.nanoTime();
            List<Student> bubble = sortService.sort(this.students);
            long elapsedTime = System.nanoTime() - start;
            drawTable(students);
            textArea.append("\n Time:" + elapsedTime + "  List size:" + bubble.size());
        }
    }

    private void drawTable(List<Student> students) {
        String[] columnNames = {"Name", "Performance"};
        Object[][] data = new Object[students.size()][2];
        for(int i = 0; i < students.size(); i++) {
            data[i][0] = students.get(i).getName();
            data[i][1] = students.get(i).getPerformance();
        }
        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);
        Container container = new Container();
        container.setLayout(new BorderLayout());
        container.add(table.getTableHeader(), BorderLayout.PAGE_START);
        container.add(table, BorderLayout.CENTER);
        add(container, BorderLayout.PAGE_END);
    }

    private void button(String name, String action, JButton button, String borderLayout) {
        button = new JButton(name);
        button.setVerticalTextPosition(AbstractButton.CENTER);
        button.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
        button.setActionCommand(action);

        button.addActionListener(this);
        add(button, borderLayout);
    }
}
