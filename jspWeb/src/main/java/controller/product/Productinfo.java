package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.ProductDao;
import model.dto.ProductDto;


@WebServlet("/product/info")
public class Productinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Productinfo() {super();}
    
    ObjectMapper mapper = new ObjectMapper();

    //제품 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String 동 = request.getParameter("동"); System.out.println("동 : "+동);
		String 서 = request.getParameter("서"); System.out.println("서 : "+서);
		String 남 = request.getParameter("남"); System.out.println("남 : "+남);
		String 북 = request.getParameter("북"); System.out.println("북 : "+북);
		
		
		ArrayList<ProductDto> result = ProductDao.getInstance().getProductList(동,서,남,북);
		System.out.println("result 결과 : ");
		System.out.println(result);
		String jsonarray = mapper.writeValueAsString(result);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonarray);
	}

	//제품 등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getSession().getServletContext().getRealPath("/product/pimg");
		
		MultipartRequest multi = new MultipartRequest(
				request, path,1024*1024*10,"UTF-8", new DefaultFileRenamePolicy());
		
		String pname = multi.getParameter("pname");			System.out.println(pname);
		String pcomment = multi.getParameter("pcomment");	System.out.println(pcomment);
		int pprice = Integer.parseInt(multi.getParameter("pprice"));	System.out.println(pprice);
		String plat = multi.getParameter("plat");			System.out.println(plat);
		String plng = multi.getParameter("plng");			System.out.println(plng);
		
		ProductDto dto = new ProductDto(pname, pcomment, pprice, plat, plng);
		
		boolean reuslt = ProductDao.getInstance().write(dto);
		response.getWriter().print(reuslt);
		
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
