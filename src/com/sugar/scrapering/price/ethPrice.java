package com.sugar.scrapering.price;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sugar.scrapering.SugarMain;

public class ethPrice implements IPriceObject{
	String url = "https://altcoinjpy.com/";
	public double price = 0.0;
	
	@Override
	public void showPrice() throws IOException {
		Document document = Jsoup.connect(url).get();
		Elements elements = (Elements)  document.select("tbody tr");
		for(Element e : elements){
			if(e.select("th a").text().equals("ETH")){
				Elements innerElements = e.getAllElements();
				String priceStr = innerElements.get(3).text().replaceAll("‰~(.+)$","");
				double newPrice = Double.parseDouble(priceStr);
					if(newPrice >=  price){
						System.out.println("E:" + priceStr + " (+" + SugarMain.kirisute(newPrice - price) + ")" );								
					}else{
						System.out.println("E:" + priceStr + " (" + SugarMain.kirisute(newPrice - price) + ")" );								
					}
					price = newPrice;
					break;
			}
		}
	}
}
