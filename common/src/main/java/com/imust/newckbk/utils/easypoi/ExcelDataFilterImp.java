package com.imust.newckbk.utils.easypoi;

import cn.afterturn.easypoi.handler.inter.IExcelDataFilter;
import com.imust.newckbk.exception.CustomException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.Iterator;

public class ExcelDataFilterImp implements IExcelDataFilter {

    private static String eof = "/end/";

    @Override
    public Workbook WorkbookFilter(Workbook workbook) throws CustomException {

        boolean readFlag = false;
        Iterator<Row> rows = workbook.getSheetAt(0).rowIterator();

        while(rows.hasNext()) {
            Row next = rows.next();

            if((null != next.getCell(0) && next.getCell(0).getStringCellValue().equals(eof)) || readFlag) {
                readFlag = true;
                rows.remove();
            }
        }

        if(!readFlag) {
            throw new CustomException("此文件没有结束标志！");
        }

        return workbook;
    }
}
