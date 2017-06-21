package hello.Service.implement;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import hello.Entity.Student;
import hello.Repository.StudentRepository;
import hello.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by luping on 2017/6/22.
 */

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAll() {
        PageHelper.startPage(1, 10);
        return studentRepository.selectAllStudents();
    }

    public PageInfo<Student> selectStudents(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Student> student = studentRepository.selectAllStudents();
        PageInfo<Student> pageInfo = new PageInfo<>(student);
        return pageInfo;
    }


    public Student getById(Long Id) {
        return studentRepository.selectStudentById(Id);
    }

    public void deleteById(Long Id) {
        studentRepository.deleteStudentById(Id);
    }

    public void save(Student student) {
        studentRepository.insertStudent(student);
    }

    public void updateStudent(Student student) {
        Integer temp = (student.getUsual_grade() + student.getDesign_grade() + student.getExam_grade()) / 3;
        if (temp.intValue() > 0)
            student.setGrade(Integer.toString(temp.intValue()));
        studentRepository.updateStudent(student);
    }
}