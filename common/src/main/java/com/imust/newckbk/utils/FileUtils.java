package com.imust.newckbk.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class FileUtils {

    public static SnowRakeIdGenerator snowRakeIdGenerator = new SnowRakeIdGenerator(0,0);

    public static String saveFile(MultipartFile file, String rootPath) throws IOException {

        //上传的图片的名称
        String fileName = file.getOriginalFilename();
        //文件名,如spring
        String name = fileName.substring(0,fileName.indexOf("."));
        //文件后缀,如.jpeg
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        //创建年月文件夹
        Calendar date = Calendar.getInstance();
        File dateDirs = new File(date.get(Calendar.YEAR)+ File.separator + (date.get(Calendar.MONTH)+1));
        //目标文件
        File descFile = new File(rootPath+File.separator+dateDirs+File.separator+fileName);

        int i = 1;
        //若文件存在重命名
        String newFilename = fileName;
        while(descFile.exists()) {
            newFilename = name+"_"+i+suffix;
            String parentPath = descFile.getParent();
            descFile = new File(parentPath+File.separator+newFilename);
            i++;
        }
        //判断目标文件所在的目录是否存在
        if(!descFile.getParentFile().exists()) {
            //如果目标文件所在的目录不存在，则创建父目录
            descFile.getParentFile().mkdirs();
        }

        //将内存中的数据写入磁盘
        file.transferTo(descFile);

        String fileUrl = date.get(Calendar.YEAR)+ "/" + (date.get(Calendar.MONTH)+1)+"/"+newFilename;
        return fileUrl;
    }


    public static String saveFileByPath(MultipartFile file, String rootPath) throws IOException {
        //上传的图片的名称
        String fileName = file.getOriginalFilename();
        //文件名,如spring
        String name = fileName.substring(0,fileName.indexOf("."));
        //文件后缀,如.jpeg
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        //目标文件
        File descFile = new File(rootPath+File.separator+fileName);

        int i = 1;
        //若文件存在重命名
        String newFilename = fileName;
        while(descFile.exists()) {
            newFilename = name+"("+i+")"+suffix;
            String parentPath = descFile.getParent();
            descFile = new File(parentPath+File.separator+newFilename);
            i++;
        }

        String tempName = descFile.getParentFile().getPath();

        //判断目标文件所在的目录是否存在
        if(!descFile.getParentFile().exists()) {
            //如果目标文件所在的目录不存在，则创建父目录
            descFile.getParentFile().mkdirs();
        }

        //将内存中的数据写入磁盘
        file.transferTo(descFile);

        String fileUrl = rootPath + "/";
        return descFile.getPath();
    }

    public static FileAuxiliary saveFileByRandom(MultipartFile file, String rootPath,String imgUrl) throws IOException {

        FileAuxiliary fileAuxiliary = new FileAuxiliary();

        //上传的图片的名称
        String fileName = file.getOriginalFilename();
        fileAuxiliary.setOriginalName(fileName);
        //文件名,如spring
        String name = fileName.substring(0,fileName.indexOf("."));
        //文件后缀,如.jpeg
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        //目标文件
        File descFile = new File(rootPath+File.separator+fileName);

        String newFilename = String.valueOf(snowRakeIdGenerator.nextId()) + suffix;
        fileAuxiliary.setNewName(newFilename);
        String parentPath = descFile.getParent();
        descFile = new File(parentPath+File.separator+newFilename);

        //判断目标文件所在的目录是否存在
        if(!descFile.getParentFile().exists()) {
            //如果目标文件所在的目录不存在，则创建父目录
            descFile.getParentFile().mkdirs();
        }

        //将内存中的数据写入磁盘
        file.transferTo(descFile);

        fileAuxiliary.setAbsolutePath(rootPath + File.separator + newFilename);
        fileAuxiliary.setRelativePath(imgUrl + "/" + newFilename);
        return fileAuxiliary;
    }

    public static void downloadFile(InputStream resourceAsStream, HttpServletResponse response,String fileName) throws Exception{
        //设置响应头和客户端保存文件名
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "utf-8"));
        //用于记录以完成的下载的数据量，单位是byte
        try {
            //激活下载操作
            OutputStream os = response.getOutputStream();

            //循环写入输出流
            byte[] b = new byte[2048];
            int length;
            while ((length = resourceAsStream.read(b)) > 0) {
                os.write(b, 0, length);
            }

            // 这里主要关闭。
            os.close();
            resourceAsStream.close();
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }


    /**
     * @Description: 解压文件
     * @Author  dujun
     * @Date   2019/3/15 3:53 PM
     * @param zipFile 目标文件
     * @param descDir 指定解压目录
     * @param urlList 存放解压后的文件目录（可选）
     * @Return
     * @Exception
     */
    public boolean unZipFile(File zipFile, String descDir,  List<String> urlList) {
        boolean flag = false;
        File pathFile = new File(descDir);
        if(!pathFile.exists()){
            pathFile.mkdirs();
        }
        ZipFile zip = null;
        try {
            zip = new ZipFile(zipFile);
            for(Enumeration entries = zip.entries(); entries.hasMoreElements();){
                ZipEntry entry = (ZipEntry)entries.nextElement();
                String zipEntryName = entry.getName();
                InputStream in = zip.getInputStream(entry);
                String outPath = (descDir+zipEntryName).replace("/", File.separator);
                //判断路径是否存在,不存在则创建文件路径
                File file = new File(outPath.substring(0, outPath.lastIndexOf(File.separator)));
                if(!file.exists()){
                    file.mkdirs();
                }
                //判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
                if(new File(outPath).isDirectory()){
                    continue;
                }
                //保存文件路径信息
                urlList.add(outPath);

                OutputStream out = new FileOutputStream(outPath);
                byte[] buf1 = new byte[2048];
                int len;
                while((len=in.read(buf1))>0){
                    out.write(buf1,0,len);
                }
                in.close();
                out.close();
            }
            flag = true;
            //必须关闭，否则无法删除该zip文件
            zip.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static File multipartFileToFile(MultipartFile file) throws Exception {

        File toFile = null;
        if (file.equals("") || file.getSize() <= 0) {
            file = null;
        } else {
            InputStream ins = null;
            ins = file.getInputStream();
            toFile = new File(file.getOriginalFilename());
            inputStreamToFile(ins, toFile);
            ins.close();
        }
        return toFile;
    }


    //获取流文件
    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[2048];
            while ((bytesRead = ins.read(buffer, 0, 2048)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 删除本地临时文件
     * @param file
     */
    public static void delteTempFile(File file) {
        if (file != null) {
            File del = new File(file.toURI());
            del.delete();
        }
    }
}



