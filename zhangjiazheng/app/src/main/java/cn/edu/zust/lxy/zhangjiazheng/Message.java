package cn.edu.zust.lxy.zhangjiazheng;

public class Message {
    private String author, content;
    public Message(String author, String content) {
        this.author=author;
        this.content=content;
    }

    public String getAuthor(){return author;}
    public String getContent() {return content;}
}
