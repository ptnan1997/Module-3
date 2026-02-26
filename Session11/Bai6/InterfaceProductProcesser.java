package Session11.Bai6;

import java.util.List;

public interface InterfaceProductProcesser {
    double calculatTotalValue (List<Product> products);
    static void printProductList (List<Product> products){
        for (Product product : products){
            System.out.println(product);
        }
    }

    default boolean hasExpensiveProduct(List<Product> products) {
        boolean  result = false;
        for (Product product : products) {
            if (product.getPrice() >100) {
                result = true;
                break;
            }
        }
        return result;
    }
}
