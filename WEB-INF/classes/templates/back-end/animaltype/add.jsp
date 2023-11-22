<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>





<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>員工資料新增 - addEmp.jsp</title>

<%@ include file="included-fragment.file" %>
<style type="text/css">
	
	button {
		padding: 5px;
	}
	form {
		display: table;
	}
	form div {
		display: table-row;
	}
	label, input, span, select {
		display: table-cell;
		margin: 5px;
		text-align: left;		
	}
	input[type=text], input[type=password], select, textarea {
		width: 200px;
		margin: 5px;
	}
	form div div {
		display: table-cell;
	}
	.center {
        margin-left: auto;
        margin-right: auto;
    }
</style>
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark bg-success fixed-top justify-content-center">
		 <div align="center"> <h2>員工資料新增 - addEmp.jsp</h2>
		 <h3><a class="navbar-brand" href="<spring:url value='/emp/select_page'/>"><img src="<spring:url value='/images/back1.gif'/>">回查詢頁</a></h3></div>
</nav>

	<div align="center">
		<h3><b>所有欄位皆為必填欄位</b></h3>
		<form:form action="insert" method="post" modelAttribute="empVO" enctype="multipart/form-data">
			
			
			
			
			
			
			<div>
			<form:label  path="ename">員工姓名:</form:label>
			<form:input  path="ename" onclick="hideContent('ename.errors');" />
			<form:errors path="ename" cssClass="error" />
			</div>
			
			<div>
			<form:label  path="job">職位:</form:label>
			<form:input  path="job" onclick="hideContent('job.errors');" />
			<form:errors path="job" cssClass="error" />
			</div>

			<div>
			<form:label  path="hiredate">雇用日期:</form:label>
			<form:input  path="hiredate" type="date" onclick="hideContent('hiredate.errors');" />
			<form:errors path="hiredate" cssClass="error" />
			</div>
			
			<div>
			<form:label  path="sal">薪水:</form:label>
			<form:input  path="sal" onclick="hideContent('sal.errors');" />
			<form:errors path="sal" cssClass="error" />
			</div>
			
            <div>
			<form:label  path="comm">獎金:</form:label>
			<form:input  path="comm" onclick="hideContent('comm.errors');" />
			<form:errors path="comm" cssClass="error" />
			</div>
			
			<div>
			<form:label  path="deptVO">部門:</form:label>	
			<form:select path="deptVO" items="${deptListData}" itemValue="deptno" itemLabel="dname" />		
			<form:errors path="deptVO" cssClass="error" />
			</div>

			
			
			
			
			<div>
			<form:label  path="upFiles">照片:</form:label>
			<form:input  path="upFiles" type="file" onclick="previewImage()" multiple="multiple" onchange="hideContent('upFiles.errors');" />
			<form:errors path="upFiles" class="error" />
			<div id="blob_holder"></div>
			</div>
				
			<div>
				<div></div>
				<form:button id="submit"> 送出新增 </form:button>
				<div></div>
			</div>
		</form:form>
	
	</div>
	

<!-- JavaScript part -->
<script type="text/javascript">
//清除提示信息
function hideContent(d) {
     document.getElementById(d).style.display = "none";
}

//照片上傳-預覽用
var filereader_support = typeof FileReader != 'undefined';
if (!filereader_support) {
	alert("No FileReader support");
}
acceptedTypes = {
		'image/png' : true,
		'image/jpeg' : true,
		'image/gif' : true
};
function previewImage() {
	var upfile1 = document.getElementById("upFiles");
	upfile1.addEventListener("change", function(event) {
		var files = event.target.files || event.dataTransfer.files;
		for (var i = 0; i < files.length; i++) {
			previewfile(files[i])
		}
	}, false);
}
function previewfile(file) {
	if (filereader_support === true && acceptedTypes[file.type] === true) {
		var reader = new FileReader();
		reader.onload = function(event) {
			var image = new Image();
			image.src = event.target.result;
			image.width = 100;
			image.height = 75;
			image.border = 2;
			if (blob_holder.hasChildNodes()) {
				blob_holder.removeChild(blob_holder.childNodes[0]);
			}
			blob_holder.appendChild(image);
		};
		reader.readAsDataURL(file);
		document.getElementById('submit').disabled = false;
	} else {
		blob_holder.innerHTML = "<div  style='text-align: left;'>" + "● filename: " + file.name
				+ "<br>" + "● ContentTyp: " + file.type
				+ "<br>" + "● size: " + file.size + "bytes"
				+ "<br>" + "● 上傳ContentType限制: <b> <font color=red>image/png、image/jpeg、image/gif </font></b></div>";
		document.getElementById('submit').disabled = true;
	}
}
</script>

</body>
</html>