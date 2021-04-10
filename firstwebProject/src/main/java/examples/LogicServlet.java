package examples;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogicServlet
 */
@WebServlet("/logic")
public class LogicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int v1 = (int)(Math.random()*100)+1; //request�� �ñ���
		int v2 = (int)(Math.random()*100)+1; //request�� �ñ���
		int result = v1 + v2;
		
		request.setAttribute("v1", v1);  //"v1"��� Ű����� �ñ�
		request.setAttribute("v2", v2);  //"v2"��� Ű����� �ñ�
		request.setAttribute("result", result);  //"result"��� Ű����� �ñ�
		
		RequestDispatcher rd = request.getRequestDispatcher("/result.jsp");//���� ���� ������ �ִٸ���, �װ��� "/jsp/result.jsp"�̷��� �� �� �ִ�.
		rd.forward(request, response);
	}

}
