[![Spring Boot & Gradle CI/CD](https://github.com/Ilggun/ilggun_server/actions/workflows/gradle.yml/badge.svg)](https://github.com/Ilggun/ilggun_server/actions/workflows/gradle.yml)
[![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2Filggun%2Fhit-counter&count_bg=%23A8A200&title_bg=%23555555&icon=reverbnation.svg&icon_color=%23FFFFFF&title=hits&edge_flat=false)](https://hits.seeyoufarm.com)
> **일꾼 메인 API 서버입니다.** [프로젝트 링크](https://github.com/ilggun)

개발중입니다 🚧

# 일꾼 프로젝트
<p align="center">
<img width="500" alt="KakaoTalk_Photo_2021-05-12-13-37-18" src="https://user-images.githubusercontent.com/66074802/122636693-83ca4b00-d125-11eb-8dae-d57d97499a0b.png">
<img width="500" alt="KakaoTalk_Photo_2021-05-12-13-37-18" src="https://user-images.githubusercontent.com/66074802/122636672-6bf2c700-d125-11eb-9a4e-06f66df866a8.png">
</p>
<br>
센서를 통해 입력된 정보를 모바일 및 웹 환경에서 모니터링 할 수 있는 시스템 
    
  
## 개발자 소개
|16학번 이영범|
|:-----:|
|<img width="200" alt="이영범" src="https://user-images.githubusercontent.com/66074802/122590969-3aceb400-d09d-11eb-95b4-e3158e67bcf7.jpg">|
|개발자|
|클라이언트, 서버 개발|
|[Dev-Beom](https://github.com/Dev-Beom)|
  
## 개요

모니터링을 위해 가격이 부담스럽고 사용자 경험이 높지 않은 모니터링 플랫폼을 이용합니다.  
금전적인 부담과 사용자 경험을 개선해 기존의 문제점을 해고할 수 있도록  해결방안으로서 '일꾼 프로젝트'를 기획했습니다.  
  
## 개발 요소

**구동 환경**

`AWS EC2 - Linux`

**사용 환경**

`Java8` `SpringFramework 2.4.4` `MySQL` `AWS EC2` `AWS S3` `AWS RDS`

**주요** **사용패키지**

`JPA` `JDBC` `Lombok` `JWT` `Spring Security` `Swagger` `Model mapper` `Spring session jdbc`
  
## 프로그램 아키텍처
<p align="center">
<img width="700" alt="프로그램 구조도" src="https://user-images.githubusercontent.com/66074802/122636601-161e1f00-d125-11eb-9402-74395cce7359.png">
<img width="500" alt="프로그램 구조도" src="https://user-images.githubusercontent.com/66074802/122636603-174f4c00-d125-11eb-831d-eaff5511133a.png">
</p>
<br>

<!-- ## 파일 구조
<details>
<summary>펼치기/접기</summary>
<div markdown="1">

│  Application.java  
│  BaseTimeEntity.java  
│  GlobalExceptionHandler.java  
│  LoggingAspect.java  
│  
├─advertisement  
│  ├─controller  
│  │      AdsController.java  
│  │  
│  ├─domain  
│  │      Ads.java  
│  │      AdsRepository.java  
│  │  
│  ├─dto  
│  │      AdsListResponseDto.java  
│  │      AdsResponseDto.java  
│  │      AdsSaveRequestDto.java  
│  │      AdsUpdateRequestDto.java  
│  │  
│  └─service  
│          AdsService.java  
│  
├─advertisement_log  
│  ├─domain  
│  │      AdLogs.java  
│  │      AdLogsRepository.java  
│  │  
│  └─dto  
│          AdLogsListResponseDto.java  
│  
├─config  
│      SwaggerConfig.java  
│  
├─file  
│  ├─controller  
│  │      FileUploadController.java  
│  │  
│  ├─dto  
│  │      S3Component.java  
│  │  
│  └─service  
│      │  FileUploadService.java  
│      │  
│      └─s3  
│              S3Service.java  
│              S3ServiceImpl.java  
│  
├─image  
│  ├─controller  
│  │      ImageController.java  
│  │  
│  ├─domain  
│  │      Image.java  
│  │      ImageRepository.java  
│  │  
│  ├─dto  
│  │      ImageListResponseDto.java  
│  │      ImageResponseDto.java  
│  │      ImageSaveRequestDto.java  
│  │  
│  └─service  
│          ImageService.java  
│  
├─result  
│  ├─controller  
│  │      ResultController.java  
│  │      ResultWebController.java  
│  │  
│  ├─domain  
│  │      Result.java  
│  │      ResultRepository.java  
│  │  
│  ├─dto  
│  │      ResultListResponseDto.java  
│  │      ResultResponseDto.java  
│  │      ResultSaveRequestDto.java  
│  │  
│  └─service  
│          ResultService.java  
│  
├─security  
│      SecurityAspect.java  
│      SecurityController.java  
│      SecurityService.java  
│      SecurityServiceImpl.java  
│      TokenRequired.java  
│  
└─user  
├─controller  
│      UserController.java  
│  
├─domain  
│      Users.java  
│      UsersRepository.java  
│  
├─dto  
│      UsersListResponseDto.java  
│      UsersResponseDto.java  
│      UsersSaveRequestDto.java  
│      UsersUpdateRequestDto.java  
│  
└─service  
UsersService.java  
</div>
</details> -->
  
## DB ERD
<p align="center">
<img width="300" alt="DB ERD" src="https://user-images.githubusercontent.com/66074802/122636725-aeb49f00-d125-11eb-953b-3f03aa795771.png">
</p>
<br>

## 주요 API  
[API 문서 with Swagger](http://15.165.207.6:8080/swagger-ui.html)  
<p align="center">
<img  alt="API" src="https://user-images.githubusercontent.com/66074802/122636884-8da07e00-d126-11eb-983b-f3ac36cf7fd2.png">
</p>
<br>
  
## 구동 화면
|Client|
|:-----:|
|![ezgif com-gif-maker (2)](https://user-images.githubusercontent.com/66074802/122636748-dad02000-d125-11eb-9cf0-5db209a8b2c9.gif)|
|![ezgif com-gif-maker (3)](https://user-images.githubusercontent.com/66074802/122636750-dc014d00-d125-11eb-9fae-edf5e20f1595.gif)|
|![ezgif com-gif-maker (4)](https://user-images.githubusercontent.com/66074802/122636754-ddcb1080-d125-11eb-9d31-0c9b3babefb8.gif)|
|![ezgif com-gif-maker (5)](https://user-images.githubusercontent.com/66074802/122636756-defc3d80-d125-11eb-8ea5-4fd4e4882c13.gif)|
|![ezgif com-gif-maker (1)](https://user-images.githubusercontent.com/66074802/122636746-d7d52f80-d125-11eb-82aa-13432a7316cf.gif)|
