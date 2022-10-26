package cn.simplelife.homework._03scope;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName ScopeServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/26 9:02
 * @Version 1.0
 */
@WebServlet(value = "/scope/demo")
public class ScopeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object num = req.getAttribute("num");
        if (num == null) {
            req.setAttribute("num", 1);
        } else {
            Integer reqNum = (Integer) num;
            req.setAttribute("num", reqNum + 1);
        }

        HttpSession session = req.getSession();
        Object sessionNum = session.getAttribute("num");
        if (sessionNum == null) {
            session.setAttribute("num", 1);
        } else {
            Integer sessNum = (Integer) sessionNum;
            session.setAttribute("num", sessNum + 1);
        }

        ServletContext servletContext = getServletContext();
        Object contextAttribute = servletContext.getAttribute("num");
        if (contextAttribute == null) {
            servletContext.setAttribute("num", 1);
        } else {
            Integer contextNum = (Integer) contextAttribute;
            servletContext.setAttribute("num", contextNum + 1);
        }

        req.getRequestDispatcher("/scope/result").forward(req, resp);
    }
}
