package hello.Service;

import com.github.pagehelper.PageInfo;
import hello.Entity.Student;

import java.util.List;
/**
 * Created by ELLLisa on 2017/6/21.
 */
public interface StudentService {

    public List<Student> getAll();

    public Student getById(Long Id);

    public PageInfo<Student> selectStudents(Integer pageNum, Integer pageSize);

    public void deleteById(Long Id);

    public void save(Student student);

    public void updateStudent(Student student);
}
