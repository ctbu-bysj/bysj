package com.ctbu.schoolofai.btsjmanager.student.service;

import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Student;
import com.ctbu.schoolofai.btsjmanager.publicTable.domain.Topic;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;


public interface StudentService {
    /**
     * 学生选题更新学生表
     * @param student
     * @return
     */
    String update(Student student);

    /**
     * 通过id查询学生
     * @param id
     * @return
     */
    Student findById(String id);

    /**
     * 通过选题查找
     * @param topic
     * @return
     */
    List<Student>  findByTopic(Topic topic);

    /**
     * 查找所有
     * @return
     */
    List<Student>  findAll();

    /**
     * 保存
     * @param student
     * @return
     */
    Student save(Student student);

    /**
     * 批量导入学生
     * @param file
     * @return
     * @throws Exception
     */
    boolean getStudent(MultipartFile file) throws Exception;

    /**
     * 导出文档
     * @param tmpFile
     * @param contentMap
     * @param exportFile
     * @return
     * @throws Exception
     */
    String  exportDucment(File tmpFile, Map<String, String> contentMap, String exportFile) throws Exception;

}
