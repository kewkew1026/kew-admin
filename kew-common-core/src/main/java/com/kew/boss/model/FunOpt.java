package com.kew.boss.model;

import java.io.Serializable;

public class FunOpt implements Serializable
{
    private static final long serialVersionUID = 3542476249534037446L;
    
    private long              funOptId;      /**资源ID**/

    private String            funOptNm;      /**资源名称**/

    private String            url;           /**资源URL**/

    private String            remarks;       /**资源备注**/


    public long getFunOptId()
    {
        return funOptId;
    }

    public void setFunOptId(long funOptId)
    {
        this.funOptId = funOptId;
    }

    public String getFunOptNm()
    {
        return funOptNm;
    }

    public void setFunOptNm(String funOptNm)
    {
        this.funOptNm = funOptNm;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getRemarks()
    {
        return remarks;
    }

    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }
}
