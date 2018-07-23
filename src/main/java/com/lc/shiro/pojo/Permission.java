package com.lc.shiro.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @Author: lichao
 * @Description:
 * @Date: 2018/7/23 15:56
 */
@Entity
@Table(name = "t_permission")
public class Permission {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(length = 20)
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
