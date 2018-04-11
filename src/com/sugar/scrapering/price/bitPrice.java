package com.sugar.scrapering.price;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sugar.scrapering.SugarMain;

public class bitPrice implements IPriceObject{
	String url = "http://xn--eck3a9bu7cul981xhp9b.com/";
	public double price = 0.0;
	
	@Override
	public void showPrice() throws IOException {
		Document document = Jsoup.connect(url).get();
		Elements elements = (Elements)  document.select("table tr");
		for(Element e : elements){
			if(e.select("td a").text().equals("bitFlyer")){
				Elements innerElements = e.getAllElements();
				String priceStr = innerElements.get(4).text().replace("‰~", "");
				double newPrice = Double.parseDouble(priceStr.replaceAll(",", ""));
					if(newPrice >=  price){
						System.out.println("B:" + priceStr + " (+" + SugarMain.kirisute(newPrice - price) + ")" );								
					}else{
						System.out.println("B:" + priceStr + " (" + SugarMain.kirisute(newPrice - price) + ")" );								
					}
				price = newPrice;
				break;
			}
		}
		
	}
}
