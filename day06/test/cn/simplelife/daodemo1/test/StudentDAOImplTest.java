package cn.simplelife.daodemo1.test;

import cn.simplelife.daodemo1.dao.IStudentDAO;
import cn.simplelife.daodemo1.dao.impl.StudentDAOImpl;
import cn.simplelife.daodemo1.domain.Student;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @ClassName StudentDAOImplTest
 * @Description
 * @Author simplelife
 * @Date 2022/10/4 12:22
 * @Version 1.0
 */

public class StudentDAOImplTest {
    private IStudentDAO studentDAO = new StudentDAOImpl();

    @Test
    public void insert() {
        studentDAO.insert(new Student(null, "赵六", 50, "652114@qq.com"));
    }

    @Test
    public void delete() {
        studentDAO.delete(2L);
    }

    @Test
    public void update() {
        Student student = new Student();
        student.setId(4L);
        student.setName("李四");
        student.setAge(18);
        student.setEmail("156321@qq.com");
        studentDAO.update(student);
    }

    @Test
    public void selectOne() {
        Student student = studentDAO.selectOne(4L);
        System.out.println(student);
    }

    @Test
    public void selectList() {
        List<Student> students = studentDAO.selectList();
        students.forEach(System.out::println);
    }
}