package ro.utcn.amqp.Controller;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.utcn.amqp.Config.EmailConfiguration;
import ro.utcn.amqp.DTO.UserDTO;


import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@RestController
public class Controller {


    private static final Logger log = LoggerFactory.getLogger(Controller.class);

    private EmailConfiguration emailCfg;

    public Controller(EmailConfiguration emailCfg) {
        this.emailCfg = emailCfg;
    }

    @PostMapping("/email")
    public void sendValidationEmail(@RequestBody UserDTO userDTO, BindingResult bindingResult){
       try {
           if (bindingResult.hasErrors()) {
               System.err.println("error");
           }
           JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
           mailSender.setHost(this.emailCfg.getHost());
           mailSender.setPort(this.emailCfg.getPort());
           mailSender.setUsername(this.emailCfg.getUsername());
           mailSender.setPassword(this.emailCfg.getPassword());

           // Create an email instance
           MimeMessage mailMessage = mailSender.createMimeMessage();
           MimeMessageHelper helper = new MimeMessageHelper(mailMessage);

           helper.setFrom(userDTO.getEmail());
           helper.setTo("rc@feedback.com");
           helper.setSubject("New feedback from " + userDTO.getFirstName());

           InputStream fl = new FileInputStream("src\\main\\resources\\templates\\EmailTemplate.html");
           String contend = IOUtils.toString(fl, StandardCharsets.UTF_8);
           contend = contend.replace("yourusername",userDTO.getFirstName() + " " + userDTO.getLastName());
           contend = contend.replace("youremail",userDTO.getEmail());
           helper.setText(contend,true);
           // Send mail
           mailSender.send(mailMessage);
       }
       catch(Exception e){
           log.error(e.getMessage());
        }
    }
}
