<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="data" class="model.BoardVO" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 페이지</title>
<script type="text/javascript">
	function del() {
		ans = confirm("내용은 복구되지않습니다. 정말 삭제하시겠습니까?");
		if (ans == true) {
			document.formA.action.value = "delete";
			document.formA.submit();
		} else {
			return;
		}
	}
</script>
</head>
<body>
	<c:choose>
		<c:when test="${data!=null}">
			<form action="controller.jsp" method="post" name="formA">
				<input type="hidden" name="action" value="update"> <input
					type="hidden" name="bid" value="<%=data.getBid()%>">
				<table border="1">
					<tr>
						<td>글 제목</td>
						<td><input type="text" name="title"
							value="<%=data.getTitle()%>"></td>
					</tr>
					<tr>
						<td>글 내용</td>
						<td><input type="text" name="content"
							value="<%=data.getContent()%>"></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" name="writer"
							value="<%=data.getWriter()%>"></td>
					</tr>
					<tr>
						<td colspan="2" align="right"><input type="submit" value="변경">
							<input type="button" value="삭제" onClick="del()"></td>
					</tr>
				</table>
			</form>
		</c:when>
		<c:otherwise>
			<h3>출력할 데이터가 없습니다!</h3>
		</c:otherwise>
	</c:choose>
	<hr>
	<a href="controller.jsp?action=main">메인페이지로 돌아가기</a>

</body>
</html>