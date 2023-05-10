package com.yedam.array;

import java.util.Scanner;

public class Exam06 {

	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);

		while(run) {
			System.out.println("-------------------------------------------------");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
			System.out.println("-------------------------------------------------");
			System.out.println("선택> ");
			
			int selectNo = Integer.parseInt(scanner.nextLine());
			
			
			if(selectNo == 1) {
				
				System.out.println("학생수> ");
				studentNum = Integer.parseInt(scanner.nextLine());
				
			} else if(selectNo == 2) {
				
				//학생 성적 입력 배열
				scores = new int[studentNum];
				for(int i = 0; i <studentNum; i++) {
					System.out.printf("scores[%d]> ", i);
					scores[i] = Integer.parseInt(scanner.nextLine());
				}
				
			} else if(selectNo == 3) {
				
				for(int i = 0; i <scores.length; i++) {
					System.out.println("scores["+ i + "]> " + scores[i]);					
				}
				
			} else if(selectNo == 4) {
				
				int max = scores[0];
				int sum = 0;
				for(int i = 0; i<scores.length; i++) {
					sum = sum + scores[i];
					if(max < scores[i]) {
						max = scores[i];
					}	
				}
				System.out.println("최고 점수: " + max);
				System.out.println("평균 점수: " + (double)sum/scores.length);
				
			} else if(selectNo == 5) {
				
				run = false;
				
			}
		
		}
		
		System.out.println("프로그램 종료");
		
		
		
		
		//answer 배열에 담긴 데이터를 읽고 각 숫자마다 개수만큼'*'를 찍는다.
		//아래 빈 영역에 코드를 입력하여 프로그램을 완성하여라
			int[] answer = {1,4,4,3,1,4,4,2,1,3,2};
			int[] counter = new int[4];
			
			//1)
//			for(int i = 0; i<answer.length; i++) {
//				if(answer[i]==1) {
//					counter[0] ++;
//				} else if(answer[i]==2) {
//					counter[1] ++;
//				} else if(answer[i]==3) {
//					counter[2] ++;
//				} else {
//					counter[3] ++;
//				}
//			}
//			for(int i = 0; i<counter.length; i++) {
//				//System.out.println(counter[i]);
//				for(int j = 0; j<counter[i]; j++) {
//					System.out.print("*");
//				}
//				System.out.println();
//			}
			
			//2)
			for(int i = 0; i<answer.length; i++) {
				counter[answer[i]-1]++;  //counter[answer[i]-1] = counter[answer[i]-1] + 1
			}
			
			for(int i = 0; i<counter.length; i++) {
				for(int j = 0; j<counter[i]; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			
			
		
			
	}
	
	
	
		
		
	
	

}
