package com.yedam.loop;

public class LoopCondition {

	public static void main(String[] args) {
		//while break;
		while(true) {
			int num = (int) (Math.random() * 6) + 1;
			System.out.println(num);
			if(num == 6) {
				break;
			}
		}
		
		//중첩 for문 안에서의 break;  -> 안에 있는 for문 종료
		for(int i = 0; i<=10; i++) {
			for(int j = 0; j<=10; j++) {
				if(j==5) {
					System.out.println("i + j = " + (i+j));
					break;   // j가 5보다 큰 값을 가질 수 없게 됨
				} else {
					System.out.println(j);
				}
			}
		}
		
		//for문 label break;  -> 밖에 있는 for문 종료
		Outter : for(char upper = 'A'; upper <= 'Z'; upper++) {
			for(char lower = 'a'; lower <= 'z'; lower++) {
				System.out.println(upper + " - " + lower);
				if(lower == 'g') {
					break Outter;
				}
			}
		}
		
		//continue
		for(int i = 0; i <= 10; i++) {
			if(i % 2 == 0) {
				continue;
			}
			System.out.println(i);
		}

	}

}
