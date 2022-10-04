package cn.simplelife.daodemo1.dao;

import cn.simplelife.daodemo1.domain.Student;

import java.util.List;

/**
 * @ClassName IStudentDao
 * @Description
 * @Author simplelife
 * @Date 2022/10/3 18:25
 * @Version 1.0
 */

public interface IStudentDAO {
    /**
     * 插入一个学生信息
     * @param student 要插入的学生信息
     */
    void insert(Student student);

    /**
     * 根据id删除一个学生信息
     * @param id 要删除的学生id
     */
    void delete(Long id);

    /**
     * 根据学生id修改学生id
     * @param student 要修改学生的id和新的信息
     */
    void update(Student student);

    /**
     * 根据学生的id查询学生的信息
     * @param id 要查询的学生id
     * @return 返回一个学生信息
     */
    Student selectOne(Long id);

    /**
     * 查询所有的学生信息
     * @return 返回所有的学生信息列表
     */
    List<Student> selectList();
}
