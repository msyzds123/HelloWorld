package com.iweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Min
 * @date 2023/11/13 22:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String userName;
    private String userPassword;
    public boolean equals(User anotherUser) {
        if (this == anotherUser) {
            return true;
        }
        if (anotherUser == null) {
            return false;
        }
        if (!userName.equals(anotherUser.userName)) {
            return false;
        }
        if (!userName.equals(anotherUser.userPassword)) {
            return false;
        }
        return true;
    }

}
