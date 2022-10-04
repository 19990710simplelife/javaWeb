package cn.simplelife.homework.test;

import cn.simplelife.homework.dao.IStudentDAO;
import cn.simplelife.homework.dao.impl.IStudentDAOImpl;
import cn.simplelife.homework.domain.Student;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @ClassName IStudentDAOImplTest
 * @Description
 * @Author simplelife
 * @Date 2022/10/4 18:12
 * @Version 1.0
 */

public class IStudentDAOImplTest {

    private IStudentDAO studentDAO = new IStudentDAOImpl();

    @Test
    public void insert() {
        studentDAO.insert(new Student(null, "赵六11", 55, "6521@qq.com"));
    }

    @Test
    public void delete() {
        studentDAO.delete(4L);
    }

    @Test
    public void update() {
        Student student = new Student();
        student.setId(4L);
        student.setName("李四1");
        student.setAge(180);
        student.setEmail("15632111@qq.com");
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