package controller;

public class ActionForward {
	
	private boolean redirect; //방식(데이터 전송여부)
	private String path; //경로
	
	//redirect방식 T == 전달할 정보가 없음
	//forward방식 F == 전달할 정보가 있음
	
	
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
