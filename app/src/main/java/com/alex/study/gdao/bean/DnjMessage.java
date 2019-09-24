package com.alex.study.gdao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
@Entity(nameInDb = "message")
public class DnjMessage {

    @Id(autoincrement = true)
    private Long id;
    private  String userName;
    private String phone;
    private boolean isExpert;
    private String  nikeName;
    private String userId;
    private Long messageId;
    private String lastContent;
    @Generated(hash = 1159027840)
    public DnjMessage(Long id, String userName, String phone, boolean isExpert,
            String nikeName, String userId, Long messageId, String lastContent) {
        this.id = id;
        this.userName = userName;
        this.phone = phone;
        this.isExpert = isExpert;
        this.nikeName = nikeName;
        this.userId = userId;
        this.messageId = messageId;
        this.lastContent = lastContent;
    }
    @Generated(hash = 1821521698)
    public DnjMessage() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public boolean getIsExpert() {
        return this.isExpert;
    }
    public void setIsExpert(boolean isExpert) {
        this.isExpert = isExpert;
    }
    public String getNikeName() {
        return this.nikeName;
    }
    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }
    public String getUserId() {
        return this.userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public Long getMessageId() {
        return this.messageId;
    }
    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }
    public String getLastContent() {
        return this.lastContent;
    }
    public void setLastContent(String lastContent) {
        this.lastContent = lastContent;
    }

}
