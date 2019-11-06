package com.evan.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * @description:
 * @author: Mr.Wu
 * @create: 2019/11/6 15:12
 **/
@Entity
@Table(name = "menu")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    String name;
    String navitem;
    String icon;

    public String getNavitem() {
        return navitem;
    }

    public void setNavitem(String navitem) {
        this.navitem = navitem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
