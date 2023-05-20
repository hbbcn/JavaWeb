package com.atguigu.admin.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.atguigu.admin.bean.Table;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Integer;

/**
 * @author : kame
 * @date: 2022/4/9 10:30 AM
 */

public class TreeVo {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TreeVo> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<TreeVo> nodeList) {
        this.nodeList = nodeList;
    }

    private Integer id;
    private String name;
    private List<TreeVo> nodeList;

    public TreeVo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TreeVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nodeList=" + nodeList +
                '}';
    }

    //模拟数据库查询出来的结果
    public static
    List<Table> tableData = Arrays.asList(
            new Table(1, 0, "根节点"),
            new Table(2, 1, "子节点1"),
            new Table(3, 2, "子节点1.1"),
            new Table(4, 2, "子节点1.2"),
            new Table(5, 2, "子节点1.3"),
            new Table(6, 1, "子节点2"),
            new Table(7, 6, "子节点2.1"),
            new Table(8, 6, "子节点2.2"),
            new Table(9, 1, "子节点3"),
            new Table(10, 9, "子节点3.1")
    );
    /**
     * list集合的行数据，转换成 tree 结构
     * @param beans
     * @return
     */
    public static List<TreeVo> list2Tree(List<Table> beans) {
        List<TreeVo> result = new ArrayList<>();
        if(!CollectionUtils.isEmpty(beans)){
            for(Table p : beans){
                if(p.getParentId() == null || p.getParentId() == 0) {
                    TreeVo vo = new TreeVo(p.getId(),p.getName());
                    vo.setNodeList(recurrence(beans, p));
                    result.add(vo);
                }
            }
        }
        return result;
    }

    public  String Bo2TreeTest(){
        List<TreeVo> result = TreeVo.list2Tree(tableData);
        String json = JSONUtil.toJsonStr(result);
        return json;
    }
    /**
     *  递归函数
     * @param list
     * @param vo
     */
    private static List<TreeVo> recurrence(List<Table> list, Table vo){
        List<TreeVo> subNodes = new ArrayList<>();
        for(Table d : list){
            if (vo.getId().equals(d.getParentId())) {
                TreeVo sub = new TreeVo(d.getId(), d.getName());
                sub.setNodeList(recurrence(list, d));
                subNodes.add(sub);
            }
        }
        return subNodes;
    }
}
