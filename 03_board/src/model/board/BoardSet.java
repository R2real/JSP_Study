package model.board;

import java.util.ArrayList;

public class BoardSet {
	// BoardVO 1개에
	// ReplyVO N개가 함께 붙어 있는 형태의 "게시글"데이터를 표현하는 클래스
	
	private BoardVO board;
	private ArrayList<ReplyVO> rdatas= new ArrayList<ReplyVO>();
	public BoardVO getBoard() {
		return board;
	}
	public void setBoard(BoardVO board) {
		this.board = board;
	}
	public ArrayList<ReplyVO> getRdatas() {
		return rdatas;
	}
	public void setRdatas(ArrayList<ReplyVO> rdatas) {
		this.rdatas = rdatas;
	}
	@Override
	public String toString() {
		return "BoardSet [board=" + board + ", rdatas=" + rdatas + "]";
	}
	
	
}
