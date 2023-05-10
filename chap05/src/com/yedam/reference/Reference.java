package com.yedam.reference;

public class Reference {

	public static void main(String[] args) {
		//참조 : 배열
		int[] array = {1,2,3,4,5,6};
		int[] array2 = {1,2,3,4,5,6};
		int[] array3 = null;  //stack에 변수만 만들어 놓고, heap영역에 데이터가 연결이 안되어 있음 -> 참조할 객체가 없다

		System.out.println(array);  //-> 데이터가 나오지 않고, 데이터가 살고있는 주소가 출력됨
		System.out.println(array2);  //array와 같은 데이터를 넣었지만 다른 주소가 출력됨
		System.out.println(array == array2);  //== 을 사용하여 비교하면, 주소가 같냐고 물어보는 것이므로 false 출력
		System.out.println(array[0]);
		//System.out.println(array3[0]); 
		System.out.println(array3);
		System.out.println(array3 == null); //객체가 null인지 아닌지 확인하는 방법
		
		if(array3 == null) {
			//array3이 null인 경우  -> nullpointerexception예방할 수 있음
		} else {
			//array3에 객체 있는 경우
		}
		
		
		
		
		
	}

}
