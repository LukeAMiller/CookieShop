import java.util.Arrays;
import java.util.ArrayList;
class Store {
    // instance fields
    String productType;
    String Streetaddress;
    double inventoryPrice;
    double customerPayment;
    double tax;
    double TotalBalance;
    ArrayList<String> Ingredients = new ArrayList<String>();
    ArrayList<Integer> IngredientCount = new ArrayList<Integer>();
    int[] TotalCookies = {0, 0, 0};
    String[] CookieTypes = {"chocolate chip", "peanut butter", "peanut butter chocolate"};
    boolean Open;

public void BuyIngredients(int newIngredients, double Cost){
    double Balance = TotalBalance - Cost;
    TotalBalance = Balance;
    if(Ingredients.size() == 0){
    Ingredients.add(0, "flour");
    IngredientCount.add(0, newIngredients);
    Ingredients.add(1, "sugar");
    IngredientCount.add(1, newIngredients);
Ingredients.add(2, "butter");
IngredientCount.add(2, newIngredients);
Ingredients.add(3, "chocolate chip");
IngredientCount.add(3, newIngredients);
Ingredients.add(4, "peanut butter");
IngredientCount.add(4, newIngredients);
    }
    else{
        IngredientCount.set(0, IngredientCount.get(0) + newIngredients);
        IngredientCount.set(1, IngredientCount.get(1) + newIngredients);
        IngredientCount.set(2, IngredientCount.get(2) + newIngredients);
        IngredientCount.set(3, IngredientCount.get(3) + newIngredients);
        IngredientCount.set(4, IngredientCount.get(4) + newIngredients);

    }
    }
public void Bake(int cookiesToBake, int CookieTypeIndex){
    if(IngredientCount.size() == 0){
    System.out.println("No Ingredients");
    }
else if(IngredientCount.get(0) > cookiesToBake){
   IngredientCount.set(0, IngredientCount.get(0) - cookiesToBake);
   IngredientCount.set(1, IngredientCount.get(1) - cookiesToBake);
   IngredientCount.set(2, IngredientCount.get(2) - cookiesToBake);
   if(CookieTypeIndex == 0){
    IngredientCount.set(3, IngredientCount.get(3) - cookiesToBake);
   }
   else if(CookieTypeIndex == 1){
    IngredientCount.set(4, IngredientCount.get(4) - cookiesToBake);
   }else if(CookieTypeIndex == 2){
    IngredientCount.set(3, IngredientCount.get(3) - cookiesToBake);
    IngredientCount.set(4, IngredientCount.get(4) - cookiesToBake);
   }
    TotalCookies[CookieTypeIndex] = TotalCookies[CookieTypeIndex] + cookiesToBake;
   }
    else{
        System.out.println("Not Enough Ingredients To Bake");
    }
}
public void ListCookiesInStock(){
    for(var i=0; i<TotalCookies.length;i++){
        if(TotalCookies[i] !=0){
            System.out.println("We currently have " + CookieTypes[i] + " in stock.");
        }
    }
}
public void getNumberofCookieType(int CookieTypeIndex){
System.out.println("There are " + TotalCookies[CookieTypeIndex] + " " + CookieTypes[CookieTypeIndex] + " cookies.");
}
public void Sell(int CustomerBought, double customerPayment, boolean Open, int CookieTypeIndex){
if(!Open){
    System.out.println("I'm sorry, we are closed.");
}
    else if(CustomerBought > TotalCookies[CookieTypeIndex]){
        System.out.println("I'm sorry, we don't have that many cookies currently in stock.");
    }
  else if(customerPayment  >= (inventoryPrice + tax)* CustomerBought ){

        TotalCookies[CookieTypeIndex] = TotalCookies[CookieTypeIndex] - CustomerBought;
        double newMoney = TotalBalance + (inventoryPrice *CustomerBought);
        TotalBalance = newMoney;
        System.out.println("Your change is $" + roundAvoid((customerPayment -((inventoryPrice + tax) *CustomerBought) ), 2));
    }else{System.out.println("I'm sorry, this is not enough money for what you asked for.");}

}
public double calculateTax(double PricetoCalculate){
    double taxtoCalculate = PricetoCalculate * 0.08;
    tax = taxtoCalculate;
    return tax;

}

public static double roundAvoid(double value, int places) {
    double scale = Math.pow(10, places);
    return Math.round(value * scale) / scale;
}
public void Advertise(String CookieType){
    if(CookieType == "chocolate chip"){
    System.out.println("Eat more " + CookieTypes[0].toUpperCase().charAt(CookieTypes[0].indexOf("chocolate")) + CookieTypes[0].toUpperCase().charAt(CookieTypes[0].indexOf("chip")) + " Cookies!");}
else if(CookieType == "peanut butter"){
    System.out.println("Eat more " + CookieTypes[1].toUpperCase().charAt(CookieTypes[1].indexOf("pean")) + CookieTypes[1].toUpperCase().charAt(CookieTypes[1].indexOf("butt")) + " Cookies!");}
    else if(CookieType == "peanut butter chocolate"){
        System.out.println("Eat more " + CookieTypes[2].toUpperCase().charAt(CookieTypes[2].indexOf("pean")) + CookieTypes[2].toUpperCase().charAt(CookieTypes[2].indexOf("butt")) +
        CookieTypes[2].toUpperCase().charAt(CookieTypes[2].indexOf("choc")) + " Cookies!");}
}
    // constructor method
    public Store(String product,  double price, String address) {

      inventoryPrice = price;
      productType = product;
Streetaddress = address;
    }
    // main method
    public static void main(String[] args) {
      Store cookieShop = new Store("cookies", 3.75, "542 Sesame Street");
      boolean LessThan5Dollars = cookieShop.inventoryPrice < 5;
      System.out.println("Is the cookie less than 5 dollars?: " + LessThan5Dollars);
 cookieShop.calculateTax(cookieShop.inventoryPrice);
 System.out.println("In my store I sell " + cookieShop.productType + " that costs $" +
 cookieShop.inventoryPrice +
 " We are located at " + cookieShop.Streetaddress);
cookieShop.ListCookiesInStock();
cookieShop.BuyIngredients(100, 10);
cookieShop.Bake(20, 0);
cookieShop.BuyIngredients(100, 10);
System.out.println("These are the number of each Ingredient: " + cookieShop.IngredientCount);
System.out.println("These are my cookie ingredients" + cookieShop.Ingredients);
cookieShop.Sell(5, 25, true, 0);
for(int item : cookieShop.TotalCookies){
System.out.println(item);
}
cookieShop.getNumberofCookieType(0);
cookieShop.Advertise("chocolate chip");
      System.out.println("My Balance is $" + cookieShop.TotalBalance);

    }
  }