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
		int v1 = (int)(Math.random()*100)+1; //request에 맡기자
		int v2 = (int)(Math.random()*100)+1; //request에 맡기자
		int result = v1 + v2;
		
		request.setAttribute("v1", v1);  //"v1"라는 키워드로 맡김
		request.setAttribute("v2", v2);  //"v2"라는 키워드로 맡김
		request.setAttribute("result", result);  //"result"라는 키워드로 맡김
		
		RequestDispatcher rd = request.getRequestDispatcher("/result.jsp");//만약 하위 폴더에 있다면은, 그것은 "/jsp/result.jsp"이렇게 쓸 수 있다.
		rd.forward(request, response);
	}

}
