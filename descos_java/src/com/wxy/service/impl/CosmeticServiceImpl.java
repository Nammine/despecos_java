package com.wxy.service.impl;
/**
 * 
 * @author wxywxy
 *
 */
import java.util.List;
import com.wxy.bean.Cosmetic;
import com.wxy.dao.CosmeticDao;
import com.wxy.service.ICosmeticService;

public class CosmeticServiceImpl implements ICosmeticService {

	@Override
	public List<Cosmetic> listAllCosmetics(){
		// TODO Auto-generated method stub
		CosmeticDao cosmeticdao = new CosmeticDao();
		List<Cosmetic> list = cosmeticdao.findAllCosmetics();
		return list;
	}

	@Override
	public Cosmetic findCosmeticDetail(int cosmeticId){
		// TODO Auto-generated method stub
		CosmeticDao cosmeticdao = new CosmeticDao();
		Cosmetic cosmetic = cosmeticdao.findCosmeticById(cosmeticId);
		return cosmetic;
	}

}
