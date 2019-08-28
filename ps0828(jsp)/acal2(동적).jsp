<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset= utf-8"
    pageEncoding="utf-8"%>
<% request.setCharacterEncoding("utf-8"); %> 
<!DOCTYPE html>
<html lang ="ko">
<head>
<meta charset="utf-8">
<title>acal</title>
<style type ="text/css">

/* internal selector  => .class, #id, element 그자체    */
#aHello {margin: auto; border: 2px solid blue; padding :10px }
h3 {color: red; text-align : center;}
#tHello {margin: auto; background-color : #abcdef;}
.sun{ color: red;}
.sat{ color: blue;}
table
{
  border-collapse: collapse;
}
</style>
</head>
<!--브라우저에 보임  -->
<%--브라우저에 안보임 --%>
<body>
<%
	Calendar cal = Calendar.getInstance(); 
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH)+1; // 0~11 로 되서 1~12로 만듬. 
	String syear = request.getParameter("year");
	String smonth = request.getParameter("month");
	if( syear != null && !syear.trim().equals(""))
	{
		year = Integer.parseInt(syear.trim());
	}
	if( smonth!= null && !smonth.trim().equals(""))
	{
		month = Integer.parseInt(smonth.trim());
	}
	if( month >12)
	{
		year ++; 
		month =1; 
	}
	else if( month < 1)
	{
		year --; 
		month =12;
	}
	cal.set(year,month-1,1); //1일에 요일을 알면. 
	String rt = String.format(
			"<a href=' %s?year=%d&month=%d'><img src= './img/right.png' alt = 'right' /></a>"
			, "acal2.jsp",year, month+1);
	//a /a 이미지를 누르면 ~~한다. 
	
	String lt = String.format(
			"<a href=' %s?year=%d&month=%d'><img src= './img/left.png' alt = 'left' /></a>"
			, "acal2.jsp",year, month-1);
	String s = String.format (lt+"%d년 %d월"+rt, year, month);

	//<div id, class 하나밖에 없으면 id , 여러개 있으면 class다. 
%>
<div id ='aHello'> 
<h3> 아현 칼렌더 </h3>

<table id ='tHello' border ="1px" > 

<col width = "70px" /><col width = "70px" />
<col width = "70px" /><col width = "70px" />
<col width = "70px" /><col width = "70px" />
<col width = "70px" />
<tr> 
<td colspan = "7" style ="text-align:center;"><%= s %> </td> 
</tr>
<tr height ="70px"> 

<th style ="color:red;">일</th>
<th>월</th><th>화</th>
<th>수</th><th>목</th>
<th>금</th>
<th class = 'sat'>토</th>
</tr>

<%
int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1~7일을 의미한다. 
%>
<tr> 
<%
for(int i=1 ; i<dayOfWeek;i++)
{	
	%>
	<td style ="vertical-align: top; text-align: left" height ="70px"> &nbsp;</td>  
	<%
}
int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
// 35 - 
for(int i = 1; i<= 37;  i++)
{
	if( i <=lastDay)
	{
		if((dayOfWeek-1 +i)%7 ==0)
		{
			%>
			<td class='sat' height ="70px" > <%= i %></td>
			<%
		}
		else if((dayOfWeek-1 +i)%7 ==1)
		{
			%>
			<td style ="color:red;" height ="70px"> <%= i %></td>
			<%	
		}
		else 
		{
			%>
			<td> <%= i %></td>
			<%
		}
		}
	else if(  i >lastDay)
	{
	%>
	<td> <%= " " %></td>
	<%	
	}
	// 토요일이면.
	if((dayOfWeek-1 +i)%7 ==0)
	{
		if( i >= lastDay)
		{
			break;
		}
		else
		{
			%>
			</tr><tr>
			<%
		}
	}
}

%>
</tr>
</table>
</div>

</body>
</html>