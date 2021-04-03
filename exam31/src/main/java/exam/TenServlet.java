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
		// 동적으로 만들어 낸다아
		// 요청이 들어왔을 때, 이 프로그램이 실행됐을 때, url/ten을 신청했을 때 만들어낸다
		// request요소는 객체 HttpServletRequest에 저장, response 요소는 HttpServletResponse에 저장
		// 리소스 타입이 뭔지 알려줘야 한다. setContentType 브라우저가 이를 보고 알맞은 리소스를 보여줄 수 있을 것이다.
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();//PrintWriter를 return 받을 수 있음
		out.println("<h1>1~10까지 출력해보겠습니다.</h1>");//자바에서 엔터를 누르든 안누르든 html 출력과는 노상관이므로 print(개행X), println(자동 끝 개행)은 동일
		for(int i  = 1; i <= 10; i ++) {
			out.print("<h1>"+i+"<br></h1>");
		}
		out.close();
	}

}
