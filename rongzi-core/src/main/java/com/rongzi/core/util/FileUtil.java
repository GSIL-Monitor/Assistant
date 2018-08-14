package com.rongzi.core.util;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.rongzi.core.exception.GunsException;
import com.rongzi.core.exception.GunsExceptionEnum;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

public class FileUtil {

    private static Logger log = LoggerFactory.getLogger(FileUtil.class);

    /**
     * NIO way
     */
    public static byte[] toByteArray(String filename) {

        File f = new File(filename);
        if (!f.exists()) {
            log.error("文件未找到！" + filename);
            throw new GunsException(GunsExceptionEnum.FILE_NOT_FOUND);
        }
        FileChannel channel = null;
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(f);
            channel = fs.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
            while ((channel.read(byteBuffer)) > 0) {
                // do nothing
                // System.out.println("reading");
            }
            return byteBuffer.array();
        } catch (IOException e) {
            throw new GunsException(GunsExceptionEnum.FILE_READING_ERROR);
        } finally {
            try {
                channel.close();
            } catch (IOException e) {
                throw new GunsException(GunsExceptionEnum.FILE_READING_ERROR);
            }
            try {
                fs.close();
            } catch (IOException e) {
                throw new GunsException(GunsExceptionEnum.FILE_READING_ERROR);
            }
        }
    }

    /**
     * 删除目录
     *
     * @author fengshuonan
     * @Date 2017/10/30 下午4:15
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }


    public static void exportDataToExcel(List<?> list, Class<?> pojoClass, String fileName, HttpServletResponse response){

        ExportParams exportParams = new ExportParams();
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClass, list);
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

            OutputStream outputStream = response.getOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

            workbook.write(bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<?>  importDataFromExcel(MultipartFile file, Class<?> pojoClass, ImportParams params){

        try {
            List<Object> list = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);

            return list;
        } catch (Exception e) {
            throw new GunsException(GunsExceptionEnum.FILE_READING_ERROR);
        }
    }

}