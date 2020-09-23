package com.example.demo.controller;
// SLF4J란, Simple Logging Facade for Java의 약자로 Log4J의 개발자 Ceki Gülcü가 LogBack과 함께 개발한 Logging Facade 즉, 로깅에 대한 인터페이스 모음이라고 볼 수 있습니다.
// LogBack이 바로 SLF4J의 Native 구현체이며 SLF4J를 사용하여 로깅 처리를 하면 실제 로그는 LogBack에서 출력하게 됩니다.
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

// Spring에서 알아야 할 요소 M,V,C
// Model - 데이터, 변수, 객체
// View - 화면, 눈에 보이는 프론트단, HTML, view, vue 등등
// Controller - RestController & Controller, URL 요청에 대한 응답을 해줌.


//   RestController    vs    Controllder
// 데이터를 Json으로 처리      Json 처리 하지 않음
// DemoApplication에 main()이 동작하면서 자바 코드가 동작 한다. 비동기 방식의 인벤트 처리이기 때문에 순차적이지 않고 여기갔다 저기갔다 작동하는 것임.
// 아래와 같은(@Controller) Annotation(주석)이 붙어있으면 자동으로 스프링프레임웍이 URL맵핑을 제어하는 제어유닛으로 바라본다.
@Controller
public class MainController {
    // 로그log: 기록을 남기는 것. 프로그램 개발이나 운영 시 발생하는 문제점을 추적하거나 운영상태를 모리터링하는 정보. 분석을 통해 통계를 낼 수도 있음.
    // 로그를 남기면 성능이 나빠진다는 단점이 있지만 로그로 얻는 정보가 훨씬 많기때문에 필요한 부분에 파일로써 로그를 남기는 것이 중요.
    static final Logger log =
            LoggerFactory.getLogger(MainController.class);

    // localhost:8080/ 으로 접속하면 제어 유닛이 아래 코드를 실행시킨다.
    // 맵핑Mapping은 관련된 것들을 연결시키는 것.
    // 요청을 처리하기 위해 받아간
    @GetMapping("/")
    public String index(Locale locale, Model model) {
        log.info("index()");

        // 현재 날짜를 받아 온다.
        Date date = new Date();
        // DateFormat.getDateTimeInstance를 통해 연, 월, 일, 시간 정보와 지역 정보를 받아 출력(locale)하도록 만든다.
        // DateFormat.LONG, DateFormat.LONG은 형식 지정
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        // 위의 정보를 문자열로 만들어야 하므로 dateFormat.format을 사용함
        // 주어진 형식대로 서식있는 날짜 형태의 문자를 만든다.
        String formattedDate = dateFormat.format(date);
        // 최종적으로 만든 정보를 servTime 속성에 전달한다.
        model.addAttribute("servTime", formattedDate);

        // index.html을 보여준다
        return "index";
    }

}

// Switch : MAC주소를 가지고 컴퓨터를 구별하는 장치
// 로컬망(내부망)은 스위치로 묶여있기 때문에 통신하는 데 문제가 없다.
// 네트워크가 나뉘어 있을 때 연결하기 위해서는 라우터가 필요. 라우터는 스위치랑 연결 되어 있고 라우터는 라우터끼리 연결되어 있다.
// 외부망으로 나갈 때 공인IP가 필요한데 주소.com을 쳤을 때 IP로 바꿔주는 것이 DNS.
// Remote서비스(Naver, Daum, ...)를 제공하기 위해서는 IP호스팅 업체를 통해 내 IP의 이름을 공인IP로 IP호스팅하면 된다.
// 요즘 회사는 거의 아마존 AWS 기능을 쓴다.