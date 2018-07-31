package com.andela;

public class MyResponse {

    private Article[] articles;

    private String totalResults;

    private String status;

    public Article[] getArticles ()
    {
        return articles;
    }

    public void setArticles (Article[] articles)
    {
        this.articles = articles;
    }

    public String getTotalResults ()
    {
        return totalResults;
    }

    public void setTotalResults (String totalResults)
    {
        this.totalResults = totalResults;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [articles = "+articles+", totalResults = "+totalResults+", status = "+status+"]";
    }
}