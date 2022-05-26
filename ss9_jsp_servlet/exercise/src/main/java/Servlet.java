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
    String mota = request.getParameter("mota");
    float gia = Float.parseFloat(request.getParameter("gia"));
    float chietkhau = Float.parseFloat(request.getParameter("chietkhau"));
    float tinh = (float) (gia*chietkhau*0.01);

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("mo ta: "+mota);
        writer.println("gia niem yet: "+gia);
        writer.println("ty le chiet khau: "+ chietkhau);
        writer.println("tong: "+(gia-tinh));
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
