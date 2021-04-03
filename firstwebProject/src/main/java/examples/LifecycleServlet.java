package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LifecycleServlet")
public class LifecycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

    public LifecycleServlet() {
    	System.out.println("LifecycleServlet 생성!!");//console log에 표시하는 것이다.
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init test 호출!!");//console log에 표시하는 것이다.
		// TODO Auto-generated method stub
	}

	public void destroy() {
		System.out.println("destroy 호출!!");//console log에 표시하는 것이다.
		// TODO Auto-generated method stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");
		out.println("<form method='post' action='/firstwebProject/LifecycleServlet'>");
		//form 태그는 이후 submit의 버튼을 클릭했을 경우 'post' 메소드 값으로 /firstweb/LifecycleServlet 에 요청해달라는 의미
		out.println("name : <input type='text' name='name'><br>");
		out.println("<input type='submit' value='ok'><br>");
		//ok 버튼 입력 시 get 메소드가 아닌 post 메소드로 같은 url이 재호출 됨
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");//ok 버튼으로 넘어간 name 우헿슨
		out.println("<h1> hello " + name + "</h1>");
		out.close();
	}

//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("service 호출!!");//console log에 표시하는 것이다.
//		// TODO Auto-generated method stub
//	}

}
