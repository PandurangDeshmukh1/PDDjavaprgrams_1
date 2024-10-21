import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/greet")
public class GreetingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><head><title>Greeting Page</title></head><body>");
        out.println("<h2>Welcome to the Greeting Page!</h2>");
        
        if (name != null && !name.isEmpty()) {
            out.println("<h3>Hello, " + name.toUpperCase() + "! Nice to meet you!</h3>");
        } else {
            out.println("<h3>Please enter your name!</h3>");
        }
        
        out.println("<form action='greet' method='post'>");
        out.println("<label for='name'>Enter your name:</label>");
        out.println("<input type='text' id='name' name='name' required>");
        out.println("<input type='submit' value='Greet Me'>");
        out.println("</form>");
        
        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
