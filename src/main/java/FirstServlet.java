
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/FirstServlettest")
public class FirstServlet extends HttpServlet{
    public FirstServlet() {
        super();
    }

    @Override
    public void init() throws ServletException { }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("This is " + this.getClass().getName() + ", using the GET method");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("This is " + this.getClass().getName() + ", using the POST method");
        out.println(request.getMethod());
        out.println(request.getRequestURL());
        out.println(request.getProtocol());
        out.println(request.getRemoteAddr());
        out.println(request.getContextPath());
        out.println(request.getScheme());
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
