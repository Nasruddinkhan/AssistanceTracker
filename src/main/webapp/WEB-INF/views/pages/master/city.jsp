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
						<label for="cityCode">City Code</label>
							<form:input path="cityCode" type="text" class="form-control"
										placeholder="Enter City Code" />
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
						<label for="country">Country</label>
							<form:select path="country" class="form-control select2">
								<form:option value="">----SELECT STATE----</form:option>
								<form:options items="${state}" itemValue="key"
									itemLabel="value" />
							</form:select>
										<form:errors path="country" cssClass="error" />
										
					</div>
				
				</div>
				<div class="box-footer">
						<div class="col-sm-12 col-sm-offset-5">
							<button type="submit" class="btn btn-primary">
							
									Save
								
							</button>
						</div>
					</div>
			</div>
			</form:form>
		</div>
		</div>
		<div class="box box-success">
			<div class="box-header with-border">
				<h3 class="box-title"></h3>
				<div class="box-tools pull-center">
					<button type="button" class="btn btn-sm btn-primary btn-box-tool">
						<i class="fa fa-plus" style="color: white"></i>
					</button>
					<button type="button" class="btn btn-sm btn-info btn-box-tool">
						<i class="fa fa-edit" style="color: white"></i>
					</button>
					<button type="button" class="btn btn-sm btn-danger btn-box-tool">
						<i class="fa fa-trash" style="color: white"></i>
					</button>
				</div>
			</div>
			<div class="box-body"></div>
		</div>
</section>

