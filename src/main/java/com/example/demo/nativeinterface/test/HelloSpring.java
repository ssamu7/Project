package com.example.demo.nativeinterface.test;

public class HelloSpring {
    // native는 시스템 하위 API들을 활용할 경우 사용한다.
    // native 키워드가 있으면 C, C++ 코드를 사용하겠다는 의미
    // Netty(JNI 베이스 고속 통신 라이브러리) / 영상은 Jnine 많이사용
    public native String print();

    static {
        // System.out.println()
        // 라이브러리 : 실행파일(메모리 섹션 text의 집합 덩어리-메모리섹션에서 텍스트, 데이터, 힙, 스텍의 텍스트임)
        // *.dll, *.so파일들이 라이브러리 파일임
        // 리눅스, 유닉스(맥)에서는 hello라는 이름이 libhello.so와 동일
        System.loadLibrary("hello");
    }
}
