package com.shakool.controller.file;

import com.shakool.utils.PropertiesUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by geekgao on 16-4-26.
 * 控制文件下载
 */
@Controller
@RequestMapping("/file")
public class DownloadController {
    @RequestMapping(value = "/voicepackage",method = RequestMethod.GET)
    public void getVoicePackage(HttpServletResponse response) {
        String filePath = PropertiesUtils.getVoicePackage();

        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition","attachment;filename=\"" + filePath.substring(filePath.lastIndexOf('/') + 1) + "\"");
            OutputStream outputStream = response.getOutputStream();
            InputStream inputStream = new FileInputStream(new File(filePath));
            byte[] buffer = new byte[8192];
            int i;
            while ((i = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, i);
            }
            outputStream.close();
        } catch(FileNotFoundException e1) {
            System.err.println("文件未找到");
        } catch(IOException e) {
            System.err.println("语音包IO错误");
        }
    }
}
