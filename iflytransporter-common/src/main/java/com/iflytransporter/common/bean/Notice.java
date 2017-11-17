package com.iflytransporter.common.bean;

import java.util.Date;

import com.iflytransporter.common.base.BaseEntity;

public class Notice extends BaseEntity{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}