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
    	System.out.println("LifecycleServlet ����!!");//console log�� ǥ���ϴ� ���̴�.
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init test ȣ��!!");//console log�� ǥ���ϴ� ���̴�.
		// TODO Auto-generated method stub
	}

	public void destroy() {
		System.out.println("destroy ȣ��!!");//console log�� ǥ���ϴ� ���̴�.
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
		//form �±״� ���� submit�� ��ư�� Ŭ������ ��� 'post' �޼ҵ� ������ /firstweb/LifecycleServlet �� ��û�ش޶�� �ǹ�
		out.println("name : <input type='text' name='name'><br>");
		out.println("<input type='submit' value='ok'><br>");
		//ok ��ư �Է� �� get �޼ҵ尡 �ƴ� post �޼ҵ�� ���� url�� ��ȣ�� ��
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");//ok ��ư���� �Ѿ name ���m��
		out.println("<h1> hello " + name + "</h1>");
		out.close();
	}

//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("service ȣ��!!");//console log�� ǥ���ϴ� ���̴�.
//		// TODO Auto-generated method stub
//	}

}
