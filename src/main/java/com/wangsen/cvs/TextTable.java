package com.wangsen.cvs;

import java.awt.Font;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangsen
 * @data 2018/6/3 0:23
 * @des
 */
public class TextTable {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        List<List<String>>  listList = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("第三方");
        strings.add("2");
        listList.add(strings);
        TextTable table =  new TextTable(stringList,listList);
        System.out.println(table.printTable());

        File file =  new File("a.txt");
        try {
            FileWriter writer = new FileWriter(file);
            long startTime =  System.currentTimeMillis();
            writer.write(table.printTable());
            writer.flush();
            writer.close();
            System.out.println(System.currentTimeMillis() - startTime + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //这个变量只是用来获取字符串的标准长度，修改无意义
    private static Font font = new Font("宋体", Font.PLAIN, 16);
    private String columnInterval="|";//列之间的间隔符号
    private AlignType at=AlignType.Center;
    private Integer MaxValueLenth=40;
    private Map<String,Integer> maxFieldValueLengthMap=null;
    List<String> columnNameList=null;
    List<List<String>> columnValueList=null;
    private boolean isException=false;
    private Integer pringtTableRow=30;
    public TextTable(List<String> columnNameListTmp,List<List<String>> columnValueListTmp){
        this(columnNameListTmp, columnValueListTmp, null);
    }
    public TextTable(List<String> columnNameListTmp,List<List<String>> columnValueListTmp,Map<String,Integer> maxFieldValueLengthMapTmp){
        if(null==columnNameListTmp||columnNameListTmp.size()==0){
            Exception e=new Exception("列名List为空");
            e.printStackTrace();
            this.isException=true;
            return;
        }
        this.columnNameList=columnNameListTmp;
        this.columnValueList=columnValueListTmp;
        this.maxFieldValueLengthMap=maxFieldValueLengthMapTmp;
    }

    /**
     * 获得处理后的表格字符串
     * @param columnNameList
     * @param columnValueList
     * @param maxColumnLength
     * @return
     */
    public String printTable(){
        if(null==this.maxFieldValueLengthMap ||this.columnNameList.size()!=this.maxFieldValueLengthMap.size()){
            this.setMaxFieldValueLengthMap(this.columnNameList, this.columnValueList, null);
        }
        if(isException){
            return "";
        }
        StringBuilder sb=new StringBuilder();
        Integer tableLenth=0;
        for(int i=0;i<columnNameList.size();i++){
            if(i==0){
                sb.append(columnInterval+" "+makeValueAlign(columnNameList.get(i),maxFieldValueLengthMap.get(columnNameList.get(i))));
            }else{
                sb.append(" "+columnInterval+" "+makeValueAlign(columnNameList.get(i),maxFieldValueLengthMap.get(columnNameList.get(i))));
            }
        }
        sb.append(columnInterval+"\n");
        tableLenth=getStrPixelsLenth(sb.toString());
        sb.insert(0,getRepairStr('-',tableLenth)+"\n");
        sb.append(getRepairStr('-',tableLenth)+"\n");
        if(null!=columnValueList&&columnValueList.size()>0){
            StringBuilder sbb=new StringBuilder();
            for(int x=0;x<columnValueList.size();x++){
                List<String> ls=columnValueList.get(x);
                for(int i=0;i<ls.size();i++){
                    if(i==0){
                        sbb.append(columnInterval+" "+makeValueAlign(ls.get(i),maxFieldValueLengthMap.get(columnNameList.get(i))));
                    }else{
                        sbb.append(" "+columnInterval+" "+makeValueAlign(ls.get(i),maxFieldValueLengthMap.get(columnNameList.get(i))));
                    }
                }
                sbb.append(columnInterval+"\n");
                if(x>this.pringtTableRow){
                    String info="打印了"+String.valueOf(pringtTableRow)+"行;共有"+String.valueOf(columnValueList.size())+"行";
                    sbb.append(columnInterval+" "+makeValueLeft(info,tableLenth)+columnInterval+"\n");
                    break;
                }
            }
            sb.append(sbb.append(getRepairStr('-',tableLenth)));
        }else{
            StringBuilder sbb=new StringBuilder();
            for(int i=0;i<columnNameList.size();i++){
                if(i==0){
                    sbb.append(columnInterval+" "+makeValueAlign("-",maxFieldValueLengthMap.get(columnNameList.get(i))));
                }else{
                    sbb.append(" "+columnInterval+" "+makeValueAlign("-",maxFieldValueLengthMap.get(columnNameList.get(i))));
                }
            }
            sbb.append(columnInterval+"\n");
            sb.append(sbb.append(getRepairStr('-',tableLenth)));
        }
        return sb.toString();
    }
    /**
     * 获取一个字符串的标准长度是多少
     * A2*.  这样是四个标准长度
     * 系统系统 这样是8个标准长度
     * @param str
     * @return
     */
    public static Integer getStrPixelsLenth(String str){
        return sun.font.FontDesignMetrics.getMetrics(font).stringWidth(str)/8;
    }
    /**
     * 让列值居中
     * @param columnValue
     * @param ColumnPixelsLenth
     * @return
     */
    private String makeValueCenter(String columnValue,Integer repaireStrLength){
        StringBuilder sb=new StringBuilder();
        if(repaireStrLength%2==1){
            sb.append(getRepairStr(' ',repaireStrLength/2));
        }else{
            sb.append(getRepairStr(' ',repaireStrLength/2));
        }
        sb.append(columnValue);
        if(repaireStrLength%2==1){
            sb.append(getRepairStr(' ',repaireStrLength/2+1));
        }else{
            sb.append(getRepairStr(' ',repaireStrLength/2));
        }
        return sb.toString();
    }
    /**
     * 让列值左对齐
     * @param columnValue
     * @param ColumnPixelsLenth
     * @return
     */
    private String makeValueLeft(String columnValue,Integer repaireStrLength){
        StringBuilder sb=new StringBuilder();
        sb.append(columnValue);
        sb.append(getRepairStr(' ',repaireStrLength));
        return sb.toString();
    }
    /**
     * 让列值又对齐
     * @param columnValue
     * @param ColumnPixelsLenth
     * @return
     */
    private String makeValueRight(String columnValue,Integer repaireStrLength){
        StringBuilder sb=new StringBuilder();
        sb.append(getRepairStr(' ',repaireStrLength));
        sb.append(columnValue);
        return sb.toString();
    }
    /**
     * 获取用于填充的字符串
     * @param str
     * @param PixelsLenth
     * @return
     */
    private static String getRepairStr(char str,Integer PixelsLenth){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<PixelsLenth;i++){
            sb.append(str);
        }
        return sb.toString();

    }
    /**
     * 根据像素长度来切割字符串
     * @param str
     * @param PixelsLenth
     * @return
     */
    private static String subStrByPixels(String str,Integer PixelsLenth){
        if(getStrPixelsLenth(str)>PixelsLenth){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<str.length()&&getStrPixelsLenth(sb.toString())<PixelsLenth-4;i++){
                sb.append(str.charAt(i));
            }
            str=sb.append("……").toString();
        }
        return str;

    }
    /**
     * 让列值对齐(左对齐OR居中OR右对齐)
     * @param columnValue
     * @param ColumnPixelsLenth
     * @return
     */
    private String makeValueAlign(String columnValue,Integer ColumnPixelsLenth){
        if(null==columnValue){
            columnValue="";
        }
        if(null==ColumnPixelsLenth){
            return columnValue;
        }
        if(getStrPixelsLenth(columnValue)>ColumnPixelsLenth){
            return subStrByPixels(columnValue,ColumnPixelsLenth);
        }
        Integer repaireStrLength=(ColumnPixelsLenth-getStrPixelsLenth(columnValue));

        switch (at) {
            case Center: {
                return makeValueCenter(columnValue,repaireStrLength);
            }
            case Left: {
                return makeValueLeft(columnValue,repaireStrLength);
            }
            case Rigth: {
                return makeValueRight(columnValue,repaireStrLength);
            }
            default:{
                return "";
            }
        }
    }
    public void setColumnInterval(String columnInterval) {
        this.columnInterval = columnInterval;
    }
    public void setMaxValueLenth(Integer maxValueLenth) {
        this.MaxValueLenth = maxValueLenth;
    }
    private void setMaxFieldValueLengthMap(List<String> columnNameListTmp,List<List<String>> columnValueListTmp,Map<String, Integer> maxFieldValueLengthMapTmp) {
        if(columnValueListTmp==null){
            columnValueListTmp=new ArrayList<List<String>>();
        }
        if(null!=maxFieldValueLengthMapTmp&&columnNameListTmp.size()==maxFieldValueLengthMapTmp.size()){
            this.maxFieldValueLengthMap = maxFieldValueLengthMapTmp;
        }else{
            this.maxFieldValueLengthMap=new HashMap<String, Integer>();
            if(columnValueListTmp.size()>0){
                for(List<String> ls:columnValueListTmp){
                    if(ls.size()!=columnNameList.size()){
                        Exception e=new Exception("有数据的列数和列名个数不相等");
                        e.printStackTrace();
                        this.isException=true;
                        return;
                    }
                    for(int i=0;i<ls.size();i++){
                        Integer valueLength=getStrPixelsLenth(ls.get(i));
                        if(!this.maxFieldValueLengthMap.containsKey(columnNameList.get(i))){
                            this.maxFieldValueLengthMap.put(columnNameList.get(i),valueLength);
                        }
                        if(valueLength>=this.maxFieldValueLengthMap.get(columnNameList.get(i))){
                            if(valueLength<=this.MaxValueLenth){
                                this.maxFieldValueLengthMap.put(columnNameList.get(i),valueLength);
                            }else{
                                this.maxFieldValueLengthMap.put(columnNameList.get(i), MaxValueLenth);
                            }
                        }
                    }
                }
            }
            for(String s:columnNameList){
                if(!this.maxFieldValueLengthMap.containsKey(s)){
                    this.maxFieldValueLengthMap.put(s, s.length());
                }
                if(this.maxFieldValueLengthMap.get(s)<s.length()){
                    this.maxFieldValueLengthMap.put(s, s.length());
                }
            }
        }
    }
    public void setPringtTableRow(Integer pringtTableRow) {
        this.pringtTableRow = pringtTableRow;
    }
    public enum AlignType {
        Left,
        Center,
        Rigth
    }
}
