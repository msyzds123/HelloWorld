package com.iweb.DAO;

import com.iweb.entity.Grade;
import lombok.Data;

import java.util.List;

/**
 * @author Min
 * @date 2023/11/15 18:26
 */
public interface GradeDAO {
    void createGrade();
    List<Grade> listBySid(Integer id);
    void insert(Grade g);
}
