package cn.simplelife.web.servlet;

import cn.simplelife.dao.IProductDAO;
import cn.simplelife.dao.impl.IProductDAOImpl;
import cn.simplelife.domain.Product;
import cn.simplelife.query.ProductQueryByConditionParams;
import cn.simplelife.query.QueryObject;
import cn.simplelife.results.PageResult;
import cn.simplelife.service.IProductService;
import cn.simplelife.service.impl.IProductServiceImpl;
import cn.simplelife.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.management.MonitorInfo;
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

    private IProductService iProductService = new IProductServiceImpl();

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

        ProductQueryByConditionParams queryObject = new ProductQueryByConditionParams();
        reqToQueryParams(req, queryObject);
        PageResult result = iProductService.query(queryObject);
        req.setAttribute("result", result);
        req.setAttribute("queryObject",queryObject);
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
            iProductService.delete(id);
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
        iProductService.insert(product);
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

    private void reqToQueryParams(HttpServletRequest req, ProductQueryByConditionParams queryObject) {
        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");
        String productName = req.getParameter("productName");
        String minSalePrice = req.getParameter("minSalePrice");
        String maxSalePrice = req.getParameter("maxSalePrice");
        String keyWord = req.getParameter("keyWord");
        queryObject.setKeyWord(keyWord);
        queryObject.setProductName(productName);
        if (StringUtils.hasLength(currentPage)) {
            queryObject.setCurrentPage(Integer.valueOf(currentPage));
        }
        if (StringUtils.hasLength(pageSize)) {
            queryObject.setPageSize(Integer.valueOf(pageSize));
        }
        if (StringUtils.hasLength(minSalePrice)) {
            queryObject.setMinSalePrice(Double.valueOf(minSalePrice));
        }
        if (StringUtils.hasLength(maxSalePrice)) {
            queryObject.setMaxSalePrice(Double.valueOf(maxSalePrice));
        }
    }

    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (StringUtils.hasLength(id)) {
            Long newId = Long.valueOf(id);
            Product product = iProductService.selectOnes(newId);
            req.setAttribute("productDate", product);
        }
        req.getRequestDispatcher("/WEB-INF/view/edit.jsp").forward(req, resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = new Product();
        reqTwoProduct(req, product);
        iProductService.update(product);
        resp.sendRedirect("/product");
    }
}
