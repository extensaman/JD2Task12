package by.academy.it.task12;

import by.academy.it.task12.entity.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "")
public class StudentServlet extends HttpServlet {

    public static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    public static final String HTTP_LOCALHOST_4200 = "http://localhost:4200";
    private StudentService studentService;
    private ObjectMapper mapper;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = null;
        try {
            students = studentService.findAll();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        resp.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, HTTP_LOCALHOST_4200);
        resp.getWriter().write(mapper.writeValueAsString(students));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        studentService = ServiceProvider.getInstance().getStudentService();
        mapper = new ObjectMapper();
    }
}
