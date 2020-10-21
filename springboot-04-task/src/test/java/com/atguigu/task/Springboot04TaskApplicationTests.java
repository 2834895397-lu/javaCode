package com.atguigu.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot04TaskApplicationTests {
    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    void contextLoads() {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("通知-今晚开会");
        simpleMailMessage.setText("今晚七点开会");
        simpleMailMessage.setTo("1335492377@qq.com");
        simpleMailMessage.setFrom("2834895397@qq.com");

        javaMailSender.send(simpleMailMessage);
    }

    @Test
    public void test02() throws MessagingException {
        //1. 创建一个复杂的消息邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        //设置邮件
        //设置主题(通过mimeMessageHelper来给要发送的mimeMessage设置主题)
        mimeMessageHelper.setSubject("通知-今晚开会");
        mimeMessageHelper.setText("<b style=color='red'>几天7:30开会</b>");
        mimeMessageHelper.setTo("1335492377@qq.com");
        mimeMessageHelper.setFrom("2834895397@qq.com");

        //上传文件
        mimeMessageHelper.addAttachment("1.jpg", new File("C:\\Users\\28348\\Pictures\\Saved Pictures\\a.jpg"));
        mimeMessageHelper.addAttachment("2.jpg", new File("C:\\Users\\28348\\Pictures\\Saved Pictures\\124bc4b74964bcaa954a2720f5d30fc.jpg"));

        //发送
        javaMailSender.send(mimeMessage);


    }

}
