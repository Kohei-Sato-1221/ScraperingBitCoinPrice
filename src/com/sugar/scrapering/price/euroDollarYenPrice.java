package com.sugar.scrapering.price;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sugar.scrapering.SugarMain;

public class euroDollarYenPrice implements IPriceObject{
	String url = "https://info.finance.yahoo.co.jp/fx/list/";
	public double price = 0.0;
	
	@Override
	public void showPrice() throws IOException {
		Document document = Jsoup.connect(url).get();
		Elements elements = (Elements)  document.select("span#EURUSD_chart_bid");
		for(Element e : elements){
				Elements innerElements = e.getAllElements();
				String priceStr = innerElements.get(0).text();
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
