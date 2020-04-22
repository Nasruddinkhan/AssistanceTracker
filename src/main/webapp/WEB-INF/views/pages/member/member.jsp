<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="content">
<div class="box box-primary">
            <div class="box-header">
              <i class="ion ion-clipboard"></i>

              <h3 class="box-title">Member Details</h3>

              <div class="box-tools pull-right">
                <ul class="pagination pagination-sm inline">
                 <!--  <li><a href="#">&laquo;</a></li>
                  <li><a href="#">1</a></li>
                  <li><a href="#">2</a></li>
                  <li><a href="#">3</a></li> -->
                  <c:if test="${pageCtn gt 1}">
                  <c:forEach var="i"  begin="1" end="${pageCtn}" step="1">
  					    <li><a href="${pageContext.request.contextPath}/member/showmemberpage/${i}/pagination.do">${i}</a> </li>
 					</c:forEach>
 					</c:if>
                </ul>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <!-- See dist/js/pages/dashboard.js to activate the todoList plugin -->
              <ul class="todo-list">
              <c:forEach items="${memberList}" var="memeber">
                <li>	
                  <!-- drag handle -->
                  <span class="handle">
                        <i class="fa fa-ellipsis-v"></i>
                        <i class="fa fa-ellipsis-v"></i>
                      </span>
                  
                  <span class="text">${memeber.firstName }</span>
                  <span class="text">${memeber.lastName } member id is </span>
                  <span class="text">${memeber.memberId }</span>
                  <span class="text">with contact details and mail id are ${memeber.contactNo } ${memeber.cantactNo1 } ${memeber.emailId }</span>
                
                      
               <!--    <small class="label label-danger"><i class="fa fa-clock-o"></i> 2 mins</small> -->
                  <div class="tools">
                    <i class="fa fa-eye"></i>
                    <i class="fa fa-edit"></i>
                    <i class="fa fa-trash-o"></i>
                  </div>
                </li>
                </c:forEach>
             </ul>
            </div>
            <!-- /.box-body -->
            <div class="box-footer clearfix no-border">
              	<div class="box-tools pull-right">
				<a href="${pageContext.request.contextPath}/member/add_member.do"><button
						type="button" class="btn btn-sm btn-primary btn-box-tool">
						<i class="fa fa-plus" style="color: white"></i>
					</button></a>
				<button type="button" class="btn btn-sm btn-info btn-box-tool">
					<i class="fa fa-edit" style="color: white"></i>
				</button>
				<button type="button" class="btn btn-sm btn-danger btn-box-tool">
					<i class="fa fa-trash" style="color: white"></i>
				</button>
			</div>
            </div>
          </div>
</section>

