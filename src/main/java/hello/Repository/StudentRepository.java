package hello.Repository;

import hello.Entity.Student;
import java.util.List;

/**
 * Created by ELLLisa on 2017/6/21.
 */
public interface StudentRepository {

    Student selectStudentById(Long Id);

    Student selectStudentByName(String name);

    List<Student> selectAllStudents();

    Integer insertStudent(Student student);

    Integer updateStudent(Student student);

    Integer deleteStudentById(Long id);
}
