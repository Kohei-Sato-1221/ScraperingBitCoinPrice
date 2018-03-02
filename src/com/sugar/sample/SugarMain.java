package com.sugar.sample;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SugarMain {
	public static void main(String args[]) throws InterruptedException{
		String url1 = "http://xn--eck3a9bu7cul981xhp9b.com/";
		String url2 = "https://altcoinjpy.com/";
		double price = 0;
		double price2 = 0;
		double price3 = 0;
		while(true){
			try {
				Document document = Jsoup.connect(url1).get();
				Elements elements = (Elements)  document.select("table tr");
				Document document2 = Jsoup.connect(url2).get();
				Elements elements2 = (Elements)  document2.select("tbody tr");
				for(Element e : elements){
					if(e.select("td a").text().equals("bitFlyer")){
						Elements innerElements = e.getAllElements();
						String priceStr = innerElements.get(4).text().replace("‰~", "");
						double newPrice = Double.parseDouble(priceStr.replaceAll(",", ""));
//						if(price != newPrice){
							if(newPrice >=  price){
								System.out.print("B:" + priceStr + " (+" + (newPrice - price) + ")" );								
							}else{
								System.out.print("B:" + priceStr + " (" + (newPrice - price) + ")" );								
							}
//						}
						price = newPrice;
					}
				}
				for(Element e : elements2){
					if(e.select("th a").text().equals("ETH")){
						Elements innerElements = e.getAllElements();
						String priceStr = innerElements.get(3).text().replaceAll("‰~(.+)$","");
						double newPrice = Double.parseDouble(priceStr);
//						if(price2 != newPrice){
							if(newPrice >=  price2){
								System.out.print(" E:" + priceStr + " (+" + (newPrice - price2) + ")" );								
							}else{
								System.out.print(" E:" + priceStr + " (" + (newPrice - price2) + ")" );								
							}
//						}
						price2 = newPrice;
					}
				}
				for(Element e : elements2){
					if(e.select("th a").text().equals("XRP")){
						Elements innerElements = e.getAllElements();
						String priceStr = innerElements.get(3).text().replaceAll("‰~(.+)$","");
						double newPrice = Double.parseDouble(priceStr);
//						if(price2 != newPrice){
							if(newPrice >=  price3){
								System.out.println(" X:" + priceStr + " (+" + (newPrice - price3) + ")" );								
							}else{
								System.out.println(" X:" + priceStr + " (" + (newPrice - price3) + ")" );								
							}
//						}
						price3 = newPrice;
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Thread.sleep(60000);
		}
	}

}
