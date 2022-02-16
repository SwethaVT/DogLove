import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Register extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("name");  
String a=request.getParameter("age");  
String e=request.getParameter("email");  
String p=request.getParameter("pwd");  
          
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","system","user");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into registeruser values(?,?,?,?)");  
  
ps.setString(1,n);  
ps.setString(2,a);  
ps.setString(3,e);  
ps.setString(4,p);  
          
int i=ps.executeUpdate();  
if(i>0){ 
out.print("<body bgcolor=rgb(0,0,0,0.3)>");
out.print("<br><br><br><br><br>");
out.print("<h2 align=center>You are successfully registered...</h2>");  
out.print("<br><h2 align=center> <a href="l.html" >Click here to login</a></h2>");
out.print("</body>");
}   
          
}catch (Exception e2) {
out.print("<body bgcolor=rgb(0,0,0,0.3)>");
out.print("<br><br><br><br><br>");
out.print("<h2 align=center>Regiatration failed...</h2>");  
out.print("<br><h2 align=center>Click here to <a href="reg.html" >Try again?</a></h2>");
out.print("<body bgcolor=rgb(0,0,0,0.3)>");
}  
          
out.close();  
}  
  
}  