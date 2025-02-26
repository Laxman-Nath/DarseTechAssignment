<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Book</title>
<%@ include file="./bootstrap.css"%>
</head>
<body class="bg-black">

	<div class="container" style="margin-top: 200px;">
		<div class="row ">
			<div class="col-md-6 offset-md-3">
				<div class="card ">
					<div class="card-header text-center  ">
						<h1>Add Book</h1>
						<h3 class="text-danger">${message }</h3>
					</div>
					<div class="card-body">
						<form action="BookEditServlet" method="post">
							<input type="hidden" name="id" value="${ book.id}" />
							<div class="mb-2 text-center">
								<label class="form-label">Name: </label> <input type="text"
									name="name" required class="form-control" value="${book.name }" />
							</div>
							<div class="mb-2 text-center">
								<label class="form-label">ISBN: </label> <input type="text"
									name="isbn" required class="form-control" value="${book.isbn }" />
							</div>
							<div class="mb-2 text-center ">
								<button type="submit" class="btn btn-primary">Submit</button>
							</div>
						</form>
					</div>
				</div>

			</div>

		</div>

	</div>
</body>
</html>