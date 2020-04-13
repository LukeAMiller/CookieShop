import java.util.Arrays;
class Store {
    // instance fields
    String productType;
    int inventoryCount;
    String Streetaddress;
    double inventoryPrice;
    double customerPayment;
    double tax;
    double TotalBalance;
    int[] TotalCookies = {0, 0, 0};
    String[] CookieTypes = {"chocolate chip", "peanut butter", "peanut butter chocolate"};
    boolean Open;
public void AddToInventory(int CountToAdd, double MoneytoSubtract, int CookieTypeIndex){
int newCount = inventoryCount + CountToAdd;
inventoryCount = newCount;
double Balance = TotalBalance - MoneytoSubtract;
TotalBalance = Balance;
TotalCookies[CookieTypeIndex] = TotalCookies[CookieTypeIndex] + CountToAdd;
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
public void Sell(int CustomerBought, double customerPayment, boolean Open){
if(!Open){
    System.out.println("I'm sorry, we are closed.");
}
    else if(CustomerBought > inventoryCount){
        System.out.println("I'm sorry, we don't have that many cookies currently in stock.");
    }
  else if(customerPayment  >= (inventoryPrice + tax)* CustomerBought ){
        int newCount  = inventoryCount - CustomerBought;
        inventoryCount = newCount;
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
public void StockInventory(){
    for(int i = 0; i<=2; i++){
        while(TotalCookies[i] <1000){
            AddToInventory(1, 0.5, i);
        }
    }
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
    public Store(String product, int count, double price, String address) {
      inventoryCount = count;
      inventoryPrice = price;
      productType = product;
Streetaddress = address;
    }
    // main method
    public static void main(String[] args) {
      Store cookieShop = new Store("cookies", 0, 3.75, "542 Sesame Street");
      boolean LessThan5Dollars = cookieShop.inventoryPrice < 5;
      System.out.println("Is the cookie less than 5 dollars?: " + LessThan5Dollars);
 cookieShop.calculateTax(cookieShop.inventoryPrice);
 cookieShop.StockInventory();
 System.out.println("In my store I sell " + cookieShop.productType + " that costs $" +
 cookieShop.inventoryPrice +
 " We are located at " + cookieShop.Streetaddress);
cookieShop.ListCookiesInStock();
cookieShop.getNumberofCookieType(2);
      cookieShop.Sell(700, 3000, true);
      cookieShop.StockInventory();
cookieShop.Advertise("chocolate chip");
      System.out.println("My Balance is $" + cookieShop.TotalBalance);

    }
  }