package Session11.Bai6;

import java.util.List;

public class ProductProcesserImpl implements InterfaceProductProcesser {
    public double calculatTotalValue(List<Product> products) {
        double TotalValue  = 0;
        for (Product product : products) {
            TotalValue += product.getPrice();
        }
        return  TotalValue;
    }

}

