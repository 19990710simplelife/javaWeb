package cn.simplelife.homework.dao;

import cn.simplelife.homework.domain.Student;

import java.util.List;

/**
 * @ClassName IStudentDAO
 * @Description
 * @Author simplelife
 * @Date 2022/10/4 17:51
 * @Version 1.0
 */

public interface IStudentDAO {
    /**
     * 插入学生信息
     *
     * @param student 要插入的学生对象
     */
    void insert(Student student);

    /**
     * 根据id删除学生信息
     *
     * @param id 要删除的学生id
     */
    void delete(Long id);

    /**
     * 根据学生对象修改学生信息
     *
     * @param student 要修改的学生信息
     */
    void update(Student student);

    /**
     * 根据学生id查找一条学生信息
     *
     * @param id 要查询的学生id
     * @return 返回查询的学生对象
     */
    Student selectOne(Long id);

    /**
     * 查询所有的学生信息
     *
     * @return 返回查询的学生集合
     */

    List<Student> selectList();
}
