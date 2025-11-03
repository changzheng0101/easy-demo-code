package com.weixiao;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author changzheng
 * @date 2025年11月03日 11:22
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private final String resourcePath = FileController.class.getClassLoader().getResource("").getPath() + "Uploads";

    /**
     * 普通文件上传 直接读取里面内容
     *
     * @param file
     * @return
     */
    @RequestMapping("/normalFile")
    public String normal(@RequestParam("file") MultipartFile file) {
        // Setting up the path of the file
        String filePath = resourcePath  +File.separator + file.getOriginalFilename();
        String fileUploadStatus;

        File destFile = new File(filePath);
        File parentDir = destFile.getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs(); // 递归创建所有父目录
        }

        // Try block to check exceptions
        try {
            // Creating an object of FileOutputStream class
            FileOutputStream fout = new FileOutputStream(filePath);
            fout.write(file.getBytes());

            // Closing the connection
            fout.close();
            fileUploadStatus = "File Uploaded Successfully";
        }

        // Catch block to handle exceptions
        catch (Exception e) {
            e.printStackTrace();
            fileUploadStatus = "Error in uploading file: " + e;
        }
        return fileUploadStatus;
    }

    /**
     * 解压文件并进行后续处理
     *
     * @return
     */
    @RequestMapping("/zipFile")
    public String zipFile() {

        return "zipFile";
    }

    /**
     * 从服务器下载文件
     *
     * @return
     */
    @RequestMapping("/downlaodFile")
    public String downloadFile() {
        return "downloadFile";
    }

    @RequestMapping(value = "/getFiles")
    public String[] getFiles() {
        File directory = new File(resourcePath);
        // 只能直接查看目录下的文件，不能查看子目录下的文件
        String[] filenames = directory.list();
        return filenames;
    }
}
