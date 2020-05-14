<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="content">
	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible hideMe" id='hideMe'
			role="alert" style="text-align: center;">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong class="hideMe">${msg}</strong>
		</div>
	</c:if>
	<div class="box box-primary">
		<div class="box-header">
			<i class="ion ion-clipboard"></i>
			<h3 class="box-title">Member Details</h3>
			<div class="box-tools pull-right">
				<ul class="pagination pagination-sm inline">
					<c:if test="${pageCtn gt 1}">
						<li><c:choose>
								<c:when test="${currentPage gt 1}">
									<a
										href="${pageContext.request.contextPath}/member/showmemberpage/${currentPage-1}/pagination.do">&laquo;</a>
								</c:when>
								<c:otherwise>
									<a>&laquo;</a>
								</c:otherwise>
							</c:choose></li>
						<li><a href="#">${currentPage} to ${pageCtn}</a></li>
						<li><c:choose>
								<c:when test="${currentPage lt pageCtn}">
									<a
										href="${pageContext.request.contextPath}/member/showmemberpage/${currentPage+1}/pagination.do">&raquo;</a>
								</c:when>
								<c:otherwise>
									<a>&raquo;</a>
								</c:otherwise>
							</c:choose></li>
					</c:if>
				</ul>
				<%-- 	<a href="${pageContext.request.contextPath}/member/add_member.do"><button
						type="button" class="btn btn-sm btn-primary btn-box-tool">
						<i class="fa fa-plus" style="color: white"></i>
					</button></a> --%>
			</div>
		</div>
		<!-- /.box-header -->
		<div class="box-body">
			<!-- See dist/js/pages/dashboard.js to activate the todoList plugin -->
			<ul class="todo-list">
				<c:forEach items="${memberList}" var="memeber">
					<li>
						<!-- drag handle --> <span class="handle"> <i
							class="fa fa-ellipsis-v"></i> <i class="fa fa-ellipsis-v"></i>
					</span> <span class="text">${memeber.firstName }</span> <span class="text">${memeber.lastName }
							member id is </span> <span class="text">${memeber.memberId }</span> <span
						class="text">with contact details and mail id are
							${memeber.contactNo } ${memeber.cantactNo1 } ${memeber.emailId }
							<a
							href="${pageContext.request.contextPath}/member/showmemberpage.do"
							class="memberiframe">TEST</a>
					</span> <!--    <small class="label label-danger"><i class="fa fa-clock-o"></i> 2 mins</small> -->
						<div class="tools">
							<i class="fa fa-eye"
								onclick="viewMemebers(`${memeber.memberId}`);"> </i> <a
								href="${pageContext.request.contextPath}/member/edit/${memeber.memberId}/add_member.do"><i
								class="fa fa-edit"></i></a> <a
								href="${pageContext.request.contextPath}/member/delete/${memeber.memberId}/add_member.do">
								<i class="fa fa-trash-o"> </i>
							</a>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
		<!-- /.box-body -->
		<div class="box-footer clearfix no-border">
			<div class="box-tools pull-right">
				<a href="${pageContext.request.contextPath}/member/add_member.do"><button
						type="button" class="btn btn-sm btn-primary btn-box-tool">
						<i class="fa fa-plus" style="color: white"></i>
					</button></a>

			</div>
		</div>
	</div>
	<div class="modal fade" id="modal-default">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">
						<strong>Members &nbsp <span id="viewmember_id"></span></strong>
					</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<h3 class="box-title">Responsive Hover Table</h3>
									<div class="box-tools">
										<div class="input-group input-group-sm" style="width: 150px;">
											<input type="text" name="table_search"
												class="form-control pull-right" placeholder="Search">

											<div class="input-group-btn">
												<button type="submit" class="btn btn-default">
													<i class="fa fa-search"></i>
												</button>
											</div>
										</div>
									</div>
								</div>
								<!-- /.box-header -->
								<div class=" table-responsive no-padding">
									<table class="table table-border table-hover">
										<tr>
											<th>ID</th>
											<th>User</th>
											<th>Date</th>
											<th>Status</th>
											<th>Reason</th>
										</tr>
										<tr>
											<td>183</td>
											<td>John Doe</td>
											<td>11-7-2014</td>
											<td><span class="label label-success">Approved</span></td>
											<td>Bacon ipsum dolor sit amet salami venison chicken
												flank fatback doner.</td>
										</tr>
										<tr>
											<td>219</td>
											<td>Alexander Pierce</td>
											<td>11-7-2014</td>
											<td><span class="label label-warning">Pending</span></td>
											<td>Bacon ipsum dolor sit amet salami venison chicken
												flank fatback doner.</td>
										</tr>
										<tr>
											<td>657</td>
											<td>Bob Doe</td>
											<td>11-7-2014</td>
											<td><span class="label label-primary">Approved</span></td>
											<td>Bacon ipsum dolor sit amet salami venison chicken
												flank fatback doner.</td>
										</tr>
										<tr>
											<td>175</td>
											<td>Mike Doe</td>
											<td>11-7-2014</td>
											<td><span class="label label-danger">Denied</span></td>
											<td>Bacon ipsum dolor sit amet salami venison chicken
												flank fatback doner.</td>
										</tr>
									</table>
								</div>
								<!-- /.box-body -->
							</div>
							<!-- /.box -->
						</div>
					</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default pull-left"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
</section>

