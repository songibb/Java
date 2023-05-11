package com.yedam.homework;

import java.util.Scanner;

public class homework_0510 {

	public static void main(String[] args) {
		//주어진 배열을 이용하여 다음 내용을 구현하세요.
		int[] arr1 = { 10, 20, 30, 50, 3, 60, -3 };
		
		//문제1. 주어진 배열 중에서 값이 60인 곳의 인덱스를 출력해보자.
		for(int i = 0; i<arr1.length; i++) {
			if(arr1[i] == 60) {
				System.out.println("60의 인덱스 : " + i);
			}
		}
		
		//문제2. 주어진 배열의 인덱스가 3인 곳은 출력하지 말고, 나머지만 출력해보자.
		for(int i = 0; i<arr1.length; i++) {
			if(i != 3) {
				System.out.println(arr1[i]);
			}
		}
		
		//문제3. 주어진 배열 안의 변경하고 싶은 값의 인덱스 번호를 입력받아, 그 값을 1000으로 변경해보자.
  		//   입력) 인덱스: 3 ->   {10, 20, 30, 1000, 3, 60, -3}
		Scanner sc = new Scanner(System.in);
		System.out.println("변경할 인덱스 번호 입력> ");
		int indexNo = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i<arr1.length; i++) {
			if(i == indexNo) {
				arr1[i] = 1000;
			}
			System.out.println(arr1[i]);
		}
		
		//문제4. 별도의 배열을 선언하여 양의 정수 10개를 입력받아 배열에 저장하고, 배열에 있는 정수 중에서 3의 배수만 출력해보자.
		int[] arr2 = new int[10];
		for(int i = 0; i<arr2.length; i++) {
			System.out.println("양의 정수 입력> ");
			arr2[i] = Integer.parseInt(sc.nextLine());
		}
		for(int i = 0; i<arr2.length; i++) {
			if(arr2[i] % 3 == 0) {
				System.out.println("3의 배수 출력 : " + arr2[i]);
			}
		}
		
		
		//추가문제
		//X대학 M교수님은 프로그래밍 수업을 맡고 있다. 교실엔 학생이 30명이 있는데, 학생 명부엔 각 학생별로 1번부터 30번까지 출석번호가 붙어 있다.
		//교수님이 내준 특별과제를 28명이 제출했는데, 그 중에서 제출 안 한 학생 2명의 출석번호를 구하는 프로그램을 작성하시오.
		//참고 : 백준 https://www.acmicpc.net/problem/5597

		//int[] attendance = new int[28]; //제출한 인원이 랜덤인 경우
		int[] attendance = {3,1,4,5,7,9,6,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
		int[] confirm = new int[30];  //제출한 명단을 새로운 배열에 넣어

//		for(int i=0; i<attendance.length; i++) {
//			attendance[i] = (int) (Math.random() * 30) +1;
//			if(i != 0) {
//				//중복비교
//				for(int j = 0; j <i; j++) {
//					if(attendance[i] ==attendance[j]) {
//						i--; //중복 시 다시 데이터 뽑게 함
//						break;
//					}
//				}
//			}
//		}
		
		
		//제출한 인원 체크
		for(int i = 0; i<attendance.length;i++) {
			confirm[attendance[i]-1]++; //confirm 배열의 길이는 30이므로 인덱스에는 29까지만 존재
		}
		
		for(int i=0; i<attendance.length;i++) {
			if(confirm[i] != 0) {
				System.out.println("제출자"+(i+1));
			}
		}
		
		for(int i=0; i<attendance.length;i++) {
			if(confirm[i] == 0) {
				System.out.println("미제출자"+(i+1));
			}
		}
		
		
		
	}
}
