package com.iweb.DAO;

import com.iweb.entity.Student;

import java.util.List;

/**
 * 提供学生类的基本的CRUD以及模糊查询和分页查询
 * @author Min
 * @date 2023/11/14 19:44
 */
public interface StudentDAO {
    /**
     * 向数据库插入学生数据
     * 包含了除id之外所有学生表所需要的字段值
     * @param stu
     */
    void insert(Student stu);

    /**
     * 根据学生id删除指定学生的数据
     * 学生的主键id如果等于null或者小于等于0，则无效
     * @param id
     */
    void delete(Integer id);

    /**
     * 根据学生id进行所有字段值得修改，暂不支持动态字段
     * 用于修改条件，其他字段作为修改值
     * @param stu
     */
    void update(Student stu);

    /**
     * 默认查询所有学生的信息
     * 返回查询到的学生对象集合，如果集合为空，则意味着表中没有数据
     * @return
     */
    List<Student> listAll();

    /**
     * 根据提供的key进行模糊查询
     *
     * @param key ，key为模糊查询关键字
     * @return 根据模糊查询返回的结果，如果没有查询到，集合为null
     */
    List<Student> listByNameLike(String key);

    /**
     * 根据提供的参数对学生信息进行limit分页查询
     * @param start limit的第一个参数，代表截取第几行的下一行
     * @param count limit的第二个参数，代表截取几行
     * @return 分页查询的返回结果，如果没有查询到，则返回null
     */
    List<Student> listByPage(Integer start, Integer count);

    /**
     * 根据提供的关键字key对学生表进行分页模糊查询
     * @param key 模糊拆寻的关键字
     * @param start limit的第一个参数，代表截取第几行的下一行
     * @param count limit的第二个参数，代表截取几行
     * @return 分页模糊查询的返回结果，如果没有查询到，则返回null
     */
    List<Student> listByPage(String key, Integer start, Integer count);

    /**
     * 插入1w条数据
     */
    void testInsert();
    Student listByIdWithGrade(Integer id);
    List<Student> listAllWithGrade(int start ,int limit);
    List<Student> listAllWithGrade();


}
