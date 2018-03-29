package com.sugar.scrapering;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SugarMain {
	public static void main(String args[]) throws InterruptedException{
		String url1 = "http://xn--eck3a9bu7cul981xhp9b.com/";
		String url2 = "https://altcoinjpy.com/";
		String url3 = "https://info.finance.yahoo.co.jp/fx/";
		double priceBit = 0;
		double priceEth = 0;
		double priceRip = 0;
		double priceNem = 0;
		double priceD = 0;
		while(true){
			try {
				Document document = Jsoup.connect(url1).get();
				Elements elements = (Elements)  document.select("table tr");
				Document document2 = Jsoup.connect(url2).get();
				Elements elements2 = (Elements)  document2.select("tbody tr");
				Document document3 = Jsoup.connect(url3).get();
				Elements elements3 = (Elements)  document3.select("span#USDJPY_top_bid");
				for(Element e : elements){
					if(e.select("td a").text().equals("bitFlyer")){
						Elements innerElements = e.getAllElements();
						String priceStr = innerElements.get(4).text().replace("‰~", "");
						double newPrice = Double.parseDouble(priceStr.replaceAll(",", ""));
							if(newPrice >=  priceBit){
								System.out.print("B:" + priceStr + " (+" + (newPrice - priceBit) + ")" );								
							}else{
								System.out.print("B:" + priceStr + " (" + (newPrice - priceBit) + ")" );								
							}
//						}
						priceBit = newPrice;
					}
				}
				for(Element e : elements2){
					if(e.select("th a").text().equals("ETH")){
						Elements innerElements = e.getAllElements();
						String priceStr = innerElements.get(3).text().replaceAll("‰~(.+)$","");
						double newPrice = Double.parseDouble(priceStr);
							if(newPrice >=  priceEth){
								System.out.print(" E:" + priceStr + " (+" + (newPrice - priceEth) + ")" );								
							}else{
								System.out.print(" E:" + priceStr + " (" + (newPrice - priceEth) + ")" );								
							}
						priceEth = newPrice;
					}
				}
				for(Element e : elements2){
					if(e.select("th a").text().equals("XRP")){
						Elements innerElements = e.getAllElements();
						String priceStr = innerElements.get(3).text().replaceAll("‰~(.+)$","");
						double newPrice = Double.parseDouble(priceStr);
							if(newPrice >=  priceRip){
								System.out.print(" R:" + priceStr + " (+" + (newPrice - priceRip) + ")" );								
							}else{
								System.out.print(" R:" + priceStr + " (" + (newPrice - priceRip) + ")" );								
							}
						priceRip = newPrice;
					}
				}
				for(Element e : elements2){
					if(e.select("th a").text().equals("XEM")){
						Elements innerElements = e.getAllElements();
						String priceStr = innerElements.get(3).text().replaceAll("‰~(.+)$","");
						double newPrice = Double.parseDouble(priceStr);
							if(newPrice >=  priceNem){
								System.out.print(" N:" + priceStr + " (+" + (newPrice - priceNem) + ")" );								
							}else{
								System.out.print(" N:" + priceStr + " (" + (newPrice - priceNem) + ")" );								
							}
						priceNem = newPrice;
					}
				}
				for(Element e : elements3){
						Elements innerElements = e.getAllElements();
						String priceStr = innerElements.get(0).text();
						double newPrice = Double.parseDouble(priceStr);
							if(newPrice >=  priceD){
								System.out.println(" D:" + priceStr + " (+" + (newPrice - priceD) + ")" );								
							}else{
								System.out.println(" D:" + priceStr + " (" + (newPrice - priceD) + ")" );								
							}
						priceD = newPrice;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			Thread.sleep(6000);
		}
	}

}
