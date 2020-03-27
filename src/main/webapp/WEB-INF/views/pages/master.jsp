<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content">
	<!-- SELECT2 EXAMPLE -->
	<div class="box box-primary">
		<div class="box-header with-border">
			<h3 class="box-title">Add Master Details</h3>
			<div class="box-tools pull-right">
				<button type="button" class="btn btn-box-tool" data-widget="add">
					<i class="fa fa-plus"></i>
				</button>
				<button type="button" class="btn btn-box-tool "
					data-widget="collapse">
					<i class="fa fa-minus"></i>
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
				<!-- /.col -->
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.box-body -->
		<!-- 	<div class="box-footer">
			<button type="submit" class="btn btn-default">Cancel</button>
			<button type="submit" class="btn btn-info pull-right">Sign
				in</button>
		</div> -->
	</div>
</section>

