package services.impl;

import model.Student;
import services.ReadDataService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aurimas on 28/09/15.
 */
public class ReadFromFileServiceImpl implements ReadDataService {

    public static final String SEPARATOR = ",";
    public static final int LINE_LENGTH = 2;


    @Override
    public List<Student> read(String filePath) {
        BufferedReader br = null;
        String line = "";
        List<Student> students = new ArrayList<Student>();

        try {

            br = new BufferedReader(new FileReader(filePath));
            // Reading file
            while ((line = br.readLine()) != null) {

                String[] info = line.split(SEPARATOR);
                //Checking if line has all info
                if (info.length != LINE_LENGTH) {
                    //Skip line (incorrect data)
                    System.out.println("Skipped line.");
                    continue;
                }
                // Creating Student object
                Student student = new Student(info[0], getFloat(info[1]));
                students.add(student);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return students;
    }

    private float getFloat(String number) throws NumberFormatException{
        if (number == null) {
            return 0.0f;
        }
        return Float.parseFloat(number);
    }

}
