<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<section class="content">
	<div class="box box-primary">
		<div class="box-header with-border">
			<h3 class="box-title">Add Payment Mode</h3>
			<div class="box-tools pull-right">
				<button type="button" class="btn btn-box-tool "
					data-widget="collapse">
					<i class="fa fa-minus"></i>
				</button>
			</div>
		</div>
		<form:form method="POST" modelAttribute="payment_mode"
			action="${pageContext.request.contextPath}/mst/savepayment_mode.do">
			<div class="box-body">
				<div class="row">
					<c:if test="${not empty payment_mode.paymentModeId}">
						<div class="col-lg-6">
							<div class="form-group">
								<label for="paymentModeId">Payment Mode ID</label>
								<form:input path="paymentModeId" type="text" readonly="true"
									class="form-control" />
								<form:hidden path="createDateTime" class="form-control" />

							</div>
						</div>
					</c:if>
					<div class="col-lg-6">
						<div class="form-group">
							<label for="pinCode">Payment Mode Name</label>
							<form:input path="paymentModeName" type="text"
								class="form-control" placeholder="Enter Payment Mode Name" />
							<form:errors path="paymentModeName" cssClass="error" />
						</div>
					</div>
				</div>
			</div>
			<div class="box-footer">
				<div class="col-sm-12 col-sm-offset-5">
					<button type="submit" class="btn btn-primary">
						<c:choose>
							<c:when test="${not empty payment_mode.paymentModeId}">
					Update
					</c:when>
							<c:otherwise>
					Save
					</c:otherwise>
						</c:choose>

					</button>
				</div>
			</div>
		</form:form>
	</div>
	<c:if test="${not empty payments}">
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-header">
						<h3 class="box-title">Country List</h3>
					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<table id="example1"
							class="table table-sm table-bordered table-striped">
							<thead>
								<tr>
									<th>Payment ID</th>
									<th>Payment Mode Name</th>
									<th>Add Date</th>
									<th>Update Date</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${payments}" var="payment">
									<tr>
										<td>${payment.paymentModeId}</td>
										<td>${payment.paymentModeName}</td>
										<td>${payment.createDateTime}</td>
										<td>${payment.updateDateTime}</td>
										<td><div class="box-tools pull-center">
												<a
													href="${pageContext.request.contextPath}/mst/edit/${payment.paymentModeId}/payment_mode.do"><button
														type="button" class="btn btn-sm btn-info btn-box-tool">
														<i class="fa fa-edit" style="color: white"></i>
													</button> </a> <a
													href="${pageContext.request.contextPath}/mst/delete/${payment.paymentModeId}/payment_mode.do"><button
														type="button" class="btn btn-sm btn-danger btn-box-tool">

														<i class="fa fa-trash" style="color: white"></i>
													</button> </a>

											</div></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</c:if>

</section>