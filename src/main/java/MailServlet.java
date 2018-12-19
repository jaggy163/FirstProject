import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet("/MailServlet")
public class MailServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Запрос параметров почтового сервера из mail.properties
        Properties properties = new Properties();
        ServletContext context = getServletContext();
        String fileName = context.getInitParameter("mail");
        //Загрузка параметров почтового сервера в объект свойств
        properties.load(context.getResourceAsStream(fileName));
        MailThread mailOperator = new MailThread(req.getParameter("to"), req.getParameter("subject"),
                req.getParameter("body"), properties);
        //запуск процесса отправки письма в отдельном потоке
        mailOperator.start();
        //переход на страницу с предложением создания нового письма
        req.getRequestDispatcher("/send.jsp").forward(req, resp);
    }
}
