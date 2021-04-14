package kr.or.connect.webapiexam.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

@WebServlet(name = "roles", urlPatterns = { "/roles" })
public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RoleServlet() {
    	super();
    	//그대로 상속
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		
		RoleDao dao = new RoleDao();
		
		List<Role> list = dao.getRoles();
		
		ObjectMapper objectmapper = new ObjectMapper();
		//jackson, java용 라이브러리에 있는 객체중 하나이다.
		//객체를 json 문자열로 전환하거나, 반대로 json 문자열을 객체로 전환해주는 역할이다. 
		String json = objectmapper.writeValueAsString(list);
		// 해당 리스트가 json 문자로 바뀌어 리턴해준다.
		
		PrintWriter out = response.getWriter();
		out.println(json);
		out.close();
	}
}
