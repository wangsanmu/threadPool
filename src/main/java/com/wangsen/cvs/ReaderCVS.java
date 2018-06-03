package com.wangsen.cvs;

import com.csvreader.CsvReader;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangsen
 * @data 2018/6/2 21:42
 * @des
 */
public class ReaderCVS {


    private Integer decodeColumNum;

    public ReaderCVS( Integer decodeColumNum) {
        this.decodeColumNum = decodeColumNum;
    }

    public static void main(String[] args) {
        String filePath = "";
        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream(filePath));
            Long startTime =  System.currentTimeMillis();
            ReaderCVS readerCVS = new ReaderCVS(1);
            readerCVS.geTCVSReader(inputStream);
            System.out.println("程序运行时间："+ (System.currentTimeMillis() - startTime) + "ms" );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param fileInputStream
     */
    public List<QaRecoder> geTCVSReader(InputStream fileInputStream){
        CsvReader reader = null;
        List<QaRecoder> qaRecoderList = new ArrayList<>();
        try {
            reader = new CsvReader(fileInputStream, ',', Charset.forName("GBK"));
            ArrayList<String[]> csvList = new ArrayList<String[]>();
            reader.readHeaders();
            System.out.println(reader.getHeader(1));
            int columNum = reader.getHeaderCount() - 1;
            while (reader.readRecord()){
                csvList.add(reader.getValues());
            }

            for(int row=0;row<csvList.size();row++){
                QaRecoder qaRecoder = new QaRecoder();
                //分类
                String  cell_0 = csvList.get(row)[0];
                //标题
                String  cell_1 = csvList.get(row)[1];
                qaRecoder.setTitles(decodeColum(cell_1));
                //回答
                String  cell_2 = csvList.get(row)[2];
                qaRecoder.setComment(cell_2);
                qaRecoderList.add(qaRecoder);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
           if(reader != null){
               reader.close();
           }
        }
        return qaRecoderList;
    }

    private String[] decodeColum(String cell) {
//        cell = "123abc";
        Character c =  new Character((char)12289);
        if(cell.contains(c.toString())){
            cell = cell.substring(cell.indexOf(c)+2);
        }
        return  cell.split("\n");
    }

    public Integer getDecodeColum() {
        return decodeColumNum;
    }

    public void setDecodeColum(Integer decodeColumNum) {
        this.decodeColumNum = decodeColumNum;
    }

}
