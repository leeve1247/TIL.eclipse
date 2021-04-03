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
		PrintWriter out = response.getWriter(); //Ŭ���̾�Ʈ���� ���� ��� ����
		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");

		Enumeration<String> headerNames = request.getHeaderNames(); //WAS �� client�� ��� ������ request�� ���彼
		while(headerNames.hasMoreElements()) { //while���� ���� 
			String headerName = headerNames.nextElement(); // ������ �˾ƺ���,
			String headerValue = request.getHeader(headerName); // request ��ü�� ���� header ���� ����
			out.println(headerName + " : " + headerValue + " <br> "); // �������� ���
		}		
		
		
		out.println("</body>");
		out.println("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response); //get���� ��û�ϴ�, post�� ���� �ᵵ �������� �ϵ� �ϴپ�
	}

}
