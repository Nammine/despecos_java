package com.briup.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.briup.service.IBookService;
import com.briup.service.impl.BookServiceImpl;
/**
 * 购物车
 * */
public class Cart {
	private Map<Integer, Integer> cart = new TreeMap<>();
	//添加订单项
	public void add(int bookId){
		Integer num = cart.get(bookId);
		System.out.println(num+"--");
		if(num == null){
			cart.put(bookId, 1);
		}else{
			num += 1;
			System.out.println(num);
			cart.put(bookId, num);
		}
	}
	//删除订单项
	public void delete(int bookId){
		cart.remove(bookId);
	}
	//查找
	public Integer find(int bookId){
		return cart.get(bookId);
	}
	//修改订单项
	public void edit(int bookId, int num){
		cart.put(bookId, num);
	}
	//列出所有订单信息
	public List<Orderline> getOrderLines(){
		IBookService bookService = new BookServiceImpl();
		Set<Integer> keys = cart.keySet();
		Iterator<Integer> iter = keys.iterator();
		List<Orderline> orderlines = new ArrayList<>();
		while(iter.hasNext()){
			Orderline orderline = new Orderline();
			Integer key = iter.next();
			Integer value = cart.get(key);
			Book book = bookService.findBookDetail(key);
			orderline.setNum(value);
			orderline.setBookName(book.getName());
			orderline.setBookPrice(book.getPrice());
			orderline.setTotal(book.getPrice()*value);
			orderlines.add(orderline);
		}
		return orderlines;
		
	}
	//获取到价钱
	public Float getCost(){
		IBookService bookService = new BookServiceImpl();
		Set<Integer> keys = cart.keySet();
		Iterator<Integer> iter = keys.iterator();
		float total = 0;
		while(iter.hasNext()){
			Integer key = iter.next();
			Book book = bookService.findBookDetail(key);
			Integer value = cart.get(key);
			float sum = book.getPrice()*value;
			total+=sum;
		}
		return total;
	}
	
}
