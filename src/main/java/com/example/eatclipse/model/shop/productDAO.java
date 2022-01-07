package com.example.eatclipse.model.shop;

import java.util.List;

public interface productDAO {

	// 메뉴 등록
	void menu_insert(productDTO dto);

	// 메뉴 목록
	List<productDTO> menu_list();

	// 메뉴 수정
	void menu_update(productDTO dto);

	// 메뉴 삭제
	void menu_delete(int no);

	// 판매 상태 변경
	void menu_type_update(productDTO dto);
}
