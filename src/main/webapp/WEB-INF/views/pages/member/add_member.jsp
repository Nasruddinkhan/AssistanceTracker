<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content">
	<div class="box box-primary">
		<div class="box-header with-border">
			<h3 class="box-title">Add Member Details</h3>
		</div>
		<form:form
			action="${pageContext.request.contextPath}/member/saveadd_member.do"
			modelAttribute="add_member">
			<div class="box-body">
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label for="paymentModeId">First Name</label>
							<form:input type="text" path="firstName" class="form-control" />
							<form:errors path="firstName" cssClass="error" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label for="paymentModeId">Last Name</label>
							<form:input path="lastName" type="text" class="form-control" />
							<form:errors path="lastName" cssClass="error" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label for="paymentModeId">Nick Name</label>
							<form:input path="nickName" type="text" class="form-control" />
							<form:errors path="nickName" cssClass="error" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label for="paymentModeId">Contact No</label>
							<form:input path="contactNo" type="text" class="form-control" />
							<form:errors path="contactNo" cssClass="error" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label for="paymentModeId">Contact No1</label>
							<form:input path="cantactNo1" type="text" class="form-control" />
							<form:errors path="cantactNo1" cssClass="error" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label for="paymentModeId">Email Id</label>
							<form:input path="emailId" type="text" class="form-control" />
							<form:errors path="emailId" cssClass="error" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label for="profession"> Profession </label>
							<form:select path="profession" type="text" class="form-control">
								<form:option value="">----SELECT PROFESSION----</form:option>
								<form:options items="${professions}" itemValue="key"
									itemLabel="value" />
							</form:select>
							<form:errors path="profession" cssClass="error" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label for="paymentModeId">Country</label>
							<form:select path="country" id="memberCountry"
								class="form-control">
								<form:option value="">----SELECT COUNTRY----</form:option>
								<form:options items="${countries}" itemValue="key"
									itemLabel="value" />
							</form:select>
							<form:errors path="country" cssClass="error" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label for="paymentModeId">State</label>
							<form:select path="state" id="memberstate" class="form-control">
								<form:options items="${states}" itemValue="key"
									itemLabel="value" />
							</form:select>
							<form:errors path="state" cssClass="error" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label for="paymentModeId"> City </label>
							<form:select path="city" id="membercity" type="text"
								class="form-control">
								<form:options items="${cities}" itemValue="key"
									itemLabel="value" />
							</form:select>
							<form:errors path="city" cssClass="error" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label for="paymentModeId">Pin code</label>
							<form:input path="pinCode" id="pinCode" type="text"
								readonly="true" class="form-control" />
							<form:errors path="pinCode" cssClass="error" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label for="paymentModeId">Street / Road</label>
							<form:input path="street" type="text" class="form-control" />
							<form:errors path="street" cssClass="error" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="paymentModeId"> Address 1 </label>
							<form:textarea class="form-control" path="address1" />
							<form:errors path="address1" cssClass="error" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="paymentModeId">Address 2</label>
							<form:textarea path="address2" class="form-control" />
							<form:errors path="address2" cssClass="error" />
						</div>
					</div>
				</div>
			</div>
			<div class="box-footer">
				<div class="col-sm-12 col-sm-offset-5">
					<button type="submit" class="btn btn-primary">Save</button>
				</div>
			</div>
		</form:form>
	</div>
</section>

