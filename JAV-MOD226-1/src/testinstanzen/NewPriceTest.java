package testinstanzen;

import mod226_08.Euro;
import testgetriebeneentwicklungbuch.Price;

public class NewPriceTest {

	public static void main(String[] args) {
		Price price = new Price();

		System.out.println("Print price and price.getCharge variants:");
		System.out.println(price);
		System.out.println(price.getCharge(1));
		System.out.println(price.getCharge(4));
		System.out.println(price.NEWRELEASE);
		System.out.println(price.REGULAR);
		System.out.println(price.NEWRELEASE);
		System.out.println();

		System.out.println("Print price.NEWRELEASE.getCharge(1).getAmount()");
		System.out.println(price.NEWRELEASE.getCharge(1).getAmount());
		System.out.println(price.NEWRELEASE.getCharge(1));
		System.out.println(price.NEWRELEASE.getCharge(1));
		System.out.println();

		System.out.println("Print price.REGULAR.getCharge(1).getAmount()");
		System.out.println(price.REGULAR.getCharge(1).getAmount());
		System.out.println(price.REGULAR.getCharge(1));
		System.out.println();

		System.out.println("Print price.getCharge(x).getAmount() variants");
		System.out.println(price.getCharge(1).getAmount());
		System.out.println(price.getCharge(4).getAmount());
		System.out.println();

		price = price.NEWRELEASE;
		System.out.println("Print price.getCharge(x).getAmount() as price.NEWRELEASE");
		System.out.println(price.getCharge(1).getAmount());
		System.out.println(price.getCharge(4).getAmount());
		System.out.println();

		price = price.REGULAR;
		System.out.println("Print price.getCharge(x).getAmount() as price.REGULAR");
		System.out.println(price.getCharge(1).getAmount());
		System.out.println(price.getCharge(4).getAmount());
		System.out.println();

		price = new Price(new Euro(2.00), new Euro(1.50), 3);
		System.out.println("price = new Price(new Euro(2.00), new Euro(1.50), 3)");
		System.out.println(price.getCharge(1).getAmount());
		System.out.println(price.getCharge(4).getAmount());
		System.out.println();	

		price = new Price();
		System.out.println("price = new Price()");
		System.out.println("price.NEWRELEASE.getBasePrice())");
		System.out.println(price.NEWRELEASE.getBasePrice());
		System.out.println("price.REGULAR.getBasePrice()");
		System.out.println(price.REGULAR.getBasePrice());

		Price priceNR, priceR;
		priceNR = new Price(new Euro(2.00), new Euro(1.50), 3);
		priceR = new Price(new Euro(1.50), new Euro(1.50), 3);
		System.out.println("created two new references:");
		System.out.println("		priceNR = new Price(new Euro(2.00), new Euro(1.50), 3);\r\n" + 
				"		priceR = new Price(new Euro(1.50), new Euro(1.50), 3);");
		System.out.println("syso priceNR.getBasePrice()");
		System.out.println(priceNR.getBasePrice());
		System.out.println("syso priceR.getBasePrice()");
		System.out.println(priceR.getBasePrice());
		System.out.println("syso priceNR.getBasePrice().getAmount()");
		System.out.println(priceNR.getBasePrice().getAmount());
		System.out.println("syso priceR.getBasePrice().getAmount()");
		System.out.println(priceR.getBasePrice().getAmount());
		
		System.out.println("getCharge of both pricenNR and priceR");
		System.out.println("priceNR.getCharge(1");
		System.out.println(priceNR.getCharge(1));
		System.out.println("priceR.getCharge(1");
		System.out.println(priceR.getCharge(1));
		System.out.println("priceNR.getCharge(1");
		System.out.println(priceNR.getCharge(1).getAmount());
		System.out.println("priceR.getCharge(1");
		System.out.println(priceR.getCharge(1).getAmount());
		
		priceNR = new Price(new Euro(2.00), new Euro(1.50), 3);
		System.out.println("this does not make sense to me:");
		System.out.println(priceNR.getCharge(1).getAmount());
		System.out.println(priceNR.getBasePrice());
		System.out.println("syso priceR.getBasePrice()");
		System.out.println("interesting: priceNR.getCharge(1).getAmount() is:");
		System.out.println(priceNR.getCharge(1).getAmount());
		priceR = new Price(new Euro(1.50), new Euro(1.50), 3);
		System.out.println("but after this: priceR = new Price(new Euro(1.50), new Euro(1.50), 3); it will be");
		System.out.println(priceNR.getCharge(1).getAmount());
		System.out.println("we are talking priceR gets changed and affects priceNR???? But why and how!");
		
		
	}

}
