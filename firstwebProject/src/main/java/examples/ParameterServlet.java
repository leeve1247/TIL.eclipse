package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/param")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ParameterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");

		String name = request.getParameter("name"); // url 에 있는 param 은 문자인지, 숫자인지 모르고 그냥 문자열로 나온다
		String age = request.getParameter("age");

		// form 태그 안에 있는 input type들도 같은 형태로 들어옵니다.........
		out.println("name :" + name + "<br>");
		out.println("age :" + age + "<br>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
