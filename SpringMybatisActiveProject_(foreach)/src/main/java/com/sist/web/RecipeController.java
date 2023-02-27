package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.dao.*;


/*
 * ������
��Ȳ��
��Ằ
�����
��ü�ع������ι�����/�������Ʈ��/���ι�/��/��ǻ����ġ/����/������/�ҽ�/���Ļ����彺����������/����/����Ÿ
��ü�ϻ��ʽ��ǵ�մ���������ִ��̾�Ʈ���ö�����İ��ľ߽�Ǫ�彺Ÿ�ϸ�������������ı�Ÿ
��ü�Ұ��������߰������ä�ҷ��ع����ް�/����ǰ������ǰ���ҹа���Ǿ�����������Ϸ���/�߰��������Ÿ
��ü�������̱��ħ������ħ���������Ƣ������ⵥġ��ȸ��Ÿ
 */
@Controller
public class RecipeController {
	@Autowired
	private RecipeDAO dao;
	
	@GetMapping("recipe/recipe.do")
	public String recipe_list(Model model)
	{
		String[] menu= {
				"�ع���","��","�","����Ʈ��","���ι�","��","����","���","���","���","������","����","��",
				"�Ұ��","�������","�߰��","����","ä��","�ع�","�ް�","������ǰ","�а���","�Ǿ","����",
				"����","���̱�","��ħ","����","��ħ","���","Ƣ��","ȸ"	
		};
		model.addAttribute("menu",menu); //<c:forEach> : List, �迭 => String[]m= getParameterValues("menu") // ������ ���� ��� Values
		return "recipe/recipe";
	}
	@PostMapping("recipe/find.do")
	public String recipe_find(String[] menu, Model model)
	{
		// A B C =s="A|" A|B|C
		String s="";
		for(String m: menu)
		{
			s+=m+"|";
		}
		s=s.substring(0,s.lastIndexOf("|"));
		List<RecipeVO> list=dao.recipeFindData(s);
		
		model.addAttribute("list",list);
		return "recipe/find";
	}
}





















