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



