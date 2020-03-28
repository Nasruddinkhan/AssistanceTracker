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
			<div class="col-sm-5">
				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">Email address</label> <input
							type="email" class="form-control" id="exampleInputEmail1"
							placeholder="Enter email">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> <input
							type="password" class="form-control" id="exampleInputPassword1"
							placeholder="Password">
					</div>
				</div>
				<div class="box-footer">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</div>
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

