package Controller;

import entity.Product;
import entity.Statusa;
import entity.SubCategory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.StatusRepository;
import repository.SubCategoryRepository;
import service.ProductImp.ProductServiceImp;
import service.ProductImp.StatusServiceImp;
import service.ProductImp.SubCategoryServiceImp;

import java.io.IOException;
import java.util.List;

@WebServlet({
        "/SAddProduct",
        "/AddProduct",
        "/GetAll",
        "/Detail",
        "/DetailProduct",
        "/LoadForm",
        "/SUpdateProduct",
        "/UpdateProduct",
        "/DeleteProduct"

})
public class Servlet extends HttpServlet {
ProductServiceImp servicePrd=new ProductServiceImp();
    SubCategoryServiceImp serviceSubCate=new SubCategoryServiceImp();
    StatusServiceImp serviceStatus=new StatusServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("SAddProduct")) {
            this.SAddProduct(request, response);
        }else if (uri.contains("GetAll")) {
            this.GetAll(request, response);
        }else if (uri.contains("/DetailProduct")) {
            this.DetailProduct(request, response);
        }
        else if (uri.contains("/LoadForm")) {
            this.LoadForm(request, response);
        }
        else if (uri.contains("/SUpdateProduct")) {
            this.SUpdateProduct(request, response);
        }
        else if (uri.contains("/DeleteProduct")) {
            this.DeleteProduct(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("AddProduct")) {
            this.AddProduct(request, response);
        }else if (uri.contains("UpdateProduct")) {
            this.UpdateProduct(request, response);
        }
    }

    private void SAddProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StatusRepository repo3=new StatusRepository();
        List<Product> listP = servicePrd.getAll();
        request.setAttribute("listP",listP);
        List<SubCategory> listSub = serviceSubCate.getAll();
        request.setAttribute("listSub",listSub);
        List<Statusa> listS = repo3.getAll();
        request.setAttribute("listS",listS);
        request.getRequestDispatcher("/WEB-INF/view/AddProduct.jsp").forward(request, response);
    }
    private void GetAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> listP = servicePrd.getAll();
        request.setAttribute("listP",listP);
        List<Statusa> listS = serviceStatus.getAll();
        request.setAttribute("listS",listS);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        System.out.println("Haha");
    }
    private void DetailProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer ID=Integer.parseInt(request.getParameter("IDDetail"));
        Product prd=servicePrd.getOne(ID);
        request.setAttribute("prd",prd);
        List<SubCategory> listSub = serviceSubCate.getAll();
        request.setAttribute("listSub",listSub);
        List<Statusa> listS = serviceStatus.getAll();
        request.setAttribute("listS",listS);
        request.getRequestDispatcher("/WEB-INF/view/DetailProduct.jsp").forward(request, response);
    }
    private void AddProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String color = request.getParameter("color");
        int quality = Integer.parseInt(request.getParameter("quality"));
        int sellPrice = Integer.parseInt(request.getParameter("sellPrice"));
        int origPrice = Integer.parseInt(request.getParameter("origiPrice"));
        int subcategoryId = Integer.parseInt(request.getParameter("subcategory"));
        SubCategory subcategory = new SubCategory(subcategoryId);
        int statusId = Integer.parseInt(request.getParameter("status"));
        Statusa status = new Statusa(statusId);
        request.setAttribute("name",name);
        request.setAttribute("name",name);
        request.setAttribute("quality",quality);
        request.setAttribute("sellPrice",sellPrice);
        request.setAttribute("origPrice",origPrice);
        request.setAttribute("status",status);
        request.setAttribute("subcategory",subcategory);
        String baoLoi="";
       boolean flag=true;
           if(name.trim().isEmpty()){
               baoLoi=baoLoi+"Bạn chưa nhập name";
               request.setAttribute("baoLoi",baoLoi);
               request.getRequestDispatcher("/WEB-INF/view/AddProduct.jsp").forward(request, response);
               flag=false;
           }
           if (color.trim().isEmpty()){
               baoLoi=baoLoi+"Bạn chưa nhập color";
               request.getRequestDispatcher("/WEB-INF/view/AddProduct.jsp").forward(request, response);
               flag=false;
           }
           try {
               int qualitys = Integer.parseInt(request.getParameter("quality"));
               if(qualitys<0){
                   baoLoi=baoLoi+"Quality phải là số dương";
                   request.setAttribute("baoLoi",baoLoi);
                   request.getRequestDispatcher("/WEB-INF/view/AddProduct.jsp").forward(request, response);
                   flag=false;
               }
           }catch (Exception e){
               baoLoi=baoLoi+"Quality phải là số";
               request.setAttribute("baoLoi",baoLoi);
               request.getRequestDispatcher("/WEB-INF/view/AddProduct.jsp").forward(request, response);
               flag=false;
           }
           if(flag){
               Product product = new Product(subcategory, name, color, quality, sellPrice, origPrice,status);
               servicePrd.insert(product);
               response.sendRedirect("/index.jsp");
           }
       }


    private void LoadForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/index.jsp");
    }
    private void DeleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ID=Integer.parseInt(request.getParameter("IDDelete"));
        Product prd=servicePrd.getOne(ID);
        servicePrd.delete(prd);
        GetAll(request,response);
    }
    private void SUpdateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer ID=Integer.parseInt(request.getParameter("IDEdit"));
        Product prd=servicePrd.getOne(ID);
        request.setAttribute("prd",prd);
        List<SubCategory> listSub = serviceSubCate.getAll();
        request.setAttribute("listSub",listSub);
        List<Statusa> listS = serviceStatus.getAll();
        request.setAttribute("listS",listS);
        request.getRequestDispatcher("/WEB-INF/view/UpdateProduct.jsp").forward(request, response);

    }
    private void UpdateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer ID=Integer.parseInt(request.getParameter("IDEdit"));
        Product prds=servicePrd.getOne(ID);
        request.setAttribute("prds",prds);
        String name = request.getParameter("name");
        String color = request.getParameter("color");
        int quality = Integer.parseInt(request.getParameter("quality"));
        int sellPrice = Integer.parseInt(request.getParameter("sellPrice"));
        int origPrice = Integer.parseInt(request.getParameter("origiPrice"));
        int subcategoryId = Integer.parseInt(request.getParameter("subcategory"));
        SubCategory subcategory = new SubCategory(subcategoryId);
        int statusId = Integer.parseInt(request.getParameter("status"));
        Statusa status = new Statusa(statusId);
        Product product = new Product(ID,subcategory, name, color, quality, sellPrice, origPrice,status);
        servicePrd.update(product);
        response.sendRedirect("/index.jsp");
        System.out.println("hAHA UPDATE");
    }
}
