package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/*import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;*/

import com.example.demo.common.MailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    //@Autowired
  //  private TemplateEngine templateEngine;

    @Test
    public void testSimpleMail() throws Exception {
        mailService.sendSimpleMail("2574133998@qq.com","正规邮件","你好！达萨碧");
    }

    @Test
    public void testHtmlMail() throws Exception {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("m15556073546@163.com","test simple mail",content);
    }

    @Test
    public void sendAttachmentsMail() {
        String filePath="C:\\Users\\Administrator\\Desktop\\52595d9c38e83228.jpg!600x600.jpg";
        mailService.sendAttachmentsMail("m15556073546@163.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
    }


    @Test
    public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "C:\\Users\\Administrator\\Desktop\\52595d9c38e83228.jpg!600x600.jpg";

        mailService.sendInlineResourceMail("m15556073546@163.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }


 /*   @Test
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("ityouknow@126.com","主题：这是模板邮件",emailContent);
    }*/
}
