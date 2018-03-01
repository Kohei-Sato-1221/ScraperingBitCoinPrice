package com.sugar.sample;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SugarMain {
	public static void main(String args[]) throws InterruptedException{
		String url = "http://xn--eck3a9bu7cul981xhp9b.com/";
		int price = 0;
		while(true){
			try {
				Document document = Jsoup.connect(url).get();
				Elements elements = (Elements)  document.select("table tr");
				for(Element e : elements){
					if(e.select("td a").text().equals("bitFlyer")){
						Elements innerElements = e.getAllElements();
						String priceStr = innerElements.get(4).text().replace("‰~", "");
						int newPrice = Integer.parseInt(priceStr.replaceAll(",", ""));
						if(price != newPrice){
							if(newPrice >=  price){
								System.out.println("B:" + priceStr + " (+" + (newPrice - price) + ")" );								
							}else{
								System.out.println("B:" + priceStr + " (" + (newPrice - price) + ")" );								
							}
						}
						price = newPrice;
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Thread.sleep(10000);
		}
	}

}
