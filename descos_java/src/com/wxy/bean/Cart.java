package com.wxy.bean;
/**
 * 
 * @author wxywxy
 *
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Iterator;



import com.wxy.service.ICosmeticService;
import com.wxy.service.impl.CosmeticServiceImpl;

public class Cart {
	private Map<Integer, Integer> cart = new TreeMap<>();
	//��Ӷ�����
	public void add(int cosmeticId){
		Integer num = cart.get(cosmeticId);
		System.out.println(num+"--");
		if(num == null){
			cart.put(cosmeticId, 1);
		}else{
			num += 1;
			System.out.println(num);
			cart.put(cosmeticId, num);
		}
	}
	//ɾ����
	public void delete(int cosmeticId){
		cart.remove(cosmeticId);
	}
	//����
	public Integer find(int cosmeticId){
		return cart.get(cosmeticId);
	}
	//�޸Ķ�����
	public void edit(int cosmeticId, int num){
		cart.put(cosmeticId, num);
	}
	//�г����ж�����Ϣ
	public List<OrderLine> getOrderLines(){
		ICosmeticService cosmeticService = new CosmeticServiceImpl();
		Set<Integer> keys = cart.keySet();
		Iterator iter =keys.iterator();
		List<OrderLine> orderlines = new ArrayList<>();
		
		while(iter.hasNext()){
			OrderLine orderline = new OrderLine();
			Integer key =(Integer) iter.next();
			Integer value = cart.get(key);
			Cosmetic cosmetic = cosmeticService.findCosmeticDetail(key);
			orderline.setId(key);
			orderline.setNum(value);
			orderline.setCosmeticName(cosmetic.getName());
			orderline.setCosmeticPrice(cosmetic.getPrice());
			orderline.setTotal(cosmetic.getPrice()*value);
			orderlines.add(orderline);
		}
		return orderlines;
		
	}
	//��ȡ����Ǯ
	public Float getCost(){
		ICosmeticService CosmeticService = new CosmeticServiceImpl();
		Set<Integer> keys = cart.keySet();
		Iterator<Integer> iter = keys.iterator();
		float total = 0;
		while(iter.hasNext()){
			Integer key = iter.next();
			Cosmetic cosmetic = CosmeticService.findCosmeticDetail(key);
			Integer value = cart.get(key);
			float sum = cosmetic.getPrice()*value;
			total+=sum;
		}
		return total;
	}
}
