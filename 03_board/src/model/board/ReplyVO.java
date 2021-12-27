package model.board;

public class ReplyVO {
	private int rid;
	private int bid;
	private String mid;
	private String rmsg;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getRmsg() {
		return rmsg;
	}
	public void setRmsg(String rmsg) {
		this.rmsg = rmsg;
	}
	@Override
	public String toString() {
		return "ReplyVO확인 [rid=" + rid + ", bid=" + bid + ", mid=" + mid + ", rmsg=" + rmsg + "]";
	}
}
