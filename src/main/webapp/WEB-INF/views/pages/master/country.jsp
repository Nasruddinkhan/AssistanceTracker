<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content">
	<div class="box box-primary">
		<div class="box-header with-border">
			<h3 class="box-title">Add Country Details</h3>
			<div class="box-tools pull-right">
				<button type="button" class="btn btn-box-tool "
					data-widget="collapse">
					<i class="fa fa-minus"></i>
				</button>
			</div>
		</div>
		<div class="row">
			<form:form method="POST"
				action="${pageContext.request.contextPath}/mst/country.do"
				modelAttribute="country">
				<div class="col-sm-12">
					<div class="box-body">
						<div class="form-group col-sm-6">
							<label for="Country Code">ALpha 3 Digit Country Code</label>
							<c:choose>
								<c:when test="${not empty country.countryCode}">
									<form:input type="text" class="form-control" path="countryCode" readonly="true"/>
									<form:hidden  class="form-control" path="isNew"  value="false"/>
									
								</c:when>
								<c:otherwise>
									<form:input type="text" class="form-control" path="countryCode" />
									<form:hidden  class="form-control" path="isNew" value="true"/>
									
								</c:otherwise>
							</c:choose>
							<form:errors path="countryCode" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label for="exampleInputPassword1">Country Name</label>
							<form:input type="text" path="countryName" class="form-control" />
							<form:errors path="countryName" cssClass="error" />
						</div>
					</div>
					<div class="box-body">
						<div class="form-group col-sm-6">
							<label for="Country Code">ALpha 2 Code</label>
							<form:input type="text" class="form-control" path="alpha2Code" />
							<form:errors path="alpha2Code" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label for="exampleInputPassword1">Numeric Code</label>
							<form:input type="text" path="numbericCode" class="form-control" />
							<form:errors path="numbericCode" cssClass="error" />
						</div>
					</div>
					<div class="box-footer">
						<div class="col-sm-12 col-sm-offset-5">
							<button type="submit" class="btn btn-primary">
							<c:choose>
								<c:when test="${not empty country.countryCode}">
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
		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible hideMe"  id='hideMe' role="alert"
				style="text-align: center;">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong class="hideMe">${msg}</strong>
			</div>
		</c:if>
	</div>
	<c:if test="${not empty countries}">
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
									<th>Country Code</th>
									<th>Country Name</th>
									<th>Alpha 2 Code</th>
									<th>Numeric Code</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${countries}" var="count">
									<tr>
										<td>${count.countryCode}</td>
										<td>${count.countryName}</td>
										<td>${count.alpha2Code}</td>
										<td>${count.numbericCode}</td>
										<td><div class="box-tools pull-center">
												<a
													href="${pageContext.request.contextPath}/mst/editCountry/${count.countryCode}.do"><button
														type="button" class="btn btn-sm btn-info btn-box-tool">
														<i class="fa fa-edit" style="color: white"></i>
													</button> </a> <a
													href="${pageContext.request.contextPath}/mst/country/${count.countryCode}.do"><button
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

