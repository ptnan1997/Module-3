package Session10.Bai5;

import java.util.ArrayList;

public class InvoiceManager implements Manage <Invoice>{
     public final ArrayList<Invoice> invoices;
     public InvoiceManager() {
          invoices = new ArrayList<>();
     }
     public void add (Invoice invoice) {
         invoices.add(invoice);
     }
     public void delete(int index) {
         if (index >= 0 && index < invoices.size()) {
             invoices.remove(index);
         }
     }
     public void update (int index,Invoice invoice) {
         if(index>=0 && index<invoices.size()){
             invoices.set(index, invoice);
         }
     }
     public void display(){
         if(invoices.isEmpty()){
             System.out.println("No invoices");
         }else {
             for (Invoice invoice:invoices){
                 System.out.println(invoice);
             }
         }

     }

}
