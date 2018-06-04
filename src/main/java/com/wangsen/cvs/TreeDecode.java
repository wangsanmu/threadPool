package com.wangsen.cvs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangsen
 * @data 2018/6/4 22:11
 * @des sdflj/sdfsdf/dsfsfs
 */
public class TreeDecode {


    private static String treePath = "第一节点/第二节点/第三节点";

    public static void main(String[] args) {
        String[] splits = treePath.split("/");
        //首节点
        String parentId = "首节点";
        //获取下所有路径
        for(int i=0;i<=splits.length;i++){
            String allPath = getAllPath(splits, i+1);
            parentId =  paseTreeDecode(allPath,splits[i],parentId);
        }
    }

    public static String paseTreeDecode(String treePath,String treeName,String parentId){
        System.out.println("sd");
        //查找该节点
        if(true){
            //找到该节点
            return "id";
        }else{
            //创建该节点 创建节点的时候treeName取末尾的
            QaCatecory qaCatecory = new QaCatecory();
            qaCatecory.setParentId(parentId);
            qaCatecory.setParentId("id");
            return "id1";
        }
    }

    public static String getAllPath(String[] splits,int n) {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<n;i++){
            if(i<n-1){
                sb.append(splits[i]).append("/");
            }else{
                sb.append(splits[i]);
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
