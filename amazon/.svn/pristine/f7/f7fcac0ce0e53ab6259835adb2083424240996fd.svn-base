package com.oracleoaec.serviceImpl;

import java.util.List;

import com.oracleoaec.dao.CartDao;
import com.oracleoaec.daoImpl.CartDaoImpl;
import com.oracleoaec.entity.Cart;
import com.oracleoaec.entity.Product;
import com.oracleoaec.service.CartService;
import com.oracleoaec.service.ProductService;

public class CartServiceImpl implements CartService {
	CartDao icd = new CartDaoImpl();

	@Override
	public int addToCart(Cart cart) {
		Cart checkCart = icd.checkCart(cart);
		ProductService pts = new ProductServiceImpl();
		//如果添加到购物车成功，则添加购物车表，否则更新购物车
		if (checkCart == null){
			icd.addCart(cart);
		} else {
			Product product = pts.findProductById(cart.getPid());
			long cartCount = checkCart.getQuantity()+cart.getQuantity();
			if(product.getHpStock()<=cartCount){
				checkCart.setQuantity(product.getHpStock());
			}else{
				checkCart.setQuantity(cartCount);
			}
			icd.updateCart(checkCart);
		}
		
		int sum=0;
		List<Integer> count = icd.updateCartCount(cart.getUserId());
		for (Integer i : count) {
			sum+=i;
		}
		return sum;
	}

	

	@Override
	public List<Cart> usersCarts(Long userId) {
		
		return icd.usersCarts(userId);
	}



	@Override
	public int checkCartCount(Long userId) {
		int sum=0;
		List<Integer> count = icd.updateCartCount(userId);
		for (Integer i : count) {
			sum+=i;
		}
		return sum;
	}



	@Override
	public int emptyCarts(Long userId) {
		
		return icd.deleteCarts(userId);
	}



	@Override
	public int deleteCartById(String ID) {
		
		return icd.deleteCartById(ID);
	}



	@Override
	public int alertCartQuantity(String id, String quantity) {
		
		return icd.alertCartQuantity(id, quantity);
	}

}
