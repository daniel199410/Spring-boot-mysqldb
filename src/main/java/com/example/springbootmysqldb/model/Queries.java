package com.example.springbootmysqldb.model;

import javax.persistence.*;

@Entity
public class Queries {
    @Id
    @GeneratedValue
    private Long cdQuery;
    private String queryType;
    private int tries;

    public Queries() {
    }

    public Long getCdQuery() {
        return cdQuery;
    }

    public void setCdQuery(Long cdQuery) {
        this.cdQuery = cdQuery;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }
}
