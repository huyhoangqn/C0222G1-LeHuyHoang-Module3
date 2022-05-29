import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet", urlPatterns = "/discount")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        float discount = Float.parseFloat(request.getParameter("discount"));
        PrintWriter writer = response.getWriter();
        try {
            float calculate = (float) (price * discount * 0.01);
            writer.println("<html>");
            writer.println("mo ta: " + description);
            writer.println("gia niem yet: " + price);
            writer.println("ty le chiet khau: " + discount);
            writer.println("tong: " + (price - calculate));
            writer.println("</html>");
        } catch (Exception e) {
            writer.println("<html>");
            writer.println("<img src=\"https://driversmayin.com/wp-content/uploads/2022/04/How-to-Fix-the-502-Bad-Gateway-Error-in-WordPress.jpg\" alt=\"\">");
            writer.println("</html>");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
