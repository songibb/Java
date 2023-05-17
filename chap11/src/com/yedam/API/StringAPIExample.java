package com.yedam.API;

import java.util.Scanner;

public class StringAPIExample {

	public static void main(String[] args) {

		//1) 문자열 뒤집기
		//String str = "abcdefg" -> "gfedcba"
		String str = "abcdefg";
		for(int i = str.length()-1; i>=0; i--) {
			System.out.print(str.charAt(i));
		}
		
		System.out.println();
		
		//2) 문자 개수 찾기
		//String str2 = "1n2ASD 330naa1"
		//숫자: 6개, 알파벳: 7개, 공백: 1개
		String str2 = "1n2ASD 330naa1";
		
		int alpha = 0, num = 0, space = 0;
		
		for(int i = 0; i<str2.length(); i++) {
			//문자열 읽기
			char tempCh = str2.charAt(i);
			if(tempCh == ' ') {
				space++; //공백 개수 증가
			} else if(tempCh >= '0' && tempCh <= '9') {
				num++; //숫자 개수 증가
			} else if(tempCh >= 'A' && tempCh <= 'Z' || tempCh >= 'a' && tempCh <= 'z') {
				alpha++; //알파벳 개수 증가
			}
		}
		System.out.println("숫자: "+ num + "개, 알파벳: " + alpha + "개, 공백: "+ space);
		
		
		//3) 주민등록번호 입력 후 나이 계산하기
		//단, 00~23년생 -> 2000~2023(21세기), 24~99년생 -> 1924~1999(20세기)
		//String ssn = "980102-1234567"
		//나이 : 26
		//String ssn = "000102-1234567"
		//나이 : 24
	
		String ssn = "980102-1234567";
		int birth = 0;
		int year = Integer.parseInt(ssn.substring(0,2));
		if(year >= 00 && year <= 23) {
			birth = Integer.parseInt("20" + ssn.substring(0,2));
			System.out.println(2023-birth+1);
		} else if(year >= 24 && year <= 99) {
			birth = Integer.parseInt("19" + ssn.substring(0,2));
			System.out.println(2023-birth+1);
		}
		
		
		
		//1924년 이후 2000년 이전 출생 => 98+26=124		
		//2000년 이후 2023년 이전 출생 => 00+24=24
		Scanner sc = new Scanner(System.in);
		
		System.out.println("생년월일>");
		String birth2 = sc.nextLine();
		//년도 문자열을 자르고 정수로 변환
		int birthNo = Integer.parseInt(birth2.substring(0,2));
		//조건/제어문
		if(birthNo <= 23) {   //생년월일은 음수를 넣을 일이 없어서 0보다 크다는 조건이 깔려있어서 그 조건을 넣지 않아도 됨
			System.out.println("나이: "+(24-birthNo)+"살");
		} else {   //생년월일의 연도만 자른 부분이라 else 사용해서 굳이 다른 조건을 넣지 않아도 됨
			System.out.println("나이: "+(124-birthNo)+"살");
			
		}
		
		
		//4) 문자열 압축
		//String str4  = "KKHSSSSSSSSE"
		//결과 -> K2HS8E
		
		String str4  = "KKHSSSSSSSSE";
		
		String result = "";
		int count = 1;
		for(int i = 0; i<str4.length(); i++) {
			//문자비교
			if(i < str4.length()-1   //마지막 i에서 i+1 오류를 막기 위해 -> &&연산자는 앞부분이 false면 뒷부분은 실행시키지 않음
					&& str4.charAt(i) == str4.charAt(i+1)) {   //i와 i+1의 숫자가 같을때    
				count++;
			//
			} else {  //i와 i+1의 숫자가 다를 때
				result += str4.charAt(i);
//				if(count>1) {
//					result += String.valueOf(count);
//				}  //1은 빼고 출력할 때 사용 / 결과 ->K2HS8E
				result += String.valueOf(count);  //결과 -> K2H1S8E1
				count = 1;
			}
		}
		System.out.println(result);
		
		
 
	}

}
