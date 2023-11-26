package com.iweb.classwork;

import lombok.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Min
 * @date 2023/11/24 16:18
 */
@Data
public class TBDao {
    String description;
    String response;
    public static List<TBDao> listByLike(String key) {
        List<TBDao> lt = new ArrayList<>();
        String sql = "select * from tb where description like concat('%',?,'%')";
        try (Connection c = DButil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ){
            ps.setString(1,key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                TBDao tb = new TBDao();
                tb.setDescription(rs.getString("description"));
                tb.setResponse(rs.getString("response"));
                lt.add(tb);
            }
            if(lt.isEmpty()){
                TBDao tb = new TBDao();
                tb.response = "没有找到对应的问题~";
                lt.add(tb);
            }
        }catch (Exception e){
            e.printStackTrace();

        }
        return lt;
    }

}
