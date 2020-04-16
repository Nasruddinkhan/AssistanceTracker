<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<section class="content">
	<div class="box box-primary">
		<div class="box-header with-border">
			<h3 class="box-title">Add PinCode Details</h3>
			<div class="box-tools pull-right">
				<button type="button" class="btn btn-box-tool "
					data-widget="collapse">
					<i class="fa fa-minus"></i>
				</button>
			</div>
		</div>
		<div class="row">
			<form:form modelAttribute="pincode"
				action="${pageContext.request.contextPath}/mst/savepincode.do"
				method="POST">
				<div class="col-sm-12">
					<div class="box-body">
						<div class="form-group col-sm-6">
							<label for="pinCode">Pin Code</label>
							<c:choose>
								<c:when test="${ pincode.isNew eq 'true'}">
									<form:input path="pinCode" type="text" class="form-control"
										placeholder="Enter City Code"  />
										<form:hidden class="form-control" path="isNew" value="true" />
								</c:when>
								<c:otherwise>
									<form:hidden class="form-control" path="isNew" value="false" />
									<form:input path="pinCode" type="text" class="form-control" readonly="true"
										placeholder="Enter State Code" />
								</c:otherwise>
							</c:choose>
							<form:errors path="pinCode" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label for="country">City</label>
							<form:select path="cityName" class="form-control select2">
								<form:option value="">----SELECT CITY----</form:option>
								<form:options items="${city}" itemValue="key" itemLabel="value" />
							</form:select>
							<form:errors path="cityName" cssClass="error" />

						</div>
					</div>
					<div class="box-footer">
						<div class="col-sm-12 col-sm-offset-5">
							<button type="submit" class="btn btn-primary">
								<c:choose>
									<c:when test="${pincode.isNew eq 'true'}">
									Save
								</c:when>
									<c:otherwise>Update</c:otherwise>
								</c:choose>
							</button>
						</div>
					</div>
				</div>

			</form:form>
		</div>
	</div>
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
		<c:if test="${not empty pincodes}">
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-header">
						<h3 class="box-title">PinCode List</h3>
					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<table id="example1"
							class="table table-sm table-bordered table-striped">
							<thead>
								<tr>
									<th>PinCode Code</th>
									<th>City Name</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${pincodes}" var="pincode">
									<tr>
										<td>${pincode.pinCode}</td>
										<td>${pincode.cityDtls}</td>
										
										<td><div class="box-tools pull-center">
												<a
													href="${pageContext.request.contextPath}/mst/edit/${pincode.pinCode}/pincode.do"><button
														type="button" class="btn btn-sm btn-info btn-box-tool">
														<i class="fa fa-edit" style="color: white"></i>
													</button> </a> <a
													href="${pageContext.request.contextPath}/mst/delete/${pincode.pinCode}/pincode.do"><button
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

