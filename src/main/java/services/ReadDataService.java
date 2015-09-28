package services;

import model.Student;

import java.util.List;

/**
 * Created by Aurimas on 28/09/15.
 * Service for reading data
 */
public interface ReadDataService {

    List<Student> read(String filePath);
}
