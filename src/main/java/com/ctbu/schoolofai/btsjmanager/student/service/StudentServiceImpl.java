package com.ctbu.schoolofai.btsjmanager.student.service;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;
import com.ctbu.schoolofai.btsjmanager.student.dao.StudentDao;


import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements  StudentService {

    @Autowired
    private StudentDao studentDao;

    public String  update(Student student){

        Student student1= studentDao.save(student);

        if (student1.getTopic().getId()!=null)
            return  "true";

         else return null;

    }

    @Override
    public Student findById(String id) {
        return studentDao.getOne(id);
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    /**
     * 学生信息通过Excel批量导入
     * @param file
     * @return
     * @throws Exception
     */
    @Override
    public boolean getStudent(MultipartFile file) throws Exception{
        List<Student> list=new ArrayList<Student>();
        //得到上传的表
        Workbook workbook= WorkbookFactory.create(file.getInputStream());
        //获取student表
        Sheet sheet=workbook.getSheet("student");
        //获取表的总行数
        int num=sheet.getFirstRowNum();
        //总列数
        int col=sheet.getRow(0).getLastCellNum();

        //遍历每一行
        for(int j=0;j<=num;j++){
            Row row=sheet.getRow(j);
            //格式转换
            Cell cell1=row.getCell(0);
             cell1.setCellType(CellType.STRING);
             //获取第J行，第2 列
            Cell cell2=row.getCell(1);
            cell2.setCellType(CellType.STRING);
            //获取第J行，第3 列
            Cell cell3=row.getCell(2);
            cell3.setCellType(CellType.STRING);
            //获取第J行，第4 列
            Cell cell4=row.getCell(3);
            cell4.setCellType(CellType.STRING);
            //获取第J行，第5列
            Cell cell5=row.getCell(4);
            cell5.setCellType(CellType.STRING);
            //获取第J行，第6 列
            Cell cell6=row.getCell(5);
            cell6.setCellType(CellType.STRING);
            //获取第J行，第7 列
            Cell cell7=row.getCell(6);
            cell7.setCellType(CellType.STRING);
            //获取第J行，第8列
            Cell cell8=row.getCell(7);
            cell8.setCellType(CellType.STRING);

            //获取第J行，第9列
            Cell cell9=row.getCell(8);
            cell9.setCellType(CellType.STRING);
            //获取第J行，第10列
            Cell cell10=row.getCell(9);
            cell10.setCellType(CellType.STRING);
            //获取第J行，第11列
            Cell cell11=row.getCell(10);
            cell11.setCellType(CellType.STRING);
            //获取第J行，第12列
            Cell cell12=row.getCell(11);
            cell12.setCellType(CellType.STRING);

            Student student=new Student();
            student.setLoginName(cell2.getStringCellValue());
            student.setLoginPwd("123456");
            student.setStudnetName(cell3.getStringCellValue());
            student.setGender(cell4.getStringCellValue());
            student.setClasses(cell5.getStringCellValue());
            student.setMajor(cell6.getStringCellValue());
            student.setQq(cell7.getStringCellValue());
            student.setTel(cell8.getStringCellValue());
            student.setPeriod(cell9.getStringCellValue());
            list.add(student);
        }

        studentDao.saveAll(list);
        return true;
    }

    /**
     * 导出文档
     * @param tmpFile
     * @param contentMap
     * @param exportFile
     * @return
     */
    @Override
    public String exportDucment(File tmpFile, Map<String, String> contentMap, String exportFile) throws Exception {
        FileInputStream tempFileInputStream=new FileInputStream(tmpFile);
        HWPFDocument document=new HWPFDocument(tempFileInputStream);

        //读取文本内容
        Range bodyRange=document.getRange();
        //替换内容
        for (Map.Entry<String,String> entry:contentMap.entrySet()){
            bodyRange.replaceText("${"+entry.getKey()+"}",entry.getValue());
        }
        //导出到文件
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        document.write(byteArrayOutputStream);
        OutputStream outputStream=new FileOutputStream(exportFile);
        outputStream.write(byteArrayOutputStream.toByteArray());
        outputStream.close();

        return "success";
    }
}
