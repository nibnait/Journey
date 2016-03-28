package com.shakool.other;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by geekgao on 16-3-28.
 * 验证码
 */
@Controller
public class Captcha {
    @RequestMapping(value = "getcaptcha" , method = RequestMethod.GET)
    public void getCaptcha(HttpSession session, HttpServletResponse response) throws IOException {
        int width = 120;
        int height = 30;
        int fontHeight;
        int codeCount = 4;
        char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        /**
         * 第一个字符的x轴值，因为后面的字符坐标依次递增，所以它们的x轴值是codeX的倍数
         */
        int codeX;

        /**
         * codeY ,验证字符的y轴值，因为并行所以值一样
         */
        int codeY;

        //width-4 除去左右多余的位置，使验证码更加集中显示，减得越多越集中
        //codeCount+1     //等比分配显示的宽度，包括左右两边的空格
        codeX = (width - 4) / (codeCount + 1);
        //height - 10 集中显示验证码
        fontHeight = height - 10;
        codeY = height - 7;

        // 定义图像buffer
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D gd = buffImg.createGraphics();
        // 创建一个随机数生成器类
        Random random = new Random();
        // 将图像填充为白色
        gd.setColor(Color.WHITE);
        gd.fillRect(0, 0, width, height);
        // 创建字体，字体的大小应该根据图片的高度来定
        Font font = new Font("Fixedsys", Font.ITALIC, fontHeight);
        // 设置字体
        gd.setFont(font);
        gd.drawRect(0, 0, width - 1, height - 1);
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证
        StringBuffer captcha = new StringBuffer();
        int red, green, blue;//黑色
        // 随机产生codeCount数字的验证码
        for (int i = 0; i < codeCount; i++) {
            // 得到随机产生的验证码数字
            String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
            // 用随机产生的颜色（蓝色周围随机）将验证码绘制到图像中
            red = random.nextInt(10) + 20;//20-30
            green = random.nextInt(20) + 120;//120-140
            blue = random.nextInt(20) + 200;//200-220
            gd.setColor(new Color(red,green,blue));
            gd.drawString(strRand, (i + 1) * codeX, codeY);
            // 将产生的四个随机数组合在一起
            captcha.append(strRand);
        }
        // 将四位数字的验证码保存到Session中
        session.setAttribute("captcha", captcha.toString());
        System.out.println(captcha.toString());
        // 禁止图像缓存
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        response.setContentType("image/jpeg");
        // 将图像输出到Servlet输出流中
        ServletOutputStream sos = response.getOutputStream();
        ImageIO.write(buffImg, "jpeg", sos);
        sos.close();
    }
}
