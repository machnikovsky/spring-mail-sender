package pl.machnikovsky.mailsenderapp.model;


public class MailToSend {

    String to;
    String subject;
    String text;
    boolean isHtmlContent;

    public MailToSend(String to, String subject, String text, boolean isHtmlContent) {
        this.to = to;
        this.subject = subject;
        this.text = text;
        this.isHtmlContent = isHtmlContent;
    }

    public MailToSend() {
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isHtmlContent() {
        return isHtmlContent;
    }

    public void setHtmlContent(boolean htmlContent) {
        isHtmlContent = htmlContent;
    }
}
