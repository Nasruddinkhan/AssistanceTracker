
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content">
	<div class="box box-primary">
		<div class="box-header with-border">
			<h3 class="box-title">Add State Details</h3>
			<div class="box-tools pull-right">
				<button type="button" class="btn btn-box-tool "
					data-widget="collapse">
					<i class="fa fa-minus"></i>
				</button>
			</div>
		</div>
		<div class="row">
			<form:form method="POST"
				action="${pageContext.request.contextPath}/mst/savestate.do"
				modelAttribute="state">
				<div class="col-sm-12">
					<div class="box-body">
						<div class="form-group col-sm-6">
							<label for="stateCode">State Code</label>
							<c:choose>
								<c:when test="${not empty state.stateCode}">
									<form:input type="text" class="form-control" path="stateCode"
										readonly="true" />
									<form:hidden class="form-control" path="isNew" value="false" />

								</c:when>
								<c:otherwise>
									<form:hidden class="form-control" path="isNew" value="true" />
									<form:input path="stateCode" type="text" class="form-control"
										placeholder="Enter State Code" />
								</c:otherwise>
							</c:choose>
							<form:errors path="stateCode" cssClass="error" />

						</div>
						<div class="form-group col-sm-6">
							<label for="stateCode">State Name</label>
							<form:input path="stateName" type="text" class="form-control"
								placeholder="Enter State Name" />
							<form:errors path="stateName" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label for="stateCode">2 Digit Code</label>
							<form:input path="alpha2Code" type="text" class="form-control"
								placeholder="Enter 2 Digit Code" />
							<form:errors path="alpha2Code" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label for="Countries">Countries</label>
							<form:select path="country" class="form-control">
								<form:option value="">----SELECT COUNTRY----</form:option>
								<form:options items="${countries}" itemValue="key"
									itemLabel="value" />
							</form:select>
							<form:errors path="country" cssClass="error" />

						</div>
					</div>
					<div class="box-footer">
							<button type="submit" class="btn btn-primary">
							<c:choose>
								<c:when test="${not empty  state.stateCode}">
									Update
								</c:when>
								<c:otherwise>Save</c:otherwise>
							</c:choose>
							</button>
					</div>
				</div>
			</form:form>
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
	</div>
	<c:if test="${not empty states}">
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
									<th>State</th>
									<th>State Name</th>
									<th>Alpha 2 Code</th>
									<th>Country</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${states}" var="state">
									<tr>
										<td>${state.stateCode}</td>
										<td>${state.stateName}</td>
										<td>${state.alpha2Code}</td>
										<td>${state.country} - ${state.countryName}</td>
										<td><div class="box-tools pull-center">
												<a
													href="${pageContext.request.contextPath}/mst/edit/${state.stateCode}/state.do"><button
														type="button" class="btn btn-sm btn-info btn-box-tool">
														<i class="fa fa-edit" style="color: white"></i>
													</button> </a> <a
													href="${pageContext.request.contextPath}/mst/delete/${state.stateCode}/state.do"><button
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

