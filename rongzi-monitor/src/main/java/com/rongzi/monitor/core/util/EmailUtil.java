package com.rongzi.monitor.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

@Component
public class EmailUtil {

    private static final Logger logger = LoggerFactory.getLogger(EmailUtil.class);

    @Autowired
    private Environment env;

    private  String auth;
    private  String host;
    private  String protocol;
    private  int port;
    private  String authName;
    private  String password;
    private  boolean isSSL;
    private  String charset ;
    private  String timeout;
    private static String toUsers;

    @PostConstruct
    public void initParam () {
        auth = env.getProperty("mail.smtp.auth");
        host = env.getProperty("mail.host");
        protocol = env.getProperty("mail.transport.protocol");
        port = env.getProperty("mail.smtp.port", Integer.class);
        authName = env.getProperty("mail.auth.name");
        password = env.getProperty("mail.auth.password");
        charset = env.getProperty("mail.send.charset");
        isSSL = env.getProperty("mail.is.ssl", Boolean.class);
        timeout = env.getProperty("mail.smtp.timeout");
        toUsers=env.getProperty("mail.sendTo");
    }

    public void sendEmail(String mailContent,String mailSubject) {
        try {
            String[] users = toUsers.split(",");

            for(int i=0;i<users.length;i++){
                JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
                javaMailSender.setHost(host);
                javaMailSender.setUsername(authName);
                javaMailSender.setPassword(password);
                javaMailSender.setDefaultEncoding(charset);
                javaMailSender.setProtocol(protocol);
                javaMailSender.setPort(port);

                Properties properties = new Properties();
                properties.setProperty("mail.smtp.auth", auth);
                properties.setProperty("mail.smtp.timeout", timeout);

                javaMailSender.setJavaMailProperties(properties);

                SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = dateFormat.format(new Date());

                MimeMessage mailMessage = javaMailSender.createMimeMessage();
                MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true);
                messageHelper.setTo(users[i]);
                messageHelper.setFrom(authName);
                messageHelper.setSubject(mailSubject);
                messageHelper.setText(time+" :   "+mailContent, true);

                javaMailSender.send(mailMessage);
            }
        } catch (Exception e) {
            logger.error("发送邮件失败!", e);
            throw new RuntimeException("发送邮件失败");
        }
    }

}
