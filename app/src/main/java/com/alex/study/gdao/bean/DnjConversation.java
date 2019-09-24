package com.alex.study.gdao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "conversation")
public class DnjConversation {

    @Id(autoincrement = true)
    private Long id;

    private String fromId;
    private String toId;
    private String content;
    private String time;
    @Generated(hash = 429272929)
    public DnjConversation(Long id, String fromId, String toId, String content,
            String time) {
        this.id = id;
        this.fromId = fromId;
        this.toId = toId;
        this.content = content;
        this.time = time;
    }
    @Generated(hash = 666922566)
    public DnjConversation() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFromId() {
        return this.fromId;
    }
    public void setFromId(String fromId) {
        this.fromId = fromId;
    }
    public String getToId() {
        return this.toId;
    }
    public void setToId(String toId) {
        this.toId = toId;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }

}
