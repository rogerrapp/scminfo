package se.puredelivery.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SCMInfoServlet extends HttpServlet {
	private static final long serialVersionUID = -5949471558791282472L;
	private String msg; 
	private String getSCMInfoFromManifest() {
		try {
			Properties prop = new Properties();
			prop.load(getServletContext().getResourceAsStream("/META-INF/MANIFEST.MF"));
			return "All attributes:" + prop.stringPropertyNames();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public void init() {
		this.msg = "Msg in Java Servlet";
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain; charset=UTF-8");
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		out.println(getSCMInfoFromManifest());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain; charset=UTF-8");
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		out.println(getSCMInfoFromManifest());
	}

	
	
}
