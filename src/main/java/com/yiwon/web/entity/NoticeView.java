package com.yiwon.web.entity;

import java.util.Date;

public class NoticeView extends Notice{
	
	private String memberName;
	
	public NoticeView() {
		// TODO Auto-generated constructor stub
	}

	public NoticeView(int id, String title, String writerid, String content, Date regdate, int hit, String files,
			String pub, String memberName) {
		super(id, title, writerid, content, regdate, hit, files, pub);

		this.memberName = memberName;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "NoticeView [memberName=" + memberName + ", getId()=" + getId() + ", getTitle()=" + getTitle()
				+ ", getWriterid()=" + getWriterid() + ", getContent()=" + getContent() + ", getRegdate()="
				+ getRegdate() + ", getHit()=" + getHit() + ", getFiles()=" + getFiles() + ", getPub()=" + getPub()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
	
	

}
