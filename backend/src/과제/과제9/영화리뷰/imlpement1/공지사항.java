package 과제.과제9.영화리뷰.imlpement1;

import 과제.과제9.영화리뷰.interface0.좋고싫어요;
import 과제.과제9.영화리뷰.super2.글을쓰기;

import java.util.ArrayList;
import java.util.Collections;

import 과제.과제9.영화리뷰.interface0.글삭제;
import 과제.과제9.영화리뷰.interface0.글쓰기;

public class 공지사항 extends 글을쓰기 implements 글삭제, 글쓰기, 좋고싫어요{
	
	public 공지사항() {};
	
	public 공지사항(String title, String contents){
		super(title, contents);
	}
	
	
	public static void top(ArrayList<글을쓰기> DB,글을쓰기 글) {
		
		int i = 0;//글번호
		for(글을쓰기 DB글: DB) {//공지사항이면 배열을 이동
			if(DB글 instanceof 공지사항) {
				i++; 
			}else { //공지사항이 아니라면? 마지막쓴글(공지사항)이랑 바꾸기
				break;
			}	
		}//for e	
	
		if(DB.size()>=2) {
		Collections.swap(DB, i, DB.size()-1);	
		}
	
	}
	
	
	@Override
	public void 좋아요(ArrayList<글을쓰기> DB,int ch01) {
		if(DB.get(ch01) instanceof 공지사항) {
			DB.get(ch01).setLike();
			System.out.println("좋아요+1");
		}
		
	}

	@Override
	public void 싫어요(ArrayList<글을쓰기> DB,int ch01) {
		if(DB.get(ch01) instanceof 공지사항) {
			DB.get(ch01).setHate();
			System.out.println("싫어요+1");
		}
	}

	@Override
	public void 글쓰기() {
		System.out.println("공지사항에 글쓰기 ");
		
	}

	@Override
	public void 글삭제() {
		System.out.println("공지사항에 글삭제 ");
		
	}
}
