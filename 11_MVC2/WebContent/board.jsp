<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 페이지</title>
<script type="text/javascript">
	function del() {
		ans = confirm("내용은 복구되지않습니다. 정말 삭제하시겠습니까?");
		if (ans == true) {
		location.href="delete.do?bid="+${data.bid};
		} else {
			return;
		}
	}
</script>
</head>
<body>
	<c:choose>
		<c:when test="${data!=null}">
			<form action="update.do" method="post">
				 <input	type="hidden" name="bid" value="${data.bid}">
				<table border="1">
					<tr>
						<td>글 제목</td>
						<td><input type="text" name="title"
							value="${data.title}"></td>
					</tr>
					<tr>
						<td>글 내용</td>
						<td><input type="text" name="content"
							value="${data.content}"></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" name="writer"
							value="${data.writer}"></td>
					</tr>
					<tr>
						<td colspan="2" align="right"><input type="submit" value="변경">
						</td>
					</tr>
				</table>
			</form>
			<a href="delete.do?bid=${data.bid}">해당 게시글 삭제</a>
		</c:when>
		<c:otherwise>
			<h3>출력할 데이터가 없습니다!</h3>
		</c:otherwise>
	</c:choose>
	<hr>
	<a href="main.do">메인페이지로 돌아가기</a>

</body>
</html>