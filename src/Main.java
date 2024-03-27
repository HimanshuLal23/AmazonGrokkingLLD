import Dao.ProductDao;
import Dao.UserDao;
import Model.*;
import services.CheckoutService;
import services.PaymentService;
import services.cart.CartAddService;
import services.cart.CartService;
import Exception.AmazonException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {

            // ======== Admin User
            Address adminAddress = new Address("123456", "HP", "Mandi");
            User adminUser = new User("abc", "1234", "abc@xyz.com", adminAddress, UserType.Admin);

            // ======== Guest User
            Address guestAddress = new Address("123456", "AP", "Kunur");
            User guestUser = new User("def", "1234", "def@xyz.com", guestAddress, UserType.Guest);

            // ======== Member User
            Address memberAddress = new Address("321654", "GJ", "Dwarka");
            User memberUser = new User("ghi", "1234", "ghi@xyz.com", memberAddress, UserType.Member);

            UserDao userDao = UserDao.getInstance();
            userDao.addUser(adminUser);
            userDao.addUser(guestUser);
            userDao.addUser(memberUser);

            // ====== Products
            Product tubeLight = new Product(12.0, "TubeLight", "Light your home", 15, Category.Electronics);
            Product elephantToy = new Product(5.0, "Elephant Miniature", "An elephant toy", 20, Category.Toy);

            ProductDao productDao = ProductDao.getInstance();
            productDao.addProduct(tubeLight);
            productDao.addProduct(elephantToy);


            // ==== Happy path with member user
            Cart cart = new Cart();
            CartService cartService = new CartAddService();
            CartItem cartItem1 = new CartItem(tubeLight.getId(), 2);
            cartService.addToCart(cart, cartItem1, memberUser);
            cartService.addToCart(cart, cartItem1,memberUser);
            cartService.addToCart(cart, cartItem1,memberUser);

            CheckoutService checkoutService = new CheckoutService();

            Order order = checkoutService.checkOutAndCreateOrder(cart,memberUser);

            PaymentService paymentService = new PaymentService();
            Payment payment = paymentService.doPayment(order,memberUser,PaymentType.Cash);
            if(payment.isSuccess()) {
                System.out.println("Thanks for shopping with us, you paid " + payment.getPrice());
            }

            // === shopping with guest user
            Cart cart2 = new Cart();
            CartService cartService2 = new CartAddService();
            CartItem cartItem2 = new CartItem(elephantToy.getId(), 2);
            cartService.addToCart(cart, cartItem2, guestUser);
            cartService.addToCart(cart, cartItem2, guestUser);
            cartService.addToCart(cart, cartItem2, guestUser);


        }catch (AmazonException exception) {
            System.out.println(exception.getMessage());
        }
    }
}