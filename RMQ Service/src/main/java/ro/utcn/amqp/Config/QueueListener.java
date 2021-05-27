package ro.utcn.amqp.Config;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import ro.utcn.amqp.Config.EmailConfiguration;
import ro.utcn.amqp.DTO.PayloadDTO;

import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
public class QueueListener {

    private static final Logger log = LoggerFactory.getLogger(QueueListener.class);

    public QueueListener(EmailConfiguration emailCfg) {
        this.emailCfg = emailCfg;
    }

    private EmailConfiguration emailCfg;

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @RabbitListener(queues = "grupa8-queue")
    public void listen(PayloadDTO in) {
       try {
           JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
           mailSender.setHost(this.emailCfg.getHost());
           mailSender.setPort(this.emailCfg.getPort());
           mailSender.setUsername(this.emailCfg.getUsername());
           mailSender.setPassword(this.emailCfg.getPassword());

           // Create an email instance
           MimeMessage mailMessage = mailSender.createMimeMessage();
           MimeMessageHelper helper = new MimeMessageHelper(mailMessage);

           helper.setTo(in.getUserEmail());
           helper.setFrom("rc@feedback.com");
           helper.setSubject("New feedback from " + in.getUserFullName());


           InputStream fl = new FileInputStream("src\\main\\resources\\templates\\EmailTemplateAsync.html");
           String contend = IOUtils.toString(fl, StandardCharsets.UTF_8);
           contend = contend.replace("yourusername",in.getUserFullName());
           contend = contend.replace("youremail",in.getUserEmail());

           MimeBodyPart messageBodyPart = new MimeBodyPart();
           messageBodyPart.setContent(contend,"text/html");
           // Send mail
           MimeBodyPart attachmentPart = new MimeBodyPart();
           //attachmentPart.attachFile(new File("D:\\Facultate\\Anul 3\\Semestrul 2\\PS\\Assigment 3\\2021-ps-a3-jitaru-vasile\\A3-BaseApp\\"+in.getTicketPath()+".pdf"));

           MimeBodyPart attachmentPart1 = new MimeBodyPart();
          // attachmentPart1.attachFile(new File("D:\\Facultate\\Anul 3\\Semestrul 2\\PS\\Assigment 3\\2021-ps-a3-jitaru-vasile\\A3-BaseApp\\"+in.getTicketPath()+".txt"));

           Multipart multipart = new MimeMultipart();

           multipart.addBodyPart(messageBodyPart);
           multipart.addBodyPart(attachmentPart);
           multipart.addBodyPart(attachmentPart1);

           mailMessage.setContent(multipart);

           mailSender.send(mailMessage);

       }catch (Exception e){
           log.error(e.getMessage());
       }
    }


}
