package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TenServlet
 */
@WebServlet("/ttt")
public class TenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// �������� ����� ���پ�
		// ��û�� ������ ��, �� ���α׷��� ������� ��, url/ten�� ��û���� �� ������
		// request��Ҵ� ��ü HttpServletRequest�� ����, response ��Ҵ� HttpServletResponse�� ����
		// ���ҽ� Ÿ���� ���� �˷���� �Ѵ�. setContentType �������� �̸� ���� �˸��� ���ҽ��� ������ �� ���� ���̴�.
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();//PrintWriter�� return ���� �� ����
		out.println("<h1>1~10���� ����غ��ڽ��ϴ�.</h1>");//�ڹٿ��� ���͸� ������ �ȴ����� html ��°��� �����̹Ƿ� print(����X), println(�ڵ� �� ����)�� ����
		for(int i  = 1; i <= 10; i ++) {
			out.print("<h1>"+i+"<br></h1>");
		}
		out.close();
	}

}
