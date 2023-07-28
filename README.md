# MoLog

------

### 프로젝트 소개

프로젝트 'MoLog'는 My Own Log의 약자로 나만의 기록을 남길 수 있는 블로그 플랫폼입니다.

### 프로젝트 목적

1. 마이크로서비스 아키텍처 구현
2. Spring Boot , JPA 학습
3. Redis를 사용하여 캐시 메모리 활용
4. Docker를 사용하여 CI/CD 

### 프로젝트 요구사항

1. 마이크로서비스 아키텍처 구현
   - Spring Cloud Eureka , Spring Cloud Api Gateway  , 기능별 API
2. 사용자 인증과 보안
3. 블로그 게시글 관리
4. 댓글 관리
5. 이미지 업로드
6. 캐시를 이용한 좋아요 기능

-----

### 사용 기술

- Java 17
- Spring Boot , Spring Data JPA, Spring Cloud Eureka, Spring Cloud Api Gateway
- MariaDB, Redis
- Jenkins, Docker, Git

-----

### 프로젝트 구조

/// Diagram Image 첨부

------

## API

### Member API

- 회원 등록
- 회원 정보 조회
- 회원 정보 수정
- 회원 탈퇴

### Auth API

 - 로그인 / 로그아웃
 - 회원 인증
 - 인증 토큰 생성
 - 인증 토큰 갱신 
 - 인증 토큰 삭제

### Board API

- 게시글 작성
- 게시글 조회
  - 모든 게시글 조회
  - 카테고리별 게시글 조회
  - 검색한 게시글 조회
- 게시글 수정
- 게시글 좋아요
- 게시글 삭제

### Comment API

	- 댓글 작성
	- 댓글 조회
	- 댓글 수정
	- 댓글 삭제
	- 댓글 좋아요

------



