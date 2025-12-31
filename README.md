# 일정 관리 시스템

```
프로젝트 개요
 - 프로젝트 목적: 스프링 입문에 익숙해지기 위한 일정 관리 시스템 구현
 - 주요 학습 목표: CRUD 학습과 검증 수행
 
기술 스택
 - Language: Java 21
 - IDE: IntelliJ IDEA
 
주요 기능
 - 일정 생성
 - 일정 단건 조회
 - 일정 목록 조회
 - 일정 수정
 - 일정 삭제
 - 댓글 생성
 
패키지 구조
src/
├── config/
│   └── JpaAudiginConfig.java
├── controller/
│   ├── CommentController.java
│   └── DateController.java
├── dto/
│   ├── CommentDto.java
│   ├── DateCommentDto.java
│   ├── DateDto.java
│   └── ErrorResponse.java
├── entity/
│   ├── BaseEntity.java
│   ├── Comment.java
│   └── Date.java
├── exception/
│   ├── CustomException.java
│   ├── GlobalExceptionHandler.java
│   └── Date.java
├── repository/
│   ├── CommentRepository.java
│   └── DateRepository.java
├── service/
│   └── impl/
│   │   ├── CommentServiceImpl.java
│   │   └── DateServiceImpl.java
│   ├── CommentService.java
│   └── DateService.java
└── type/
    └── Errorcode.java

```


# Date_Management API

일정 생성, 단건 조회, 목록 조회, 수정, 삭제, 댓글 생성 기능을 제공합니다

| API 명    | 설명               |
| -------- | ---------------- |
| 일정 생성    | 일정을 생성합니다        |
| 일정 단건 조회 | 개별 일정을 조회합니다     |
| 일정 목록 조회 | 일정을 목록 단위로 조회합니다 |
| 일정 수정    | 일정을 수정합니다        |
| 일정 삭제    | 일정을 삭제합니다        |
| 댓글 생성    | 댓글을 생성합니다        |


## 일정 생성
일정을 생성합니다

| 메서드  | 요청 URL                     |
| ---- | -------------------------- |
| POST | http://localhost:8080/date |

Request Elements
| 파라미터     | 타입     | 필수여부 | 설명   |
| -------- | ------ | ---- | ---- |
| name     | String | 필수   | 제목   |
| content  | String | 필수   | 내용   |
| author   | String | 필수   | 저자   |
| password | String | 필수   | 비밀번호 |

## 일정 단건 조회
개별 일정을 조회합니다

| 메서드  | 요청 URL                     |
| ---- | -------------------------- |
| GET | http://localhost:8080/date/{id} |

## 일정 목록 조회
일정을 목록 단위로 조회합니다

| 메서드  | 요청 URL                     |
| ---- | -------------------------- |
| GET | http://localhost:8080/date |

Request Elements
| 파라미터     | 타입     | 필수여부 | 설명   |
| -------- | ------ | ---- | ---- |
| author     | String | 필수   | 저자   |

## 일정 수정
일정을 수정합니다

| 메서드  | 요청 URL                     |
| ---- | -------------------------- |
| PUT | http://localhost:8080/date/{id} |

Request Elements
| 파라미터     | 타입     | 필수여부 | 설명   |
| -------- | ------ | ---- | ---- |
| name     | String | 필수   | 제목   |
| content  | String | 필수   | 내용   |
| author   | String | 필수   | 저자   |
| password | String | 필수   | 비밀번호 |

## 일정 삭제
일정을 삭제합니다

| 메서드  | 요청 URL                     |
| ---- | -------------------------- |
| DELETE | http://localhost:8080/date |

Request Elements
| 파라미터     | 타입     | 필수여부 | 설명   |
| -------- | ------ | ---- | ---- |
| id     | Long | 필수   | 식별아이디   |
| password | String | 필수   | 비밀번호 |

## 댓글 생성
댓글을 생성합니다

| 메서드  | 요청 URL                     |
| ---- | -------------------------- |
| POST | http://localhost:8080/comment |

Request Elements
| 파라미터     | 타입     | 필수여부 | 설명   |
| -------- | ------ | ---- | ---- |
| content  | String | 필수   | 내용   |
| author   | String | 필수   | 저자   |
| password | String | 필수   | 비밀번호 |

# ERD

<img width="836" height="256" alt="image" src="https://github.com/user-attachments/assets/b3cc2ba9-2e8a-4224-a4c8-0279910e35c1" />

# POSTMAN 테스트
제목 길이가 일정 제한을 넘어갈 경우
<img width="1068" height="694" alt="image" src="https://github.com/user-attachments/assets/c711d481-683f-4548-a2c9-8511e2b9548e" />

일정 생성
<img width="1079" height="720" alt="image" src="https://github.com/user-attachments/assets/425aff60-f3d7-461d-bada-61fe0c51ae3a" />

목록 조회
<img width="1072" height="760" alt="image" src="https://github.com/user-attachments/assets/bcb88237-2ef4-43b8-a4e7-00eab7911a7a" />

댓글 생성 제한
<img width="1061" height="705" alt="image" src="https://github.com/user-attachments/assets/c4afc770-8132-43e1-974a-8ce20fd20f1d" />

댓글 조회
<img width="1067" height="874" alt="image" src="https://github.com/user-attachments/assets/00057982-f60f-482d-a31d-1fc6a5d482b7" />

단건 조회
<img width="1070" height="825" alt="image" src="https://github.com/user-attachments/assets/43bd3b67-a302-4481-acd0-83e1e94b9ba3" />

일정 수정
<img width="1064" height="708" alt="image" src="https://github.com/user-attachments/assets/e6580fca-485a-493e-bb84-32994c2a60dd" />

일정 삭제
<img width="1073" height="592" alt="image" src="https://github.com/user-attachments/assets/ebca4f07-ef6b-4cd6-87f8-09ce89f21e4a" />

