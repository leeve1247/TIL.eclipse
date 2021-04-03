package examples;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/header")
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HeaderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); //클라이언트와의 연결 통로 형성
		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");

		Enumeration<String> headerNames = request.getHeaderNames(); //WAS 는 client의 모든 정보를 request에 저장슨
		while(headerNames.hasMoreElements()) { //while문을 통해 
			String headerName = headerNames.nextElement(); // 값들을 알아보고,
			String headerValue = request.getHeader(headerName); // request 객체를 통해 header 값을 얻어낸다
			out.println(headerName + " : " + headerValue + " <br> "); // 브라우저에 출력
		}		
		
		
		out.println("</body>");
		out.println("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response); //get으로 요청하니, post에 글을 써도 마찬가지 일듯 하다아
	}

}
