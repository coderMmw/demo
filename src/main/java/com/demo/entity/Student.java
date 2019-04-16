package com.demo.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
 *
 *  @author author
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 1539760662779L;


    /**
     * 主键
     *
     * isNullAble:0,defaultVal:
     */
    private String sno;

    /**
     *
     * isNullAble:0,defaultVal:
     */
    private String sname;

    /**
     *
     * isNullAble:0,defaultVal:
     */
    private String ssex;

    /**
     *
     * isNullAble:1
     */
    private java.time.LocalDateTime sbirthday;

    /**
     *
     * isNullAble:1
     */
    private String sclass;


    public void setSno(String sno){this.sno = sno;}

    public String getSno(){return this.sno;}

    public void setSname(String sname){this.sname = sname;}

    public String getSname(){return this.sname;}

    public void setSsex(String ssex){this.ssex = ssex;}

    public String getSsex(){return this.ssex;}

    public void setSbirthday(java.time.LocalDateTime sbirthday){this.sbirthday = sbirthday;}

    public java.time.LocalDateTime getSbirthday(){return this.sbirthday;}

    public void setSclass(String sclass){this.sclass = sclass;}

    public String getSclass(){return this.sclass;}


}
