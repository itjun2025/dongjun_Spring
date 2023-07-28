<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<script src="https://kit.fontawesome.com/ae4a843f52.js" crossorigin="anonymous"></script>
</head>

<body>
	<%@include file="./header.jsp" %>
    <div id="wrapper">

      
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html"> <i class="fa-solid fa-book"></i>도서관리 프로그램</a>
            </div>
            <!-- /.navbar-header -->

          

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="index.html"><i class="fa fa-dashboard fa-fw"></i> 도서관리</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>차트<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="flot.html">Flot Charts</a>
                                </li>

                                <li>
                                    <a href="morris.html">Morris.js Charts</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="tables.html"><i class="fa fa-table fa-fw"></i>테이블</a>
                        </li>
                        
                     
                            </ul>
                            <!-- /.nav-second-level -->
                       
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        
        <!--게시판-->
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">테이블</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            	도서목록
                        </div>
                        <!-- 검색폼 -->
                        <form name="searchForm" action="/book/list">
                        <input type="text" name="pageNo" value="${param.pageNo }">
                         <div class="form-inline text-center">
						    <div class="form-group">
						        
						        <select class="form-control" name="searchField">
						            <option value="title" ${pageDto.cri.searchField == 'title' ? 'selected' : ''}>제목</option>
						            <option value="author" ${pageDto.cri.searchField == 'author' ? 'selected' : ''}>작가</option>
						            
						        </select>
						        <div class="form-group">
						            <input class="form-control" name="searchWord">
						        </div>
						        <button type='submit' class="btn btn-default">검색</button>
						    </div>
						    </div>
                        </form>
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th>도서번호</th>
                                        <th>제목</th>
                                        <th>작가</th>
                                        <th>대여여부</th>
                                    </tr>
                                </thead>
                                <tbody>
                                
                                <c:forEach items="${list }" var="vo">
                                    <tr class="odd gradeX">
                                        <td><input type="checkbox"></td>
                                        <td><a href="/book/view?no=${vo.no }">${vo.no }</a></td>
                                        <td>${vo.title }</td>
                                        <td>${vo.author }</td>
                                        <td class="center">${vo.rentynStr }</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                                    
                            </table>
                            <div class="text-center">
				   <%@include file="../common/pageNavi.jsp" %>
                            </div>
   
   
                            <!-- /.table-responsive -->
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
            
            <!-- /.row -->
        </div>
        <!--  게시판 끝 -->
        <!-- /#page-wrapper -->
        

    </div>
    
    <%@include file="./footer.jsp" %>
   
   

</body>

</html>