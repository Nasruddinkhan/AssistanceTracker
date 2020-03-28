<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content">
	<div class="box box-primary">
		<div class="box-header with-border">
			<h3 class="box-title"></h3>
			<div class="box-tools pull-center">
				<button type="button" class="btn btn-sm btn-primary btn-box-tool">
					<i class="fa fa-plus" style="color:white"></i>
				</button>
				<button type="button" class="btn btn-sm btn-info btn-box-tool">
					<i class="fa fa-edit" style="color:white"></i>
				</button>
				<button type="button" class="btn btn-sm btn-danger btn-box-tool">
					<i class="fa fa-trash" style="color:white"></i>
				</button>
			</div>
		</div>
		<div class="box-body">
			<div class="row">
				<div class="col-md-4">
					<div class="form-group">
						<select class="form-control select2" style="width: 100%;">
							<option selected="selected">Please Select Pages</option>
							<option>903579</option>
							<option>903580</option>
							<option>903521</option>
							<option>903582</option>
							<option>903583</option>
							<option>903584</option>
						</select>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<label>&nbsp;</label>
						<button type="submit" class="btn btn-primary btn-sm ">Search</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

