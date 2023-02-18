package 과제.과제9.영화리뷰.imlpement1;

import 과제.과제9.영화리뷰.interface0.좋고싫어요;
import 과제.과제9.영화리뷰.super2.글을쓰기;

import java.util.ArrayList;

import 과제.과제9.영화리뷰.interface0.글삭제;
import 과제.과제9.영화리뷰.interface0.글쓰기;

public class 커뮤니티 extends 글을쓰기 implements 글삭제, 글쓰기, 좋고싫어요{
	private String user;
	public 커뮤니티() {};
	
	public 커뮤니티(String title, String contents, String user){
		super(title, contents);
		this.user = user;
	}
	
	
	public void comment(String user) {
		System.out.println(user+" 를 comment합니다.");
		
	}
	
	
	@Override
	public void 좋아요(ArrayList<글을쓰기> DB,int ch01) {
		if(DB.get(ch01) instanceof 커뮤니티) {
			DB.get(ch01).setLike();
			System.out.println("좋아요+1");
		}
		
	}

	@Override
	public void 싫어요(ArrayList<글을쓰기> DB,int ch01) {
		if(DB.get(ch01) instanceof 커뮤니티) {
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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
}
