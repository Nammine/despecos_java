package com.wxy.service;
/**
 * 
 * @author wxywxy
 * ��ױƷbean
 */
import java.util.List;
import com.wxy.bean.Cosmetic;

public interface ICosmeticService {
    List<Cosmetic> listAllCosmetics();
	Cosmetic findCosmeticDetail(int cosmeticId);
}
