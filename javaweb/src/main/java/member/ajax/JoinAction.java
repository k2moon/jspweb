package member.ajax;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import member.dao.MemberDAO;
import member.dto.MemberDTO;

@WebServlet("/joinAction.json")
public class JoinAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String role = request.getParameter("role");
		MemberDTO dto = new MemberDTO(id, pw, name, role);
		
		MemberDAO dao = new MemberDAO();
		int rs = dao.insert(dto);
		
		Map<String, String> map = new HashMap<>();
		map.put("rs", rs+"");
		
		String gson = new Gson().toJson(map);
		
		response.getWriter().write(gson);
		
	}

}
