package 과제.과제9.영화리뷰.imlpement1;

import 과제.과제9.영화리뷰.interface0.좋고싫어요;
import 과제.과제9.영화리뷰.super2.글을쓰기;

import java.util.ArrayList;

import 과제.과제9.영화리뷰.interface0.글삭제;
import 과제.과제9.영화리뷰.interface0.글쓰기;


public class 영화리뷰 extends 글을쓰기 implements 글삭제, 글쓰기, 좋고싫어요{
	
	private String 별점;
	public 영화리뷰() {};
	
	public 영화리뷰(String title, String contents,int 별){
		super(title, contents);
	}
	
	
	public void 별점(int a) {
		
		for(int i = 1; i<=a ; i++){
		별점 +="★";
		}
		System.out.println(a+" 만큼 별점을 남깁니다.");
		
	}
	
	
	@Override
	public void 좋아요(ArrayList<글을쓰기> DB,int ch01) {
		if(DB.get(ch01) instanceof 영화리뷰) {
			DB.get(ch01).setLike();
			System.out.println("좋아요+1");
		}
		
	}

	@Override
	public void 싫어요(ArrayList<글을쓰기> DB,int ch01) {
		if(DB.get(ch01) instanceof 영화리뷰) {
			DB.get(ch01).setHate();
			System.out.println("싫어요+1");
		}
	}

	@Override
	public void 글쓰기() {
		System.out.println("영화리뷰에 글쓰기 ");
		
	}

	@Override
	public void 글삭제() {
		System.out.println("영화리뷰에 글삭제 ");
		
	}
	
	
	
}
