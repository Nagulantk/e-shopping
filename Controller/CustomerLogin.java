package Controller;
import Model.*;
import View.*;
import java.util.ArrayList;
public class CustomerLogin {

    public void customerLoggingIn()
    {
        LoginViewInterface loginView=new LoginView();
        Server server=Server.getServer();
        CustomerViewInterface customerView=new CustomerView();
        Filter filter=new Filter();
        BackGroundProcess backGroundProcess=new BackGroundProcess();
        ProductViewInterface productsView=new ProductsView();
        CartViewInterface cartView=new CartView();
        PlaceOrder placeOrder=new PlaceOrder();
        OrderViewInterface orderView=new OrderView();
        Customer customer= (Customer) backGroundProcess.loginDetailsValidate(loginView.userNameInputting(),loginView.passWordInputting(),Enums.UserTypeLogin.CUSTOMER);
        loginView.loginStatus(customer);
        boolean customerCondition=true;
        if(customer!=null)
        {
            productsView.customerProductView(server.getProductList());
         while (customerCondition) {
            Enums.CustomerMenu customerInput=customerView.customerInputting();
            switch (customerInput) {
                case VIEWPROFILE:
                    customerView.customerDetailsDisplay(customer);
                    break;
                case EDITPROFILE:
                    backGroundProcess.profileEditing(customer);
                    break;

                case SELECTPRODUCT:
                    productsView.customerProductView(server.getProductList());
                    selectingProduct(customer);
                    break;
                case APPLYFILTERS:
                    productsView.customerProductView(filter.applyFilters());
                    break;

                case OPENCART:
                    ArrayList<Product> cartProductList = customer.getCart().getProductList();
                    productsView.customerProductView(cartProductList);
                    Enums.CartMenu cartMenuInput = cartView.cartMenuInputting();
                    switch (cartMenuInput) {
                        case PLACEORDER:
                             placeOrder.placingOrder(cartProductList, customer);
                             customer.getCart().setProductList(new ArrayList<>());
                            break;
                        case REMOVEPRODUCTFROMCART:
                            removingProduct(cartProductList, customer);
                            break;
                    }
                    break;
                case DISPLAYPREVIOUSORDERS:
                    if(customer.getOrders().size()!=0) {
                        for (Order order : customer.getOrders()) {
                            orderView.displayOrderDetails(order);
                        }
                    }
                    else {
                        orderView.displayOrderResult();
                    }
                    break;
                case LOGOUT:
                    customerCondition = false;
                    break;
            }
            }
        }
    }
    public void selectingProduct(Customer customer)
    {
        Server server=Server.getServer();
        ProductViewInterface productsView=new ProductsView();
        SelectProductViewInterface selectProduct=new SelectProductView();
        Product selectedProduct=null;
        int productID=selectProduct.selectingProduct();
        boolean selectProductCondition=false;
        for(Product products:server.getProductList())
        {
            if(products.getProductID()==productID)
            {
                productsView.viewProduct(products);
                selectProductCondition=true;
                selectedProduct=products;
                break;
            }
        }
        selectProduct.displaySelectProductResult(selectProductCondition);
        if(selectProductCondition)
        {
            Enums.SelectProductMenu selectProductInput = selectProduct.selectProductMenuInputting();
            if (selectProductInput == Enums.SelectProductMenu.ADDPRODUCTTOCART) {
                customer.getCart().setProductList(selectedProduct);
                selectProduct.displayAddingProductToCartResult();
            }
        }
    }
    public void removingProduct(ArrayList<Product> cartProductList,Customer customer)
    {
        CartViewInterface cartView=new CartView();
        Server server=Server.getServer();
        int productID=cartView.selectingProduct();
        boolean cartCondition=false;
        for(Product product:server.getProductList())
        {
            if(product.getProductID()==productID)
            {
                cartProductList.remove(product);
                customer.getCart().setProductList(cartProductList);
                 cartCondition=true;
            }
        }
        cartView.displayAddingProductToCartResult(cartCondition);
    }
}