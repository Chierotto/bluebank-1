package bluebank.sevlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bluebank.jdbc.modelo.*;

@WebServlet("/transferencia")
public class TransfereSevlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
 
		PrintWriter out = response.getWriter();
		
		Conta contaOrigem = new Conta();
		Conta contaDestino = new Conta();
		
		String agOrigem = request.getParameter("agOrigem");
		String ctaOrigem = request.getParameter("contaOrigem");
		String agDestino = request.getParameter("agDestino");
		String ctaDestino = request.getParameter("contaDestino");
		String valorTexto = request.getParameter("valor");
	
		try{
			contaOrigem.setAgencia(Integer.parseInt(agOrigem));
			contaOrigem.setConta(Integer.parseInt(ctaOrigem));
			contaDestino.setAgencia(Integer.parseInt(agDestino));
			contaDestino.setConta(Integer.parseInt(ctaDestino));
				
	    	double valor = Double.parseDouble(valorTexto);
		
			try{
				contaOrigem.transfere(contaDestino, valor);			
		        out.println("<html>");
		        out.println("<body>");
		        out.println("Transferencia realizada com sucesso ");
		        out.println("</body>");
		        out.println("</html>");
			
			}catch (Exception e) {
		        out.println("<html>");
		        out.println("<body>");
		        out.println(e.getMessage());
		        out.println("</body>");
		        out.println("</html>");
	
			}
			
		
		}catch (Exception e) {
	        out.println("<html>");
	        out.println("<body>");
	        out.println("Conta ou valor invalido");
	        out.println("</body>");
	        out.println("</html>");

		}		
	}
	
}
