package cn.happy.house;

import java.util.Date;

/**
 * Created by CKW on 2017/1/12.
 */
public class House {
    private Integer id;
    private String title;
    private String description;
    private String price;
    private Date pubdate;
    private Integer fioorage;
    private String contact;
    private Integer user_id;
    private Integer type_id;
    private Integer streeet_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public Integer getFioorage() {
        return fioorage;
    }

    public void setFioorage(Integer fioorage) {
        this.fioorage = fioorage;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public Integer getStreeet_id() {
        return streeet_id;
    }

    public void setStreeet_id(Integer street_id) {
        this.streeet_id = street_id;
    }
}
