package Controller;
import Model.*;
import View.*;
import java.util.ArrayList;
public class AdminLogin
{
    public void adminLoggingIn()
    {
        BackGroundProcess backGroundProcess=new BackGroundProcess();
        LoginViewInterface loginView=new LoginView();
        boolean logoutCondition = true;
        AdminViewInterface adminView=new AdminView();
        Admin admin = (Admin) backGroundProcess.loginDetailsValidate(loginView.userNameInputting(), loginView.passWordInputting(),Enums.UserTypeLogin.ADMIN);
        while (logoutCondition) {
            if (admin != null) {
                adminView.displayAdminLoginResult(true);
                Enums.AdminMenu adminInput = adminView.adminMenuInputting();
                if (adminInput == Enums.AdminMenu.VIEWPRODUCTSTOVERIFY)
                {
                   verifyProduct();
                }
                else {
                    logoutCondition = false;
                }

            }
            else
            {
                adminView.displayAdminLoginResult(false);
            }
        }
    }
    public void verifyProduct()
    {
        Admin admin=Admin.getAdmin();
        Server server=Server.getServer();
        ProductViewInterface productsView=new ProductsView();
        AdminViewInterface adminView=new AdminView();
        if(admin.getProductsToBeVerified().size()!=0) {
            for (Product product : admin.getProductsToBeVerified()) {
                productsView.viewProduct(product);
                adminView.displayVerifyProductMenu();
                if (adminView.conditionMenuInputting() == Enums.Condition.YES) {
                    product.setProductStatus(Enums.ProductStatus.ONFORSALE);
                    server.setProductList(product);
                    adminView.verifyProductResult(true);

                } else {
                    product.setProductStatus(Enums.ProductStatus.REJECTEDBYADMIN);
                    adminView.verifyProductResult(false);
                }
                admin.setProductsToBeVerified(new ArrayList<>());
            }
        }
        else {
            productsView.viewProduct(null);
        }

    }
}
