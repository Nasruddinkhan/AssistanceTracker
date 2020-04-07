<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content">
	<div class="box box-primary">
		<div class="box-header with-border">
			<h3 class="box-title">Add City Details</h3>
			<div class="box-tools pull-right">
				<button type="button" class="btn btn-box-tool "
					data-widget="collapse">
					<i class="fa fa-minus"></i>
				</button>
			</div>
		</div>
		
		<div class="row">
		<form:form modelAttribute="city" method="POST"
				action="${pageContext.request.contextPath}/mst/savecity.do">
			<div class="col-sm-12">
				<div class="box-body">
					<div class="form-group col-sm-6">
						<label for="stateCode">State Code</label>
							<c:choose>
								<c:when test="${not empty city.cityCode}">
									<form:input type="text" class="form-control" path="cityCode"
										readonly="true" />
									<form:hidden class="form-control" path="isNew" value="false" />

								</c:when>
								<c:otherwise>
									<form:hidden class="form-control" path="isNew" value="true" />
									<form:input path="cityCode" type="text" class="form-control"
										placeholder="Enter State Code" />
								</c:otherwise>
							</c:choose>
										<form:errors path="cityCode" cssClass="error" />
					</div>
					<div class="form-group col-sm-6">
						<label for="cityName">City Name</label>
							<form:input path="cityName" type="text" class="form-control"
										placeholder="Enter City Code" />
										<form:errors path="cityName" cssClass="error" />
										
					</div>
					<div class="form-group col-sm-6">
						<label for="cityAlphaCOde">City 2 Alpha Code</label>
							<form:input path="cityAlphaCOde"  type="text" class="form-control"
										placeholder="Enter City Code" />
										<form:errors path="cityAlphaCOde" cssClass="error" />
					</div>
					<div class="form-group col-sm-6">
						<label for="country">State</label>
							<form:select path="state" class="form-control select2">
								<form:option value="">----SELECT STATE----</form:option>
								<form:options items="${state}" itemValue="key"
									itemLabel="value" />
							</form:select>
										<form:errors path="state" cssClass="error" />
										
					</div>
				
				</div>
				<div class="box-footer">
						<div class="col-sm-12 col-sm-offset-5">
							<button type="submit" class="btn btn-primary btn-sm">
							<c:choose>
								<c:when test="${not empty  city.cityCode}">
									Update
								</c:when>
								<c:otherwise>Save</c:otherwise>
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
		<c:if test="${not empty cities}">
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-header">
						<h3 class="box-title">City List</h3>
					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<table id="example1"
							class="table table-sm table-bordered table-striped">
							<thead>
								<tr>
									<th>City</th>
									<th>State Name</th>
									<th>Alpha 2 Code</th>
									<th>State</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${cities}" var="city">
									<tr>
										<td>${city.cityCode}</td>
										<td>${city.cityName}</td>
										<td>${city.cityAlphaCOde}</td>
										<td>${city.state} - ${city.stateName}</td>
										<td><div class="box-tools pull-center">
												<a
													href="${pageContext.request.contextPath}/mst/edit/${city.cityCode}/city.do"><button
														type="button" class="btn btn-sm btn-info btn-box-tool">
														<i class="fa fa-edit" style="color: white"></i>
													</button> </a> <a
													href="${pageContext.request.contextPath}/mst/delete/${city.cityCode}/city.do"><button
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

