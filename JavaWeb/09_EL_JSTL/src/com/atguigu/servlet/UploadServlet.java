package com.atguigu.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.attribute.FileTime;
import java.security.interfaces.ECKey;
import java.util.List;

/**
 *@ClassName UploadServlet
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/7/26 18:14
 *@Version 1.0
 */
public class UploadServlet extends HttpServlet {

    /**
     * 用来处理文件上传
     *      第一步：就是需要导入两个jar包：
     *          commons-fileupload-1.2.1.jar和commons-io-1.4.jar
     * 两个包中我们常用的类：
     *  ServletFileUpload类，用于解析上传的数据
     *  FileItem类：表示每个表单项。
     *
     *
     *  boolean ServletFileUpload.isMultipartContent(HttpServletRequest request);
     *      判断当前上传的数据格式是否是多段的格式
     *
     *  public List<FileItem> parseRequest(HttpServletRequest request)
     *      解析上传数据
     *
     *  boolean FileItem.isFormField()
     *      判断当前这个表单项，是否是普通表单项。还是上传的文件类型。
     *      true 表示普通类型的表单项
     *      false 表示上传的文件类型
     *
     *  String FileItem.getFiledName()
     *      获取表单项的name属性值
     *
     *  String FileItem.getString()
     *      获取当前表单项的值
     *
     *  String FileItem.getName()
     *      获取上传的文件名
     *
     *  void FileItem.write(file);
     *      将上传的文件写到参数file所指向的磁盘目录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        ServletInputStream inputStream = req.getInputStream();
//        byte[] buffer = new byte[102000];
//        int read = inputStream.read(buffer);
//        System.out.println(new String(buffer,0,read));

        // 1.先判断上传的数据是否是多段的数据(只有多段的数据，才是文件上传的)
        if(ServletFileUpload.isMultipartContent(req)){
            // 创建FileItemFactory工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            // 创建了用于解析上传数据的工具类ServletFileUpload类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            // 解析上传的数据，得到每一个表单项FileItem
            try {
                List<FileItem> list = servletFileUpload.parseRequest(req);

                    // 循环判断，每一个表单项，是普通类型，还是上传的文件
                    for(FileItem fileItem : list){

                        if (fileItem.isFormField()){
                            //普通表单项
                            System.out.println("表单项的name属性值" + fileItem.getFieldName());
                            // 参数utf-8解决乱码问题
                            System.out.println("表单项的value属性值" + fileItem.getString("utf-8"));
                        }else {
                            //上传的文件
                            System.out.println("表单项的name属性值" + fileItem.getFieldName());
                            System.out.println("上传的文件名" + fileItem.getName());
                            fileItem.write(new File("d:\\f.jpg" ));
                        }
                    }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("文件上传过来了");
    }

}

