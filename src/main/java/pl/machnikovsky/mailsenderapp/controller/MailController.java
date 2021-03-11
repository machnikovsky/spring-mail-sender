package pl.machnikovsky.mailsenderapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;
import pl.machnikovsky.mailsenderapp.model.MailToSend;
import pl.machnikovsky.mailsenderapp.service.MailService;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/send")
public class MailController {

    MailService mailService;

    @Value("${dest.mail.address}")
    String destinationEmail;

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/")
    @ResponseBody
    public String sendMail() throws MessagingException {
        mailService.sendMail(
                destinationEmail,
                "Test message subject",
                "Test message text, message send from Spring.",
                true
                );
        return "Mail to default email sent!";
    }

    @GetMapping("/params")
    @ResponseBody
    public String sendMailByParams(
                @RequestParam("to") String to,
                @RequestParam("subject") String subject,
                @RequestParam("text") String text,
                @RequestParam("html") boolean isHtmlContent
    ) throws MessagingException {
        mailService.sendMail(
                to,
                subject,
                text,
                isHtmlContent
        );
        return "Mail sent by params!";
    }

    @GetMapping("/body")
    @ResponseBody
    public String sendMailByBody(@RequestBody MailToSend mailToSend) throws MessagingException {
        mailService.sendMailByBody(mailToSend);
        return "Mailt sent by body!";
    }

    @GetMapping("/path/{to}/{subject}/{text}/{html}")
    @ResponseBody
    public String sendMailByPath(
            @PathVariable("to") String to,
            @PathVariable("subject") String subject,
            @PathVariable("text") String text,
            @PathVariable("html") boolean isHtmlContent
    ) throws MessagingException {
        mailService.sendMail(
                to,
                subject,
                text,
                isHtmlContent
        );
        return "Mail sent by path variables!";
    }


}
