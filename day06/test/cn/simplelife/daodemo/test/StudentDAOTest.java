package cn.simplelife.daodemo.test;

import cn.simplelife.daodemo.dao.IStudentDAO;
import cn.simplelife.daodemo.dao.impl.StudentDAOImpl;
import cn.simplelife.daodemo.domain.Student;
import org.junit.Test;

import java.util.List;

/**
 * @ClassName StudentDAOTest
 * @Description
 * @Author simplelife
 * @Date 2022/10/3 18:40
 * @Version 1.0
 */

public class StudentDAOTest {
    private IStudentDAO studentDAO = new StudentDAOImpl();

    @Test
    public void insert() {
        studentDAO.insert(new Student(null, "王五", 52, "6521@qq.com"));
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
        System.out.println(students);
    }
}