package com.wangsen.cvs;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author wangsen
 * @data 2018/6/2 23:37
 * @des  画表格  已经知道表格的行数，列数 先画出个表格 然后填充数据
 */
public class ShowData {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final float INITIAL_WIDE = 1L;
    public static final float INITAL_HIGH = 1L;

    public void TableDate(Float wide,Float high,Integer rowNum,Integer colNum){
        wide = (wide == null || wide == 0) ? wide = INITIAL_WIDE : wide;
        high = (high == null || high == 0 )? high = INITIAL_WIDE : high;
        if(rowNum <= 1 || colNum <= 1){
            logger.info("rowNum or colNum error");
        }
//        DrowTable(wide,high,rowNum,colNum);
    }

//    private void DrowTable(Float wide, Float high, Integer rowNum, Integer colNum) {
//        TextTable.
//    }

}
