package jnode.ui.shared.dto;

import java.io.Serializable;

public class EchoMail implements Serializable {
    private String echoarea;
    private String subject;
    private String body;

    public String getEchoarea() {
        return echoarea;
    }

    public void setEchoarea(String echoarea) {
        this.echoarea = echoarea;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "EchoMail{" +
                "echoarea='" + echoarea + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
