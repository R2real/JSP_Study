package model;

public class BoardVO {
	private int bid;
	private String writer;
	private String title;
	private String content;
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "boardVO [bid=" + bid + ", writer=" + writer + ", title=" + title + ", content=" + content + "]";
	}
	
	
	
	
}
