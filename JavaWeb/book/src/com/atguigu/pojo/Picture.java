package com.atguigu.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 *@ClassName Picture
 *@Description  TODO
 *@Author hqb
 *@Date 2022/3/13 15:43
 *@Version 1.0
 */
public class Picture{

    private String id;
    private String strImg;
    private Map<String, String> map;

  /*  public Integer getId() {
        return id;
    }*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStrImg() {
        return strImg;
    }

/*    public void setId(Integer id) {
        this.id = id;
    }*/

    public void setStrImg(String strImg) {
        this.strImg = strImg;
    }

  /*  public Map<Integer, String> getMap() {
        return map;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }*/

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Picture() {
    }
}

