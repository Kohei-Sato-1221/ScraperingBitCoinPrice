package com.sugar.scrapering;

import java.io.IOException;
import java.math.BigDecimal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sugar.scrapering.price.IPriceObject;
import com.sugar.scrapering.price.bitPrice;
import com.sugar.scrapering.price.dollarYenPrice;
import com.sugar.scrapering.price.ethPrice;
import com.sugar.scrapering.price.euroDollarYenPrice;
import com.sugar.scrapering.price.xemPrice;
import com.sugar.scrapering.price.xrpPrice;

public class SugarMain {
	public static void main(String args[]) throws InterruptedException{
		IPriceObject bit = new bitPrice();
		IPriceObject eth = new ethPrice();
		IPriceObject xrp = new xrpPrice();
		IPriceObject xem = new xemPrice();
		IPriceObject dol = new dollarYenPrice();
		IPriceObject eur = new euroDollarYenPrice();
		while(true){
			try {
				bit.showPrice();
				eth.showPrice();
				xrp.showPrice();
				xem.showPrice();
				dol.showPrice();
				eur.showPrice();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("----------------" );	
			Thread.sleep(6000);
		}
	}
	
	
	public static double kirisute(double price){
		BigDecimal bd = new BigDecimal(price);
		double retVal = bd.setScale(3, BigDecimal.ROUND_DOWN).doubleValue();
		return retVal;
	
	}

}
