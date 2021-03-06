package UserServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ConnectionFact.ConnectionFactory;
import ConnectionFact.ResourceClose;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class GymAreaServlet
 */
@WebServlet("/SonPlaceServlet")
public class SonPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SonPlaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		String GymArea1= request.getParameter("GymArea");
//		System.out.print("=="+GymArea1+"''");
		JSONObject result=JSONObject.fromObject(GymArea1);
	//	String tel=(String) result.get("Tel");
		String GymArea=(String) result.get("GymArea");
		String Place=(String) result.get("Place");
		PreparedStatement pstmt=null;		
		ResultSet rs=null;
		String back;
		Connection conn=null;
	    List ls=new ArrayList();
		try{	String sql=null;
		    sql="select distinct sonplace from Area where GymArea=? and place=?";
		    conn=ConnectionFactory.getConnection();
			 pstmt=conn.prepareStatement(sql);
			// pstmt.setString(1, tel);
			 pstmt.setString(1, GymArea);
			 pstmt.setString(2, Place);
			 rs=pstmt.executeQuery();	
			  ResultSetMetaData metaData = rs.getMetaData();  
			   int columnCount = metaData.getColumnCount();  
			   JSONObject jsonObj=null;
			 if(rs.next()) {  
			    	do{
			        jsonObj = new JSONObject();  
			         
			        // 遍历每一列  
			        for (int i = 1; i <= columnCount; i++) {  
			            String columnName =metaData.getColumnLabel(i);  
			            String value = rs.getString(columnName);  
			            jsonObj.put(columnName, value);  
			        }  
			        ls.add(jsonObj);
			    	}while(rs.next());
			         
			        back=ls.toString();
//			        System.out.println(back);
					out.write(back);
					out.flush();
			    } 
			   else{
					out.write("加载失败");
					out.flush();
			    }
				
	}catch(Exception e){
		e.printStackTrace();
		
	}finally{
		   ResourceClose.close(rs, pstmt, conn);
		   }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doGet(request, response);
	}

}
