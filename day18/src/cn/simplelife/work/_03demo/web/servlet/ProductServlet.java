package cn.simplelife.work._03demo.web.servlet;

import cn.simplelife.work._03demo.dao.IProductDAO;
import cn.simplelife.work._03demo.dao.impl.IProductDAOImpl;
import cn.simplelife.work._03demo.domain.Product;
import cn.simplelife.work._03demo.uitils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @ClassName ProductServlet
 * @Description
 * @Author simplelife
 * @Date 2022/10/28 20:11
 * @Version 1.0
 */
@WebServlet(value = "/product")
public class ProductServlet extends HttpServlet {

    private IProductDAO iProductDAO = new IProductDAOImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Object usersInSession = req.getSession().getAttribute("USERS_IN_SESSION");
        // 判断用户是否登录
        if (usersInSession == null) {
            resp.sendRedirect("/login.jsp");
            return;
        }
        // 用户已经登录
        String cmd = req.getParameter("cmd");
        if ("delete".equals(cmd)) {
            delete(req, resp);
        } else if ("input".equals(cmd)) {
            input(req, resp);
        } else if ("save".equals(cmd)) {
            save(req, resp);
        } else if ("edit".equals(cmd)) {
            edit(req, resp);
        } else if ("update".equals(cmd)) {
            update(req, resp);
        } else {
            list(req, resp);
        }

    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 2、调用dao的方法查询数据
        List<Product> products = iProductDAO.selectAll();
        // 3、将数据设置到作用域
        req.setAttribute("products", products);
        // 4、进行跳转
        req.getRequestDispatcher("/WEB-INF/view/list.jsp").forward(req, resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、设置请求参数编码
        req.setCharacterEncoding("utf-8");
        // 2、接收请求参数
        String strId = req.getParameter("id");
        // 3、判断请求到的参数是否为空
        if (StringUtils.hasLength(strId)) {
            Long id = Long.valueOf(strId);
            // 4、调用方法删除数据
            iProductDAO.delete(id);
            // 5、重定向到数据显示页面
            resp.sendRedirect("/product");
        }
    }

    protected void input(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/input.jsp").forward(req, resp);
    }

    protected void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 1、创建一个空对象
        Product product = new Product();
        // 2、封装参数
        reqTwoProduct(req, product);
        // 3、保存信息
        iProductDAO.insert(product);
        // 4、重定向到查询页面
        resp.sendRedirect("/product");
    }

    private void reqTwoProduct(HttpServletRequest req, Product product) throws UnsupportedEncodingException {
        req.setCharacterEncoding("utf-8");
        String productName = req.getParameter("productName");
        String dirId = req.getParameter("dirId");
        String salePrice = req.getParameter("salePrice");
        String supplier = req.getParameter("supplier");
        String brand = req.getParameter("brand");
        String cutoff = req.getParameter("cutoff");
        String costPrice = req.getParameter("costPrice");
        String id = req.getParameter("id");
        if (StringUtils.hasLength(id)) {
            product.setId(Long.valueOf(id));
        }
        if (StringUtils.hasLength(dirId)) {
            product.setDirId(Long.valueOf(dirId));
        }
        if (StringUtils.hasLength(salePrice)) {
            product.setSalePrice(Double.valueOf(salePrice));
        }
        if (StringUtils.hasLength(cutoff)) {
            product.setCutoff(Double.valueOf(cutoff));
        }
        if (StringUtils.hasLength(costPrice)) {
            product.setCostPrice(Double.valueOf(costPrice));
        }
        product.setProductName(productName);
        product.setSupplier(supplier);
        product.setBrand(brand);
    }

    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (StringUtils.hasLength(id)) {
            Long newId = Long.valueOf(id);
            Product product = iProductDAO.selectOne(newId);
            req.setAttribute("productDate", product);
        }
        req.getRequestDispatcher("/WEB-INF/view/edit.jsp").forward(req, resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = new Product();
        reqTwoProduct(req, product);
        iProductDAO.update(product);
        resp.sendRedirect("/product");
    }
}
