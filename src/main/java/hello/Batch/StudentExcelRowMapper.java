package hello.Batch;

import hello.Entity.Student;
import org.springframework.batch.item.excel.RowMapper;
import org.springframework.batch.item.excel.support.rowset.RowSet;

import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.Long.parseLong;
import static java.lang.Long.valueOf;

/**
 * Created by ELLLisa on 2017/6/21.
 */
public class StudentExcelRowMapper implements RowMapper<Student> {

    static Long ID = 141220074L;

    @Override
    public Student mapRow(RowSet rowSet) throws Exception {
        Student student = new Student();
        student.setId(transferLong(rowSet.getColumnValue(0)));
        student.setStudentname(rowSet.getColumnValue(1));
        student.setDepartment(rowSet.getColumnValue(3));
        student.setGrade(rowSet.getColumnValue(4));
        return student;
    }

    private Long transferLong(String num) {
        long result = 1;
        for (int i = 2; i < 10; i++) {
            result = result * 10 + num.charAt(i) - '0';
        }
        return new Long(result);
    }

    private Integer transferInteger(String num) {
        int i = 0;
        int index = 0;
        while (num.charAt(index) != '.') {
            i = i * 10 + num.charAt(index) - '0';
        }
        return new Integer(i);
    }
}
