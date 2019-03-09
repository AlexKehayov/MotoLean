package com.alex.motolean;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/calculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Calc2.html");

		double fi1 = 0;
		String fi2 = "";
		double fi_real = 0;
		double speed = 0;
		double radius = 0;

		try {
			fi1 = Double.parseDouble(request.getParameter("koeftr"));
			fi2 = (request.getParameter("motociklet"));
			speed = (Double.parseDouble(request.getParameter("skorost")))*1000/3600;
			radius = Double.parseDouble(request.getParameter("radius"));

			switch (fi2) {
			case "0":
				break;
			case "1":
				fi_real = 40;
				break;
			case "2":
				fi_real = 50;
				break;
			case "3":
				fi_real = 55;
				break;
			case "4":
				fi_real = 61;
				break;
			case "5":
				fi_real = 64;
				break;

			default:
				throw new Exception();
			}

		} catch (Exception e) {

			rd.forward(request, response);
		}

		if (fi1 != 0) {
			fi_real = Math.toDegrees(Math.atan(fi1));
		}

		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println("Ugul fi: " + fi_real + " deg<br/>");
//		out.println("Skorost: " + speed + " m/s<br/>");
//		out.println("Radius: " + radius + " m<br/>");
//		out.println();

		double finew = Math.toDegrees(Math.atan((speed * speed) / (9.8 * radius)));
		double proportion = fi_real/finew;
		
		request.setAttribute("proportion", proportion);
		request.setAttribute("fi_real", fi_real);
		request.setAttribute("finew", finew);
		request.setAttribute("speed", speed);
		request.setAttribute("radius", radius);
		
//		out.printf("Max fi: %.2f            Current fi: %.2f  <br/>", fi_real, finew);
//		
//		out.printf("Proporciq: %.2f\n <br/>", proportion);
//		out.println();
		
		String str="";
		
		if(proportion<1) str=("Този път няма да ти се размине...");
		else if(proportion<1.1) str=("Изключително опасна ситуация");
		else if(proportion<1.2) str=("Много опасна ситуация");
		else if(proportion<1.3) str=("Опасна ситуация");
		else if(proportion<1.4) str=("Подходете внимателно към ситуацията");
		else if(proportion<1.5) str=("Липсват значителни рискове");
		else str=("В безопасност си!");
		
		request.setAttribute("str", str);
		request.getRequestDispatcher("Calculator.jsp").forward(request, response);
	}

}
