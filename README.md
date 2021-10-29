# :smile: SpringBoard From MIN

MVC패턴을 이용한 간단한 개인 프로젝트이며,
데이터CRUD(CREATE,READ,UPDATE,DELETE)기능 구현에 대한 도움이 되고자
스프링 게시판 프로젝트를 만들어보았습니다.
--------
### 개발 환경
- Window 10
- STS4
- MYSQL 8.0.27
- Apache Tomcat 9.0
- JAVA 11
- Lombok 1.18.12
--------
### 구현 순서
- VO,DTO(도메인 모델계층) ->Mapper(퍼시스턴트 계층) ->Service(비즈니스 계층)->Controller(제어계층)->JSP(프리젠티에션 계층)순입니다.
- Mapper과 Service 작업 시에는 Junit 테스트를 거쳐 진행했습니다.
--------
### 개발된 기능
- 기본적인 게시판 뷰(페이징 처리)
- 게시물 등록,조회,수정,삭제
- 게시물 검색 
--------
:heavy_check_mark: 게시판 테이블(Min_board)

![테이블 속성](https://user-images.githubusercontent.com/49664700/139385999-8f13b9ab-6c4d-4bdf-a4ce-f1e66b59feee.PNG)

#

:heavy_check_mark: **게시판 목록**

![리스트 controller](https://user-images.githubusercontent.com/49664700/139387372-65767588-4429-4cd8-8c42-7446f7cbf9cd.PNG)
 ```
 리스트는 뷰(View)에 데이터를 전송하기 위해 Model 파라미터를 추가,
 페이징 쿼리를 동적 제어하기 위해 필요한 데이터 'pageNum'과 'amount'을 같이 파라미터로
 전달하기 위한 용도로 작성한 Criteria 클래스(class)를 파라미터에 추가 
 리스트 목록과 페이징에 필요한 값을 addAttribute()메소드를 활용하여 저장
 ```
 
 ![리스트 mapper2](https://user-images.githubusercontent.com/49664700/139388270-e405f4e9-6179-4b62-a0b7-a970198ed61b.PNG)
 ###### BoardMapper.xml

```
select문을 사용하였고 페이징 쿼리는 LIMIT방식으로 하였으며 
PageMakerDTO를 활용하기 위해 게시물 전체 개수 데이터가 필요하였기때문에  total값을 구할수 있는 쿼리를 만들었습니다.
두개의 쿼리에 주제검색 쿼리가 중복되기 때문에 코드의 양을 줄이기 위해 <sql>,<include>를 사용하였습니다.
```

![list](https://user-images.githubusercontent.com/49664700/139390104-fca3c1a2-d1be-418a-933c-841c8bf8c3f3.PNG)
###### list.jsp

#

:heavy_check_mark: **게시판 등록**

![게시판 등록](https://user-images.githubusercontent.com/49664700/139390456-e66ba142-69bf-4e1a-b53a-f808678d58ec.PNG)
###### BoardController.java
```
Log4jdbc-log4j2 라이브러리를 통해 BoardVO클래스에 데이터가 의도대로 저장되었는지 확인
BoardService.java에서 메서드 enroll() 호출하고 데이터를 전달을 위해 view로 부터 전달받은 boardVO 삽입
등록 성공을 알리기 위해 RedirectAttributes 파라미터를 추가하고 addFlashAttribute()메서드로 일회성으로 데이터를 전달합니다.
전달받은 데이터가 있을경우 result 경고창이 뜹니다.
```
![게시판 등록 view](https://user-images.githubusercontent.com/49664700/139390722-dfe81545-8aa2-44c1-86e8-605fc0c6349d.PNG)
###### enroll.jsp

#

:heavy_check_mark: **게시판 조회**

![조회controller](https://user-images.githubusercontent.com/49664700/139390878-9b4fd057-58ad-458f-b5d6-1c43419544f8.PNG)
###### BoardController.java
```
뷰로부터 게시물 번호를 전달받기위해 int형 변수를 파라미터에 추가, 쿼리실행후 전달받은 BoardVO 객체를 전달하기 위해
Model 파라미터 추가, 이전화면 List에 pageNum을 전달하기 위해 criteria를 파라미터에 추가하였습니다.
```
![조회 view](https://user-images.githubusercontent.com/49664700/139391195-4c4bdb3e-f202-43ee-bd08-e688bff08bd4.PNG)
###### get.jsp

#

:heavy_check_mark: **게시판 수정**

![수정 controller](https://user-images.githubusercontent.com/49664700/139391382-291d8bad-94f9-4e99-bf0c-2d40a10b93db.PNG)
###### BoardController.java
```
수정(GET)은 조회페이지와 동일합니다. 따라서 int 형 파라미터와 해당 게시물 내용을 호출하는 service메소드 (getPage())를 호출
수정(POST)는 수정될 내용의 데이터를 가져오기 위해 BoardVO 클래스를 파라미터로 부여하였고 수정 기능 실행 후 리다이렉트 방식으로 
리스트 페이지 이동시 데이터를 같이 전송하기 위해서 RedirctAttributes 객체를 파라미터로 부여했습니다.
```
![수정 view](https://user-images.githubusercontent.com/49664700/139391496-fa0574e6-1c38-4acc-a5a1-9a5e9b491e52.PNG)
###### modify.jsp

#

:heavy_check_mark: **게시판 삭제**

![삭제 컨트롤러](https://user-images.githubusercontent.com/49664700/139391722-d8d2a6a9-20ca-4dcb-b02f-09e1a97233c9.PNG)
###### BoardController.java
```
삭제 쿼리를 실행하기 위해선 게시판 번호(bno)에 대한 정보가 필요로 하기 때문에 int형 변수를 파라미터로 부여하였고, 
수정 기능 실행 후 리다이렉트 방식으로 리스트 페이지 이동시 데이터를 같이 전송하기 위해서 RedirctAttributes 객체를
 파라미터로 부여했습니다.
 ```
 












